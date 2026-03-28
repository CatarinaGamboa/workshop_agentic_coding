package agentic.bufferedinputstream.run_3.bufferedinputstream;

import java.io.InputStream;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("NonNegInt(int x) { x >= 0 }")
@ExternalRefinementsFor("java.io.BufferedInputStream")
@StateSet({"closed", "markedopen", "open"})
public interface BufferedInputStreamRefinements {

    @StateRefinement(to = "open(this)")
    public void BufferedInputStream(InputStream in);

    @StateRefinement(to = "open(this)")
    public void BufferedInputStream(InputStream in, @Refinement("size > 0") int size);

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "markedopen(this)")
    @Refinement("_ >= 0")
    public int available();

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "open(this)", to = "markedopen(this)")
    @StateRefinement(from = "markedopen(this)")
    public void mark(@Refinement("NonNegInt(readlimit)") int readlimit);

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "markedopen(this)")
    public boolean markSupported();

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "markedopen(this)")
    @Refinement("_ >= -1")
    public int read();

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "markedopen(this)")
    @Refinement("_ >= -1")
    public int read(byte[] b, @Refinement("NonNegInt(off)") int off, @Refinement("NonNegInt(len)") int len);

    @StateRefinement(from = "markedopen(this)")
    public void reset();

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "markedopen(this)")
    @Refinement("_ >= 0")
    public long skip(@Refinement("n >= 0") long n);

}