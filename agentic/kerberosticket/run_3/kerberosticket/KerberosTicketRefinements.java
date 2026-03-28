package agentic.kerberosticket.run_3.kerberosticket;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import javax.security.auth.kerberos.KerberosPrincipal;
import javax.crypto.SecretKey;
import java.net.InetAddress;
import java.util.Date;

@ExternalRefinementsFor("javax.security.auth.kerberos.KerberosTicket")
@StateSet({"destroyed", "valid"})
public interface KerberosTicketRefinements {

    @StateRefinement(to = "valid(this)")
    public void KerberosTicket(byte[] asn1Encoding, KerberosPrincipal client, KerberosPrincipal server, byte[] sessionKey, int keyType, boolean[] flags, Date authTime, Date startTime, Date endTime, Date renewTill, InetAddress[] clientAddresses);

    @StateRefinement(to = "destroyed(this)")
    public void destroy();

    @StateRefinement(from = "valid(this)")
    public SecretKey getSessionKey();

    @StateRefinement(from = "valid(this)")
    @Refinement("_ >= 0")
    public int getSessionKeyType();

    @StateRefinement(from = "valid(this)")
    public byte[] getEncoded();

    @StateRefinement(from = "valid(this)")
    public void refresh();

    public KerberosPrincipal getClient();

    public KerberosPrincipal getServer();

    public boolean isForwardable();

    public boolean isForwarded();

    public boolean isProxiable();

    public boolean isProxy();

    public boolean isPostdated();

    public boolean isRenewable();

    public boolean isInitial();

    public boolean[] getFlags();

    public Date getAuthTime();

    public Date getStartTime();

    public Date getEndTime();

    public Date getRenewTill();

    public InetAddress[] getClientAddresses();

    public boolean isCurrent();

    public boolean isDestroyed();

    public String toString();

    @Refinement("true")
    public int hashCode();

    public boolean equals(Object other);

}
