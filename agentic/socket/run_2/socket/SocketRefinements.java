package agentic.socket.run_2.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketOption;
import java.util.Set;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("ValidPort(int p) { p >= 0 && p <= 65535 }")
@RefinementAlias("PositiveSize(int s) { s > 0 }")
@ExternalRefinementsFor("java.net.Socket")
@StateSet({"bound", "closed", "connected", "unconnected"})
public interface SocketRefinements<T> {

    @StateRefinement(to = "unconnected(this)")
    public void Socket();

    @StateRefinement(to = "unconnected(this)")
    public void Socket(Proxy proxy);

    @StateRefinement(to = "unconnected(this)")
    public void Socket(SocketImpl impl);

    @StateRefinement(to = "connected(this)")
    public void Socket(String host, @Refinement("ValidPort(port)") int port);

    @StateRefinement(to = "connected(this)")
    public void Socket(InetAddress address, @Refinement("ValidPort(port)") int port);

    @StateRefinement(to = "connected(this)")
    public void Socket(String host, @Refinement("ValidPort(port)") int port, InetAddress localAddr, @Refinement("ValidPort(localPort)") int localPort);

    @StateRefinement(to = "connected(this)")
    public void Socket(InetAddress address, @Refinement("ValidPort(port)") int port, InetAddress localAddr, @Refinement("ValidPort(localPort)") int localPort);

    @StateRefinement(to = "connected(this)")
    public void Socket(String host, @Refinement("ValidPort(port)") int port, boolean stream);

    @StateRefinement(to = "connected(this)")
    public void Socket(InetAddress host, @Refinement("ValidPort(port)") int port, boolean stream);

    @StateRefinement(from = "unconnected(this)", to = "bound(this)")
    public void bind(SocketAddress bindpoint);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "unconnected(this)", to = "connected(this)")
    @StateRefinement(from = "bound(this)", to = "connected(this)")
    public void connect(SocketAddress endpoint);

    @StateRefinement(from = "unconnected(this)", to = "connected(this)")
    @StateRefinement(from = "bound(this)", to = "connected(this)")
    public void connect(SocketAddress endpoint, @Refinement("timeout >= 0") int timeout);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public SocketChannel getChannel();

    @StateRefinement(from = "connected(this)")
    public InputStream getInputStream();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public boolean getKeepAlive();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public InetAddress getLocalAddress();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @Refinement("_ >= -1 && _ <= 65535")
    public int getLocalPort();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public boolean getOOBInline();

    @StateRefinement(from = "connected(this)")
    public OutputStream getOutputStream();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @Refinement("PositiveSize(_)")
    public int getReceiveBufferSize();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public boolean getReuseAddress();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @Refinement("PositiveSize(_)")
    public int getSendBufferSize();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @Refinement("_ >= -1")
    public int getSoLinger();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @Refinement("_ >= 0")
    public int getSoTimeout();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public boolean getTcpNoDelay();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    @Refinement("_ >= 0 && _ <= 255")
    public int getTrafficClass();

    @StateRefinement(from = "connected(this)")
    public void sendUrgentData(int data);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void setKeepAlive(boolean on);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void setOOBInline(boolean on);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void setReceiveBufferSize(@Refinement("PositiveSize(size)") int size);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void setReuseAddress(boolean on);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void setSendBufferSize(@Refinement("PositiveSize(size)") int size);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void setSoLinger(boolean on, @Refinement("linger >= 0") int linger);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void setSoTimeout(@Refinement("timeout >= 0") int timeout);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void setTcpNoDelay(boolean on);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "bound(this)")
    @StateRefinement(from = "connected(this)")
    public void setTrafficClass(@Refinement("tc >= 0 && tc <= 255") int tc);

    @StateRefinement(from = "connected(this)")
    public void shutdownInput();

    @StateRefinement(from = "connected(this)")
    public void shutdownOutput();

}
