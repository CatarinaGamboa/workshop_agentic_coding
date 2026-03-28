package agentic.choicecallback.run_4.choicecallback;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("ValidIndex(int i) { i >= 0 }")
@ExternalRefinementsFor("javax.security.auth.callback.ChoiceCallback")
@StateSet({"multiselect", "singleselect"})
public interface ChoiceCallbackRefinements {

    @StateRefinement(to = "singleselect(this)")
    @StateRefinement(to = "multiselect(this)")
    public void ChoiceCallback(String prompt, String[] choices, @Refinement("ValidIndex(defaultChoice)") int defaultChoice, boolean multipleSelectionsAllowed);

    @StateRefinement(from = "singleselect(this)")
    @StateRefinement(from = "multiselect(this)")
    public String getPrompt();

    @StateRefinement(from = "singleselect(this)")
    @StateRefinement(from = "multiselect(this)")
    public String[] getChoices();

    @StateRefinement(from = "singleselect(this)")
    @StateRefinement(from = "multiselect(this)")
    @Refinement("ValidIndex(_)")
    public int getDefaultChoice();

    @StateRefinement(from = "singleselect(this)")
    @StateRefinement(from = "multiselect(this)")
    public boolean allowMultipleSelections();

    @StateRefinement(from = "singleselect(this)")
    @StateRefinement(from = "multiselect(this)")
    public void setSelectedIndex(@Refinement("ValidIndex(selection)") int selection);

    @StateRefinement(from = "multiselect(this) || singleselect(this)")
    public void setSelectedIndexes(int[] selections);

    @StateRefinement(from = "singleselect(this)")
    @StateRefinement(from = "multiselect(this)")
    public int[] getSelectedIndexes();

}
