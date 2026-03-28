package agentic.throwable.run_4.throwable;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

import java.io.PrintStream;
import java.io.PrintWriter;

@ExternalRefinementsFor("java.lang.Throwable")
@StateSet({"causeset", "causeunset", "maybecauseset"})
public interface ThrowableRefinements {

    @StateRefinement(to = "causeunset(this)")
    public void Throwable();

    @StateRefinement(to = "causeunset(this)")
    public void Throwable(String message);

    @StateRefinement(to = "causeset(this)")
    public void Throwable(Throwable cause);

    @StateRefinement(to = "causeset(this)")
    public void Throwable(String message, Throwable cause);

    @StateRefinement(to = "maybecauseset(this)")
    public void Throwable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace);

    @StateRefinement(from = "causeunset(this)", to = "causeset(this)")
    @StateRefinement(from = "maybecauseset(this)")
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