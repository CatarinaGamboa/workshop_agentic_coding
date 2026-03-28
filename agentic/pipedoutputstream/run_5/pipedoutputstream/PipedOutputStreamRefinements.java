package agentic.pipedoutputstream.run_5.pipedoutputstream;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.io.PipedInputStream;

@ExternalRefinementsFor("java.io.PipedOutputStream")
@StateSet({"unconnected", "connected", "closed"})
public interface PipedOutputStreamRefinements {

    @StateRefinement(to = "unconnected(this)")
    public void PipedOutputStream();

    @StateRefinement(to = "connected(this)")
    public void PipedOutputStream(PipedInputStream snk);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "unconnected(this)", to = "connected(this)")
    public void connect(PipedInputStream snk);

    @StateRefinement(from = "connected(this)")
    public void flush();

    @StateRefinement(from = "connected(this)")
    public void write(int b);

    @StateRefinement(from = "connected(this)")
    public void write(byte[] b, int off, int len);

}
