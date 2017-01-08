package facin.extensao.jsf3.web;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Julio
 */
@Named
@SessionScoped
public class SaudacaoBean implements Serializable {

    private String saudacao;

    public String getSaudacao() {
        return saudacao;
    }

    public void setSaudacao(String saudacao) {
        this.saudacao = saudacao;
    }

}
