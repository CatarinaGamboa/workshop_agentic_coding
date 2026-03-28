package agentic.throwable.run_1.throwable;

import java.io.PrintStream;
import java.io.PrintWriter;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
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

    // initCause can only be called when the cause has not yet been set (CauseUnset state).
    // Calling it from CauseSet state throws IllegalStateException.
    @StateRefinement(from = "!causeset(this)", to = "causeset(this)")
    public Throwable initCause(Throwable cause);

    public String getMessage();

    public String getLocalizedMessage();

    public Throwable getCause();

    public String toString();

    public void printStackTrace();

    public void printStackTrace(PrintStream s);

    public void printStackTrace(PrintWriter s);

    public Throwable fillInStackTrace();

    public StackTraceElement[] getStackTrace();

    public void setStackTrace(StackTraceElement[] stackTrace);

    public void addSuppressed(Throwable exception);

    public Throwable[] getSuppressed();

}