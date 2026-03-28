package agentic.bufferedinputstream.run_1.bufferedinputstream;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.io.InputStream;

@ExternalRefinementsFor("java.io.BufferedInputStream")
@StateSet({"closed", "marked", "open"})
public interface BufferedInputStreamRefinements {

    @StateRefinement(to = "open(this)")
    public void BufferedInputStream(InputStream in);

    @StateRefinement(to = "open(this)")
    public void BufferedInputStream(InputStream in, @Refinement("size > 0") int size);

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    @Refinement("_ >= 0")
    public int available();

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "open(this)", to = "marked(this)")
    @StateRefinement(from = "marked(this)")
    public void mark(@Refinement("readlimit > 0") int readlimit);

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    public boolean markSupported();

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    @Refinement("_ >= -1")
    public int read();

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    @Refinement("_ >= -1")
    public int read(byte[] b, @Refinement("off >= 0") int off, @Refinement("len >= 0") int len);

    @StateRefinement(from = "marked(this)")
    public void reset();

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    @Refinement("_ >= 0")
    public long skip(@Refinement("n >= 0") long n);

}
