package agentic.xmlfilterimpl.run_5.xmlfilterimpl;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import org.xml.sax.XMLReader;
import org.xml.sax.InputSource;

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

}