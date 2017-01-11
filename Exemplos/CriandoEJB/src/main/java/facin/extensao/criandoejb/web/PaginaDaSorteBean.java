package facin.extensao.criandoejb.web;

import facin.extensao.criandoejb.negocio.SorteadorLocal;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Julio
 */
@Named
@RequestScoped
public class PaginaDaSorteBean {

    @EJB(name = "sorteadorBean")
    private SorteadorLocal sorteadorBean;

    public int getNumero() {
        return sorteadorBean.getNumero();
    }

}
