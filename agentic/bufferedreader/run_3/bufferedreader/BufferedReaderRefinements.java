package agentic.bufferedreader.run_3.bufferedreader;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.io.Reader;
import java.util.stream.Stream;

@RefinementAlias("NonNegative(int x) { x >= 0 }")
@ExternalRefinementsFor("java.io.BufferedReader")
@StateSet({"closed", "marked", "open"})
public interface BufferedReaderRefinements {

    @StateRefinement(to = "open(this)")
    public void BufferedReader(Reader in);

    @StateRefinement(to = "open(this)")
    public void BufferedReader(Reader in, @Refinement("sz > 0") int sz);

    @StateRefinement(from = "open(this)", to = "closed(this)")
    @StateRefinement(from = "marked(this)", to = "closed(this)")
    public void close();

    @StateRefinement(from = "open(this)", to = "marked(this)")
    @StateRefinement(from = "marked(this)", to = "marked(this)")
    public void mark(@Refinement("NonNegative(readAheadLimit)") int readAheadLimit);

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    public boolean markSupported();

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    public int read();

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    public int read(char[] cbuf, int off, int len);

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    public String readLine();

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    public boolean ready();

    @StateRefinement(from = "marked(this)", to = "marked(this)")
    public void reset();

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    @StateRefinement(from = "closed(this)")
    public Stream<String> lines();

}
