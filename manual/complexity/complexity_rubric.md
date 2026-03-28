# Specification Complexity Rubric

This rubric classifies the specification complexity of encoding a Java class's typestate protocol as a LiquidJava specification. Complexity is determined by counting **factors** — structural features that increase the difficulty of producing a correct specification.

- **none** — no typestate protocol exists
- **simple** — no factors
- **moderate** — one factor
- **complex** — two or more factors

## Filter: State Protocol

> Does this class have a meaningful state protocol?

| Value | Description |
|-------|-------------|
| **no** | The class has no meaningful states — methods are always valid regardless of history |
| **yes** | The class has at least one state-dependent method constraint |

If **no** → complexity is `none`. Stop here.

## Factors

Each of the following is a **factor**. Count how many are present.

| Factor | Description |
|--------|-------------|
| **Branching transitions** | Same method leads to different target states depending on source state — requires multiple `@StateRefinement` entries with different from/to pairs for one method |
| **Scale** | >5 unique transition patterns (distinct source→target pairs) OR ≥20 annotated methods. These are correlated measures of specification size — count as one factor even if both trigger |
| **More than one state set** | Two or more independent state dimensions where at least one has >2 states |
| **State-dependent value refinements** | Value refinements interact with state transitions — state is determined by parameter values, or refinements are conditional on the current state |
| **Encoding workarounds** | The protocol requires features not supported by LiquidJava, forcing non-standard annotation patterns or significant feature drops (multi-class typestate, unsupported types, mixing value and state refinements in ways the tool cannot handle) |

## Classification

```
No state protocol?
  → none

Two or more factors?
  → complex

Exactly one factor?
  → moderate

No factors?
  → simple
```

## Evidence-Based Annotation

Reviewers should ground their classification in concrete evidence from the expert annotation process. Each class has a `RATIONALE.md` file (in `src/main/java/agentic_vs_expert/<class>/`) that records annotator rationales, tool limitations, and final decisions.

**Process:**

1. **Read** the class's `RATIONALE.md` and expert refinement files
2. **Identify factors** — check for each factor listed above
3. **Count and classify** — apply the classification rules

**Evidence indicators from RATIONALE.md:**

| Indicator | Points to |
|-----------|-----------|
| Few methods, fixed source→target transitions | no factors (simple) |
| Same method has multiple `@StateRefinement` with different from/to | branching |
| >5 distinct (source→target) pairs in expert spec | scale |
| ≥20 methods requiring state annotations | scale |
| More than one state set where at least one has >2 states | more than one state set |
| Value refinements that interact with state transitions | state-dependent values |
| Non-standard annotation patterns forced by tool limitations | encoding workarounds |
| Significant protocol features dropped because LiquidJava cannot express them | encoding workarounds |
| Multi-class typestate dependencies | encoding workarounds |

## Summary

| Level | Rule | Key Signal |
|-------|------|------------|
| none | No state protocol | Methods always valid regardless of history |
| simple | Zero factors | Fixed transitions, single state set, small spec |
| moderate | Exactly one factor | One structural complication |
| complex | Two or more factors | Multiple complications compound |
