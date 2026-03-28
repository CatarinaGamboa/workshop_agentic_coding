package agentic.choicecallback.run_1.choicecallback;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("ValidIndex(int i) { i >= 0 }")
@ExternalRefinementsFor("javax.security.auth.callback.ChoiceCallback")
@StateSet({"multiselect", "singleselect"})
public interface ChoiceCallbackRefinements {

    @StateRefinement(to = "multiselect(this)", from = "multipleSelectionsAllowed == true")
    @StateRefinement(to = "singleselect(this)", from = "multipleSelectionsAllowed == false")
    public void ChoiceCallback(String prompt, String[] choices, @Refinement("ValidIndex(defaultChoice)") int defaultChoice, boolean multipleSelectionsAllowed);

    public String getPrompt();

    public String[] getChoices();

    @Refinement("_ >= 0")
    public int getDefaultChoice();

    public boolean allowMultipleSelections();

    public void setSelectedIndex(@Refinement("ValidIndex(selection)") int selection);

    @StateRefinement(from = "singleselect(this)")
    public void setSelectedIndexes(int[] selections);

    public int[] getSelectedIndexes();

}
