package agentic.zipoutputstream.run_1.zipoutputstream;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;

@RefinementAlias("ValidLevel(int v) { v >= 0 && v <= 9 }")
@ExternalRefinementsFor("java.util.zip.ZipOutputStream")
@StateSet({"closed", "entryopen", "open"})
public interface ZipOutputStreamRefinements {

    @StateRefinement(to = "open(this)")
    public void ZipOutputStream(OutputStream out);

    @StateRefinement(to = "open(this)")
    public void ZipOutputStream(OutputStream out, Charset charset);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "entryopen(this)", to = "open(this)")
    public void closeEntry();

    @StateRefinement(from = "!closed(this)", to = "closed(this)")
    public void finish();

    @StateRefinement(from = "open(this)", to = "entryopen(this)")
    @StateRefinement(from = "entryopen(this)")
    public void putNextEntry(ZipEntry e);

    @StateRefinement(from = "open(this)")
    public void setComment(String comment);

    @StateRefinement(from = "open(this)")
    public void setLevel(@Refinement("ValidLevel(level)") int level);

    @StateRefinement(from = "open(this)")
    public void setMethod(int method);

    @StateRefinement(from = "entryopen(this)")
    public void write(byte[] b, @Refinement("off >= 0") int off, @Refinement("len >= 0") int len);

}