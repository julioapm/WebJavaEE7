package facin.extensao.ejb2.comum;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Julio
 */
@Remote
public interface Catalogo {
    void adicionar(Produto umProduto);
    List<Produto> listarTodos();
}
