package agentic.imagewriteparam.run_4.imagewriteparam;

import java.awt.Dimension;
import java.util.Locale;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("Quality(float q) { q >= 0.0 && q <= 1.0 }")
@RefinementAlias("PositiveDim(int d) { d > 0 }")
@ExternalRefinementsFor("javax.imageio.ImageWriteParam")
@StateSet({"texplicitcexplicit", "texplicitcexplicittyped", "texplicitcnotexplicit", "texplicitsetcexplicit", "texplicitsetcexplicittyped", "texplicitsetcnotexplicit", "tnotexplicitcexplicit", "tnotexplicitcexplicittyped", "tnotexplicitcnotexplicit"})
public interface ImageWriteParamRefinements {

    @StateRefinement(to = "tnotexplicitcnotexplicit(this)")
    public void ImageWriteParam(Locale locale);

    @StateRefinement(from = "tnotexplicitcexplicit(this)")
    @StateRefinement(from = "texplicitcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)")
    @StateRefinement(from = "tnotexplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)")
    public float getBitRate(@Refinement("Quality(quality)") float quality);

    @StateRefinement(from = "tnotexplicitcexplicit(this)")
    @StateRefinement(from = "texplicitcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)")
    @StateRefinement(from = "tnotexplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)")
    @Refinement("Quality(_)")
    public float getCompressionQuality();

    @StateRefinement(from = "tnotexplicitcexplicit(this)")
    @StateRefinement(from = "texplicitcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)")
    @StateRefinement(from = "tnotexplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)")
    public String[] getCompressionQualityDescriptions();

    @StateRefinement(from = "tnotexplicitcexplicit(this)")
    @StateRefinement(from = "texplicitcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)")
    @StateRefinement(from = "tnotexplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)")
    public float[] getCompressionQualityValues();

    @StateRefinement(from = "tnotexplicitcexplicit(this)")
    @StateRefinement(from = "texplicitcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)")
    @StateRefinement(from = "tnotexplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)")
    public String getCompressionType();

    @StateRefinement(from = "tnotexplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)")
    public String getLocalizedCompressionTypeName();

    @StateRefinement(from = "texplicitsetcnotexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)")
    public int getTileGridXOffset();

    @StateRefinement(from = "texplicitsetcnotexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)")
    public int getTileGridYOffset();

    @StateRefinement(from = "texplicitsetcnotexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)")
    @Refinement("PositiveDim(_)")
    public int getTileHeight();

    @StateRefinement(from = "texplicitsetcnotexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)")
    @Refinement("PositiveDim(_)")
    public int getTileWidth();

    @StateRefinement(from = "tnotexplicitcexplicit(this)")
    @StateRefinement(from = "texplicitcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)")
    @StateRefinement(from = "tnotexplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)")
    public boolean isCompressionLossless();

    @StateRefinement(from = "tnotexplicitcnotexplicit(this)", to = "tnotexplicitcexplicit(this)")
    @StateRefinement(from = "texplicitcnotexplicit(this)", to = "texplicitcexplicit(this)")
    @StateRefinement(from = "texplicitsetcnotexplicit(this)", to = "texplicitsetcexplicit(this)")
    @StateRefinement(from = "tnotexplicitcexplicit(this)", to = "tnotexplicitcnotexplicit(this)")
    @StateRefinement(from = "texplicitcexplicit(this)", to = "texplicitcnotexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)", to = "texplicitsetcnotexplicit(this)")
    @StateRefinement(from = "tnotexplicitcexplicittyped(this)", to = "tnotexplicitcnotexplicit(this)")
    @StateRefinement(from = "texplicitcexplicittyped(this)", to = "texplicitcnotexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)", to = "texplicitsetcnotexplicit(this)")
    public void setCompressionMode(int mode);

    @StateRefinement(from = "tnotexplicitcexplicit(this)")
    @StateRefinement(from = "texplicitcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)")
    @StateRefinement(from = "tnotexplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)")
    public void setCompressionQuality(@Refinement("Quality(quality)") float quality);

    @StateRefinement(from = "tnotexplicitcexplicit(this)", to = "tnotexplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitcexplicit(this)", to = "texplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)", to = "texplicitsetcexplicittyped(this)")
    @StateRefinement(from = "tnotexplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)")
    public void setCompressionType(String compressionType);

    @StateRefinement(from = "texplicitcnotexplicit(this)", to = "texplicitsetcnotexplicit(this)")
    @StateRefinement(from = "texplicitcexplicit(this)", to = "texplicitsetcexplicit(this)")
    @StateRefinement(from = "texplicitcexplicittyped(this)", to = "texplicitsetcexplicittyped(this)")
    @StateRefinement(from = "texplicitsetcnotexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)")
    public void setTiling(@Refinement("PositiveDim(tileWidth)") int tileWidth, @Refinement("PositiveDim(tileHeight)") int tileHeight, int tileGridXOffset, int tileGridYOffset);

    @StateRefinement(from = "tnotexplicitcnotexplicit(this)", to = "texplicitcnotexplicit(this)")
    @StateRefinement(from = "tnotexplicitcexplicit(this)", to = "texplicitcexplicit(this)")
    @StateRefinement(from = "tnotexplicitcexplicittyped(this)", to = "texplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitcnotexplicit(this)", to = "tnotexplicitcnotexplicit(this)")
    @StateRefinement(from = "texplicitcexplicit(this)", to = "tnotexplicitcexplicit(this)")
    @StateRefinement(from = "texplicitcexplicittyped(this)", to = "tnotexplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitsetcnotexplicit(this)", to = "texplicitcnotexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)", to = "texplicitcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)", to = "texplicitcexplicittyped(this)")
    public void setTilingMode(int mode);

    @StateRefinement(from = "tnotexplicitcexplicit(this)")
    @StateRefinement(from = "texplicitcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)")
    @StateRefinement(from = "tnotexplicitcexplicittyped(this)", to = "tnotexplicitcexplicit(this)")
    @StateRefinement(from = "texplicitcexplicittyped(this)", to = "texplicitcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)", to = "texplicitsetcexplicit(this)")
    public void unsetCompression();

    @StateRefinement(from = "texplicitcnotexplicit(this)")
    @StateRefinement(from = "texplicitcexplicit(this)")
    @StateRefinement(from = "texplicitcexplicittyped(this)")
    @StateRefinement(from = "texplicitsetcnotexplicit(this)", to = "texplicitcnotexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicit(this)", to = "texplicitcexplicit(this)")
    @StateRefinement(from = "texplicitsetcexplicittyped(this)", to = "texplicitcexplicittyped(this)")
    public void unsetTiling();

}