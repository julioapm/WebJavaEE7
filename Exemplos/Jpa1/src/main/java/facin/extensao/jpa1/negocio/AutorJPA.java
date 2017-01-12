package facin.extensao.jpa1.negocio;

import facin.extensao.jpa1.entidades.Autor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AutorJPA implements AutorDAO {

    private EntityManager em;

    public AutorJPA(EntityManager e) {
        em = e;
    }

    @Override
    public Autor criar(String primeiroNome, String ultimoNome) throws DAOAutorException {
        Autor a = new Autor();
        a.setPrimeiroNome(primeiroNome);
        a.setUltimoNome(ultimoNome);
        try {
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            return a;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new DAOAutorException("Erro na criação", e);
        }
    }

    @Override
    public List<Autor> buscar() throws DAOAutorException {
        try {
            TypedQuery<Autor> c = em.createQuery(
                    "select a from Autor a", Autor.class);
            return c.getResultList();
        } catch (Exception e) {
            throw new DAOAutorException("Erro na busca", e);
        }
    }

    @Override
    public List<Autor> buscarPorUltimoNome(String nome) throws DAOAutorException {
        try {
            TypedQuery<Autor> c = (TypedQuery<Autor>) em.createNamedQuery("autoresPorUltimoNome");
            c.setParameter("ultimoNome", nome);
            return c.getResultList();
        } catch (Exception e) {
            throw new DAOAutorException("Erro na busca", e);
        }
    }

    @Override
    public void alterar(Autor autor) throws DAOAutorException {
        try {
            em.getTransaction().begin();
            em.merge(autor); //para garantir que a entidade esta no contexto do JPA
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new DAOAutorException("Erro na alteração", e);
        }
    }

    @Override
    public Autor buscar(int codigo) throws DAOAutorException {
        try {
            return em.find(Autor.class, codigo);
        } catch (Exception e) {
            throw new DAOAutorException("Erro na busca", e);
        }
    }
}
