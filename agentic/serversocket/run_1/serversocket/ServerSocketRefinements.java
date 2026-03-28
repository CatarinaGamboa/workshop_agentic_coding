package agentic.serversocket.run_1.serversocket;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.net.SocketImplFactory;
import java.net.Socket;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;
import java.net.SocketOption;
import java.util.Set;

@RefinementAlias("ValidPort(int p) { p >= 0 && p <= 65535 }")
@RefinementAlias("Positive(int x) { x > 0 }")
@ExternalRefinementsFor("java.net.ServerSocket")
@StateSet({"bound", "closed", "unbound"})
public interface ServerSocketRefinements<T> {

    @StateRefinement(to = "unbound(this)")
    public void ServerSocket(SocketImpl impl);

    @StateRefinement(to = "unbound(this)")
    public void ServerSocket();

    @StateRefinement(to = "bound(this)")
    public void ServerSocket(@Refinement("ValidPort(port)") int port);

    @StateRefinement(to = "bound(this)")
    public void ServerSocket(
        @Refinement("ValidPort(port)") int port,
        @Refinement("Positive(backlog)") int backlog
    );

    @StateRefinement(to = "bound(this)")
    public void ServerSocket(
        @Refinement("ValidPort(port)") int port,
        @Refinement("Positive(backlog)") int backlog,
        InetAddress bindAddr
    );

    @StateRefinement(from = "bound(this)")
    public Socket accept();

    @StateRefinement(from = "unbound(this)", to = "bound(this)")
    public void bind(SocketAddress endpoint);

    @StateRefinement(from = "unbound(this)", to = "bound(this)")
    public void bind(SocketAddress endpoint, @Refinement("Positive(backlog)") int backlog);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public T getOption(SocketOption<T> option);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @Refinement("Positive(_)")
    public int getReceiveBufferSize();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public boolean getReuseAddress();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @Refinement("_ >= 0")
    public int getSoTimeout();

    @StateRefinement(from = "bound(this)")
    public void implAccept(Socket s);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public ServerSocket setOption(SocketOption<T> name, T value);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public void setReceiveBufferSize(@Refinement("Positive(size)") int size);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public void setReuseAddress(boolean on);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public void setSoTimeout(@Refinement("timeout >= 0") int timeout);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public void setSocketFactory(SocketImplFactory fac);

    public InetAddress getInetAddress();

    @Refinement("_ >= -1")
    public int getLocalPort();

    public SocketAddress getLocalSocketAddress();

    public ServerSocketChannel getChannel();

    public boolean isBound();

    public boolean isClosed();

    public String toString();

    public Set<SocketOption<?>> supportedOptions();

}
