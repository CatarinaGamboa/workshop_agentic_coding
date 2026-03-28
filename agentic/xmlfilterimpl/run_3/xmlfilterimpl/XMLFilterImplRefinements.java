package agentic.xmlfilterimpl.run_3.xmlfilterimpl;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

@ExternalRefinementsFor("org.xml.sax.helpers.XMLFilterImpl")
@StateSet({"hasparent", "noparent"})
public interface XMLFilterImplRefinements {

    @StateRefinement(to = "noparent(this)")
    public void XMLFilterImpl();

    @StateRefinement(to = "hasparent(this)")
    public void XMLFilterImpl(XMLReader parent);

    @StateRefinement(to = "hasparent(this)")
    public void setParent(XMLReader parent);

    public XMLReader getParent();

    @StateRefinement(from = "hasparent(this)")
    public void setFeature(String name, boolean value);

    @StateRefinement(from = "hasparent(this)")
    public boolean getFeature(String name);

    @StateRefinement(from = "hasparent(this)")
    public void setProperty(String name, Object value);

    @StateRefinement(from = "hasparent(this)")
    public Object getProperty(String name);

    public void setEntityResolver(EntityResolver resolver);

    public EntityResolver getEntityResolver();

    public void setDTDHandler(DTDHandler handler);

    public DTDHandler getDTDHandler();

    public void setContentHandler(ContentHandler handler);

    public ContentHandler getContentHandler();

    public void setErrorHandler(ErrorHandler handler);

    public ErrorHandler getErrorHandler();

    @StateRefinement(from = "hasparent(this)")
    public void parse(InputSource input);

    @StateRefinement(from = "hasparent(this)")
    public void parse(String systemId);

    public InputSource resolveEntity(String publicId, String systemId);

    public void notationDecl(String name, String publicId, String systemId);

    public void unparsedEntityDecl(String name, String publicId, String systemId, String notationName);

    public void setDocumentLocator(Locator locator);

    public void startDocument();

    public void endDocument();

    public void startPrefixMapping(String prefix, String uri);

    public void endPrefixMapping(String prefix);

    public void startElement(String uri, String localName, String qName, Attributes atts);

    public void endElement(String uri, String localName, String qName);

    public void characters(
        char[] ch,
        @Refinement("start >= 0") int start,
        @Refinement("length >= 0") int length
    );

    public void ignorableWhitespace(
        char[] ch,
        @Refinement("start >= 0") int start,
        @Refinement("length >= 0") int length
    );

    public void processingInstruction(String target, String data);

    public void skippedEntity(String name);

    public void warning(SAXParseException e);

    public void error(SAXParseException e);

    public void fatalError(SAXParseException e);

}
