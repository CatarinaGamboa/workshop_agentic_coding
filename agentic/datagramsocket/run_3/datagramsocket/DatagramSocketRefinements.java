package agentic.datagramsocket.run_3.datagramsocket;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.net.DatagramPacket;
import java.net.DatagramSocketImpl;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.nio.channels.DatagramChannel;

@RefinementAlias("ValidPort(int p) { p >= 0 && p <= 65535 }")
@RefinementAlias("PositiveSize(int s) { s > 0 }")
@RefinementAlias("TrafficClass(int tc) { tc >= 0 && tc <= 255 }")
@ExternalRefinementsFor("java.net.DatagramSocket")
@StateSet({"bound", "closed", "connected", "unbound"})
public interface DatagramSocketRefinements<T> {

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
    public void disconnect();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public boolean getBroadcast();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public InetAddress getLocalAddress();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public int getLocalPort();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public T getOption(SocketOption<T> name);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @Refinement("_ > 0")
    public int getReceiveBufferSize();

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

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void joinGroup(SocketAddress mcastaddr, NetworkInterface netIf);

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
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
    public java.net.DatagramSocket setOption(SocketOption<T> name, T value);

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

}
