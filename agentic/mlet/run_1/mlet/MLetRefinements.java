package agentic.mlet.run_1.mlet;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

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

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void addURL(URL url);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void addURL(String url);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public URL check(String version, URL codebase, String jarfile, MLetContent mlet);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public Class findClass(String name);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public String findLibrary(String libname);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public String getLibraryDirectory();

    @StateRefinement(from = "registered(this)")
    public Set<Object> getMBeansFromURL(URL url);

    @StateRefinement(from = "registered(this)")
    public Set<Object> getMBeansFromURL(String url);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public URL[] getURLs();

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public Class loadClass(String name, ClassLoaderRepository clr);

    @StateRefinement(from = "registered(this)", to = "deregistered(this)")
    public void postDeregister();

    @StateRefinement(from = "unregistered(this)", to = "registered(this)")
    @StateRefinement(from = "unregistered(this)")
    public void postRegister(Boolean registrationDone);

    @StateRefinement(from = "registered(this)")
    public void preDeregister();

    @StateRefinement(from = "unregistered(this)")
    public ObjectName preRegister(MBeanServer server, ObjectName name);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void readExternal(ObjectInput in);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void setLibraryDirectory(String libdir);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void writeExternal(ObjectOutput out);

}
