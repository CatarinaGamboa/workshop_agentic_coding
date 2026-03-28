package agentic.kerberoskey.run_2.kerberoskey;

import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.Refinement;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;
import javax.security.auth.kerberos.KerberosPrincipal;

@ExternalRefinementsFor("javax.security.auth.kerberos.KerberosKey")
@StateSet({"active", "destroyed"})
public interface KerberosKeyRefinements {

    @StateRefinement(to = "active(this)")
    public void KerberosKey(KerberosPrincipal principal, byte[] keyBytes, int keyType, @Refinement("versionNum >= 0") int versionNum);

    @StateRefinement(to = "active(this)")
    public void KerberosKey(KerberosPrincipal principal, char[] password, String algorithm);

    @StateRefinement(from = "active(this)", to = "destroyed(this)")
    @StateRefinement(from = "destroyed(this)", to = "destroyed(this)")
    public void destroy();

    @StateRefinement(from = "active(this)")
    public String getAlgorithm();

    @StateRefinement(from = "active(this)")
    public byte[] getEncoded();

    @StateRefinement(from = "active(this)")
    public String getFormat();

    @StateRefinement(from = "active(this)")
    public int getKeyType();

    @StateRefinement(from = "active(this)")
    public KerberosPrincipal getPrincipal();

    @StateRefinement(from = "active(this)")
    public int getVersionNumber();

    public boolean isDestroyed();

    public String toString();

    public int hashCode();

    public boolean equals(Object other);

}
