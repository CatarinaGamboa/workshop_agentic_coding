package agentic.deflateroutputstream.run_1.deflateroutputstream;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.io.OutputStream;
import java.util.zip.Deflater;

@RefinementAlias("ValidSize(int s) { s > 0 }")
@ExternalRefinementsFor("java.util.zip.DeflaterOutputStream")
@StateSet({"closed", "finished", "open"})
public interface DeflaterOutputStreamRefinements {

    @StateRefinement(to = "open(this)")
    public void DeflaterOutputStream(OutputStream out, Deflater def, @Refinement("ValidSize(size)") int size, boolean syncFlush);

    @StateRefinement(to = "open(this)")
    public void DeflaterOutputStream(OutputStream out, Deflater def, @Refinement("ValidSize(size)") int size);

    @StateRefinement(to = "open(this)")
    public void DeflaterOutputStream(OutputStream out, Deflater def, boolean syncFlush);

    @StateRefinement(to = "open(this)")
    public void DeflaterOutputStream(OutputStream out, Deflater def);

    @StateRefinement(to = "open(this)")
    public void DeflaterOutputStream(OutputStream out, boolean syncFlush);

    @StateRefinement(to = "open(this)")
    public void DeflaterOutputStream(OutputStream out);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "open(this)", to = "open(this)")
    public void deflate();

    @StateRefinement(from = "open(this)", to = "finished(this)")
    public void finish();

    @StateRefinement(from = "open(this)", to = "open(this)")
    @StateRefinement(from = "finished(this)", to = "finished(this)")
    public void flush();

    @StateRefinement(from = "open(this)", to = "open(this)")
    public void write(int b);

    @StateRefinement(from = "open(this)", to = "open(this)")
    public void write(byte[] b, int off, int len);

}
