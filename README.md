# Workshop: Analyzing AI Agent Data with Agentic Coding Tools

This repository provides materials for a hands-on workshop on using **agentic coding tools** (Claude Code, Cursor, Copilot, etc.) to explore, analyze, and write up findings from a real research dataset.

## Prerequisites

- Python 3.10+ with [uv](https://docs.astral.sh/uv/) installed
- An agentic coding tool of your choice (Claude Code, Cursor, Copilot, etc.)
- LaTeX distribution (optional, for the final writing step)

## Getting Started

```bash
git clone <repo-url>
cd workshop_agentic_coding
uv sync
```

Then open `WORKSHOP.md` for the full workshop guide.

## Workshop Steps

| Step | Goal | Key Skill Practiced |
|------|------|---------------------|
| 1. **Explore** | Understand the repo structure and data | Prompting for open-ended exploration |
| 2. **Parse** | Extract metrics from workflow logs into a CSV | Test-driven development with an agent |
| 3. **Analyze** | Create a Jupyter notebook with visualizations | Planning before implementation |
| 4. **Review** | Critically review and refine the analysis | Using agents for code review |
| 5. **Write** | Draft a results section in LaTeX | Grounding generated text in data |

## Dataset

The dataset comes from **Barista**, a system that uses AI agents to synthesize [typestate](https://en.wikipedia.org/wiki/Typestate_analysis) specifications for Java standard library classes. It contains results from **175 agent runs** (35 classes × 5 independent runs each), including workflow logs, generated specifications, and state machine diagrams.

## What is Typestate?

Typestate is a protocol that tracks which methods are valid to call based on an object's current state. For example, you can't `read()` from a stream that has already been `close()`d. Barista uses AI agents to automatically discover these protocols and express them as [LiquidJava](https://catarinagamboa.github.io/liquidjava.html) refinement annotations.

## Repository Structure

```
.
├── agentic/                    # Agent-generated results (35 classes × 5 runs)
│   └── <class>/
│       └── run_{1..5}/
│           ├── logs/
│           │   └── workflow_*.json          # Agent execution log (cost, duration, tool calls)
│           └── <class>/
│               ├── <Class>Refinements.java  # Generated typestate specification
│               ├── <Class>.mmd              # Mermaid state diagram
│               └── <Class>.json             # State machine (JSON)
├── manual/
│   └── complexity/
│       ├── complexity_review_final.csv      # Expert complexity ratings per class
│       └── complexity_rubric.md             # Rubric used for ratings
├── paper.tex                   # LaTeX paper template to fill in
├── listClasses.txt             # The 35 fully qualified Java class names
├── pyproject.toml              # Python dependencies (managed with uv)
├── WORKSHOP.md                 # Detailed workshop instructions
└── CLAUDE.md                   # Instructions for AI coding assistants
```


## Workflow Log Metrics

Each `workflow_*.json` captures:

- **Session metrics** — wall clock time, total cost (USD), number of SDK turns
- **Tool call counts** — per tool (Read, Write, Bash, MCP tools, etc.)
- **Agent spawns** — which sub-agents were invoked
- **Per-agent breakdown** — turns and tool calls by agent
- **Turn sequence** — ordered list of agent turns with tool call details

## Java Classes

The 35 classes span the Java standard library across several packages (`java.io`, `java.net`, `java.util`, `javax.swing`, etc.) and range from classes with no meaningful typestate (e.g., `PopupMenu`, `Clipboard`) to complex protocol-driven classes (e.g., `Socket`, `ZipOutputStream`, `LoginContext`).

See `listClasses.txt` for the full list.

## License

MIT — see [LICENSE](LICENSE) for details.
