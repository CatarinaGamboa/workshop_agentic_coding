package agentic.datagramsocket.run_2.datagramsocket;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.net.DatagramSocketImpl;
import java.net.SocketAddress;
import java.net.InetAddress;
import java.nio.channels.DatagramChannel;
import java.net.DatagramPacket;
import java.net.NetworkInterface;
import java.net.DatagramSocketImplFactory;
import java.net.SocketOption;

@RefinementAlias("ValidPort(int p) { p >= 0 && p <= 65535 }")
@RefinementAlias("PositiveSize(int s) { s >= 0 }")
@ExternalRefinementsFor("java.net.DatagramSocket")
@StateSet({"boundconnected", "boundunconnected", "closed", "unboundunconnected"})
public interface DatagramSocketRefinements<T> {

    @StateRefinement(to = "unboundunconnected(this)")
    public void DatagramSocket(DatagramSocketImpl impl);

    @StateRefinement(to = "boundunconnected(this)")
    public void DatagramSocket();

    @StateRefinement(to = "unboundunconnected(this)")
    public void DatagramSocket(SocketAddress bindaddr);

    @StateRefinement(to = "boundunconnected(this)")
    public void DatagramSocket(@Refinement("ValidPort(port)") int port);

    @StateRefinement(to = "boundunconnected(this)")
    public void DatagramSocket(@Refinement("ValidPort(port)") int port, InetAddress laddr);

    @StateRefinement(from = "unboundunconnected(this)", to = "boundunconnected(this)")
    public void bind(SocketAddress addr);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "unboundunconnected(this)", to = "boundconnected(this)")
    @StateRefinement(from = "boundunconnected(this)", to = "boundconnected(this)")
    public void connect(InetAddress address, @Refinement("ValidPort(port)") int port);

    @StateRefinement(from = "unboundunconnected(this)", to = "boundconnected(this)")
    @StateRefinement(from = "boundunconnected(this)", to = "boundconnected(this)")
    public void connect(SocketAddress addr);

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)", to = "boundunconnected(this)")
    public void disconnect();

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public boolean getBroadcast();

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public DatagramChannel getChannel();

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public InetAddress getLocalAddress();

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public int getLocalPort();

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public SocketAddress getLocalSocketAddress();

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    @Refinement("PositiveSize(_)")
    public int getReceiveBufferSize();

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public boolean getReuseAddress();

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    @Refinement("PositiveSize(_)")
    public int getSendBufferSize();

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    @Refinement("_ >= 0")
    public int getSoTimeout();

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    @Refinement("_ >= 0 && _ <= 255")
    public int getTrafficClass();

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void joinGroup(SocketAddress mcastaddr, NetworkInterface netIf);

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void leaveGroup(SocketAddress mcastaddr, NetworkInterface netIf);

    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void receive(DatagramPacket p);

    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void send(DatagramPacket p);

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void setBroadcast(boolean on);

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void setDatagramSocketImplFactory(DatagramSocketImplFactory fac);

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void setReceiveBufferSize(@Refinement("PositiveSize(size)") int size);

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void setReuseAddress(boolean on);

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void setSendBufferSize(@Refinement("PositiveSize(size)") int size);

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void setSoTimeout(@Refinement("timeout >= 0") int timeout);

    @StateRefinement(from = "unboundunconnected(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void setTrafficClass(@Refinement("tc >= 0 && tc <= 255") int tc);

}