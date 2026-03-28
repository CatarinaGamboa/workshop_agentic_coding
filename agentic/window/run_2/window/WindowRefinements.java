package agentic.window.run_2.window;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.BufferCapabilities;
import java.awt.Window;

@RefinementAlias("AtLeastOne(int n) { n >= 1 }")
@ExternalRefinementsFor("window.Window")
@StateSet({"displayable", "notdisplayable", "visible"})
public interface WindowRefinements {

    @StateRefinement(to = "notdisplayable(this)")
    public void Window(Frame owner);

    @StateRefinement(to = "notdisplayable(this)")
    public void Window(Window owner);

    @StateRefinement(to = "notdisplayable(this)")
    public void Window(Window owner, GraphicsConfiguration gc);

    @StateRefinement(from = "displayable(this)")
    @StateRefinement(from = "visible(this)")
    public void createBufferStrategy(@Refinement("AtLeastOne(numBuffers)") int numBuffers, BufferCapabilities caps);

    @StateRefinement(from = "displayable(this)")
    @StateRefinement(from = "visible(this)")
    public void createBufferStrategy(@Refinement("AtLeastOne(numBuffers)") int numBuffers);

    @StateRefinement(to = "notdisplayable(this)")
    public void dispose();

    @StateRefinement(from = "visible(this)", to = "displayable(this)")
    public void hide();

    @StateRefinement(from = "notdisplayable(this)", to = "displayable(this)")
    @StateRefinement(from = "visible(this)")
    public void pack();

    @StateRefinement(from = "notdisplayable(this)")
    @StateRefinement(from = "displayable(this)")
    public void setLocationByPlatform(boolean locationByPlatform);

    @StateRefinement(from = "notdisplayable(this)")
    public void setType(Window.Type type);

    @StateRefinement(to = "visible(this)")
    public void setVisible(boolean b);

    @StateRefinement(to = "visible(this)")
    public void show();

    @StateRefinement(from = "visible(this)")
    public void toBack();

    @StateRefinement(from = "visible(this)")
    public void toFront();

}
