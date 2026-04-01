# Workshop: Analyzing AI Agent Data with Agentic Coding Tools

This workshop walks you through analyzing data from **Barista**, a system that uses AI agents to synthesize typestate specifications for Java classes. You'll use agentic coding tools (e.g., Claude Code, Cursor, Copilot) to explore, parse, analyze, and write up findings from 175 agent runs across 35 Java classes.

## Prerequisites

- Python 3.10+ with [uv](https://docs.astral.sh/uv/) installed
- An agentic coding tool of your choice
- LaTeX distribution (for the final step)

## Setup

```bash
git clone <repo-url>
cd <repo-name>
uv sync
```

---

## Step 1: Understand the Repository

**Goal:** Get familiar with the data and what it represents.

**What to ask the agent:**

> "You are a researcher in Software Engineering. Look at the files and folder to understand what's in this repo. Make me an HTML of what it does and the files that exist."

- **Role definition** — define a role for your agent
- **Concrete output format** — asking for HTML gives the agent a clear deliverable, not just a chat response
- **Open-ended exploration** — letting the agent decide what to include tests whether it can find the important parts on its own

**Key questions to answer:**
- How many classes are there? How many runs per class?
- What metrics does a workflow log capture?
- What is a typestate specification?
- What complexity levels exist and how are they determined?

---

## Step 2: Parse Workflow Logs into a CSV

**Goal:** Extract key metrics from all 175 workflow log JSON files into a structured CSV.

**What to ask the agent:**

> "Can we join the info from the logs into a CSV? Create tests first and then do it."

- **"Tests first"** — forces a Test-Driven Development workflow: the agent writes tests before implementation, catching edge cases early
- **Casual phrasing works** — you don't need a precise spec; the agent explores the log structure itself


**Expected output:** A CSV file with one row per run containing agent performance metrics.

---

## Step 3: Create an Analysis Notebook

**Goal:** Build a Jupyter notebook that analyzes the CSV and produces visualizations.

**What to ask the agent:**

> "We need to analyze these results. Plan an analysis using the logs and the complexity ratings. Think about the main interesting results, ask questions back. Only create the notebook after planning."

- **"Plan ... ask questions back"** — prevents the agent from rushing into code; it proposes an analysis plan and asks clarifying questions first (e.g., how to treat "none" classes, which hypotheses to prioritize)
- **"Only create after planning"** — separates thinking from doing; you review the plan before any code is written
- **Pointing to both data sources** — tells the agent to join the metrics CSV with the complexity CSV, which it might not do on its own

**Suggested analyses:**
- Are there outlier runs that cost significantly more? Which classes?
- Is there high variance across runs for the same class?
- Do complex classes cost more or take longer than simple ones?
- Which sub-agents (protocol-analyzer, liquidjava-spec-writer, etc.) are spawned most often?
- Is there a correlation between number of tool calls and cost?

---

## Step 4: Review

**Goal:** Critically review the notebook and refine the analysis.

**What to ask the agent:**

> "Review the notebook for correctness, completeness, and clarity. Are the statistical tests appropriate? Are there analyses missing? Suggest additional analyses I might not have considered."

- **Explicit review criteria** — "correctness, completeness, clarity" gives the agent a checklist instead of a vague "looks good?"
- **"Are the tests appropriate?"** — prompts the agent to think critically, not just agree with what it already produced
- **Asking for suggestions** — the agent may spot patterns you missed (e.g., outlier analysis, efficiency metrics)

---

## Step 5: Write a Results Section in LaTeX

**Goal:** Draft a results section for `paper.tex` based on your analysis.

**What to ask the agent:**

> "Fill in the Results section of `paper.tex` based on the notebook findings. Include a LaTeX table with per-complexity-level metrics and references to figures. Keep results factual, save interpretation for Discussion."

- **Grounding in existing work** — "based on the notebook findings" tells the agent to pull numbers from what was already computed, not invent new analysis
- **Specifying structure** — "LaTeX table" and "references to figures" set concrete expectations for the output format
- **Style guidance** — "factual, save interpretation for Discussion" prevents the agent from editorializing in the wrong section

---

## Wrap-Up

By the end of this workshop you will have:
- Explored a real research dataset using agentic coding tools
- Written a data processing script
- Created an analysis notebook with visualizations
- Reviewed and refined your work
- Drafted a LaTeX paper section

Reflect on how the agentic coding tools helped (or didn't) at each step. Which steps benefited most from AI assistance? Where did you need to guide the tool most?
