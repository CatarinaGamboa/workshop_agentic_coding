package agentic.requiredmodelmbean.run_2.requiredmodelmbean;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanServer;
import javax.management.Notification;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.AttributeChangeNotification;
import javax.management.modelmbean.ModelMBeanInfo;
import javax.management.loading.ClassLoaderRepository;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("javax.management.modelmbean.RequiredModelMBean")
@StateSet({"registered", "unregistered"})
public interface RequiredModelMBeanRefinements {

    // Constructors - always transition to unregistered state
    @StateRefinement(to = "unregistered(this)")
    public void RequiredModelMBean();

    @StateRefinement(to = "unregistered(this)")
    public void RequiredModelMBean(ModelMBeanInfo mbi);

    // setModelMBeanInfo: only callable in Unregistered state (forbidden in Registered)
    @StateRefinement(from = "unregistered(this)")
    public void setModelMBeanInfo(ModelMBeanInfo mbi);

    // setManagedResource: callable from both states
    public void setManagedResource(Object mr, String mr_type);

    // load: should only be called before registration (Unregistered state)
    @StateRefinement(from = "unregistered(this)")
    public void load();

    // store: callable from both states
    public void store();

    // getMBeanInfo: callable from both states
    public MBeanInfo getMBeanInfo();

    // invoke: callable from both states
    public Object invoke(String opName, Object[] opArgs, String[] sig);

    // getAttribute: callable from both states
    public Object getAttribute(String attrName);

    // getAttributes: callable from both states
    public AttributeList getAttributes(String[] attrNames);

    // setAttribute: callable from both states
    public void setAttribute(Attribute attribute);

    // setAttributes: callable from both states
    public AttributeList setAttributes(AttributeList attributes);

    // addNotificationListener: callable from both states
    public void addNotificationListener(NotificationListener listener, NotificationFilter filter, Object handback);

    // removeNotificationListener (single arg): callable from both states
    public void removeNotificationListener(NotificationListener listener);

    // removeNotificationListener (three args): callable from both states
    public void removeNotificationListener(NotificationListener listener, NotificationFilter filter, Object handback);

    // sendNotification with Notification object: callable from both states
    public void sendNotification(Notification ntfyObj);

    // sendNotification with String text: callable from both states
    public void sendNotification(String ntfyText);

    // getNotificationInfo: callable from both states
    public MBeanNotificationInfo[] getNotificationInfo();

    // addAttributeChangeNotificationListener: callable from both states
    public void addAttributeChangeNotificationListener(NotificationListener inlistener, String inAttributeName, Object inhandback);

    // removeAttributeChangeNotificationListener: callable from both states
    public void removeAttributeChangeNotificationListener(NotificationListener inlistener, String inAttributeName);

    // sendAttributeChangeNotification with AttributeChangeNotification: callable from both states
    public void sendAttributeChangeNotification(AttributeChangeNotification ntfyObj);

    // sendAttributeChangeNotification with two Attributes: callable from both states
    public void sendAttributeChangeNotification(Attribute inOldVal, Attribute inNewVal);

    // getClassLoaderRepository: callable from both states
    public ClassLoaderRepository getClassLoaderRepository();

    // preRegister: Unregistered --> Registered
    @StateRefinement(from = "!registered(this)", to = "registered(this)")
    public ObjectName preRegister(MBeanServer server, ObjectName name);

    // postRegister: callable from Registered state (stays Registered)
    @StateRefinement(from = "registered(this)")
    public void postRegister(Boolean registrationDone);

    // preDeregister: Registered --> Unregistered
    @StateRefinement(from = "!unregistered(this)", to = "unregistered(this)")
    public void preDeregister();

    // postDeregister: callable from Unregistered state (stays Unregistered)
    @StateRefinement(from = "unregistered(this)")
    public void postDeregister();

}
