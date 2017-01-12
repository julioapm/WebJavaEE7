package facin.extensao.criandojpa.negocio;

import facin.extensao.criandojpa.entidades.DiscountCode;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Julio
 */
@Stateless
public class DiscountCodeFacade extends AbstractFacade<DiscountCode> implements DiscountCodeFacadeLocal {

    @PersistenceContext(unitName = "criandojpaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiscountCodeFacade() {
        super(DiscountCode.class);
    }
    
}
