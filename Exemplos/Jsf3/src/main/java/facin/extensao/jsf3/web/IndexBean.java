package facin.extensao.jsf3.web;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Julio
 */
@Named
@RequestScoped
public class IndexBean implements Serializable{
    private String nome;
    @Inject
    private SaudacaoBean saudacaoBean;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String acaoEnviar() {
        saudacaoBean.setSaudacao("Alô " + nome + "!");
        return "saudacao";
    }
}
