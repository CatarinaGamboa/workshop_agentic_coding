package agentic.requiredmodelmbean.run_1.requiredmodelmbean;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanServer;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.AttributeChangeNotification;
import javax.management.modelmbean.ModelMBeanInfo;
import javax.management.loading.ClassLoaderRepository;
import javax.management.Notification;

@ExternalRefinementsFor("javax.management.modelmbean.RequiredModelMBean")
@StateSet({"deregistered", "registered", "unregistered"})
public interface RequiredModelMBeanRefinements {

    @StateRefinement(to = "unregistered(this)")
    public void RequiredModelMBean();

    @StateRefinement(to = "unregistered(this)")
    public void RequiredModelMBean(ModelMBeanInfo mbi);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void addAttributeChangeNotificationListener(NotificationListener inlistener, String inAttributeName, Object inhandback);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void addNotificationListener(NotificationListener listener, NotificationFilter filter, Object handback);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public Object getAttribute(String attrName);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public AttributeList getAttributes(String[] attrNames);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public ClassLoaderRepository getClassLoaderRepository();

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public MBeanInfo getMBeanInfo();

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public MBeanNotificationInfo[] getNotificationInfo();

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public Object invoke(String opName, Object[] opArgs, String[] sig);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void load();

    @StateRefinement(from = "deregistered(this)")
    public void postDeregister();

    @StateRefinement(from = "registered(this)")
    public void postRegister(Boolean registrationDone);

    @StateRefinement(from = "registered(this)", to = "deregistered(this)")
    public void preDeregister();

    @StateRefinement(from = "unregistered(this)", to = "registered(this)")
    public ObjectName preRegister(MBeanServer server, ObjectName name);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void removeAttributeChangeNotificationListener(NotificationListener inlistener, String inAttributeName);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void removeNotificationListener(NotificationListener listener);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void removeNotificationListener(NotificationListener listener, NotificationFilter filter, Object handback);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void sendAttributeChangeNotification(AttributeChangeNotification ntfyObj);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void sendAttributeChangeNotification(Attribute inOldVal, Attribute inNewVal);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void sendNotification(Notification ntfyObj);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void sendNotification(String ntfyText);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void setAttribute(Attribute attribute);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public AttributeList setAttributes(AttributeList attributes);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void setManagedResource(Object mr, String mr_type);

    @StateRefinement(from = "unregistered(this)")
    public void setModelMBeanInfo(ModelMBeanInfo mbi);

    @StateRefinement(from = "unregistered(this)")
    @StateRefinement(from = "registered(this)")
    public void store();

}