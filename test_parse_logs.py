"""Tests for parse_logs.py — extracting workflow metrics into CSV."""
import csv
import json
import os
import tempfile

import pytest

from parse_logs import parse_workflow, parse_all_logs, COLUMNS


# --- Fixtures ---

SAMPLE_LOG = {
    "timestamp": "2026-03-11T03:53:57.656105+00:00",
    "metrics": {
        "session": {
            "wall_clock_secs": 628.23,
            "total_cost_usd": 3.458547,
            "sdk_turns": 6,
        },
        "tool_calls": {
            "Read": 46,
            "Edit": 21,
            "Bash": 10,
            "Task": 4,
            "Write": 3,
            "mcp__barista_tools__validate_dfa": 3,
            "Grep": 3,
            "mcp__barista_tools__verify_liquidjava": 3,
            "mcp__barista_tools__generate_tests": 1,
            "mcp__barista_tools__generate_refinements": 1,
            "Glob": 1,
        },
        "tool_errors": {"Grep": 1},
        "agent_spawns": {
            "protocol-analyzer": 1,
            "java-test-completer": 1,
            "liquidjava-spec-writer": 1,
            "liquidjava-verifier": 1,
        },
        "agents": {
            "orchestrator": {
                "turns": 13,
                "tool_calls": {"Task": 4, "Read": 1},
                "tool_errors": {},
            },
            "protocol-analyzer": {
                "turns": 12,
                "tool_calls": {"Edit": 5, "Read": 2, "Write": 2},
                "tool_errors": {},
            },
        },
        "turns": [
            {"turn": 1, "agent": "orchestrator", "tool_calls": 0},
            {"turn": 2, "agent": "orchestrator", "tool_calls": 1},
        ],
    },
}

MINIMAL_LOG = {
    "timestamp": "2026-03-11T04:00:00.000000+00:00",
    "metrics": {
        "session": {"wall_clock_secs": 100.0, "total_cost_usd": 1.0, "sdk_turns": 2},
        "tool_calls": {"Read": 5},
        "tool_errors": {},
        "agent_spawns": {},
        "agents": {
            "orchestrator": {"turns": 2, "tool_calls": {"Read": 5}, "tool_errors": {}}
        },
        "turns": [{"turn": 1, "agent": "orchestrator", "tool_calls": 5}],
    },
}


def _make_log_tree(base, class_name, run_num, log_data):
    """Create agentic/<class>/run_<n>/logs/workflow_xxx.json in a temp dir."""
    log_dir = os.path.join(base, "agentic", class_name, f"run_{run_num}", "logs")
    os.makedirs(log_dir)
    path = os.path.join(log_dir, f"workflow_20260311_0{run_num}0000.json")
    with open(path, "w") as f:
        json.dump(log_data, f)
    return path


# --- Tests for parse_workflow ---


class TestParseWorkflow:
    def test_extracts_session_metrics(self):
        row = parse_workflow(SAMPLE_LOG, "socket", 1)
        assert row["class_name"] == "socket"
        assert row["run"] == 1
        assert row["wall_clock_secs"] == 628.23
        assert row["total_cost_usd"] == 3.458547
        assert row["sdk_turns"] == 6

    def test_extracts_tool_call_counts(self):
        row = parse_workflow(SAMPLE_LOG, "socket", 1)
        assert row["tool_Read"] == 46
        assert row["tool_Edit"] == 21
        assert row["tool_Bash"] == 10
        assert row["tool_Write"] == 3
        assert row["tool_Grep"] == 3
        assert row["tool_Glob"] == 1
        assert row["tool_Task"] == 4

    def test_extracts_mcp_tool_counts(self):
        row = parse_workflow(SAMPLE_LOG, "socket", 1)
        assert row["tool_mcp_validate_dfa"] == 3
        assert row["tool_mcp_verify_liquidjava"] == 3
        assert row["tool_mcp_generate_tests"] == 1
        assert row["tool_mcp_generate_refinements"] == 1

    def test_extracts_total_tool_calls(self):
        row = parse_workflow(SAMPLE_LOG, "socket", 1)
        assert row["total_tool_calls"] == 46 + 21 + 10 + 4 + 3 + 3 + 3 + 3 + 1 + 1 + 1

    def test_extracts_total_tool_errors(self):
        row = parse_workflow(SAMPLE_LOG, "socket", 1)
        assert row["total_tool_errors"] == 1

    def test_extracts_agent_spawn_counts(self):
        row = parse_workflow(SAMPLE_LOG, "socket", 1)
        assert row["spawn_protocol_analyzer"] == 1
        assert row["spawn_java_test_completer"] == 1
        assert row["spawn_liquidjava_spec_writer"] == 1
        assert row["spawn_liquidjava_verifier"] == 1

    def test_extracts_total_agent_spawns(self):
        row = parse_workflow(SAMPLE_LOG, "socket", 1)
        assert row["total_agent_spawns"] == 4

    def test_extracts_total_turns(self):
        row = parse_workflow(SAMPLE_LOG, "socket", 1)
        assert row["total_turns"] == len(SAMPLE_LOG["metrics"]["turns"])

    def test_missing_tools_default_to_zero(self):
        row = parse_workflow(MINIMAL_LOG, "throwable", 1)
        assert row["tool_Edit"] == 0
        assert row["tool_Bash"] == 0
        assert row["tool_Write"] == 0
        assert row["tool_mcp_validate_dfa"] == 0

    def test_missing_agent_spawns_default_to_zero(self):
        row = parse_workflow(MINIMAL_LOG, "throwable", 1)
        assert row["spawn_protocol_analyzer"] == 0
        assert row["total_agent_spawns"] == 0

    def test_timestamp_extracted(self):
        row = parse_workflow(SAMPLE_LOG, "socket", 1)
        assert row["timestamp"] == "2026-03-11T03:53:57.656105+00:00"


# --- Tests for parse_all_logs (integration with filesystem) ---


class TestParseAllLogs:
    def test_parses_multiple_classes_and_runs(self):
        with tempfile.TemporaryDirectory() as tmpdir:
            _make_log_tree(tmpdir, "socket", 1, SAMPLE_LOG)
            _make_log_tree(tmpdir, "socket", 2, MINIMAL_LOG)
            _make_log_tree(tmpdir, "throwable", 1, MINIMAL_LOG)

            rows = parse_all_logs(os.path.join(tmpdir, "agentic"))
            assert len(rows) == 3
            classes = {r["class_name"] for r in rows}
            assert classes == {"socket", "throwable"}

    def test_sorted_by_class_then_run(self):
        with tempfile.TemporaryDirectory() as tmpdir:
            _make_log_tree(tmpdir, "socket", 2, MINIMAL_LOG)
            _make_log_tree(tmpdir, "socket", 1, SAMPLE_LOG)
            _make_log_tree(tmpdir, "throwable", 1, MINIMAL_LOG)

            rows = parse_all_logs(os.path.join(tmpdir, "agentic"))
            keys = [(r["class_name"], r["run"]) for r in rows]
            assert keys == [("socket", 1), ("socket", 2), ("throwable", 1)]

    def test_columns_constant_matches_row_keys(self):
        row = parse_workflow(SAMPLE_LOG, "socket", 1)
        assert set(COLUMNS) == set(row.keys())

    def test_writes_csv(self):
        with tempfile.TemporaryDirectory() as tmpdir:
            _make_log_tree(tmpdir, "socket", 1, SAMPLE_LOG)
            rows = parse_all_logs(os.path.join(tmpdir, "agentic"))

            csv_path = os.path.join(tmpdir, "out.csv")
            with open(csv_path, "w", newline="") as f:
                writer = csv.DictWriter(f, fieldnames=COLUMNS)
                writer.writeheader()
                writer.writerows(rows)

            with open(csv_path) as f:
                reader = csv.DictReader(f)
                loaded = list(reader)
            assert len(loaded) == 1
            assert loaded[0]["class_name"] == "socket"
            assert float(loaded[0]["wall_clock_secs"]) == 628.23
