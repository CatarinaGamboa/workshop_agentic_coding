"""Parse Barista workflow logs into a CSV with one row per run."""
import csv
import json
from pathlib import Path


def parse_workflow_log(log_path: Path, class_name: str, run: int) -> dict:
    """Parse a single workflow JSON log into a flat dict of metrics."""
    with open(log_path) as f:
        data = json.load(f)

    metrics = data["metrics"]
    session = metrics["session"]

    row = {
        "class_name": class_name,
        "run": run,
        "timestamp": data["timestamp"],
        "wall_clock_secs": session["wall_clock_secs"],
        "total_cost_usd": session["total_cost_usd"],
        "sdk_turns": session["sdk_turns"],
    }

    # Tool calls
    tool_calls = metrics.get("tool_calls", {})
    row["total_tool_calls"] = sum(tool_calls.values())
    for tool, count in tool_calls.items():
        row[f"tool_{tool}"] = count

    # Tool errors
    tool_errors = metrics.get("tool_errors", {})
    row["total_tool_errors"] = sum(tool_errors.values())

    # Agent spawns
    agent_spawns = metrics.get("agent_spawns", {})
    row["total_agent_spawns"] = sum(agent_spawns.values())

    # Per-agent turns
    agents = metrics.get("agents", {})
    for agent_name, agent_data in agents.items():
        row[f"agent_turns_{agent_name}"] = agent_data["turns"]

    # Total turns
    row["total_turns"] = len(metrics.get("turns", []))

    return row


def collect_all_logs(agentic_dir: Path) -> list[dict]:
    """Walk the agentic directory and parse all workflow logs."""
    rows = []
    agentic_dir = Path(agentic_dir)

    for class_dir in sorted(agentic_dir.iterdir()):
        if not class_dir.is_dir():
            continue
        class_name = class_dir.name

        for run_dir in sorted(class_dir.iterdir()):
            if not run_dir.is_dir() or not run_dir.name.startswith("run_"):
                continue
            run_num = int(run_dir.name.split("_")[1])

            logs_dir = run_dir / "logs"
            if not logs_dir.exists():
                continue

            for log_file in sorted(logs_dir.glob("workflow_*.json")):
                row = parse_workflow_log(log_file, class_name, run_num)
                rows.append(row)

    rows.sort(key=lambda r: (r["class_name"], r["run"]))
    return rows


def write_csv(rows: list[dict], output_path: Path) -> None:
    """Write rows to CSV, unifying all columns with 0 for missing values."""
    if not rows:
        return

    # Collect all keys across all rows
    all_keys = set()
    for row in rows:
        all_keys.update(row.keys())

    # Fixed column order: identifiers first, then session, then sorted remainder
    fixed_start = ["class_name", "run", "timestamp", "wall_clock_secs", "total_cost_usd",
                    "sdk_turns", "total_tool_calls", "total_tool_errors",
                    "total_agent_spawns", "total_turns"]
    remaining = sorted(all_keys - set(fixed_start))
    fieldnames = fixed_start + remaining

    with open(output_path, "w", newline="") as f:
        writer = csv.DictWriter(f, fieldnames=fieldnames)
        writer.writeheader()
        for row in rows:
            # Fill missing keys with 0
            full_row = {k: row.get(k, 0) for k in fieldnames}
            writer.writerow(full_row)


if __name__ == "__main__":
    agentic_dir = Path(__file__).parent / "agentic"
    output = Path(__file__).parent / "workflow_metrics.csv"
    rows = collect_all_logs(agentic_dir)
    write_csv(rows, output)
    print(f"Wrote {len(rows)} rows to {output}")
