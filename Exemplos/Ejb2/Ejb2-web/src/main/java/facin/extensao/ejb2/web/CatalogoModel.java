package facin.extensao.ejb2.web;

import facin.extensao.ejb2.comum.Catalogo;
import facin.extensao.ejb2.comum.Produto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Julio
 */
@Named
@SessionScoped
public class CatalogoModel implements Serializable {

    private Produto produtoAtual;
    private List<Produto> produtosListagem;
    @EJB
    private Catalogo catalogoEjb;

    public CatalogoModel() {
        produtoAtual = new Produto();
    }

    public Produto getProdutoAtual() {
        return produtoAtual;
    }

    public void setProdutoAtual(Produto produtoAtual) {
        this.produtoAtual = produtoAtual;
    }

    public List<Produto> getProdutosListagem() {
        if (produtosListagem == null) {
            produtosListagem = catalogoEjb.listarTodos();
        }
        return produtosListagem;
    }

    public String salvar() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto alterado com sucesso!", "Produto: " + produtoAtual.getCodigo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "index";
    }

}
