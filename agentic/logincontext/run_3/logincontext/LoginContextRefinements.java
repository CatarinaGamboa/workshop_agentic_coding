package agentic.logincontext.run_3.logincontext;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.Configuration;
import liquidjava.specification.ExternalRefinementsFor;
import liquidjava.specification.StateRefinement;
import liquidjava.specification.StateSet;

@ExternalRefinementsFor("javax.security.auth.login.LoginContext")
@StateSet({"loggedin", "loggedout", "ready"})
public interface LoginContextRefinements {

    @StateRefinement(to = "ready(this)")
    public void LoginContext(String name);

    @StateRefinement(to = "ready(this)")
    public void LoginContext(String name, Subject subject);

    @StateRefinement(to = "ready(this)")
    public void LoginContext(String name, CallbackHandler callbackHandler);

    @StateRefinement(to = "ready(this)")
    public void LoginContext(String name, Subject subject, CallbackHandler callbackHandler);

    @StateRefinement(to = "ready(this)")
    public void LoginContext(String name, Subject subject, CallbackHandler callbackHandler, Configuration config);

    @StateRefinement(from = "ready(this)", to = "loggedin(this)")
    public void login();

    @StateRefinement(from = "loggedin(this)", to = "loggedout(this)")
    public void logout();

    public Subject getSubject();

}