package agentic.transformerexception.run_5.transformerexception;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import javax.xml.transform.SourceLocator;
import java.io.PrintStream;
import java.io.PrintWriter;

@ExternalRefinementsFor("javax.xml.transform.TransformerException")
@StateSet({"causelocked", "causesettable"})
public interface TransformerExceptionRefinements {

    @StateRefinement(to = "causesettable(this)")
    public void TransformerException(String message);

    @StateRefinement(to = "causesettable(this)")
    public void TransformerException(String message, SourceLocator locator);

    @StateRefinement(to = "causelocked(this)")
    public void TransformerException(Throwable e);

    @StateRefinement(to = "causelocked(this)")
    public void TransformerException(String message, Throwable e);

    @StateRefinement(to = "causelocked(this)")
    public void TransformerException(String message, SourceLocator locator, Throwable e);

    @StateRefinement(from = "!causelocked(this)", to = "causelocked(this)")
    public Throwable initCause(Throwable cause);

    @StateRefinement(from = "causesettable(this) || causelocked(this)")
    public SourceLocator getLocator();

    @StateRefinement(from = "causesettable(this) || causelocked(this)")
    public void setLocator(SourceLocator location);

    @StateRefinement(from = "causesettable(this) || causelocked(this)")
    public Throwable getException();

    @StateRefinement(from = "causesettable(this) || causelocked(this)")
    public Throwable getCause();

    @StateRefinement(from = "causesettable(this) || causelocked(this)")
    public String getMessageAndLocation();

    @StateRefinement(from = "causesettable(this) || causelocked(this)")
    public String getLocationAsString();

    @StateRefinement(from = "causesettable(this) || causelocked(this)")
    public void printStackTrace();

    @StateRefinement(from = "causesettable(this) || causelocked(this)")
    public void printStackTrace(PrintStream s);

    @StateRefinement(from = "causesettable(this) || causelocked(this)")
    public void printStackTrace(PrintWriter s);

}
