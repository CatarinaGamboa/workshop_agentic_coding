package agentic.serversocket.run_5.serversocket;

import java.net.InetAddress;
import java.net.ServerSocketChannel;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.net.SocketOption;
import java.net.Socket;
import java.util.Set;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@RefinementAlias("ValidPort(int p) { p >= 0 && p <= 65535 }")
@ExternalRefinementsFor("java.net.ServerSocket")
@StateSet({"bound", "closed", "unbound"})
public interface ServerSocketRefinements<T> {

    @StateRefinement(to = "unbound(this)")
    public void ServerSocket();

    @StateRefinement(to = "unbound(this)")
    public void ServerSocket(SocketImpl impl);

    @StateRefinement(to = "bound(this)")
    public void ServerSocket(@Refinement("ValidPort(port)") int port);

    @StateRefinement(to = "bound(this)")
    public void ServerSocket(@Refinement("ValidPort(port)") int port, int backlog);

    @StateRefinement(to = "bound(this)")
    public void ServerSocket(@Refinement("ValidPort(port)") int port, int backlog, InetAddress bindAddr);

    @StateRefinement(from = "bound(this)")
    public Socket accept();

    @StateRefinement(from = "unbound(this)", to = "bound(this)")
    public void bind(SocketAddress endpoint);

    @StateRefinement(from = "unbound(this)", to = "bound(this)")
    public void bind(SocketAddress endpoint, int backlog);

    @StateRefinement(to = "closed(this)")
    public void close();

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public T getOption(SocketOption name);

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
    public java.net.ServerSocket setOption(SocketOption name, T value);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public void setPerformancePreferences(int connectionTime, int latency, int bandwidth);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public void setReceiveBufferSize(@Refinement("size > 0") int size);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public void setReuseAddress(boolean on);

    @StateRefinement(from = "unbound(this)")
    @StateRefinement(from = "bound(this)")
    public void setSoTimeout(@Refinement("timeout >= 0") int timeout);

}
