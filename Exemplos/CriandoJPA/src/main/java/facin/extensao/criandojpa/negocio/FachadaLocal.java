package facin.extensao.criandojpa.negocio;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julio
 */
@Local
public interface FachadaLocal {

    List<CustomerDTO> getCustomers() throws FachadaException;
}
