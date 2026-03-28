package agentic.bufferedreader.run_4.bufferedreader;

import java.io.Reader;
import java.util.stream.Stream;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("NonNegative(int x) { x >= 0 }")
@ExternalRefinementsFor("java.io.BufferedReader")
@StateSet({"closed", "marked", "open"})
public interface BufferedReaderRefinements {

    @StateRefinement(to = "open(this)")
    public void BufferedReader(Reader in, @Refinement("sz > 0") int sz);

    @StateRefinement(to = "open(this)")
    public void BufferedReader(Reader in);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "open(this)", to = "marked(this)")
    @StateRefinement(from = "marked(this)")
    public void mark(@Refinement("NonNegative(readAheadLimit)") int readAheadLimit);

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    public boolean markSupported();

    @Refinement("_ >= -1 && _ <= 65535")
    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    public int read();

    @Refinement("_ >= -1")
    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    public int read(char[] cbuf, @Refinement("NonNegative(off)") int off, @Refinement("NonNegative(len)") int len);

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    public String readLine();

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    public boolean ready();

    @StateRefinement(from = "marked(this)")
    public void reset();

    public Stream<String> lines();

}