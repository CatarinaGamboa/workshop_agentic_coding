package agentic.bufferedinputstream.run_5.bufferedinputstream;

import java.io.InputStream;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("NonNegInt(int x) { x >= 0 }")
@ExternalRefinementsFor("bufferedinputstream.BufferedInputStream")
@StateSet({"closed", "openmarked", "openunmarked"})
public interface BufferedInputStreamRefinements {

    @StateRefinement(to = "openunmarked(this)")
    public void BufferedInputStream(InputStream in);

    @StateRefinement(to = "openunmarked(this)")
    public void BufferedInputStream(InputStream in, @Refinement("size > 0") int size);

    @StateRefinement(from = "openunmarked(this)")
    @StateRefinement(from = "openmarked(this)")
    @Refinement("_ >= 0")
    public int available();

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "openunmarked(this)", to = "openmarked(this)")
    @StateRefinement(from = "openmarked(this)")
    public void mark(@Refinement("readlimit > 0") int readlimit);

    @StateRefinement(from = "openunmarked(this)")
    @StateRefinement(from = "openmarked(this)")
    public boolean markSupported();

    @StateRefinement(from = "openunmarked(this)")
    @StateRefinement(from = "openmarked(this)")
    @Refinement("_ >= -1")
    public int read();

    @StateRefinement(from = "openunmarked(this)")
    @StateRefinement(from = "openmarked(this)")
    @Refinement("_ >= -1")
    public int read(byte[] b, @Refinement("NonNegInt(off)") int off, @Refinement("NonNegInt(len)") int len);

    @StateRefinement(from = "openmarked(this)")
    public void reset();

    @StateRefinement(from = "openunmarked(this)")
    @StateRefinement(from = "openmarked(this)")
    @Refinement("_ >= 0")
    public long skip(@Refinement("n >= 0") long n);

}
