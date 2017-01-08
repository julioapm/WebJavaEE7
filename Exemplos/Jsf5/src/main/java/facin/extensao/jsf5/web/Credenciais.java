package facin.extensao.jsf5.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Julio
 */
@Named
@RequestScoped
public class Credenciais {
    @NotNull
    @Size(min=3, max=25)
    private String nomeusuario;
    @NotNull
    @Size(min=5, max=20)
    private String senha;

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
