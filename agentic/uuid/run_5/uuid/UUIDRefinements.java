package agentic.uuid.run_5.uuid;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.util.UUID;

@ExternalRefinementsFor("java.util.UUID")
@StateSet({"maybeversion1", "nonversion1"})
public interface UUIDRefinements {

    @StateRefinement(to = "maybeversion1(this)")
    public void UUID(long mostSigBits, long leastSigBits);

    @StateRefinement(to = "nonversion1(this)")
    public UUID randomUUID();

    @StateRefinement(to = "nonversion1(this)")
    public UUID nameUUIDFromBytes(byte[] name);

    @StateRefinement(to = "maybeversion1(this)")
    public UUID fromString(String name);

    public long getLeastSignificantBits();

    public long getMostSignificantBits();

    @Refinement("_ >= 1 && _ <= 4")
    public int version();

    @Refinement("_ >= 0")
    public int variant();

    @StateRefinement(from = "maybeversion1(this)")
    @Refinement("_ >= 0")
    public long timestamp();

    @StateRefinement(from = "maybeversion1(this)")
    @Refinement("_ >= 0 && _ <= 16383")
    public int clockSequence();

    @StateRefinement(from = "maybeversion1(this)")
    @Refinement("_ >= 0")
    public long node();

    public String toString();

    public int hashCode();

    public boolean equals(Object obj);

    @Refinement("_ >= -1 && _ <= 1")
    public int compareTo(UUID val);

}
