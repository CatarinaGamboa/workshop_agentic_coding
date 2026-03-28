package agentic.serversocket.run_3.serversocket;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import java.net.InetAddress;
import java.nio.channels.ServerSocketChannel;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.net.SocketOption;
import java.util.Set;

@RefinementAlias("ValidPort(int p) { p >= 0 && p <= 65535 }")
@RefinementAlias("PositiveSize(int s) { s > 0 }")
@ExternalRefinementsFor("java.net.ServerSocket")
@StateSet({"bound", "closed", "unbound"})
public interface ServerSocketRefinements {

    @StateRefinement(to = "unbound(this)")
    public void ServerSocket();

    @StateRefinement(to = "unbound(this)")
    public void ServerSocket(SocketImpl impl);

    @StateRefinement(to = "bound(this)")
    public void ServerSocket(@Refinement("ValidPort(port)") int port);

    @StateRefinement(to = "bound(this)")
    public void ServerSocket(
        @Refinement("ValidPort(port)") int port,
        @Refinement("backlog > 0") int backlog
    );

    @StateRefinement(to = "bound(this)")
    public void ServerSocket(
        @Refinement("ValidPort(port)") int port,
        @Refinement("backlog > 0") int backlog,
        InetAddress bindAddr
    );

    @StateRefinement(from = "bound(this)")
    public Socket accept();

    @StateRefinement(from = "unbound(this)", to = "bound(this)")
    public void bind(SocketAddress endpoint);

    @StateRefinement(from = "unbound(this)", to = "bound(this)")
    public void bind(SocketAddress endpoint, @Refinement("backlog > 0") int backlog);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    @Refinement("_ > 0")
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
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public void setReceiveBufferSize(@Refinement("PositiveSize(size)") int size);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public void setReuseAddress(boolean on);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public void setSoTimeout(@Refinement("timeout >= 0") int timeout);

}
