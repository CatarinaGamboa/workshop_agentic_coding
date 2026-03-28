package agentic.datagramsocket.run_5.datagramsocket;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.DatagramSocketImpl;
import java.net.DatagramPacket;
import java.nio.channels.DatagramChannel;
import java.net.NetworkInterface;
import java.net.SocketOption;

@RefinementAlias("ValidPort(int p) { p >= 0 && p <= 65535 }")
@RefinementAlias("PositiveSize(int s) { s > 0 }")
@ExternalRefinementsFor("java.net.DatagramSocket")
@StateSet({"bound", "closed", "connected", "unbound", "maybeunbound"})
public interface DatagramSocketRefinements {

    @StateRefinement(to = "bound(this)")
    public void DatagramSocket();

    @StateRefinement(to = "bound(this)")
    public void DatagramSocket(@Refinement("ValidPort(port)") int port);

    @StateRefinement(to = "bound(this)")
    public void DatagramSocket(@Refinement("ValidPort(port)") int port, InetAddress laddr);

    @StateRefinement(to = "unbound(this)")
    public void DatagramSocket(DatagramSocketImpl impl);

    @StateRefinement(to = "maybeunbound(this)")
    public void DatagramSocket(SocketAddress bindaddr);

    @StateRefinement(from = "unbound(this)", to = "bound(this)")
    @StateRefinement(from = "maybeunbound(this)", to = "bound(this)")
    public void bind(SocketAddress addr);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "unbound(this)", to = "connected(this)")
    @StateRefinement(from = "maybeunbound(this)", to = "connected(this)")
    @StateRefinement(from = "bound(this)", to = "connected(this)")
    @StateRefinement(from = "connected(this)")
    public void connect(InetAddress address, @Refinement("ValidPort(port)") int port);

    @StateRefinement(from = "unbound(this)", to = "connected(this)")
    @StateRefinement(from = "maybeunbound(this)", to = "connected(this)")
    @StateRefinement(from = "bound(this)", to = "connected(this)")
    @StateRefinement(from = "connected(this)")
    public void connect(SocketAddress addr);

    @StateRefinement(from = "connected(this)", to = "bound(this)")
    @StateRefinement(from = "bound(this)")
    public void disconnect();

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "maybeunbound(this)")
    public boolean getBroadcast();

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "maybeunbound(this)")
    public InetAddress getLocalAddress();

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "maybeunbound(this)")
    public int getLocalPort();

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "maybeunbound(this)")
    public SocketAddress getLocalSocketAddress();

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "maybeunbound(this)")
    @Refinement("_ > 0")
    public int getReceiveBufferSize();

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "maybeunbound(this)")
    public boolean getReuseAddress();

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "maybeunbound(this)")
    @Refinement("_ > 0")
    public int getSendBufferSize();

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "maybeunbound(this)")
    @Refinement("_ >= 0")
    public int getSoTimeout();

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "maybeunbound(this)")
    @Refinement("_ >= 0 && _ <= 255")
    public int getTrafficClass();

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "maybeunbound(this)")
    public void joinGroup(SocketAddress mcastaddr, NetworkInterface netIf);

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "maybeunbound(this)")
    public void leaveGroup(SocketAddress mcastaddr, NetworkInterface netIf);

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "maybeunbound(this)")
    public void receive(DatagramPacket p);

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "maybeunbound(this)")
    public void send(DatagramPacket p);

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "maybeunbound(this)")
    public void setBroadcast(boolean on);

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "maybeunbound(this)")
    public void setReceiveBufferSize(@Refinement("PositiveSize(size)") int size);

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "maybeunbound(this)")
    public void setReuseAddress(boolean on);

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "maybeunbound(this)")
    public void setSendBufferSize(@Refinement("PositiveSize(size)") int size);

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "maybeunbound(this)")
    public void setSoTimeout(@Refinement("timeout >= 0") int timeout);

    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "maybeunbound(this)")
    public void setTrafficClass(@Refinement("tc >= 0 && tc <= 255") int tc);

}
