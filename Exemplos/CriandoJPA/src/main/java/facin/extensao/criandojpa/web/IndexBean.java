package facin.extensao.criandojpa.web;

import facin.extensao.criandojpa.negocio.CustomerDTO;
import facin.extensao.criandojpa.negocio.FachadaLocal;
import java.util.List;
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
    private FachadaLocal fachadaEjb;
    
    public List<CustomerDTO> getCustomers() {
        return fachadaEjb.getCustomers();
    }

}
