package agentic.requiredmodelmbean.run_3.requiredmodelmbean;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.modelmbean.ModelMBeanInfo;

@ExternalRefinementsFor("javax.management.modelmbean.RequiredModelMBean")
@StateSet({"registered", "unregistered"})
public interface RequiredModelMBeanRefinements {

    @StateRefinement(to = "unregistered(this)")
    public void RequiredModelMBean();

    @StateRefinement(to = "unregistered(this)")
    public void RequiredModelMBean(ModelMBeanInfo mbi);

    @StateRefinement(from = "!unregistered(this)", to = "unregistered(this)")
    public void postDeregister();

    @StateRefinement(from = "!registered(this)", to = "registered(this)")
    public void postRegister(Boolean registrationDone);

    @StateRefinement(from = "!unregistered(this)", to = "unregistered(this)")
    public void preDeregister();

    @StateRefinement(from = "!registered(this)", to = "registered(this)")
    public ObjectName preRegister(MBeanServer server, ObjectName name);

    @StateRefinement(from = "unregistered(this)")
    public void setModelMBeanInfo(ModelMBeanInfo mbi);

}