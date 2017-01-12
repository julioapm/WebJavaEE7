package facin.extensao.criandojpa.negocio;

import facin.extensao.criandojpa.entidades.Customer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julio
 */
@Local
public interface CustomerFacadeLocal {

    void create(Customer customer);

    void edit(Customer customer);

    void remove(Customer customer);

    Customer find(Object id);

    List<Customer> findAll();

    List<Customer> findRange(int[] range);

    int count();
    
}
