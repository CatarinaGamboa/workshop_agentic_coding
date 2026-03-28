package agentic.rmiconnector.run_4.rmiconnector;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.rmi.RMIServer;
import javax.management.MBeanServerConnection;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import javax.security.auth.Subject;
import java.util.Map;

@ExternalRefinementsFor("javax.management.remote.rmi.RMIConnector")
@StateSet({"closed", "connected", "disconnected"})
public interface RMIConnectorRefinements {

    @StateRefinement(to = "disconnected(this)")
    public void RMIConnector(JMXServiceURL url, Map environment);

    @StateRefinement(to = "disconnected(this)")
    public void RMIConnector(RMIServer rmiServer, Map environment);

    public String toString();

    public JMXServiceURL getAddress();

    @StateRefinement(from = "disconnected(this)", to = "connected(this)")
    public void connect();

    @StateRefinement(from = "disconnected(this)", to = "connected(this)")
    public void connect(Map environment);

    @StateRefinement(from = "connected(this)")
    public String getConnectionId();

    @StateRefinement(from = "connected(this)")
    public MBeanServerConnection getMBeanServerConnection();

    @StateRefinement(from = "connected(this)")
    public MBeanServerConnection getMBeanServerConnection(Subject delegationSubject);

    public void addConnectionNotificationListener(NotificationListener listener, NotificationFilter filter, Object handback);

    public void removeConnectionNotificationListener(NotificationListener listener);

    public void removeConnectionNotificationListener(NotificationListener listener, NotificationFilter filter, Object handback);

    @StateRefinement(from = "connected(this)", to = "closed(this)")
    public void close();

}