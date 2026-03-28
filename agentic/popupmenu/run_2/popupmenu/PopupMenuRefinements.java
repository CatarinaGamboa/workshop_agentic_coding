package agentic.popupmenu.run_2.popupmenu;

import java.awt.Component;
import javax.accessibility.AccessibleContext;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.awt.PopupMenu")
@StateSet({"created", "withcomponentparent"})
public interface PopupMenuRefinements {

    @StateRefinement(to = "created(this)")
    public void PopupMenu();

    @StateRefinement(to = "created(this)")
    public void PopupMenu(String label);

    @StateRefinement(to = "withcomponentparent(this)")
    public void addNotify();

    @StateRefinement(from = "withcomponentparent(this)")
    public AccessibleContext getAccessibleContext();

    @StateRefinement(from = "withcomponentparent(this)")
    public void show(Component origin, int x, int y);

}