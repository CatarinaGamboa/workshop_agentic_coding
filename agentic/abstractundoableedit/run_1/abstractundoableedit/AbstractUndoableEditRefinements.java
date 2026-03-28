package agentic.abstractundoableedit.run_1.abstractundoableedit;

import javax.swing.undo.UndoableEdit;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("javax.swing.undo.AbstractUndoableEdit")
@StateSet({"dead", "done", "undone"})
public interface AbstractUndoableEditRefinements {

    @StateRefinement(to = "done(this)")
    public void AbstractUndoableEdit();

    @StateRefinement(from = "done(this)")
    @StateRefinement(from = "undone(this)")
    public boolean addEdit(UndoableEdit anEdit);

    @StateRefinement(from = "done(this)")
    @StateRefinement(from = "undone(this)")
    public boolean canRedo();

    @StateRefinement(from = "done(this)")
    @StateRefinement(from = "undone(this)")
    public boolean canUndo();

    @StateRefinement(to = "dead(this)")
    public void die();

    @StateRefinement(from = "done(this)")
    @StateRefinement(from = "undone(this)")
    public String getPresentationName();

    @StateRefinement(from = "done(this)")
    @StateRefinement(from = "undone(this)")
    public String getRedoPresentationName();

    @StateRefinement(from = "done(this)")
    @StateRefinement(from = "undone(this)")
    public String getUndoPresentationName();

    @StateRefinement(from = "done(this)")
    @StateRefinement(from = "undone(this)")
    public boolean isSignificant();

    @StateRefinement(from = "undone(this)", to = "done(this)")
    public void redo();

    @StateRefinement(from = "done(this)")
    @StateRefinement(from = "undone(this)")
    public boolean replaceEdit(UndoableEdit anEdit);

    @StateRefinement(from = "done(this)")
    @StateRefinement(from = "undone(this)")
    public String toString();

    @StateRefinement(from = "done(this)", to = "undone(this)")
    public void undo();

}