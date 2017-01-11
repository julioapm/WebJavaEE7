package facin.extensao.criandoejb.negocio;

import java.util.Random;
import javax.ejb.Stateless;

/**
 *
 * @author Julio
 */
@Stateless
public class Sorteador implements SorteadorLocal {

    @Override
    public int getNumero() {
        Random gerador = new Random();
        return gerador.nextInt(10);

    }

}
