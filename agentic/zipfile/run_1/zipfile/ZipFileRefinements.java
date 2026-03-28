package agentic.zipfile.run_1.zipfile;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;

@ExternalRefinementsFor("java.util.zip.ZipFile")
@StateSet({"closed", "open"})
public interface ZipFileRefinements {

    @StateRefinement(to = "open(this)")
    public void ZipFile(String name);

    @StateRefinement(to = "open(this)")
    public void ZipFile(File file);

    @StateRefinement(to = "open(this)")
    public void ZipFile(File file, int mode);

    @StateRefinement(to = "open(this)")
    public void ZipFile(File file, int mode, Charset charset);

    @StateRefinement(to = "open(this)")
    public void ZipFile(String name, Charset charset);

    @StateRefinement(to = "open(this)")
    public void ZipFile(File file, Charset charset);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "open(this)")
    public Enumeration<? extends ZipEntry> entries();

    @StateRefinement(from = "open(this)")
    public String getComment();

    @StateRefinement(from = "open(this)")
    public ZipEntry getEntry(String name);

    @StateRefinement(from = "open(this)")
    public InputStream getInputStream(ZipEntry entry);

    @StateRefinement(from = "open(this)")
    @Refinement("_ >= 0")
    public int size();

    @StateRefinement(from = "open(this)")
    public Stream<? extends ZipEntry> stream();

    public String getName();

}