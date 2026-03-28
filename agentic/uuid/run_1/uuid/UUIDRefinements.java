package agentic.uuid.run_1.uuid;

import java.util.UUID;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("uuid.UUID")
@StateSet({"nontimebased", "maybetimebased"})
@RefinementAlias("ValidVersion(int v) { v >= 1 && v <= 4 }")
@RefinementAlias("CompareResult(int r) { r >= -1 && r <= 1 }")
public interface UUIDRefinements {

    // Constructor: produces maybeTimeBased state (version unknown at static time)
    @StateRefinement(to = "maybetimebased(this)")
    public void UUID(long mostSigBits, long leastSigBits);

    // Static factories: produce NonTimeBased state (version 3 or 4, not time-based)
    @StateRefinement(to = "nontimebased(this)")
    public UUID randomUUID();

    @StateRefinement(to = "nontimebased(this)")
    public UUID nameUUIDFromBytes(byte[] name);

    @StateRefinement(to = "nontimebased(this)")
    public UUID fromString(String name);

    // Methods valid in both states (self-loops in both): no from constraint
    public long getLeastSignificantBits();

    public long getMostSignificantBits();

    @Refinement("ValidVersion(_)")
    public int version();

    public int variant();

    public String toString();

    public int hashCode();

    public boolean equals(Object obj);

    @Refinement("CompareResult(_)")
    public int compareTo(UUID val);

    // Methods only valid in maybeTimeBased state (time-based operations)
    @StateRefinement(from = "maybetimebased(this)")
    @Refinement("_ >= 0")
    public long timestamp();

    @StateRefinement(from = "maybetimebased(this)")
    @Refinement("_ >= 0 && _ <= 16383")
    public int clockSequence();

    @StateRefinement(from = "maybetimebased(this)")
    @Refinement("_ >= 0")
    public long node();

}
