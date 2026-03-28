package agentic.abstractundoableedit.run_3.abstractundoableedit;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("javax.swing.undo.AbstractUndoableEdit")
@StateSet({"dead", "done", "undone"})
public interface AbstractUndoableEditRefinements {

    @StateRefinement(to = "done(this)")
    public void AbstractUndoableEdit();

    @StateRefinement(from = "done(this)", to = "dead(this)")
    @StateRefinement(from = "undone(this)", to = "dead(this)")
    @StateRefinement(from = "dead(this)", to = "dead(this)")
    public void die();

    @StateRefinement(from = "undone(this)", to = "done(this)")
    public void redo();

    @StateRefinement(from = "done(this)", to = "undone(this)")
    public void undo();

    @StateRefinement(from = "done(this)", to = "done(this)")
    @StateRefinement(from = "undone(this)", to = "undone(this)")
    @StateRefinement(from = "dead(this)", to = "dead(this)")
    public boolean addEdit(javax.swing.undo.UndoableEdit anEdit);

    @StateRefinement(from = "done(this)", to = "done(this)")
    @StateRefinement(from = "undone(this)", to = "undone(this)")
    @StateRefinement(from = "dead(this)", to = "dead(this)")
    public boolean replaceEdit(javax.swing.undo.UndoableEdit anEdit);

    @StateRefinement(from = "done(this)", to = "done(this)")
    @StateRefinement(from = "undone(this)", to = "undone(this)")
    @StateRefinement(from = "dead(this)", to = "dead(this)")
    public boolean canRedo();

    @StateRefinement(from = "done(this)", to = "done(this)")
    @StateRefinement(from = "undone(this)", to = "undone(this)")
    @StateRefinement(from = "dead(this)", to = "dead(this)")
    public boolean canUndo();

    @StateRefinement(from = "done(this)", to = "done(this)")
    @StateRefinement(from = "undone(this)", to = "undone(this)")
    @StateRefinement(from = "dead(this)", to = "dead(this)")
    public boolean isSignificant();

}
