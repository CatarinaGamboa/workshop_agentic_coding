package agentic.undomanager.run_4.undomanager;

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

    @StateRefinement(to = "ended(this)")
    public void end();

    @StateRefinement(from = "inprogress(this)")
    public void setLimit(@Refinement("true") int l);

    public int getLimit();

    public void discardAllEdits();

    public UndoableEdit editToBeUndone();

    public UndoableEdit editToBeRedone();

    public void undoTo(UndoableEdit edit) throws javax.swing.undo.CannotUndoException;

    public void redoTo(UndoableEdit edit) throws javax.swing.undo.CannotRedoException;

    public void undoOrRedo() throws javax.swing.undo.CannotRedoException, javax.swing.undo.CannotUndoException;

    public boolean canUndoOrRedo();

    public void undo() throws javax.swing.undo.CannotUndoException;

    public boolean canUndo();

    public void redo() throws javax.swing.undo.CannotRedoException;

    public boolean canRedo();

    public boolean addEdit(UndoableEdit anEdit);

    public String getUndoOrRedoPresentationName();

    public String getUndoPresentationName();

    public String getRedoPresentationName();

    public void trimForLimit();

    public void trimEdits(@Refinement("from >= 0") int from, @Refinement("to >= 0") int to);

    public void undoableEditHappened(UndoableEditEvent e);

    public String toString();

}
