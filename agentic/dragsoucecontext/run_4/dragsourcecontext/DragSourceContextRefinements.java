package agentic.dragsoucecontext.run_4.dragsourcecontext;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.datatransfer.Transferable;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.awt.dnd.DragSourceContext")
@StateSet({"ended", "haslistener", "nolistener"})
public interface DragSourceContextRefinements {

    @StateRefinement(to = "nolistener(this)")
    public void DragSourceContext(DragGestureEvent trigger, Cursor dragCursor, Image dragImage, Point offset, Transferable t, DragSourceListener dsl);

    @StateRefinement(from = "nolistener(this)", to = "haslistener(this)")
    public void addDragSourceListener(DragSourceListener dsl);

    @StateRefinement(from = "!ended(this)", to = "ended(this)")
    public void dragDropEnd(DragSourceDropEvent dsde);

    @StateRefinement(from = "nolistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void dragEnter(DragSourceDragEvent dsde);

    @StateRefinement(from = "nolistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void dragExit(DragSourceEvent dse);

    @StateRefinement(from = "nolistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void dragMouseMoved(DragSourceDragEvent dsde);

    @StateRefinement(from = "nolistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void dragOver(DragSourceDragEvent dsde);

    @StateRefinement(from = "nolistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void dropActionChanged(DragSourceDragEvent dsde);

    @StateRefinement(from = "nolistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public Component getComponent();

    @StateRefinement(from = "nolistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public Cursor getCursor();

    @StateRefinement(from = "nolistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public DragSource getDragSource();

    @StateRefinement(from = "nolistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public int getSourceActions();

    @StateRefinement(from = "nolistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public Transferable getTransferable();

    @StateRefinement(from = "nolistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public DragGestureEvent getTrigger();

    @StateRefinement(from = "nolistener(this)")
    @StateRefinement(from = "haslistener(this)", to = "nolistener(this)")
    public void removeDragSourceListener(DragSourceListener dsl);

    @StateRefinement(from = "nolistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void setCursor(Cursor c);

    @StateRefinement(from = "nolistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void transferablesFlavorsChanged();

    @StateRefinement(from = "nolistener(this)")
    @StateRefinement(from = "haslistener(this)")
    public void updateCurrentCursor(int sourceAct, int targetAct, int status);

}