package agentic.bufferedinputstream.run_4.bufferedinputstream;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.io.InputStream;

@ExternalRefinementsFor("java.io.BufferedInputStream")
@StateSet({"closed", "openmarked", "openunmarked"})
@RefinementAlias("NonNegativeInt(int x) { x >= 0 }")
public interface BufferedInputStreamRefinements {

    @StateRefinement(to = "openunmarked(this)")
    public void BufferedInputStream(InputStream in);

    @StateRefinement(to = "openunmarked(this)")
    public void BufferedInputStream(InputStream in, @Refinement("size > 0") int size);

    @StateRefinement(from = "openunmarked(this)")
    @StateRefinement(from = "openmarked(this)")
    @Refinement("_ >= 0")
    public int available();

    @StateRefinement(from = "openunmarked(this)", to = "closed(this)")
    @StateRefinement(from = "openmarked(this)", to = "closed(this)")
    @StateRefinement(from = "closed(this)")
    public void close();

    @StateRefinement(from = "openunmarked(this)", to = "openmarked(this)")
    @StateRefinement(from = "openmarked(this)")
    public void mark(@Refinement("readlimit > 0") int readlimit);

    @StateRefinement(from = "openunmarked(this)")
    @StateRefinement(from = "openmarked(this)")
    public boolean markSupported();

    @StateRefinement(from = "openunmarked(this)")
    @StateRefinement(from = "openmarked(this)")
    @Refinement("_ >= -1 && _ <= 255")
    public int read();

    @StateRefinement(from = "openunmarked(this)")
    @StateRefinement(from = "openmarked(this)")
    @Refinement("_ >= -1")
    public int read(byte[] b, @Refinement("NonNegativeInt(off)") int off, @Refinement("NonNegativeInt(len)") int len);

    @StateRefinement(from = "openmarked(this)")
    public void reset();

    @StateRefinement(from = "openunmarked(this)")
    @StateRefinement(from = "openmarked(this)")
    @Refinement("_ >= 0")
    public long skip(@Refinement("n >= 0") long n);

}
