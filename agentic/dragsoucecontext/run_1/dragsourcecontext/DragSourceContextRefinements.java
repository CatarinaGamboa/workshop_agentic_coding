package agentic.dragsoucecontext.run_1.dragsourcecontext;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
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
@StateSet({"ended", "haslistener", "maybelistener"})
@RefinementAlias("NonNegative(int x) { x >= 0 }")
public interface DragSourceContextRefinements {

    @StateRefinement(to = "maybelistener(this)")
    public void DragSourceContext(DragGestureEvent trigger, Cursor dragCursor, Image dragImage, Point offset, Transferable t, DragSourceListener dsl);

    @StateRefinement(from = "maybelistener(this)", to = "haslistener(this)")
    public void addDragSourceListener(DragSourceListener dsl);

    @StateRefinement(from = "!ended(this)", to = "ended(this)")
    public void dragDropEnd(DragSourceDropEvent dsde);

    @StateRefinement(from = "maybelistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void dragEnter(DragSourceDragEvent dsde);

    @StateRefinement(from = "maybelistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void dragExit(DragSourceEvent dse);

    @StateRefinement(from = "maybelistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void dragMouseMoved(DragSourceDragEvent dsde);

    @StateRefinement(from = "maybelistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void dragOver(DragSourceDragEvent dsde);

    @StateRefinement(from = "maybelistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void dropActionChanged(DragSourceDragEvent dsde);

    @StateRefinement(from = "maybelistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public Component getComponent();

    @StateRefinement(from = "maybelistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public Cursor getCursor();

    @StateRefinement(from = "maybelistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public DragSource getDragSource();

    @StateRefinement(from = "maybelistener(this)")
    @StateRefinement(from = "haslistener(this)")
    @Refinement("NonNegative(_)")
    public int getSourceActions();

    @StateRefinement(from = "maybelistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public Transferable getTransferable();

    @StateRefinement(from = "maybelistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public DragGestureEvent getTrigger();

    @StateRefinement(from = "maybelistener(this)")
    @StateRefinement(from = "haslistener(this)", to = "maybelistener(this)")
    public void removeDragSourceListener(DragSourceListener dsl);

    @StateRefinement(from = "maybelistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void setCursor(Cursor c);

    @StateRefinement(from = "maybelistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void transferablesFlavorsChanged();

    @StateRefinement(from = "maybelistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void updateCurrentCursor(@Refinement("NonNegative(sourceAct)") int sourceAct, @Refinement("NonNegative(targetAct)") int targetAct, @Refinement("NonNegative(status)") int status);

}