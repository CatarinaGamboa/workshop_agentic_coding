package agentic.droptarget.run_5.droptarget;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.awt.Component;
import java.awt.Point;
import java.awt.datatransfer.FlavorMap;
import java.awt.dnd.DropTargetListener;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetContext;

@RefinementAlias("ValidActions(int x) { x >= 0 }")
@ExternalRefinementsFor("java.awt.dnd.DropTarget")
@StateSet({"maybelistener", "haslistener"})
public interface DropTargetRefinements {

    @StateRefinement(to = "maybelistener(this)")
    public void DropTarget();

    @StateRefinement(to = "maybelistener(this)")
    public void DropTarget(Component c, DropTargetListener dtl);

    @StateRefinement(to = "maybelistener(this)")
    public void DropTarget(Component c, @Refinement("ValidActions(ops)") int ops, DropTargetListener dtl);

    @StateRefinement(to = "maybelistener(this)")
    public void DropTarget(Component c, @Refinement("ValidActions(ops)") int ops, DropTargetListener dtl, boolean act);

    @StateRefinement(to = "maybelistener(this)")
    public void DropTarget(Component c, @Refinement("ValidActions(ops)") int ops, DropTargetListener dtl, boolean act, FlavorMap fm);

    @StateRefinement(from = "!haslistener(this)", to = "haslistener(this)")
    public void addDropTargetListener(DropTargetListener dtl);

    @StateRefinement(to = "maybelistener(this)")
    public void removeDropTargetListener(DropTargetListener dtl);

    public void setComponent(Component c);

    public Component getComponent();

    public void setDefaultActions(@Refinement("ValidActions(ops)") int ops);

    @Refinement("ValidActions(_)")
    public int getDefaultActions();

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