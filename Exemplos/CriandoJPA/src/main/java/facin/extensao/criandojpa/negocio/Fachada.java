package facin.extensao.criandojpa.negocio;

import facin.extensao.criandojpa.entidades.Customer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Julio
 */
@Stateless
public class Fachada implements FachadaLocal {

    @EJB
    private DiscountCodeFacadeLocal discountEjb;
    @EJB
    private CustomerFacadeLocal cutomerEjb;

    @Override
    public List<CustomerDTO> getCustomers() throws FachadaException {
        try {
            List<Customer> customers = cutomerEjb.findAll();
            return copiarParaDTO(customers);
        } catch (Exception e) {
            throw new FachadaException("Erro ao buscar", e);
        }
    }

    private List<CustomerDTO> copiarParaDTO(List<Customer> todos) {
        List<CustomerDTO> dtos = new ArrayList<>(todos.size());
        for (Customer c : todos) {
            Integer id = c.getCustomerId();
            String name = c.getName();
            String address = c.getAddressline1() + " " + c.getAddressline2() + " " + c.getCity() + " " + c.getState();
            String phone = c.getPhone();
            String fax = c.getFax();
            String email = c.getEmail();
            Integer limit = c.getCreditLimit();
            BigDecimal discount = new BigDecimal(c.getDiscountCode().getRate());
            CustomerDTO dto = new CustomerDTO(id, name, address, phone, fax, email, limit, discount);
            dtos.add(dto);
        }
        return dtos;
    }
}
