package agentic.kerberosticket.run_2.kerberosticket;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.RefinementAlias;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

import java.net.InetAddress;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.security.auth.kerberos.KerberosPrincipal;

@ExternalRefinementsFor("javax.security.auth.kerberos.KerberosTicket")
@StateSet({"destroyed", "valid"})
public interface KerberosTicketRefinements {

    // Constructor: sets object into Valid state
    @StateRefinement(to = "valid(this)")
    public void KerberosTicket(byte[] asn1Encoding, KerberosPrincipal client, KerberosPrincipal server, byte[] sessionKey, int keyType, boolean[] flags, Date authTime, Date startTime, Date endTime, Date renewTill, InetAddress[] clientAddresses);

    // destroy() is callable from any state and always results in Destroyed
    @StateRefinement(to = "destroyed(this)")
    public void destroy();

    // Methods callable from both Valid and Destroyed (no state change, no from constraint)
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

    public int hashCode();

    public boolean equals(Object other);

    // Methods only callable from Valid state (throw IllegalStateException if destroyed)
    @StateRefinement(from = "valid(this)")
    public SecretKey getSessionKey();

    @StateRefinement(from = "valid(this)")
    public int getSessionKeyType();

    @StateRefinement(from = "valid(this)")
    public byte[] getEncoded();

    @StateRefinement(from = "valid(this)")
    public void refresh();

}
