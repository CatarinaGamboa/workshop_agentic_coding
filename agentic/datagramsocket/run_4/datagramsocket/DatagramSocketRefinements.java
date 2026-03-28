package agentic.datagramsocket.run_4.datagramsocket;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.net.DatagramSocketImpl;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.DatagramPacket;
import java.net.NetworkInterface;
import java.net.SocketOption;
import java.net.DatagramSocket;
import java.nio.channels.DatagramChannel;
import java.util.Set;

@RefinementAlias("ValidPort(int p) { p >= 0 && p <= 65535 }")
@RefinementAlias("PositiveSize(int s) { s > 0 }")
@RefinementAlias("TrafficClass(int tc) { tc >= 0 && tc <= 255 }")
@ExternalRefinementsFor("java.net.DatagramSocket")
@StateSet({"bound", "closed", "connected", "unbound"})
public interface DatagramSocketRefinements {

    @StateRefinement(to = "unbound(this)")
    public void DatagramSocket(DatagramSocketImpl impl);

    @StateRefinement(to = "bound(this)")
    public void DatagramSocket();

    @StateRefinement(to = "bound(this)")
    public void DatagramSocket(SocketAddress bindaddr);

    @StateRefinement(to = "bound(this)")
    public void DatagramSocket(@Refinement("ValidPort(port)") int port);

    @StateRefinement(to = "bound(this)")
    public void DatagramSocket(@Refinement("ValidPort(port)") int port, InetAddress laddr);

    @StateRefinement(from = "unbound(this)", to = "bound(this)")
    public void bind(SocketAddress addr);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "unbound(this)", to = "connected(this)")
    @StateRefinement(from = "bound(this)", to = "connected(this)")
    @StateRefinement(from = "connected(this)")
    public void connect(InetAddress address, @Refinement("ValidPort(port)") int port);

    @StateRefinement(from = "unbound(this)", to = "connected(this)")
    @StateRefinement(from = "bound(this)", to = "connected(this)")
    @StateRefinement(from = "connected(this)")
    public void connect(SocketAddress addr);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)", to = "bound(this)")
    @StateRefinement(from = "closed(this)")
    public void disconnect();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public boolean getBroadcast();

    // callable from all states including Closed (sticky return after close)
    public InetAddress getInetAddress();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public InetAddress getLocalAddress();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @Refinement("_ >= -1")
    public int getLocalPort();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @Refinement("_ > 0")
    public int getReceiveBufferSize();

    // callable from all states including Closed (sticky return after close)
    @Refinement("_ >= -1")
    public int getPort();

    // callable from all states including Closed
    public SocketAddress getRemoteSocketAddress();

    // callable from all states including Closed
    public SocketAddress getLocalSocketAddress();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public boolean getReuseAddress();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @Refinement("_ > 0")
    public int getSendBufferSize();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @Refinement("_ >= 0")
    public int getSoTimeout();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @Refinement("TrafficClass(_)")
    public int getTrafficClass();

    // callable from all states including Closed
    public DatagramChannel getChannel();

    // callable from all states including Closed (sticky true)
    public boolean isBound();

    // callable from all states including Closed (sticky true)
    public boolean isConnected();

    // callable from all states including Closed
    public boolean isClosed();

    @StateRefinement(from = "bound(this)")
    public void joinGroup(SocketAddress mcastaddr, NetworkInterface netIf);

    @StateRefinement(from = "bound(this)")
    public void leaveGroup(SocketAddress mcastaddr, NetworkInterface netIf);

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void receive(DatagramPacket p);

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void send(DatagramPacket p);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void setBroadcast(boolean on);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void setReceiveBufferSize(@Refinement("PositiveSize(size)") int size);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void setReuseAddress(boolean on);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void setSendBufferSize(@Refinement("PositiveSize(size)") int size);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void setSoTimeout(@Refinement("timeout >= 0") int timeout);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void setTrafficClass(@Refinement("TrafficClass(tc)") int tc);

    // callable from all states including Closed
    public Set supportedOptions();

}
