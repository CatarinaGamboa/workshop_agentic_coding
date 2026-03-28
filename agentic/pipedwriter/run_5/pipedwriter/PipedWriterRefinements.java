package agentic.pipedwriter.run_5.pipedwriter;

import java.io.PipedReader;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.io.PipedWriter")
@StateSet({"closed", "connected", "unconnected"})
public interface PipedWriterRefinements {

    @StateRefinement(to = "unconnected(this)")
    public void PipedWriter();

    @StateRefinement(to = "connected(this)")
    public void PipedWriter(PipedReader snk);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "unconnected(this)", to = "connected(this)")
    public void connect(PipedReader snk);

    @StateRefinement(from = "connected(this)")
    public void flush();

    @StateRefinement(from = "connected(this)")
    public void write(int c);

    @StateRefinement(from = "connected(this)")
    public void write(char[] cbuf, int off, int len);

}
