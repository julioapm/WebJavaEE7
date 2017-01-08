package facin.extensao.jsf5.web;

import facin.extensao.jsf5.cdi.LoggedIn;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Julio
 */
@Named
@SessionScoped
public class Login implements Serializable{
    @Inject
    private Credenciais credenciais;
    private String usuario;
    
    public void login(){
        if(credenciais.getSenha().equals("senha")){
            usuario = credenciais.getNomeusuario();
        }
    }
    
    public void logout(){
        usuario = null;
    }
    
    public boolean isLoggedIn() {
        return usuario != null;
    }
    
    @Produces @LoggedIn
    public String getUsuarioAtual(){
        return usuario;
    }
}
