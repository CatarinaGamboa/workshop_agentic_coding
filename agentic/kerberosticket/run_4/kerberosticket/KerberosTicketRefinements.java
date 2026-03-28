package agentic.kerberosticket.run_4.kerberosticket;

import java.net.InetAddress;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.security.auth.kerberos.KerberosPrincipal;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("kerberosticket.KerberosTicket")
@StateSet({"active", "destroyed"})
public interface KerberosTicketRefinements {

    @StateRefinement(to = "active(this)")
    public void KerberosTicket(byte[] asn1Encoding, KerberosPrincipal client, KerberosPrincipal server, byte[] sessionKey, int keyType, boolean[] flags, Date authTime, Date startTime, Date endTime, Date renewTill, InetAddress[] clientAddresses);

    @StateRefinement(to = "destroyed(this)")
    public void destroy();

    @StateRefinement(from = "active(this)")
    public Date getAuthTime();

    @StateRefinement(from = "active(this)")
    public KerberosPrincipal getClient();

    @StateRefinement(from = "active(this)")
    public InetAddress[] getClientAddresses();

    @StateRefinement(from = "active(this)")
    public byte[] getEncoded();

    @StateRefinement(from = "active(this)")
    public Date getEndTime();

    @StateRefinement(from = "active(this)")
    public boolean[] getFlags();

    @StateRefinement(from = "active(this)")
    public Date getRenewTill();

    @StateRefinement(from = "active(this)")
    public KerberosPrincipal getServer();

    @StateRefinement(from = "active(this)")
    public SecretKey getSessionKey();

    @StateRefinement(from = "active(this)")
    public int getSessionKeyType();

    @StateRefinement(from = "active(this)")
    public Date getStartTime();

    @StateRefinement(from = "active(this)")
    public boolean isCurrent();

    @StateRefinement(from = "active(this)")
    public boolean isForwardable();

    @StateRefinement(from = "active(this)")
    public boolean isForwarded();

    @StateRefinement(from = "active(this)")
    public boolean isInitial();

    @StateRefinement(from = "active(this)")
    public boolean isPostdated();

    @StateRefinement(from = "active(this)")
    public boolean isProxiable();

    @StateRefinement(from = "active(this)")
    public boolean isProxy();

    @StateRefinement(from = "active(this)")
    public boolean isRenewable();

    @StateRefinement(from = "active(this)")
    public void refresh();

    public boolean isDestroyed();

    public String toString();

    public int hashCode();

    public boolean equals(Object other);

}
