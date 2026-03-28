package agentic.dragsoucecontext.run_5.dragsourcecontext;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.awt.Cursor;
import java.awt.Component;
import java.awt.Image;
import java.awt.Point;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.datatransfer.Transferable;

@ExternalRefinementsFor("java.awt.dnd.DragSourceContext")
@StateSet({"dragging", "ended", "overtarget"})
@RefinementAlias("DnDAction(int v) { v >= 0 }")
public interface DragSourceContextRefinements {

    @StateRefinement(to = "dragging(this)")
    public void DragSourceContext(DragGestureEvent trigger, Cursor dragCursor, Image dragImage, Point offset, Transferable t, DragSourceListener dsl);

    @StateRefinement(from = "dragging(this)")
    @StateRefinement(from = "overtarget(this)")
    public void addDragSourceListener(DragSourceListener dsl);

    @StateRefinement(from = "!ended(this)", to = "ended(this)")
    public void dragDropEnd(DragSourceDropEvent dsde);

    @StateRefinement(from = "dragging(this)", to = "overtarget(this)")
    public void dragEnter(DragSourceDragEvent dsde);

    @StateRefinement(from = "overtarget(this)", to = "dragging(this)")
    public void dragExit(DragSourceEvent dse);

    @StateRefinement(from = "dragging(this)")
    @StateRefinement(from = "overtarget(this)")
    public void dragMouseMoved(DragSourceDragEvent dsde);

    @StateRefinement(from = "overtarget(this)")
    public void dragOver(DragSourceDragEvent dsde);

    @StateRefinement(from = "overtarget(this)")
    public void dropActionChanged(DragSourceDragEvent dsde);

    @StateRefinement(from = "dragging(this)")
    @StateRefinement(from = "overtarget(this)")
    public Component getComponent();

    @StateRefinement(from = "dragging(this)")
    @StateRefinement(from = "overtarget(this)")
    public Cursor getCursor();

    @StateRefinement(from = "dragging(this)")
    @StateRefinement(from = "overtarget(this)")
    public DragSource getDragSource();

    @StateRefinement(from = "dragging(this)")
    @StateRefinement(from = "overtarget(this)")
    @Refinement("DnDAction(_)")
    public int getSourceActions();

    @StateRefinement(from = "dragging(this)")
    @StateRefinement(from = "overtarget(this)")
    public Transferable getTransferable();

    @StateRefinement(from = "dragging(this)")
    @StateRefinement(from = "overtarget(this)")
    public DragGestureEvent getTrigger();

    @StateRefinement(from = "dragging(this)")
    @StateRefinement(from = "overtarget(this)")
    public void removeDragSourceListener(DragSourceListener dsl);

    @StateRefinement(from = "dragging(this)")
    @StateRefinement(from = "overtarget(this)")
    public void setCursor(Cursor c);

    @StateRefinement(from = "dragging(this)")
    @StateRefinement(from = "overtarget(this)")
    public void transferablesFlavorsChanged();

    @StateRefinement(from = "dragging(this)")
    @StateRefinement(from = "overtarget(this)")
    public void updateCurrentCursor(@Refinement("DnDAction(sourceAct)") int sourceAct, @Refinement("DnDAction(targetAct)") int targetAct, @Refinement("status >= 0 && status <= 3") int status);

}