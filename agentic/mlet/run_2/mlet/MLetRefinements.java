package agentic.mlet.run_2.mlet;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import java.net.URLStreamHandlerFactory;
import java.util.Set;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.loading.MLetContent;
import javax.management.loading.ClassLoaderRepository;

@ExternalRefinementsFor("javax.management.loading.MLet")
@StateSet({"registered", "unregistered"})
public interface MLetRefinements {

    // Constructors - all transition to unregistered state
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

    // Methods callable from both states (no from constraint)
    public void addURL(URL url);

    public void addURL(String url);

    public URL[] getURLs();

    public String getLibraryDirectory();

    public void setLibraryDirectory(String libdir);

    public void writeExternal(ObjectOutput out);

    public void readExternal(ObjectInput in);

    public Class findClass(String name);

    public String findLibrary(String libname);

    public Class loadClass(String name, ClassLoaderRepository clr);

    public URL check(String version, URL codebase, String jarfile, MLetContent mlet);

    // getMBeansFromURL: only callable when registered (throws IllegalStateException otherwise)
    @StateRefinement(from = "registered(this)")
    public Set<Object> getMBeansFromURL(URL url);

    @StateRefinement(from = "registered(this)")
    public Set<Object> getMBeansFromURL(String url);

    // Registration lifecycle methods
    @StateRefinement(from = "unregistered(this)")
    public ObjectName preRegister(MBeanServer server, ObjectName name);

    // postRegister: if registrationDone=true -> Registered; if false -> stays Unregistered
    @StateRefinement(from = "unregistered(this)", to = "registered(this)")
    public void postRegister(Boolean registrationDone);

    @StateRefinement(from = "registered(this)")
    public void preDeregister();

    @StateRefinement(from = "registered(this)", to = "unregistered(this)")
    public void postDeregister();

}
