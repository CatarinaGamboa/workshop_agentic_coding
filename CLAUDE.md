# CLAUDE.md

## Project Summary

This repository contains data from **Barista**, a system that uses AI agents to synthesize typestate specifications for Java classes. It includes workflow logs and generated specifications from 35 Java standard library classes, each run 5 times independently.

## Key Concepts

- **Typestate**: A protocol that tracks which methods are valid to call based on an object's state (e.g., you can't read from a closed stream)
- **LiquidJava**: A verification framework that checks Java code against typestate refinements using `@StateSet`, `@StateRefinement`, and `@Refinement` annotations
- **Refinements file**: A `*Refinements.java` file that declares states and method contracts for a Java class

## Directory Layout

- `agentic/` — 35 classes x 5 runs, each containing:
  - `logs/workflow_*.json` — agent execution logs (cost, duration, tool calls, agent turns)
  - `{class}/{ClassRefinements.java}` — generated typestate specification
  - `{class}/{Class.mmd}` — Mermaid state diagram
  - `{class}/{Class.json}` — state machine in JSON format
- `listClasses.txt` — the 35 fully qualified Java class names

## Workflow Log Structure

Each `workflow_*.json` contains:
- `metrics.session` — wall_clock_secs, total_cost_usd, sdk_turns
- `metrics.tool_calls` — counts per tool (Read, Write, Bash, MCP tools, etc.)
- `metrics.agent_spawns` — which sub-agents were invoked
- `metrics.agents` — per-agent turn and tool call breakdown
- `metrics.turns` — ordered list of agent turns with tool call counts

## Python Environment

This project uses **uv** for Python dependency management. Always use `uv run` to execute Python scripts:

```bash
uv run python3 script.py   # NOT python3 script.py
```

## Workshop Tasks

1. **Explore** — Understand the repo structure and data
2. **Parse** — Extract metrics from workflow logs into a CSV
3. **Analyze** — Create a Jupyter notebook to analyze the data
4. **Review** — Review and refine the analysis
5. **Write** — Draft a results section in LaTeX

## Important Notes

- The `dragsoucecontext` folder has a known typo (missing 'r') in the outer folder name
- Some classes have 0 states (no typestate needed): PopupMenu, Clipboard, ThreadGroup, etc.
- There are 35 classes x 5 runs = 175 total runs
