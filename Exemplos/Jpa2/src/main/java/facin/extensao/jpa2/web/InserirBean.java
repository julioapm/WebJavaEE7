package facin.extensao.jpa2.web;

import facin.extensao.jpa2.entidades.Autor;
import facin.extensao.jpa2.negocio.AutorDAO;
import facin.extensao.jpa2.negocio.DAOAutorException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Julio
 */
@Named
@RequestScoped
public class InserirBean {

    private Autor autor;
    @EJB
    private AutorDAO autorDao;

    @PostConstruct
    public void inicializarDados() {
        autor = new Autor();
        autor.setPrimeiroNome("Nome");
        autor.setUltimoNome("Sobrenome");
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void inserir() {
        if (autor != null) {
            try {
                autorDao.criar(autor.getPrimeiroNome(), autor.getUltimoNome());
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Autor inserido com sucesso", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (DAOAutorException e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha de insercao", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }
}
