package agentic.threadgroup.run_2.threadgroup;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.lang.ThreadGroup")
@StateSet({"active", "destroyed"})
public interface ThreadGroupRefinements {

    @StateRefinement(to = "active(this)")
    public void ThreadGroup(String name);

    @StateRefinement(to = "active(this)")
    public void ThreadGroup(ThreadGroup parent, String name);

    @StateRefinement(from = "active(this)")
    @Refinement("_ >= 0")
    public int activeCount();

    @StateRefinement(from = "active(this)")
    @Refinement("_ >= 0")
    public int activeGroupCount();

    @StateRefinement(from = "active(this)")
    public void checkAccess();

    @StateRefinement(from = "!destroyed(this)", to = "destroyed(this)")
    public void destroy();

    @StateRefinement(from = "active(this)")
    @Refinement("_ >= 0")
    public int enumerate(Thread[] list, boolean recurse);

    @StateRefinement(from = "active(this)")
    @Refinement("_ >= 0")
    public int enumerate(ThreadGroup[] list, boolean recurse);

    @StateRefinement(from = "active(this)")
    public int getMaxPriority();

    @StateRefinement(from = "active(this)")
    public String getName();

    @StateRefinement(from = "active(this)")
    public ThreadGroup getParent();

    @StateRefinement(from = "active(this)")
    public void interrupt();

    @StateRefinement(from = "active(this)")
    public boolean isDaemon();

    public boolean isDestroyed();

    @StateRefinement(from = "active(this)")
    public void list();

    @StateRefinement(from = "active(this)")
    public boolean parentOf(ThreadGroup g);

    @StateRefinement(from = "active(this)")
    public void resume();

    @StateRefinement(from = "active(this)")
    public void setDaemon(boolean daemon);

    @StateRefinement(from = "active(this)")
    public void setMaxPriority(int pri);

    @StateRefinement(from = "active(this)")
    public void stop();

    @StateRefinement(from = "active(this)")
    public void suspend();

    @StateRefinement(from = "active(this)")
    public String toString();

    @StateRefinement(from = "active(this)")
    public void uncaughtException(Thread t, Throwable e);

}
