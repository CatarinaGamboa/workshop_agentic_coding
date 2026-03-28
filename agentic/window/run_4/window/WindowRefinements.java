package agentic.window.run_4.window;

import java.awt.Frame;
import java.awt.Window;
import java.awt.BufferCapabilities;
import java.awt.GraphicsConfiguration;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.awt.Window")
@StateSet({"invisible", "visible"})
public interface WindowRefinements<T> {

    @StateRefinement(to = "invisible(this)")
    public void Window(Frame owner);

    @StateRefinement(to = "invisible(this)")
    public void Window(Window owner);

    @StateRefinement(to = "invisible(this)")
    public void Window(Window owner, GraphicsConfiguration gc);

    @StateRefinement(to = "invisible(this)")
    public void dispose();

    @StateRefinement(to = "invisible(this)")
    public void hide();

    @StateRefinement(from = "invisible(this)")
    public void setLocationByPlatform(boolean locationByPlatform);

    @StateRefinement(from = "invisible(this)")
    public void setType(Window.Type type);

    @StateRefinement(from = "invisible(this)", to = "visible(this)")
    @StateRefinement(from = "visible(this)", to = "visible(this)")
    public void setVisible(boolean b);

    @StateRefinement(from = "!visible(this)", to = "visible(this)")
    public void show();

    public void createBufferStrategy(@Refinement("numBuffers >= 1") int numBuffers);

    public void createBufferStrategy(@Refinement("numBuffers >= 1") int numBuffers, BufferCapabilities caps);

    public void setOpacity(@Refinement("opacity >= 0.0f && opacity <= 1.0f") float opacity);

}
