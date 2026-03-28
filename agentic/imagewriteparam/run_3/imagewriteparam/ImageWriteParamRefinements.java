package agentic.imagewriteparam.run_3.imagewriteparam;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.util.Locale;
import java.awt.Dimension;

@RefinementAlias("Quality(float q) { q >= 0.0 && q <= 1.0 }")
@ExternalRefinementsFor("javax.imageio.ImageWriteParam")
@StateSet({"defaultcomprset", "defaultcomprtypeset", "defaultdefault", "tilingparamssetcomprset", "tilingparamssetcomprtypeset", "tilingparamssetdefault", "tilingsetcomprset", "tilingsetcomprtypeset", "tilingsetdefault"})
public interface ImageWriteParamRefinements {

    @StateRefinement(to = "defaultdefault(this)")
    public void ImageWriteParam();

    @StateRefinement(to = "defaultdefault(this)")
    public void ImageWriteParam(Locale locale);

    @StateRefinement(from = "defaultcomprtypeset(this)")
    @StateRefinement(from = "tilingsetcomprtypeset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)")
    public float getBitRate(@Refinement("Quality(quality)") float quality);

    @StateRefinement(from = "defaultcomprtypeset(this)")
    @StateRefinement(from = "tilingsetcomprtypeset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)")
    @Refinement("Quality(_)")
    public float getCompressionQuality();

    @StateRefinement(from = "defaultcomprtypeset(this)")
    @StateRefinement(from = "tilingsetcomprtypeset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)")
    public String[] getCompressionQualityDescriptions();

    @StateRefinement(from = "defaultcomprtypeset(this)")
    @StateRefinement(from = "tilingsetcomprtypeset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)")
    public float[] getCompressionQualityValues();

    @StateRefinement(from = "defaultcomprset(this)")
    @StateRefinement(from = "defaultcomprtypeset(this)")
    @StateRefinement(from = "tilingsetcomprset(this)")
    @StateRefinement(from = "tilingsetcomprtypeset(this)")
    @StateRefinement(from = "tilingparamssetcomprset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)")
    public String getCompressionType();

    @StateRefinement(from = "defaultcomprtypeset(this)")
    @StateRefinement(from = "tilingsetcomprtypeset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)")
    public String getLocalizedCompressionTypeName();

    @StateRefinement(from = "tilingparamssetdefault(this)")
    @StateRefinement(from = "tilingparamssetcomprset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)")
    public int getTileGridXOffset();

    @StateRefinement(from = "tilingparamssetdefault(this)")
    @StateRefinement(from = "tilingparamssetcomprset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)")
    public int getTileGridYOffset();

    @StateRefinement(from = "tilingparamssetdefault(this)")
    @StateRefinement(from = "tilingparamssetcomprset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)")
    @Refinement("_ > 0")
    public int getTileHeight();

    @StateRefinement(from = "tilingparamssetdefault(this)")
    @StateRefinement(from = "tilingparamssetcomprset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)")
    @Refinement("_ > 0")
    public int getTileWidth();

    @StateRefinement(from = "defaultcomprtypeset(this)")
    @StateRefinement(from = "tilingsetcomprtypeset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)")
    public boolean isCompressionLossless();

    @StateRefinement(from = "defaultdefault(this)", to = "defaultcomprset(this)")
    @StateRefinement(from = "defaultcomprset(this)")
    @StateRefinement(from = "defaultcomprtypeset(this)", to = "defaultcomprset(this)")
    @StateRefinement(from = "tilingsetdefault(this)", to = "tilingsetcomprset(this)")
    @StateRefinement(from = "tilingsetcomprset(this)")
    @StateRefinement(from = "tilingsetcomprtypeset(this)", to = "tilingsetcomprset(this)")
    @StateRefinement(from = "tilingparamssetdefault(this)", to = "tilingparamssetcomprset(this)")
    @StateRefinement(from = "tilingparamssetcomprset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)", to = "tilingparamssetcomprset(this)")
    public void setCompressionMode(int mode);

    @StateRefinement(from = "defaultcomprtypeset(this)")
    @StateRefinement(from = "tilingsetcomprtypeset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)")
    public void setCompressionQuality(@Refinement("Quality(quality)") float quality);

    @StateRefinement(from = "defaultcomprset(this)", to = "defaultcomprtypeset(this)")
    @StateRefinement(from = "tilingsetcomprset(this)", to = "tilingsetcomprtypeset(this)")
    @StateRefinement(from = "tilingparamssetcomprset(this)", to = "tilingparamssetcomprtypeset(this)")
    @StateRefinement(from = "defaultcomprtypeset(this)", to = "defaultcomprset(this)")
    @StateRefinement(from = "tilingsetcomprtypeset(this)", to = "tilingsetcomprset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)", to = "tilingparamssetcomprset(this)")
    public void setCompressionType(String compressionType);

    @StateRefinement(from = "tilingsetdefault(this)", to = "tilingparamssetdefault(this)")
    @StateRefinement(from = "tilingsetcomprset(this)", to = "tilingparamssetcomprset(this)")
    @StateRefinement(from = "tilingsetcomprtypeset(this)", to = "tilingparamssetcomprtypeset(this)")
    public void setTiling(
        @Refinement("tileWidth > 0") int tileWidth,
        @Refinement("tileHeight > 0") int tileHeight,
        int tileGridXOffset,
        int tileGridYOffset
    );

    @StateRefinement(from = "defaultdefault(this)", to = "tilingsetdefault(this)")
    @StateRefinement(from = "tilingsetdefault(this)")
    @StateRefinement(from = "tilingparamssetdefault(this)", to = "tilingsetdefault(this)")
    @StateRefinement(from = "defaultcomprset(this)", to = "tilingsetcomprset(this)")
    @StateRefinement(from = "tilingsetcomprset(this)")
    @StateRefinement(from = "tilingparamssetcomprset(this)", to = "tilingsetcomprset(this)")
    @StateRefinement(from = "defaultcomprtypeset(this)", to = "tilingsetcomprtypeset(this)")
    @StateRefinement(from = "tilingsetcomprtypeset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)", to = "tilingsetcomprtypeset(this)")
    public void setTilingMode(int mode);

    @StateRefinement(from = "defaultcomprtypeset(this)", to = "defaultcomprset(this)")
    @StateRefinement(from = "tilingsetcomprtypeset(this)", to = "tilingsetcomprset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)", to = "tilingparamssetcomprset(this)")
    @StateRefinement(from = "defaultcomprset(this)")
    @StateRefinement(from = "tilingsetcomprset(this)")
    @StateRefinement(from = "tilingparamssetcomprset(this)")
    public void unsetCompression();

    @StateRefinement(from = "tilingparamssetdefault(this)", to = "tilingsetdefault(this)")
    @StateRefinement(from = "tilingparamssetcomprset(this)", to = "tilingsetcomprset(this)")
    @StateRefinement(from = "tilingparamssetcomprtypeset(this)", to = "tilingsetcomprtypeset(this)")
    public void unsetTiling();

}