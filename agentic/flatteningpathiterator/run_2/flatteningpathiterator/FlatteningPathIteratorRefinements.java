package agentic.flatteningpathiterator.run_2.flatteningpathiterator;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.awt.geom.PathIterator;

@RefinementAlias("NonNegativeDouble(double v) { v >= 0.0 }")
@ExternalRefinementsFor("java.awt.geom.FlatteningPathIterator")
@StateSet({"done", "iterating"})
public interface FlatteningPathIteratorRefinements {

    @StateRefinement(to = "iterating(this)")
    public void FlatteningPathIterator(PathIterator src, @Refinement("NonNegativeDouble(flatness)") double flatness);

    @StateRefinement(to = "iterating(this)")
    public void FlatteningPathIterator(PathIterator src, @Refinement("NonNegativeDouble(flatness)") double flatness, @Refinement("limit >= 0") int limit);

    @Refinement("_ >= 0.0")
    public double getFlatness();

    @Refinement("_ >= 0")
    public int getRecursionLimit();

    public int getWindingRule();

    public boolean isDone();

    @StateRefinement(from = "iterating(this)", to = "done(this)")
    @StateRefinement(from = "done(this)")
    public void next();

    @StateRefinement(from = "iterating(this)")
    public int currentSegment(float[] coords);

    @StateRefinement(from = "iterating(this)")
    public int currentSegment(double[] coords);

}
