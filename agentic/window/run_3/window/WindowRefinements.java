package agentic.window.run_3.window;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.awt.BufferCapabilities;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;

@RefinementAlias("NumBuffers(int n) { n >= 1 }")
@ExternalRefinementsFor("window.Window")
@StateSet({"hidden", "invisible", "visible"})
public interface WindowRefinements {

    @StateRefinement(to = "invisible(this)")
    public void Window(Frame owner);

    @StateRefinement(to = "invisible(this)")
    public void Window(Window owner);

    @StateRefinement(to = "invisible(this)")
    public void Window(Window owner, GraphicsConfiguration gc);

    @StateRefinement(from = "hidden(this)")
    @StateRefinement(from = "visible(this)")
    public void createBufferStrategy(@Refinement("NumBuffers(numBuffers)") int numBuffers);

    @StateRefinement(from = "hidden(this)")
    @StateRefinement(from = "visible(this)")
    public void createBufferStrategy(@Refinement("NumBuffers(numBuffers)") int numBuffers, BufferCapabilities caps);

    @StateRefinement(to = "invisible(this)")
    public void dispose();

    @StateRefinement(from = "visible(this)", to = "hidden(this)")
    public void hide();

    @StateRefinement(from = "invisible(this)", to = "hidden(this)")
    @StateRefinement(from = "hidden(this)")
    @StateRefinement(from = "visible(this)")
    public void pack();

    @StateRefinement(from = "invisible(this)")
    public void setType(Window.Type type);

    @StateRefinement(from = "invisible(this)")
    @StateRefinement(from = "hidden(this)", to = "visible(this)")
    @StateRefinement(from = "visible(this)", to = "hidden(this)")
    public void setVisible(boolean b);

    @StateRefinement(to = "visible(this)")
    public void show();

    @StateRefinement(from = "visible(this)")
    public void toBack();

    @StateRefinement(from = "visible(this)")
    public void toFront();

    public void setOpacity(@Refinement("opacity >= 0.0 && opacity <= 1.0") float opacity);

    @Refinement("_ >= 0.0 && _ <= 1.0")
    public float getOpacity();

}