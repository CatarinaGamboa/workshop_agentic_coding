package agentic.datagramsocket.run_1.datagramsocket;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.net.DatagramSocketImpl;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.net.DatagramPacket;
import java.nio.channels.DatagramChannel;

@RefinementAlias("ValidPort(int p) { p >= 0 && p <= 65535 }")
@RefinementAlias("BufferSize(int s) { s > 0 }")
@ExternalRefinementsFor("java.net.DatagramSocket")
@StateSet({"boundconnected", "boundunconnected", "closed", "maybeunbound"})
public interface DatagramSocketRefinements {

    @StateRefinement(to = "maybeunbound(this)")
    public void DatagramSocket(DatagramSocketImpl impl);

    @StateRefinement(to = "boundunconnected(this)")
    public void DatagramSocket();

    @StateRefinement(to = "boundunconnected(this)")
    public void DatagramSocket(@Refinement("ValidPort(port)") int port);

    @StateRefinement(to = "boundunconnected(this)")
    public void DatagramSocket(@Refinement("ValidPort(port)") int port, InetAddress laddr);

    @StateRefinement(to = "maybeunbound(this)")
    public void DatagramSocket(SocketAddress bindaddr);

    @StateRefinement(from = "maybeunbound(this)", to = "boundunconnected(this)")
    public void bind(SocketAddress addr);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "maybeunbound(this)", to = "boundconnected(this)")
    @StateRefinement(from = "boundunconnected(this)", to = "boundconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    @StateRefinement(from = "closed(this)")
    public void connect(InetAddress address, @Refinement("ValidPort(port)") int port);

    @StateRefinement(from = "maybeunbound(this)", to = "boundconnected(this)")
    @StateRefinement(from = "boundunconnected(this)", to = "boundconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    @StateRefinement(from = "closed(this)")
    public void connect(SocketAddress addr);

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)", to = "boundunconnected(this)")
    @StateRefinement(from = "closed(this)")
    public void disconnect();

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public boolean getBroadcast();

    public boolean isBound();

    public boolean isConnected();

    public boolean isClosed();

    public InetAddress getInetAddress();

    @Refinement("_ >= -1 && _ <= 65535")
    public int getPort();

    public SocketAddress getRemoteSocketAddress();

    public DatagramChannel getChannel();

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public InetAddress getLocalAddress();

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    @Refinement("_ >= -1 && _ <= 65535")
    public int getLocalPort();

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public SocketAddress getLocalSocketAddress();

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    @Refinement("_ > 0")
    public int getReceiveBufferSize();

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public boolean getReuseAddress();

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    @Refinement("_ > 0")
    public int getSendBufferSize();

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    @Refinement("_ >= 0")
    public int getSoTimeout();

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    @Refinement("_ >= 0 && _ <= 255")
    public int getTrafficClass();

    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void joinGroup(SocketAddress mcastaddr, NetworkInterface netIf);

    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void leaveGroup(SocketAddress mcastaddr, NetworkInterface netIf);

    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void receive(DatagramPacket p);

    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void send(DatagramPacket p);

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void setBroadcast(boolean on);

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void setReceiveBufferSize(@Refinement("BufferSize(size)") int size);

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void setReuseAddress(boolean on);

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void setSendBufferSize(@Refinement("BufferSize(size)") int size);

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void setSoTimeout(@Refinement("timeout >= 0") int timeout);

    @StateRefinement(from = "maybeunbound(this)")
    @StateRefinement(from = "boundunconnected(this)")
    @StateRefinement(from = "boundconnected(this)")
    public void setTrafficClass(@Refinement("tc >= 0 && tc <= 255") int tc);

}