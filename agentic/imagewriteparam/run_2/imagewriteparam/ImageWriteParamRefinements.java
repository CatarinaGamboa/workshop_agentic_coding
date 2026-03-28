package agentic.imagewriteparam.run_2.imagewriteparam;

import java.util.Locale;
import java.awt.Dimension;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("Quality(float q) { q >= 0.0 && q <= 1.0 }")
@RefinementAlias("PositiveDim(int d) { d > 0 }")
@ExternalRefinementsFor("javax.imageio.ImageWriteParam")
@StateSet({"tilingdefaultcompressiondefault", "tilingdefaultcompressionexplicitnotype", "tilingdefaultcompressionexplicitwithtype", "tilingexplicitnoparamscompressiondefault", "tilingexplicitnoparamscompressionexplicitnotype", "tilingexplicitnoparamscompressionexplicitwithtype", "tilingexplicitwithparamscompressiondefault", "tilingexplicitwithparamscompressionexplicitnotype", "tilingexplicitwithparamscompressionexplicitwithtype"})
public interface ImageWriteParamRefinements {

    @StateRefinement(to = "tilingdefaultcompressiondefault(this)")
    public void ImageWriteParam(Locale locale);

    @StateRefinement(from = "tilingdefaultcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public float getBitRate(@Refinement("Quality(quality)") float quality);

    @StateRefinement(from = "tilingdefaultcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    @Refinement("Quality(_)")
    public float getCompressionQuality();

    @StateRefinement(from = "tilingdefaultcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public String[] getCompressionQualityDescriptions();

    @StateRefinement(from = "tilingdefaultcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public float[] getCompressionQualityValues();

    @StateRefinement(from = "tilingdefaultcompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingdefaultcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public String getCompressionType();

    @StateRefinement(from = "tilingdefaultcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public String getLocalizedCompressionTypeName();

    @StateRefinement(from = "tilingexplicitwithparamscompressiondefault(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public int getTileGridXOffset();

    @StateRefinement(from = "tilingexplicitwithparamscompressiondefault(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public int getTileGridYOffset();

    @StateRefinement(from = "tilingexplicitwithparamscompressiondefault(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    @Refinement("PositiveDim(_)")
    public int getTileHeight();

    @StateRefinement(from = "tilingexplicitwithparamscompressiondefault(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    @Refinement("PositiveDim(_)")
    public int getTileWidth();

    @StateRefinement(from = "tilingdefaultcompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingdefaultcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public boolean isCompressionLossless();

    @StateRefinement(from = "tilingdefaultcompressiondefault(this)", to = "tilingdefaultcompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingdefaultcompressionexplicitnotype(this)", to = "tilingdefaultcompressiondefault(this)")
    @StateRefinement(from = "tilingdefaultcompressionexplicitwithtype(this)", to = "tilingdefaultcompressiondefault(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressiondefault(this)", to = "tilingexplicitnoparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitnotype(this)", to = "tilingexplicitnoparamscompressiondefault(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitwithtype(this)", to = "tilingexplicitnoparamscompressiondefault(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressiondefault(this)", to = "tilingexplicitwithparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitnotype(this)", to = "tilingexplicitwithparamscompressiondefault(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)", to = "tilingexplicitwithparamscompressiondefault(this)")
    public void setCompressionMode(int mode);

    @StateRefinement(from = "tilingdefaultcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public void setCompressionQuality(@Refinement("Quality(quality)") float quality);

    @StateRefinement(from = "tilingdefaultcompressionexplicitnotype(this)", to = "tilingdefaultcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingdefaultcompressionexplicitwithtype(this)", to = "tilingdefaultcompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitnotype(this)", to = "tilingexplicitnoparamscompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitwithtype(this)", to = "tilingexplicitnoparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitnotype(this)", to = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)", to = "tilingexplicitwithparamscompressionexplicitnotype(this)")
    public void setCompressionType(String compressionType);

    @StateRefinement(from = "tilingexplicitnoparamscompressiondefault(this)", to = "tilingexplicitwithparamscompressiondefault(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitnotype(this)", to = "tilingexplicitwithparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitwithtype(this)", to = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressiondefault(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public void setTiling(@Refinement("PositiveDim(tileWidth)") int tileWidth, @Refinement("PositiveDim(tileHeight)") int tileHeight, int tileGridXOffset, int tileGridYOffset);

    @StateRefinement(from = "tilingdefaultcompressiondefault(this)", to = "tilingexplicitnoparamscompressiondefault(this)")
    @StateRefinement(from = "tilingdefaultcompressionexplicitnotype(this)", to = "tilingexplicitnoparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingdefaultcompressionexplicitwithtype(this)", to = "tilingexplicitnoparamscompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressiondefault(this)", to = "tilingdefaultcompressiondefault(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitnotype(this)", to = "tilingdefaultcompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitwithtype(this)", to = "tilingdefaultcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressiondefault(this)", to = "tilingdefaultcompressiondefault(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitnotype(this)", to = "tilingdefaultcompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)", to = "tilingdefaultcompressionexplicitwithtype(this)")
    public void setTilingMode(int mode);

    @StateRefinement(from = "tilingdefaultcompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingdefaultcompressionexplicitwithtype(this)", to = "tilingdefaultcompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitwithtype(this)", to = "tilingexplicitnoparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)", to = "tilingexplicitwithparamscompressionexplicitnotype(this)")
    public void unsetCompression();

    @StateRefinement(from = "tilingexplicitnoparamscompressiondefault(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitnoparamscompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressiondefault(this)", to = "tilingexplicitnoparamscompressiondefault(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitnotype(this)", to = "tilingexplicitnoparamscompressionexplicitnotype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)", to = "tilingexplicitnoparamscompressionexplicitwithtype(this)")
    public void unsetTiling();

}