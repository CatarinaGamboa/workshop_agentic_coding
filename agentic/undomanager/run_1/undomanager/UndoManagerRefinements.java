package agentic.undomanager.run_1.undomanager;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("javax.swing.undo.UndoManager")
@StateSet({"ended", "inprogress"})
public interface UndoManagerRefinements {

    @StateRefinement(to = "inprogress(this)")
    public void UndoManager();

    @StateRefinement(to = "ended(this)")
    public void end();

    @StateRefinement(from = "inprogress(this)")
    public void setLimit(int l);

}
