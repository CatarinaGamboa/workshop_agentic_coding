package agentic.logincontext.run_5.logincontext;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.Configuration;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("javax.security.auth.login.LoginContext")
@StateSet({"authenticated", "created", "loggedout"})
public interface LoginContextRefinements {

    @StateRefinement(to = "created(this)")
    public void LoginContext(String name);

    @StateRefinement(to = "created(this)")
    public void LoginContext(String name, Subject subject);

    @StateRefinement(to = "created(this)")
    public void LoginContext(String name, CallbackHandler callbackHandler);

    @StateRefinement(to = "created(this)")
    public void LoginContext(String name, Subject subject, CallbackHandler callbackHandler);

    @StateRefinement(to = "created(this)")
    public void LoginContext(String name, Subject subject, CallbackHandler callbackHandler, Configuration config);

    @StateRefinement(from = "created(this)", to = "authenticated(this)")
    public void login();

    @StateRefinement(from = "authenticated(this)", to = "loggedout(this)")
    public void logout();

    public Subject getSubject();

}