package agentic.imagewriteparam.run_5.imagewriteparam;

import java.util.Locale;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("Quality(float q) { q >= 0.0 && q <= 1.0 }")
@ExternalRefinementsFor("javax.imageio.ImageWriteParam")
@StateSet({"tilingexplicitsetcompexplicit", "tilingexplicitsetcompnonexplicit", "tilingexplicitunsetcompexplicit", "tilingexplicitunsetcompnonexplicit", "tilingnonexplicitcompexplicit", "tilingnonexplicitcompnonexplicit"})
public interface ImageWriteParamRefinements {

    @StateRefinement(to = "tilingnonexplicitcompnonexplicit(this)")
    public void ImageWriteParam(Locale locale);

    @StateRefinement(from = "tilingnonexplicitcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)")
    public float getBitRate(@Refinement("Quality(quality)") float quality);

    @StateRefinement(from = "tilingnonexplicitcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)")
    @Refinement("Quality(_)")
    public float getCompressionQuality();

    @StateRefinement(from = "tilingnonexplicitcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)")
    public String[] getCompressionQualityDescriptions();

    @StateRefinement(from = "tilingnonexplicitcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)")
    public float[] getCompressionQualityValues();

    @StateRefinement(from = "tilingnonexplicitcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)")
    public String getCompressionType();

    @StateRefinement(from = "tilingnonexplicitcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)")
    public String getLocalizedCompressionTypeName();

    @StateRefinement(from = "tilingexplicitsetcompnonexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)")
    public int getTileGridXOffset();

    @StateRefinement(from = "tilingexplicitsetcompnonexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)")
    public int getTileGridYOffset();

    @StateRefinement(from = "tilingexplicitsetcompnonexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)")
    @Refinement("_ > 0")
    public int getTileHeight();

    @StateRefinement(from = "tilingexplicitsetcompnonexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)")
    @Refinement("_ > 0")
    public int getTileWidth();

    @StateRefinement(from = "tilingnonexplicitcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)")
    public boolean isCompressionLossless();

    @StateRefinement(from = "tilingnonexplicitcompnonexplicit(this)", to = "tilingnonexplicitcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompnonexplicit(this)", to = "tilingexplicitunsetcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompnonexplicit(this)", to = "tilingexplicitsetcompexplicit(this)")
    @StateRefinement(from = "tilingnonexplicitcompexplicit(this)", to = "tilingnonexplicitcompnonexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompexplicit(this)", to = "tilingexplicitunsetcompnonexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)", to = "tilingexplicitsetcompnonexplicit(this)")
    public void setCompressionMode(int mode);

    @StateRefinement(from = "tilingnonexplicitcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)")
    public void setCompressionQuality(@Refinement("Quality(quality)") float quality);

    @StateRefinement(from = "tilingnonexplicitcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)")
    public void setCompressionType(String compressionType);

    @StateRefinement(from = "tilingexplicitunsetcompnonexplicit(this)", to = "tilingexplicitsetcompnonexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompnonexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompexplicit(this)", to = "tilingexplicitsetcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)")
    public void setTiling(@Refinement("tileWidth > 0") int tileWidth, @Refinement("tileHeight > 0") int tileHeight, int tileGridXOffset, int tileGridYOffset);

    @StateRefinement(from = "tilingnonexplicitcompnonexplicit(this)", to = "tilingexplicitunsetcompnonexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompnonexplicit(this)", to = "tilingnonexplicitcompnonexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompnonexplicit(this)", to = "tilingnonexplicitcompnonexplicit(this)")
    @StateRefinement(from = "tilingnonexplicitcompexplicit(this)", to = "tilingexplicitunsetcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompexplicit(this)", to = "tilingnonexplicitcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)", to = "tilingnonexplicitcompexplicit(this)")
    public void setTilingMode(int mode);

    @StateRefinement(from = "tilingnonexplicitcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)")
    public void unsetCompression();

    @StateRefinement(from = "tilingexplicitunsetcompnonexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompnonexplicit(this)", to = "tilingexplicitunsetcompnonexplicit(this)")
    @StateRefinement(from = "tilingexplicitunsetcompexplicit(this)")
    @StateRefinement(from = "tilingexplicitsetcompexplicit(this)", to = "tilingexplicitunsetcompexplicit(this)")
    public void unsetTiling();

}