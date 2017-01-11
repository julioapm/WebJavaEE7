package facin.extensao.ejb2.negocio;

import facin.extensao.ejb2.comum.Catalogo;
import facin.extensao.ejb2.comum.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

/**
 *
 * @author Julio
 */
@Stateful
public class CatalogoBean implements Catalogo {

    private List<Produto> produtos;

    public CatalogoBean() {
        produtos = new ArrayList<>();
    }

    @PostConstruct
    public void inicializar() {
        produtos.add(new Produto(1, "Apontador", 1.95));
        produtos.add(new Produto(2, "Caneta", 2.5));
        produtos.add(new Produto(3, "Borracha", 0.85));
    }

    @Override
    public void adicionar(Produto umProduto) {
        produtos.add(umProduto);
    }

    @Override
    public List<Produto> listarTodos() {
        return produtos;
    }

}
