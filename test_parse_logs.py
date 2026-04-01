"""Tests for parsing workflow logs into CSV."""
import csv
import json
import os
import tempfile
from pathlib import Path

import pytest

from parse_logs import parse_workflow_log, collect_all_logs, write_csv


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
                "tool_calls": {"Edit": 5, "mcp__barista_tools__validate_dfa": 3, "Read": 2, "Write": 2},
                "tool_errors": {},
            },
            "java-test-completer": {
                "turns": 28,
                "tool_calls": {"Read": 17, "Bash": 10, "mcp__barista_tools__generate_tests": 1},
                "tool_errors": {},
            },
            "liquidjava-spec-writer": {
                "turns": 22,
                "tool_calls": {"Edit": 14, "Read": 5, "Grep": 2, "mcp__barista_tools__generate_refinements": 1},
                "tool_errors": {"Grep": 1},
            },
            "liquidjava-verifier": {
                "turns": 29,
                "tool_calls": {"Read": 21, "mcp__barista_tools__verify_liquidjava": 3, "Edit": 2, "Glob": 1, "Write": 1, "Grep": 1},
                "tool_errors": {},
            },
        },
        "turns": [{"turn": i, "agent": "orchestrator", "tool_calls": i % 3} for i in range(1, 105)],
        "system_messages": {"task_started": 4, "init": 1},
    },
    "messages": [],
}

MINIMAL_LOG = {
    "timestamp": "2026-03-11T01:00:00+00:00",
    "metrics": {
        "session": {"wall_clock_secs": 100.0, "total_cost_usd": 0.5, "sdk_turns": 2},
        "tool_calls": {"Read": 5},
        "tool_errors": {},
        "agent_spawns": {"protocol-analyzer": 1},
        "agents": {
            "orchestrator": {"turns": 3, "tool_calls": {"Read": 1}, "tool_errors": {}},
            "protocol-analyzer": {"turns": 5, "tool_calls": {"Read": 4}, "tool_errors": {}},
        },
        "turns": [{"turn": 1, "agent": "orchestrator", "tool_calls": 1}],
        "system_messages": {},
    },
    "messages": [],
}


@pytest.fixture
def sample_log_file(tmp_path):
    p = tmp_path / "workflow_20260311_034329.json"
    p.write_text(json.dumps(SAMPLE_LOG))
    return p


@pytest.fixture
def minimal_log_file(tmp_path):
    p = tmp_path / "workflow_20260311_010000.json"
    p.write_text(json.dumps(MINIMAL_LOG))
    return p


@pytest.fixture
def fake_agentic_dir(tmp_path):
    """Create a realistic agentic/ directory with 2 classes x 2 runs."""
    agentic = tmp_path / "agentic"
    for cls, runs in [("socket", 2), ("popupmenu", 2)]:
        for r in range(1, runs + 1):
            log_dir = agentic / cls / f"run_{r}" / "logs"
            log_dir.mkdir(parents=True)
            log_file = log_dir / f"workflow_2026031{r}_000000.json"
            log_file.write_text(json.dumps(SAMPLE_LOG if cls == "socket" else MINIMAL_LOG))
    return agentic


# --- Tests for parse_workflow_log ---

class TestParseWorkflowLog:
    def test_extracts_session_metrics(self, sample_log_file):
        row = parse_workflow_log(sample_log_file, class_name="socket", run=1)
        assert row["wall_clock_secs"] == 628.23
        assert row["total_cost_usd"] == 3.458547
        assert row["sdk_turns"] == 6

    def test_extracts_class_and_run(self, sample_log_file):
        row = parse_workflow_log(sample_log_file, class_name="socket", run=3)
        assert row["class_name"] == "socket"
        assert row["run"] == 3

    def test_extracts_timestamp(self, sample_log_file):
        row = parse_workflow_log(sample_log_file, class_name="socket", run=1)
        assert row["timestamp"] == "2026-03-11T03:53:57.656105+00:00"

    def test_counts_total_tool_calls(self, sample_log_file):
        row = parse_workflow_log(sample_log_file, class_name="socket", run=1)
        expected = 46 + 21 + 10 + 4 + 3 + 3 + 3 + 3 + 1 + 1 + 1  # = 96
        assert row["total_tool_calls"] == expected

    def test_counts_total_tool_errors(self, sample_log_file):
        row = parse_workflow_log(sample_log_file, class_name="socket", run=1)
        assert row["total_tool_errors"] == 1

    def test_zero_tool_errors_when_empty(self, minimal_log_file):
        row = parse_workflow_log(minimal_log_file, class_name="popupmenu", run=1)
        assert row["total_tool_errors"] == 0

    def test_extracts_individual_tool_counts(self, sample_log_file):
        row = parse_workflow_log(sample_log_file, class_name="socket", run=1)
        assert row["tool_Read"] == 46
        assert row["tool_Edit"] == 21
        assert row["tool_Bash"] == 10
        assert row["tool_mcp__barista_tools__validate_dfa"] == 3

    def test_missing_tools_are_zero(self, minimal_log_file):
        row = parse_workflow_log(minimal_log_file, class_name="popupmenu", run=1)
        assert row["tool_Read"] == 5
        assert row.get("tool_Edit", 0) == 0

    def test_counts_total_agent_spawns(self, sample_log_file):
        row = parse_workflow_log(sample_log_file, class_name="socket", run=1)
        assert row["total_agent_spawns"] == 4

    def test_extracts_per_agent_turns(self, sample_log_file):
        row = parse_workflow_log(sample_log_file, class_name="socket", run=1)
        assert row["agent_turns_orchestrator"] == 13
        assert row["agent_turns_protocol-analyzer"] == 12
        assert row["agent_turns_java-test-completer"] == 28
        assert row["agent_turns_liquidjava-spec-writer"] == 22
        assert row["agent_turns_liquidjava-verifier"] == 29

    def test_counts_total_turns(self, sample_log_file):
        row = parse_workflow_log(sample_log_file, class_name="socket", run=1)
        assert row["total_turns"] == 104

    def test_missing_agent_turns_are_absent(self, minimal_log_file):
        row = parse_workflow_log(minimal_log_file, class_name="popupmenu", run=1)
        assert row["agent_turns_orchestrator"] == 3
        assert row["agent_turns_protocol-analyzer"] == 5
        assert "agent_turns_liquidjava-verifier" not in row


# --- Tests for collect_all_logs ---

class TestCollectAllLogs:
    def test_finds_all_logs(self, fake_agentic_dir):
        rows = collect_all_logs(fake_agentic_dir)
        assert len(rows) == 4  # 2 classes x 2 runs

    def test_extracts_class_name_from_path(self, fake_agentic_dir):
        rows = collect_all_logs(fake_agentic_dir)
        class_names = {r["class_name"] for r in rows}
        assert class_names == {"socket", "popupmenu"}

    def test_extracts_run_number_from_path(self, fake_agentic_dir):
        rows = collect_all_logs(fake_agentic_dir)
        runs = sorted(r["run"] for r in rows if r["class_name"] == "socket")
        assert runs == [1, 2]

    def test_rows_sorted_by_class_then_run(self, fake_agentic_dir):
        rows = collect_all_logs(fake_agentic_dir)
        keys = [(r["class_name"], r["run"]) for r in rows]
        assert keys == sorted(keys)


# --- Tests for write_csv ---

class TestWriteCsv:
    def test_writes_header_and_rows(self, fake_agentic_dir, tmp_path):
        rows = collect_all_logs(fake_agentic_dir)
        out = tmp_path / "output.csv"
        write_csv(rows, out)

        with open(out) as f:
            reader = csv.DictReader(f)
            csv_rows = list(reader)

        assert len(csv_rows) == 4
        assert "class_name" in csv_rows[0]
        assert "wall_clock_secs" in csv_rows[0]

    def test_consistent_columns_across_rows(self, fake_agentic_dir, tmp_path):
        """All rows should have the same columns, with 0 for missing tools/agents."""
        rows = collect_all_logs(fake_agentic_dir)
        out = tmp_path / "output.csv"
        write_csv(rows, out)

        with open(out) as f:
            reader = csv.DictReader(f)
            csv_rows = list(reader)

        # All rows should have same keys
        for row in csv_rows:
            assert set(row.keys()) == set(csv_rows[0].keys())

    def test_missing_values_filled_with_zero(self, fake_agentic_dir, tmp_path):
        rows = collect_all_logs(fake_agentic_dir)
        out = tmp_path / "output.csv"
        write_csv(rows, out)

        with open(out) as f:
            reader = csv.DictReader(f)
            csv_rows = list(reader)

        # popupmenu rows shouldn't have empty cells for tools that only socket has
        for row in csv_rows:
            for k, v in row.items():
                assert v != "", f"Column {k} has empty value in row {row['class_name']}/run_{row['run']}"
