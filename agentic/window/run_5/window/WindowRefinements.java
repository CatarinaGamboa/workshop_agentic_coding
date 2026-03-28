package agentic.window.run_5.window;

import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.BufferCapabilities;
import java.awt.Window;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.awt.Window")
@StateSet({"displayable", "invisible", "visible"})
public interface WindowRefinements {

    @StateRefinement(to = "invisible(this)")
    public void Window(Frame owner);

    @StateRefinement(to = "invisible(this)")
    public void Window(Window owner);

    @StateRefinement(to = "invisible(this)")
    public void Window(Window owner, GraphicsConfiguration gc);

    @StateRefinement(from = "displayable(this)")
    @StateRefinement(from = "visible(this)")
    public void createBufferStrategy(@Refinement("numBuffers >= 1") int numBuffers);

    @StateRefinement(from = "displayable(this)")
    @StateRefinement(from = "visible(this)")
    public void createBufferStrategy(@Refinement("numBuffers >= 1") int numBuffers, BufferCapabilities caps);

    @StateRefinement(from = "!invisible(this)", to = "invisible(this)")
    public void dispose();

    @StateRefinement(from = "displayable(this)")
    @StateRefinement(from = "visible(this)", to = "displayable(this)")
    public void hide();

    @StateRefinement(from = "invisible(this)", to = "displayable(this)")
    @StateRefinement(from = "displayable(this)")
    @StateRefinement(from = "visible(this)")
    public void pack();

    @StateRefinement(from = "invisible(this)")
    @StateRefinement(from = "displayable(this)")
    public void setLocationByPlatform(boolean locationByPlatform);

    @StateRefinement(from = "invisible(this)")
    public void setType(Window.Type type);

    @StateRefinement(to = "visible(this)")
    public void setVisible(boolean b);

    @StateRefinement(from = "!visible(this)", to = "visible(this)")
    public void show();

    @StateRefinement(from = "visible(this)")
    public void toBack();

    @StateRefinement(from = "visible(this)")
    public void toFront();

}