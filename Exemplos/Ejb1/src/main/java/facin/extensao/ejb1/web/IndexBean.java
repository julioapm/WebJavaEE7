package facin.extensao.ejb1.web;

import facin.extensao.ejb1.negocio.AloMundoBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Julio
 */
@Named
@RequestScoped
public class IndexBean {
    @EJB
    private AloMundoBean ejb;
    
    public String getAlo() {
        return ejb.getSaudacao();
    }
}
