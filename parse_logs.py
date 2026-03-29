"""Parse Barista workflow logs into a flat CSV."""
import csv
import glob
import json
import os
import re
import sys

# Standard tool names to extract as columns
STANDARD_TOOLS = ["Read", "Edit", "Bash", "Write", "Grep", "Glob", "Task"]

# MCP tools (stripped of the mcp__barista_tools__ prefix)
MCP_TOOLS = ["validate_dfa", "verify_liquidjava", "generate_tests", "generate_refinements"]

# Agent names to track spawns
AGENT_NAMES = [
    "protocol_analyzer",
    "java_test_completer",
    "liquidjava_spec_writer",
    "liquidjava_verifier",
]

COLUMNS = [
    "class_name",
    "run",
    "timestamp",
    "wall_clock_secs",
    "total_cost_usd",
    "sdk_turns",
    # standard tools
    *[f"tool_{t}" for t in STANDARD_TOOLS],
    # mcp tools
    *[f"tool_mcp_{t}" for t in MCP_TOOLS],
    "total_tool_calls",
    "total_tool_errors",
    # agent spawns
    *[f"spawn_{a}" for a in AGENT_NAMES],
    "total_agent_spawns",
    "total_turns",
]


def parse_workflow(data: dict, class_name: str, run: int) -> dict:
    """Extract a flat dict of metrics from a workflow JSON object."""
    metrics = data["metrics"]
    session = metrics["session"]
    tool_calls = metrics.get("tool_calls", {})
    tool_errors = metrics.get("tool_errors", {})
    agent_spawns = metrics.get("agent_spawns", {})
    turns = metrics.get("turns", [])

    row = {
        "class_name": class_name,
        "run": run,
        "timestamp": data.get("timestamp", ""),
        "wall_clock_secs": session["wall_clock_secs"],
        "total_cost_usd": session["total_cost_usd"],
        "sdk_turns": session["sdk_turns"],
    }

    # Standard tool counts
    for tool in STANDARD_TOOLS:
        row[f"tool_{tool}"] = tool_calls.get(tool, 0)

    # MCP tool counts (keys in the log use mcp__barista_tools__ prefix)
    for mcp in MCP_TOOLS:
        row[f"tool_mcp_{mcp}"] = tool_calls.get(f"mcp__barista_tools__{mcp}", 0)

    row["total_tool_calls"] = sum(tool_calls.values())
    row["total_tool_errors"] = sum(tool_errors.values())

    # Agent spawns (keys in log use hyphens, we use underscores)
    for agent in AGENT_NAMES:
        hyphen_key = agent.replace("_", "-")
        row[f"spawn_{agent}"] = agent_spawns.get(hyphen_key, 0)

    row["total_agent_spawns"] = sum(agent_spawns.values())
    row["total_turns"] = len(turns)

    return row


def parse_all_logs(agentic_dir: str) -> list[dict]:
    """Walk agentic/ and parse every workflow log. Returns sorted rows."""
    rows = []
    for class_dir in sorted(os.listdir(agentic_dir)):
        class_path = os.path.join(agentic_dir, class_dir)
        if not os.path.isdir(class_path):
            continue
        for run_dir in sorted(os.listdir(class_path)):
            match = re.match(r"run_(\d+)", run_dir)
            if not match:
                continue
            run_num = int(match.group(1))
            log_dir = os.path.join(class_path, run_dir, "logs")
            if not os.path.isdir(log_dir):
                continue
            for log_file in glob.glob(os.path.join(log_dir, "workflow_*.json")):
                with open(log_file) as f:
                    data = json.load(f)
                rows.append(parse_workflow(data, class_dir, run_num))

    rows.sort(key=lambda r: (r["class_name"], r["run"]))
    return rows


def main():
    agentic_dir = os.path.join(os.path.dirname(__file__), "agentic")
    rows = parse_all_logs(agentic_dir)

    out_path = os.path.join(os.path.dirname(__file__), "agent_metrics.csv")
    with open(out_path, "w", newline="") as f:
        writer = csv.DictWriter(f, fieldnames=COLUMNS)
        writer.writeheader()
        writer.writerows(rows)

    print(f"Wrote {len(rows)} rows to {out_path}")


if __name__ == "__main__":
    main()
