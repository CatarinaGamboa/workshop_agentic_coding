package agentic.pipedoutputstream.run_4.pipedoutputstream;

import java.io.PipedInputStream;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.io.PipedOutputStream")
@StateSet({"closed", "connected", "unconnected"})
public interface PipedOutputStreamRefinements {

    @StateRefinement(to = "unconnected(this)")
    public void PipedOutputStream();

    @StateRefinement(to = "connected(this)")
    public void PipedOutputStream(PipedInputStream snk);

    @StateRefinement(from = "!closed(this)", to = "closed(this)")
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