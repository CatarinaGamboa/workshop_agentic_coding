package agentic.abstractundoableedit.run_4.abstractundoableedit;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import javax.swing.undo.UndoableEdit;

@ExternalRefinementsFor("javax.swing.undo.AbstractUndoableEdit")
@StateSet({"dead", "done", "undone"})
public interface AbstractUndoableEditRefinements {

    @StateRefinement(to = "done(this)")
    public void AbstractUndoableEdit();

    @StateRefinement(to = "dead(this)")
    public void die();

    @StateRefinement(from = "done(this)", to = "undone(this)")
    public void undo();

    @StateRefinement(from = "undone(this)", to = "done(this)")
    public void redo();

    public boolean canUndo();

    public boolean canRedo();

    public boolean addEdit(UndoableEdit anEdit);

    public boolean replaceEdit(UndoableEdit anEdit);

    public boolean isSignificant();

    public String getPresentationName();

    public String getUndoPresentationName();

    public String getRedoPresentationName();

    public String toString();

}
