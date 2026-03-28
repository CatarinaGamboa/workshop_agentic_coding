package agentic.choicecallback.run_5.choicecallback;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("ValidIndex(int i) { i >= 0 }")
@ExternalRefinementsFor("javax.security.auth.callback.ChoiceCallback")
@StateSet({"multipleselection", "singleselection"})
public interface ChoiceCallbackRefinements {

    @StateRefinement(to = "singleselection(this)")
    @StateRefinement(to = "multipleselection(this)")
    public void ChoiceCallback(String prompt, String[] choices, @Refinement("ValidIndex(defaultChoice)") int defaultChoice, boolean multipleSelectionsAllowed);

    public String getPrompt();

    public String[] getChoices();

    @Refinement("_ >= 0")
    public int getDefaultChoice();

    public boolean allowMultipleSelections();

    public void setSelectedIndex(@Refinement("ValidIndex(selection)") int selection);

    public void setSelectedIndexes(int[] selections);

    public int[] getSelectedIndexes();

}
