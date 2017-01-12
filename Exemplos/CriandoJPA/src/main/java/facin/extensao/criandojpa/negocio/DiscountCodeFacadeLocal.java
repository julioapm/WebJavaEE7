package facin.extensao.criandojpa.negocio;

import facin.extensao.criandojpa.entidades.DiscountCode;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julio
 */
@Local
public interface DiscountCodeFacadeLocal {

    void create(DiscountCode discountCode);

    void edit(DiscountCode discountCode);

    void remove(DiscountCode discountCode);

    DiscountCode find(Object id);

    List<DiscountCode> findAll();

    List<DiscountCode> findRange(int[] range);

    int count();
    
}
