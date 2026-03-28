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

**Tasks:**
1. Ask your agentic tool to explain the repository structure
2. Explore the `agentic/` directory — understand the class/run/file hierarchy
3. Open a workflow log (e.g., `agentic/throwable/run_1/logs/workflow_*.json`) and understand its structure
4. Open a refinements file (e.g., `agentic/throwable/run_1/throwable/ThrowableRefinements.java`) and understand what a typestate specification looks like
5. Look at the Mermaid diagram (`.mmd`) and state machine JSON (`.json`) for the same class
6. Check `listClasses.txt` to see all 35 target classes
7. Read `manual/complexity/complexity_rubric.md` to understand how specification complexity is classified

**Key questions to answer:**
- How many classes are there? How many runs per class?
- What metrics does a workflow log capture?
- What is a typestate specification?
- What complexity levels exist and how are they determined?

---

## Step 2: Parse Workflow Logs into a CSV

**Goal:** Extract key metrics from all 175 workflow log JSON files into a structured CSV.

**Tasks:**
1. Ask your agentic tool to write a Python script that:
   - Reads all `workflow_*.json` files from `agentic/`
   - Extracts relevant metrics (at minimum: class name, run number, wall_clock_secs, total_cost_usd, sdk_turns, tool call counts, agent spawn counts)
   - Outputs a CSV file (e.g., `agent_metrics.csv`)
2. Run the script: `uv run python3 <script_name>.py`
3. Verify the output — check that you have 175 rows (or close to it), one per run
4. Optionally, enrich the CSV by joining with `manual/complexity/complexity_review_final.csv` to add the complexity rating per class

**Hints:**
- The workflow logs have nested JSON — `metrics.session.wall_clock_secs`, `metrics.tool_calls`, etc.
- Some fields may vary across logs — handle missing keys gracefully
- Remember to use `uv run python3` (not bare `python3`)

**Expected output:** A CSV file with one row per run containing agent performance metrics.

---

## Step 3: Create an Analysis Notebook

**Goal:** Build a Jupyter notebook that analyzes the CSV and produces visualizations.

**Tasks:**
1. Ask your agentic tool to create a Jupyter notebook that:
   - Loads the CSV from Step 2
   - Computes summary statistics (mean, std, min, max) for cost and duration
   - Creates visualizations, for example:
     - Distribution of cost per run (histogram or boxplot)
     - Distribution of duration per run
     - Cost vs. duration scatter plot
     - Tool usage breakdown (which tools are used most?)
     - Agent turns distribution
     - Per-class comparison (which classes required more effort?)
     - Cost/duration by complexity level (if you joined complexity data)
   - Adds markdown cells explaining each analysis
2. Run the notebook and verify the plots render correctly
3. Iterate — ask your agentic tool to refine or add analyses based on what you see

**Suggested analyses:**
- Are there outlier runs that cost significantly more? Which classes?
- Is there high variance across runs for the same class?
- Do complex classes cost more or take longer than simple ones?
- Which sub-agents (protocol-analyzer, liquidjava-spec-writer, etc.) are spawned most often?
- Is there a correlation between number of tool calls and cost?

---

## Step 4: Review

**Goal:** Critically review the notebook and refine the analysis.

**Tasks:**
1. Ask your agentic tool to review the notebook for:
   - Correctness — are the statistics computed correctly?
   - Completeness — are there obvious analyses missing?
   - Clarity — are the plots well-labeled and the markdown explanations clear?
   - Code quality — is the code clean and well-organized?
2. Address any issues found
3. Ask your agentic tool to suggest additional analyses you might not have considered
4. Add at least one new analysis based on the suggestions
5. Re-run the notebook to ensure everything is consistent

**Review checklist:**
- [ ] All plots have titles, axis labels, and legends where appropriate
- [ ] Summary statistics are reported with appropriate precision
- [ ] Outliers or interesting patterns are discussed
- [ ] The notebook tells a coherent story from start to finish

---

## Step 5: Write a Results Section in LaTeX

**Goal:** Draft a results section for `paper.tex` based on your analysis.

**Tasks:**
1. Open `paper.tex` — it has a skeleton with TODO sections
2. Ask your agentic tool to help you fill in the Results section based on the notebook findings
3. Include:
   - Key statistics (mean cost, mean duration, variance across runs)
   - At least one LaTeX table summarizing results (e.g., per-complexity-level metrics)
   - References to figures (you can export notebook plots as PDFs for inclusion)
   - Brief interpretation of the findings
4. Fill in other sections as time permits (Introduction, Methodology, Discussion)
5. Compile the paper: `pdflatex paper.tex`

**Tips:**
- Export plots from the notebook as PDF: `fig.savefig('figure.pdf', bbox_inches='tight')`
- Use `\begin{table}...\end{table}` for tables, `\begin{figure}...\end{figure}` for plots
- Keep the results factual — save interpretation for the Discussion section

---

## Wrap-Up

By the end of this workshop you will have:
- Explored a real research dataset using agentic coding tools
- Written a data processing script
- Created an analysis notebook with visualizations
- Reviewed and refined your work
- Drafted a LaTeX paper section

Reflect on how the agentic coding tools helped (or didn't) at each step. Which steps benefited most from AI assistance? Where did you need to guide the tool most?
