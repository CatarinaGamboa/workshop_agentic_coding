package agentic.xmlfilterimpl.run_1.xmlfilterimpl;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;

@RefinementAlias("NonNegative(int v) { v >= 0 }")
@ExternalRefinementsFor("org.xml.sax.helpers.XMLFilterImpl")
@StateSet({"noparent", "withparent"})
public interface XMLFilterImplRefinements {

    @StateRefinement(to = "noparent(this)")
    public void XMLFilterImpl();

    @StateRefinement(to = "withparent(this)")
    public void XMLFilterImpl(XMLReader parent);

    @StateRefinement(from = "withparent(this)")
    public boolean getFeature(String name);

    @StateRefinement(from = "withparent(this)")
    public Object getProperty(String name);

    @StateRefinement(from = "withparent(this)")
    public void parse(InputSource input);

    @StateRefinement(from = "withparent(this)")
    public void parse(String systemId);

    @StateRefinement(from = "withparent(this)")
    public void setFeature(String name, boolean value);

    @StateRefinement(to = "withparent(this)")
    public void setParent(XMLReader parent);

    @StateRefinement(from = "withparent(this)")
    public void setProperty(String name, Object value);

    public void characters(char[] ch, @Refinement("NonNegative(start)") int start, @Refinement("NonNegative(length)") int length);

    public void ignorableWhitespace(char[] ch, @Refinement("NonNegative(start)") int start, @Refinement("NonNegative(length)") int length);

}