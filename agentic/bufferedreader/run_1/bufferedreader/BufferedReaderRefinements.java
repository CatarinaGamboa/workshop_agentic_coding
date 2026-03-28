package agentic.bufferedreader.run_1.bufferedreader;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.io.Reader;
import java.util.stream.Stream;

@RefinementAlias("CharOrEof(int v) { v >= -1 && v <= 65535 }")
@ExternalRefinementsFor("java.io.BufferedReader")
@StateSet({"closed", "marked", "open"})
public interface BufferedReaderRefinements {

    @StateRefinement(to = "open(this)")
    public void BufferedReader(Reader in);

    @StateRefinement(to = "open(this)")
    public void BufferedReader(Reader in, @Refinement("sz > 0") int sz);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    public Stream<String> lines();

    @StateRefinement(from = "open(this)", to = "marked(this)")
    @StateRefinement(from = "marked(this)")
    public void mark(@Refinement("readAheadLimit >= 0") int readAheadLimit);

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    public boolean markSupported();

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    @Refinement("CharOrEof(_)")
    public int read();

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    @Refinement("_ >= -1 && _ <= len")
    public int read(char[] cbuf, @Refinement("off >= 0") int off, @Refinement("len >= 0") int len);

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    public String readLine();

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "marked(this)")
    public boolean ready();

    @StateRefinement(from = "marked(this)")
    public void reset();

}
