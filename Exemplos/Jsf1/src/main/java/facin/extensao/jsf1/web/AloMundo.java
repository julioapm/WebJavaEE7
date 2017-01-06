package facin.extensao.jsf1.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Julio
 */
@Named
@RequestScoped
public class AloMundo {

    private String saudacao;

    public AloMundo() {
        saudacao = "Alô, Mundo!";
    }

    public String getSaudacao() {
        return saudacao;
    }

    public void setSaudacao(String saudacao) {
        this.saudacao = saudacao;
    }
}
