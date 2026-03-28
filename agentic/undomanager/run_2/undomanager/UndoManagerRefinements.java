package agentic.undomanager.run_2.undomanager;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import javax.swing.undo.UndoableEdit;
import javax.swing.event.UndoableEditEvent;

@ExternalRefinementsFor("javax.swing.undo.UndoManager")
@StateSet({"ended", "inprogress"})
public interface UndoManagerRefinements {

    @StateRefinement(to = "inprogress(this)")
    public void UndoManager();

    public int getLimit();

    public void discardAllEdits();

    public void trimForLimit();

    public void trimEdits(int from, int to);

    @StateRefinement(from = "inprogress(this)")
    public void setLimit(int l);

    public UndoableEdit editToBeUndone();

    public UndoableEdit editToBeRedone();

    public void undoTo(UndoableEdit edit);

    public void redoTo(UndoableEdit edit);

    public void undoOrRedo();

    public boolean canUndoOrRedo();

    public void undo();

    public boolean canUndo();

    public void redo();

    public boolean canRedo();

    public boolean addEdit(UndoableEdit anEdit);

    @StateRefinement(to = "ended(this)")
    public void end();

    public String getUndoOrRedoPresentationName();

    public String getUndoPresentationName();

    public String getRedoPresentationName();

    public void undoableEditHappened(UndoableEditEvent e);

    public String toString();

}