package agentic.bufferedreader.run_2.bufferedreader;

import java.io.Reader;
import java.util.stream.Stream;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.io.BufferedReader")
@StateSet({"closed", "marked", "open"})
public interface BufferedReaderRefinements {

    @StateRefinement(to = "open(this)")
    public void BufferedReader(Reader in);

    @StateRefinement(to = "open(this)")
    public void BufferedReader(Reader in, @Refinement("sz > 0") int sz);

    @StateRefinement(from = "open(this)", to = "closed(this)")
    @StateRefinement(from = "marked(this)", to = "closed(this)")
    @StateRefinement(from = "closed(this)", to = "closed(this)")
    public void close();

    @StateRefinement(from = "closed(this)", to = "closed(this)")
    public Stream<String> lines();

    @StateRefinement(from = "open(this)", to = "marked(this)")
    @StateRefinement(from = "marked(this)", to = "marked(this)")
    public void mark(@Refinement("readAheadLimit >= 0") int readAheadLimit);

    @StateRefinement(from = "open(this)", to = "open(this)")
    @StateRefinement(from = "marked(this)", to = "marked(this)")
    public boolean markSupported();

    @StateRefinement(from = "open(this)", to = "open(this)")
    @StateRefinement(from = "marked(this)", to = "marked(this)")
    @Refinement("_ >= -1 && _ <= 65535")
    public int read();

    @StateRefinement(from = "open(this)", to = "open(this)")
    @StateRefinement(from = "marked(this)", to = "marked(this)")
    @Refinement("_ >= -1")
    public int read(char[] cbuf, @Refinement("off >= 0") int off, @Refinement("len >= 0 && len <= cbuf.length - off") int len);

    @StateRefinement(from = "open(this)", to = "open(this)")
    @StateRefinement(from = "marked(this)", to = "marked(this)")
    public String readLine();

    @StateRefinement(from = "open(this)", to = "open(this)")
    @StateRefinement(from = "marked(this)", to = "marked(this)")
    public boolean ready();

    @StateRefinement(from = "marked(this)", to = "open(this)")
    public void reset();

}
