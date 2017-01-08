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
public class AloMundo implements Serializable{
    private String nome;
    private String saudacao;

    public String getSaudacao() {
        return saudacao;
    }

    public void setSaudacao(String saudacao) {
        this.saudacao = saudacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String acaoEnviar() {
        saudacao = "Alô " + nome + "!";
        return "saudacao";
    }
}
