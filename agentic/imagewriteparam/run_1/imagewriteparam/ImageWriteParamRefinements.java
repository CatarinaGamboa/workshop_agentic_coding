package agentic.imagewriteparam.run_1.imagewriteparam;

import java.awt.Dimension;
import java.util.Locale;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("Quality(float q) { q >= 0.0 && q <= 1.0 }")
@ExternalRefinementsFor("javax.imageio.ImageWriteParam")
@StateSet({"tilingexplicitcompressionexplicit", "tilingexplicitcompressionexplicitwithtype", "tilingexplicitcompressionnone", "tilingexplicitwithparamscompressionexplicit", "tilingexplicitwithparamscompressionexplicitwithtype", "tilingexplicitwithparamscompressionnone", "tilingnonecompressionexplicit", "tilingnonecompressionexplicitwithtype", "tilingnonecompressionnone"})
public interface ImageWriteParamRefinements {

    @StateRefinement(to = "tilingnonecompressionnone(this)")
    public void ImageWriteParam(Locale locale);

    @StateRefinement(from = "tilingnonecompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public float getBitRate(@Refinement("Quality(quality)") float quality);

    @StateRefinement(from = "tilingnonecompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    @Refinement("Quality(_)")
    public float getCompressionQuality();

    @StateRefinement(from = "tilingnonecompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public String[] getCompressionQualityDescriptions();

    @StateRefinement(from = "tilingnonecompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public float[] getCompressionQualityValues();

    @StateRefinement(from = "tilingnonecompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public String getCompressionType();

    @StateRefinement(from = "tilingnonecompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public String getLocalizedCompressionTypeName();

    @StateRefinement(from = "tilingexplicitwithparamscompressionnone(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public int getTileGridXOffset();

    @StateRefinement(from = "tilingexplicitwithparamscompressionnone(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public int getTileGridYOffset();

    @StateRefinement(from = "tilingexplicitwithparamscompressionnone(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    @Refinement("_ > 0")
    public int getTileHeight();

    @StateRefinement(from = "tilingexplicitwithparamscompressionnone(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    @Refinement("_ > 0")
    public int getTileWidth();

    @StateRefinement(from = "tilingnonecompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public boolean isCompressionLossless();

    @StateRefinement(from = "tilingnonecompressionnone(this)", to = "tilingnonecompressionexplicit(this)")
    @StateRefinement(from = "tilingnonecompressionexplicit(this)", to = "tilingnonecompressionnone(this)")
    @StateRefinement(from = "tilingnonecompressionexplicitwithtype(this)", to = "tilingnonecompressionnone(this)")
    @StateRefinement(from = "tilingexplicitcompressionnone(this)", to = "tilingexplicitcompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicit(this)", to = "tilingexplicitcompressionnone(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicitwithtype(this)", to = "tilingexplicitcompressionnone(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionnone(this)", to = "tilingexplicitwithparamscompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicit(this)", to = "tilingexplicitwithparamscompressionnone(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)", to = "tilingexplicitwithparamscompressionnone(this)")
    public void setCompressionMode(int mode);

    @StateRefinement(from = "tilingnonecompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public void setCompressionQuality(@Refinement("Quality(quality)") float quality);

    @StateRefinement(from = "tilingnonecompressionexplicit(this)", to = "tilingnonecompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingnonecompressionexplicitwithtype(this)", to = "tilingnonecompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicit(this)", to = "tilingexplicitcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicitwithtype(this)", to = "tilingexplicitcompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicit(this)", to = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)", to = "tilingexplicitwithparamscompressionexplicit(this)")
    public void setCompressionType(String compressionType);

    @StateRefinement(from = "tilingexplicitcompressionnone(this)", to = "tilingexplicitwithparamscompressionnone(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicit(this)", to = "tilingexplicitwithparamscompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicitwithtype(this)", to = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionnone(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)")
    public void setTiling(@Refinement("tileWidth > 0") int tileWidth, @Refinement("tileHeight > 0") int tileHeight, int tileGridXOffset, int tileGridYOffset);

    @StateRefinement(from = "tilingnonecompressionnone(this)", to = "tilingexplicitcompressionnone(this)")
    @StateRefinement(from = "tilingnonecompressionexplicit(this)", to = "tilingexplicitcompressionexplicit(this)")
    @StateRefinement(from = "tilingnonecompressionexplicitwithtype(this)", to = "tilingexplicitcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitcompressionnone(this)", to = "tilingnonecompressionnone(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicit(this)", to = "tilingnonecompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicitwithtype(this)", to = "tilingnonecompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionnone(this)", to = "tilingnonecompressionnone(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicit(this)", to = "tilingnonecompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)", to = "tilingnonecompressionexplicitwithtype(this)")
    public void setTilingMode(int mode);

    @StateRefinement(from = "tilingnonecompressionexplicit(this)")
    @StateRefinement(from = "tilingnonecompressionexplicitwithtype(this)", to = "tilingnonecompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicitwithtype(this)", to = "tilingexplicitcompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)", to = "tilingexplicitwithparamscompressionexplicit(this)")
    public void unsetCompression();

    @StateRefinement(from = "tilingexplicitcompressionnone(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitcompressionexplicitwithtype(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionnone(this)", to = "tilingexplicitcompressionnone(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicit(this)", to = "tilingexplicitcompressionexplicit(this)")
    @StateRefinement(from = "tilingexplicitwithparamscompressionexplicitwithtype(this)", to = "tilingexplicitcompressionexplicitwithtype(this)")
    public void unsetTiling();

}
