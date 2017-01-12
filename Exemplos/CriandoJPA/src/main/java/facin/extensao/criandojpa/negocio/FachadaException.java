package facin.extensao.criandojpa.negocio;

import javax.ejb.EJBException;

/**
 *
 * @author Julio
 */
public class FachadaException extends EJBException {

    public FachadaException() {
    }

    public FachadaException(String message) {
        super(message);
    }

    public FachadaException(String message, Exception ex) {
        super(message, ex);
    }
}
