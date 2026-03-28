package agentic.flatteningpathiterator.run_3.flatteningpathiterator;

import java.awt.geom.PathIterator;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("java.awt.geom.FlatteningPathIterator")
@StateSet({"done", "iterating"})
@RefinementAlias("NonNegativeDouble(double v) { v >= 0.0 }")
@RefinementAlias("NonNegativeInt(int v) { v >= 0 }")
public interface FlatteningPathIteratorRefinements {

    @StateRefinement(to = "iterating(this)")
    public void FlatteningPathIterator(PathIterator src, @Refinement("NonNegativeDouble(flatness)") double flatness);

    @StateRefinement(to = "iterating(this)")
    public void FlatteningPathIterator(PathIterator src, @Refinement("NonNegativeDouble(flatness)") double flatness, @Refinement("NonNegativeInt(limit)") int limit);

    @Refinement("NonNegativeDouble(_)")
    public double getFlatness();

    @Refinement("NonNegativeInt(_)")
    public int getRecursionLimit();

    public int getWindingRule();

    public boolean isDone();

    @StateRefinement(from = "iterating(this)")
    public int currentSegment(float[] coords);

    @StateRefinement(from = "iterating(this)")
    public int currentSegment(double[] coords);

    @StateRefinement(from = "!done(this)", to = "done(this)")
    public void next();

}
