package agentic.transformerexception.run_3.transformerexception;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import javax.xml.transform.SourceLocator;
import java.io.PrintStream;
import java.io.PrintWriter;

@ExternalRefinementsFor("javax.xml.transform.TransformerException")
@StateSet({"causenotset", "causeset"})
public interface TransformerExceptionRefinements {

    @StateRefinement(to = "causenotset(this)")
    public void TransformerException(String message);

    @StateRefinement(to = "causenotset(this)")
    public void TransformerException(String message, SourceLocator locator);

    @StateRefinement(to = "causeset(this)")
    public void TransformerException(Throwable e);

    @StateRefinement(to = "causeset(this)")
    public void TransformerException(String message, Throwable e);

    @StateRefinement(to = "causeset(this)")
    public void TransformerException(String message, SourceLocator locator, Throwable e);

    public SourceLocator getLocator();

    public void setLocator(SourceLocator location);

    public Throwable getException();

    public Throwable getCause();

    @StateRefinement(from = "causenotset(this)", to = "causeset(this)")
    public Throwable initCause(Throwable cause);

    public String getMessageAndLocation();

    public String getLocationAsString();

    public void printStackTrace();

    public void printStackTrace(PrintStream s);

    public void printStackTrace(PrintWriter s);

}