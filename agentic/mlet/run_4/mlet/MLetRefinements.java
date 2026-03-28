package agentic.mlet.run_4.mlet;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import java.net.URLStreamHandlerFactory;
import java.util.Set;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.loading.ClassLoaderRepository;
import javax.management.loading.MLetContent;

@ExternalRefinementsFor("javax.management.loading.MLet")
@StateSet({"deregistered", "registered", "unregistered"})
public interface MLetRefinements {

    @StateRefinement(to = "unregistered(this)")
    public void MLet();

    @StateRefinement(to = "unregistered(this)")
    public void MLet(URL[] urls);

    @StateRefinement(to = "unregistered(this)")
    public void MLet(URL[] urls, ClassLoader parent);

    @StateRefinement(to = "unregistered(this)")
    public void MLet(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory);

    @StateRefinement(to = "unregistered(this)")
    public void MLet(URL[] urls, boolean delegateToCLR);

    @StateRefinement(to = "unregistered(this)")
    public void MLet(URL[] urls, ClassLoader parent, boolean delegateToCLR);

    @StateRefinement(to = "unregistered(this)")
    public void MLet(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory, boolean delegateToCLR);

    public void addURL(URL url);

    public void addURL(String url);

    public URL[] getURLs();

    public String getLibraryDirectory();

    public void setLibraryDirectory(String libdir);

    public void writeExternal(ObjectOutput out);

    public void readExternal(ObjectInput in);

    public String findLibrary(String libname);

    public Class<?> loadClass(String name, ClassLoaderRepository clr);

    public URL check(String version, URL codebase, String jarfile, MLetContent mlet);

    @StateRefinement(from = "registered(this)")
    public Set<Object> getMBeansFromURL(URL url);

    @StateRefinement(from = "registered(this)")
    public Set<Object> getMBeansFromURL(String url);

    @StateRefinement(from = "registered(this)")
    public void postRegister(Boolean registrationDone);

    @StateRefinement(from = "registered(this)", to = "deregistered(this)")
    public void preDeregister();

    @StateRefinement(from = "unregistered(this)", to = "registered(this)")
    public ObjectName preRegister(MBeanServer server, ObjectName name);

    @StateRefinement(from = "deregistered(this)")
    public void postDeregister();

}
