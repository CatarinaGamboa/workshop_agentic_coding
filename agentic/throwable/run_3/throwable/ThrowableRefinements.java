package agentic.throwable.run_3.throwable;

import java.io.PrintStream;
import java.io.PrintWriter;
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

    @StateRefinement(from = "causeunset(this)", to = "causeset(this)")
    public Throwable initCause(Throwable cause);

    @StateRefinement(from = "causeunset(this) || causeset(this)")
    public String getMessage();

    @StateRefinement(from = "causeunset(this) || causeset(this)")
    public String getLocalizedMessage();

    @StateRefinement(from = "causeunset(this) || causeset(this)")
    public Throwable getCause();

    @StateRefinement(from = "causeunset(this) || causeset(this)")
    public String toString();

    @StateRefinement(from = "causeunset(this) || causeset(this)")
    public void printStackTrace();

    @StateRefinement(from = "causeunset(this) || causeset(this)")
    public void printStackTrace(PrintStream s);

    @StateRefinement(from = "causeunset(this) || causeset(this)")
    public void printStackTrace(PrintWriter s);

    @StateRefinement(from = "causeunset(this) || causeset(this)")
    public Throwable fillInStackTrace();

    @StateRefinement(from = "causeunset(this) || causeset(this)")
    public StackTraceElement[] getStackTrace();

    @StateRefinement(from = "causeunset(this) || causeset(this)")
    public void setStackTrace(StackTraceElement[] stackTrace);

    @StateRefinement(from = "causeunset(this) || causeset(this)")
    public void addSuppressed(Throwable exception);

    @StateRefinement(from = "causeunset(this) || causeset(this)")
    public Throwable[] getSuppressed();

}