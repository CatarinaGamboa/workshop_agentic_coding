package agentic.kerberosticket.run_1.kerberosticket;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

import java.net.InetAddress;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.security.auth.kerberos.KerberosPrincipal;

@ExternalRefinementsFor("javax.security.auth.kerberos.KerberosTicket")
@StateSet({"active", "destroyed"})
public interface KerberosTicketRefinements {

    @StateRefinement(to = "active(this)")
    public void KerberosTicket(byte[] asn1Encoding, KerberosPrincipal client, KerberosPrincipal server, byte[] sessionKey, int keyType, boolean[] flags, Date authTime, Date startTime, Date endTime, Date renewTill, InetAddress[] clientAddresses);

    @StateRefinement(from = "!destroyed(this)", to = "destroyed(this)")
    public void destroy();

    @StateRefinement(from = "active(this)")
    public byte[] getEncoded();

    @StateRefinement(from = "active(this)")
    public SecretKey getSessionKey();

    @StateRefinement(from = "active(this)")
    public int getSessionKeyType();

    @StateRefinement(from = "active(this)")
    public void refresh();

}
