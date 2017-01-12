package facin.extensao.webservice1cliente;

import proxy.AloMundo;
import proxy.AloMundoService;

/**
 *
 * @author Julio
 */
public class Cliente {

    public static void main(String[] args) {
        try {
            AloMundoService service = new AloMundoService();
            AloMundo port = service.getAloMundoPort();
            String resultado = port.getSaudacao();
            System.out.println(resultado);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
        }

    }
    
}
