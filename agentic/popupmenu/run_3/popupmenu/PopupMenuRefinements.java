package agentic.popupmenu.run_3.popupmenu;

import java.awt.Component;
import javax.accessibility.AccessibleContext;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.awt.PopupMenu")
@StateSet({"maybecomponentparent", "noncomponentparent"})
public interface PopupMenuRefinements {

    @StateRefinement(to = "maybecomponentparent(this)")
    public void PopupMenu();

    @StateRefinement(to = "maybecomponentparent(this)")
    public void PopupMenu(String label);

    @StateRefinement(to = "noncomponentparent(this)")
    public void addNotify();

    @StateRefinement(from = "maybecomponentparent(this)")
    public void show(Component origin, int x, int y);

    public AccessibleContext getAccessibleContext();

}