package facin.extensao.ejb1.negocio;

import javax.ejb.Stateless;

/**
 *
 * @author Julio
 */
@Stateless
public class AloMundoBean {

    private String saudacao;

    public AloMundoBean() {
        saudacao = "Alô Mundo!";
    }

    public String getSaudacao() {
        return saudacao;
    }
}
