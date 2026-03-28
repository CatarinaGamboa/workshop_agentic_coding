package agentic.socket.run_5.socket;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.net.*;
import java.io.*;

@RefinementAlias("ValidPort(int p) { p >= 0 && p <= 65535 }")
@RefinementAlias("PositiveSize(int s) { s > 0 }")
@ExternalRefinementsFor("java.net.Socket")
@StateSet({"bothshutdown", "closed", "connected", "inputshutdown", "outputshutdown", "unconnected"})
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

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public void bind(SocketAddress bindpoint);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "unconnected(this)", to = "connected(this)")
    public void connect(SocketAddress endpoint);

    @StateRefinement(from = "unconnected(this)", to = "connected(this)")
    public void connect(SocketAddress endpoint, @Refinement("timeout >= 0") int timeout);

    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "outputshutdown(this)")
    public InputStream getInputStream();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public boolean getKeepAlive();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public boolean getOOBInline();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public T getOption(SocketOption name);

    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    public OutputStream getOutputStream();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public @Refinement("PositiveSize(_)") int getReceiveBufferSize();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public boolean getReuseAddress();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public @Refinement("PositiveSize(_)") int getSendBufferSize();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public int getSoLinger();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public @Refinement("_ >= 0") int getSoTimeout();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public boolean getTcpNoDelay();

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public int getTrafficClass();

    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public void sendUrgentData(int data);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public void setKeepAlive(boolean on);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public void setOOBInline(boolean on);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public java.net.Socket setOption(SocketOption name, T value);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public void setReceiveBufferSize(@Refinement("PositiveSize(size)") int size);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public void setReuseAddress(boolean on);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public void setSendBufferSize(@Refinement("PositiveSize(size)") int size);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public void setSoLinger(boolean on, @Refinement("linger >= 0") int linger);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public void setSoTimeout(@Refinement("timeout >= 0") int timeout);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public void setTcpNoDelay(boolean on);

    @StateRefinement(from = "unconnected(this)")
    @StateRefinement(from = "connected(this)")
    @StateRefinement(from = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)")
    @StateRefinement(from = "bothshutdown(this)")
    public void setTrafficClass(@Refinement("tc >= 0 && tc <= 255") int tc);

    @StateRefinement(from = "connected(this)", to = "inputshutdown(this)")
    @StateRefinement(from = "outputshutdown(this)", to = "bothshutdown(this)")
    public void shutdownInput();

    @StateRefinement(from = "connected(this)", to = "outputshutdown(this)")
    @StateRefinement(from = "inputshutdown(this)", to = "bothshutdown(this)")
    public void shutdownOutput();

}
