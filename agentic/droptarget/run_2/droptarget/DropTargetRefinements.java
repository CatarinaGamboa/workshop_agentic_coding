package agentic.droptarget.run_2.droptarget;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.awt.Component;
import java.awt.Point;
import java.awt.datatransfer.FlavorMap;
import java.awt.dnd.DropTargetListener;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;

@ExternalRefinementsFor("java.awt.dnd.DropTarget")
@StateSet({"activehaslistener", "activenolistener", "inactivehaslistener", "inactivenolistener", "maybeactivelistener"})
public interface DropTargetRefinements {

    @StateRefinement(to = "inactivenolistener(this)")
    public void DropTarget();

    @StateRefinement(to = "maybeactivelistener(this)")
    public void DropTarget(Component c, DropTargetListener dtl);

    @StateRefinement(to = "maybeactivelistener(this)")
    public void DropTarget(Component c, int ops, DropTargetListener dtl);

    @StateRefinement(to = "maybeactivelistener(this)")
    public void DropTarget(Component c, int ops, DropTargetListener dtl, boolean act);

    @StateRefinement(to = "maybeactivelistener(this)")
    public void DropTarget(Component c, int ops, DropTargetListener dtl, boolean act, FlavorMap fm);

    public void setComponent(Component c);

    public Component getComponent();

    public void setDefaultActions(int ops);

    public int getDefaultActions();

    @StateRefinement(from = "inactivenolistener(this)", to = "inactivehaslistener(this)")
    @StateRefinement(from = "activenolistener(this)", to = "activehaslistener(this)")
    @StateRefinement(from = "maybeactivelistener(this)")
    public void addDropTargetListener(DropTargetListener dtl);

    @StateRefinement(from = "inactivenolistener(this)")
    @StateRefinement(from = "inactivehaslistener(this)", to = "inactivenolistener(this)")
    @StateRefinement(from = "activenolistener(this)")
    @StateRefinement(from = "activehaslistener(this)", to = "activenolistener(this)")
    @StateRefinement(from = "maybeactivelistener(this)")
    public void removeDropTargetListener(DropTargetListener dtl);

    @StateRefinement(from = "inactivenolistener(this)", to = "activenolistener(this)")
    @StateRefinement(from = "inactivehaslistener(this)", to = "activehaslistener(this)")
    @StateRefinement(from = "activenolistener(this)", to = "inactivenolistener(this)")
    @StateRefinement(from = "activehaslistener(this)", to = "inactivehaslistener(this)")
    @StateRefinement(from = "maybeactivelistener(this)")
    public void setActive(boolean isActive);

    public boolean isActive();

    public void dragEnter(DropTargetDragEvent dtde);

    public void dragOver(DropTargetDragEvent dtde);

    public void dropActionChanged(DropTargetDragEvent dtde);

    public void dragExit(DropTargetEvent dte);

    public void drop(DropTargetDropEvent dtde);

    public FlavorMap getFlavorMap();

    public void setFlavorMap(FlavorMap fm);

    public void addNotify();

    public void removeNotify();

    public DropTargetContext getDropTargetContext();

    public DropTargetContext createDropTargetContext();

    public void initializeAutoscrolling(Point p);

    public void updateAutoscroll(Point dragCursorLocn);

    public void clearAutoscroll();

}