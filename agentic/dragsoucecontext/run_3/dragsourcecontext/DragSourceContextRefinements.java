package agentic.dragsoucecontext.run_3.dragsourcecontext;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

@ExternalRefinementsFor("java.awt.dnd.DragSourceContext")
@StateSet({"dragginghaslistener", "draggingnolistener", "ended", "maybedragginghaslistener"})
public interface DragSourceContextRefinements {

    @StateRefinement(to = "maybedragginghaslistener(this)")
    public void DragSourceContext(DragGestureEvent trigger, Cursor dragCursor, Image dragImage, Point offset, Transferable t, DragSourceListener dsl);

    @StateRefinement(from = "maybedragginghaslistener(this)", to = "dragginghaslistener(this)")
    @StateRefinement(from = "draggingnolistener(this)", to = "dragginghaslistener(this)")
    public void addDragSourceListener(DragSourceListener dsl);

    @StateRefinement(from = "!ended(this)", to = "ended(this)")
    public void dragDropEnd(DragSourceDropEvent dsde);

    @StateRefinement(from = "maybedragginghaslistener(this)")
    @StateRefinement(from = "dragginghaslistener(this)")
    @StateRefinement(from = "draggingnolistener(this)")
    public void dragEnter(DragSourceDragEvent dsde);

    @StateRefinement(from = "maybedragginghaslistener(this)")
    @StateRefinement(from = "dragginghaslistener(this)")
    @StateRefinement(from = "draggingnolistener(this)")
    public void dragExit(DragSourceEvent dse);

    @StateRefinement(from = "maybedragginghaslistener(this)")
    @StateRefinement(from = "dragginghaslistener(this)")
    @StateRefinement(from = "draggingnolistener(this)")
    public void dragMouseMoved(DragSourceDragEvent dsde);

    @StateRefinement(from = "maybedragginghaslistener(this)")
    @StateRefinement(from = "dragginghaslistener(this)")
    @StateRefinement(from = "draggingnolistener(this)")
    public void dragOver(DragSourceDragEvent dsde);

    @StateRefinement(from = "maybedragginghaslistener(this)")
    @StateRefinement(from = "dragginghaslistener(this)")
    @StateRefinement(from = "draggingnolistener(this)")
    public void dropActionChanged(DragSourceDragEvent dsde);

    @StateRefinement(from = "maybedragginghaslistener(this)")
    @StateRefinement(from = "dragginghaslistener(this)")
    @StateRefinement(from = "draggingnolistener(this)")
    public Component getComponent();

    @StateRefinement(from = "maybedragginghaslistener(this)")
    @StateRefinement(from = "dragginghaslistener(this)")
    @StateRefinement(from = "draggingnolistener(this)")
    public Cursor getCursor();

    @StateRefinement(from = "maybedragginghaslistener(this)")
    @StateRefinement(from = "dragginghaslistener(this)")
    @StateRefinement(from = "draggingnolistener(this)")
    public DragSource getDragSource();

    @StateRefinement(from = "maybedragginghaslistener(this)")
    @StateRefinement(from = "dragginghaslistener(this)")
    @StateRefinement(from = "draggingnolistener(this)")
    public int getSourceActions();

    @StateRefinement(from = "maybedragginghaslistener(this)")
    @StateRefinement(from = "dragginghaslistener(this)")
    @StateRefinement(from = "draggingnolistener(this)")
    public Transferable getTransferable();

    @StateRefinement(from = "maybedragginghaslistener(this)")
    @StateRefinement(from = "dragginghaslistener(this)")
    @StateRefinement(from = "draggingnolistener(this)")
    public DragGestureEvent getTrigger();

    @StateRefinement(from = "maybedragginghaslistener(this)")
    @StateRefinement(from = "dragginghaslistener(this)", to = "draggingnolistener(this)")
    @StateRefinement(from = "draggingnolistener(this)")
    public void removeDragSourceListener(DragSourceListener dsl);

    @StateRefinement(from = "maybedragginghaslistener(this)")
    @StateRefinement(from = "dragginghaslistener(this)")
    @StateRefinement(from = "draggingnolistener(this)")
    public void setCursor(Cursor c);

    @StateRefinement(from = "maybedragginghaslistener(this)")
    @StateRefinement(from = "dragginghaslistener(this)")
    @StateRefinement(from = "draggingnolistener(this)")
    public void transferablesFlavorsChanged();

    @StateRefinement(from = "maybedragginghaslistener(this)")
    @StateRefinement(from = "dragginghaslistener(this)")
    @StateRefinement(from = "draggingnolistener(this)")
    public void updateCurrentCursor(int sourceAct, int targetAct, int status);

}