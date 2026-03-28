package agentic.pipedoutputstream.run_1.pipedoutputstream;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.io.PipedInputStream;

@ExternalRefinementsFor("java.io.PipedOutputStream")
@StateSet({"closed", "connected", "unconnected"})
public interface PipedOutputStreamRefinements {

    @StateRefinement(to = "unconnected(this)")
    public void PipedOutputStream();

    @StateRefinement(to = "connected(this)")
    public void PipedOutputStream(PipedInputStream snk);

    @StateRefinement(from = "connected(this)", to = "closed(this)")
    @StateRefinement(from = "closed(this)")
    public void close();

    @StateRefinement(from = "unconnected(this)", to = "connected(this)")
    public void connect(PipedInputStream snk);

    @StateRefinement(from = "connected(this)")
    public void flush();

    @StateRefinement(from = "connected(this)")
    public void write(int b);

    @StateRefinement(from = "connected(this)")
    public void write(byte[] b, @Refinement("off >= 0 && off <= b.length") int off, @Refinement("len >= 0 && len <= b.length - off") int len);

}
