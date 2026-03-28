package agentic.throwable.run_2.throwable;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.lang.Throwable")
@StateSet({"causeset", "causeunset"})
public interface ThrowableRefinements {

    @StateRefinement(to = "causeunset(this)")
    public void Throwable();

    @StateRefinement(to = "causeunset(this)")
    public void Throwable(String message);

    @StateRefinement(to = "causeset(this)")
    public void Throwable(Throwable cause);

    @StateRefinement(to = "causeset(this)")
    public void Throwable(String message, Throwable cause);

    @StateRefinement(to = "causeset(this)")
    public void Throwable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace);

    @StateRefinement(from = "!causeset(this)", to = "causeset(this)")
    public Throwable initCause(Throwable cause);

}