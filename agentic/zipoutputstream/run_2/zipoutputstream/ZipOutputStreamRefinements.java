package agentic.zipoutputstream.run_2.zipoutputstream;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;

@RefinementAlias("ValidLevel(int level) { level >= 0 && level <= 9 }")
@ExternalRefinementsFor("java.util.zip.ZipOutputStream")
@StateSet({"closed", "entryopen", "finished", "open"})
public interface ZipOutputStreamRefinements {

    @StateRefinement(to = "open(this)")
    public void ZipOutputStream(OutputStream out);

    @StateRefinement(to = "open(this)")
    public void ZipOutputStream(OutputStream out, Charset charset);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "entryopen(this)", to = "open(this)")
    public void closeEntry();

    @StateRefinement(from = "open(this)", to = "finished(this)")
    @StateRefinement(from = "entryopen(this)", to = "finished(this)")
    public void finish();

    @StateRefinement(from = "open(this)", to = "entryopen(this)")
    @StateRefinement(from = "entryopen(this)")
    public void putNextEntry(ZipEntry e);

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "entryopen(this)")
    public void setComment(String comment);

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "entryopen(this)")
    public void setLevel(@Refinement("ValidLevel(level)") int level);

    @StateRefinement(from = "open(this)")
    @StateRefinement(from = "entryopen(this)")
    public void setMethod(int method);

    @StateRefinement(from = "entryopen(this)")
    public void write(byte[] b, int off, int len);

}
