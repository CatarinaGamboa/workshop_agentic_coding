package agentic.undomanager.run_3.undomanager;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import javax.swing.undo.UndoableEdit;
import javax.swing.event.UndoableEditEvent;

@ExternalRefinementsFor("javax.swing.undo.UndoManager")
@StateSet({"ended", "inprogress"})
public interface UndoManagerRefinements {

    // Constructor: transitions to inprogress state
    @StateRefinement(to = "inprogress(this)")
    public void UndoManager();

    // end(): transitions from inprogress (or any non-ended state) to ended
    @StateRefinement(from = "!ended(this)", to = "ended(this)")
    public void end();

    // setLimit(): only callable in inprogress state (throws RuntimeException in ended state)
    @StateRefinement(from = "inprogress(this)")
    public void setLimit(int l);

    // getLimit(): callable from any state; returns the maximum number of edits (< 0 means unlimited)
    public int getLimit();

    // discardAllEdits(): callable from any state
    public void discardAllEdits();

    // trimForLimit(): callable from any state
    public void trimForLimit();

    // trimEdits(): callable from any state; operates on index range [from, to]
    public void trimEdits(int from, int to);

    // editToBeUndone(): callable from any state
    public UndoableEdit editToBeUndone();

    // editToBeRedone(): callable from any state
    public UndoableEdit editToBeRedone();

    // undoTo(): callable from any state
    public void undoTo(UndoableEdit edit);

    // redoTo(): callable from any state
    public void redoTo(UndoableEdit edit);

    // undoOrRedo(): callable from any state
    public void undoOrRedo();

    // canUndoOrRedo(): callable from any state
    public boolean canUndoOrRedo();

    // undo(): callable from any state
    public void undo();

    // canUndo(): callable from any state
    public boolean canUndo();

    // redo(): callable from any state
    public void redo();

    // canRedo(): callable from any state
    public boolean canRedo();

    // addEdit(): callable from any state; returns false when in ended state
    public boolean addEdit(UndoableEdit anEdit);

    // getUndoOrRedoPresentationName(): callable from any state
    public String getUndoOrRedoPresentationName();

    // getUndoPresentationName(): callable from any state
    public String getUndoPresentationName();

    // getRedoPresentationName(): callable from any state
    public String getRedoPresentationName();

    // undoableEditHappened(): callable from any state
    public void undoableEditHappened(UndoableEditEvent e);

    // toString(): callable from any state
    public String toString();

}