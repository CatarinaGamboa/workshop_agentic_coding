package agentic.deflateroutputstream.run_5.deflateroutputstream;

import java.io.OutputStream;
import java.util.zip.Deflater;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.util.zip.DeflaterOutputStream")
@StateSet({"closed", "finished", "open"})
public interface DeflaterOutputStreamRefinements {

    @StateRefinement(to = "open(this)")
    public void DeflaterOutputStream(OutputStream out, Deflater def, @Refinement("size > 0") int size, boolean syncFlush);

    @StateRefinement(to = "open(this)")
    public void DeflaterOutputStream(OutputStream out, Deflater def, @Refinement("size > 0") int size);

    @StateRefinement(to = "open(this)")
    public void DeflaterOutputStream(OutputStream out, Deflater def, boolean syncFlush);

    @StateRefinement(to = "open(this)")
    public void DeflaterOutputStream(OutputStream out, Deflater def);

    @StateRefinement(to = "open(this)")
    public void DeflaterOutputStream(OutputStream out, boolean syncFlush);

    @StateRefinement(to = "open(this)")
    public void DeflaterOutputStream(OutputStream out);

    @StateRefinement(from = "!closed(this)", to = "closed(this)")
    public void close();

    @StateRefinement(from = "open(this)")
    public void deflate();

    @StateRefinement(from = "open(this)", to = "finished(this)")
    public void finish();

    @StateRefinement(from = "open(this)")
    public void flush();

    @StateRefinement(from = "open(this)")
    public void write(int b);

    @StateRefinement(from = "open(this)")
    public void write(byte[] b, @Refinement("off >= 0") int off, @Refinement("len >= 0") int len);

}
