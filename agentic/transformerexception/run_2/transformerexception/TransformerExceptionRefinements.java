package agentic.transformerexception.run_2.transformerexception;

import java.io.PrintStream;
import java.io.PrintWriter;
import javax.xml.transform.SourceLocator;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("javax.xml.transform.TransformerException")
@StateSet({"causeset", "causeunset"})
public interface TransformerExceptionRefinements {

    @StateRefinement(to = "causeunset(this)")
    public void TransformerException(String message);

    @StateRefinement(to = "causeunset(this)")
    public void TransformerException(String message, SourceLocator locator);

    @StateRefinement(to = "causeset(this)")
    public void TransformerException(Throwable e);

    @StateRefinement(to = "causeset(this)")
    public void TransformerException(String message, Throwable e);

    @StateRefinement(to = "causeset(this)")
    public void TransformerException(String message, SourceLocator locator, Throwable e);

    @StateRefinement(from = "!causeset(this)", to = "causeset(this)")
    public Throwable initCause(Throwable cause);

}