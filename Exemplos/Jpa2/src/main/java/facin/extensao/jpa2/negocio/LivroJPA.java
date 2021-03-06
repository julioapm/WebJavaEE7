package facin.extensao.jpa2.negocio;

import facin.extensao.jpa2.entidades.Autor;
import facin.extensao.jpa2.entidades.Editora;
import facin.extensao.jpa2.entidades.Editora_;
import facin.extensao.jpa2.entidades.Livro;
import facin.extensao.jpa2.entidades.Livro_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class LivroJPA implements LivroDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Livro criar(String titulo, int ano, int codigoEditora, Autor[] autores) throws DAOLivroException {
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setAno(ano);
        Editora editora = em.find(Editora.class, codigoEditora);
        //Editora editora = em.getReference(Editora.class, codigoEditora);
        if (editora == null) {
            throw new DAOLivroException("Erro na criação, editora não existente");
        }
        try {
            em.persist(livro);
            editora.addLivro(livro);
            if (autores != null) {
                for (Autor a : autores) {
                    livro.addAutor(a);
                }
            }
            return livro;
        } catch (Exception e) {
            throw new DAOLivroException("Erro na criação", e);
        }
    }

    @Override
    public List<Livro> buscar() throws DAOLivroException {
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Livro> cq = cb.createQuery(Livro.class);
            TypedQuery<Livro> consulta =
                    em.createQuery(cq.select(cq.from(Livro.class)));
            return consulta.getResultList();
        }catch(Exception e){
            throw new DAOLivroException("Erro na busca", e);
        }
    }

    @Override
    public Livro buscar(int codigo) throws DAOLivroException {
        try{
            return em.find(Livro.class, codigo);
        }catch(Exception e){
            throw new DAOLivroException("Erro na busca", e);
        }
    }

    @Override
    public List<Livro> buscarPorEditora(int codigo) throws DAOLivroException {
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Livro> cq = cb.createQuery(Livro.class);
            Root<Livro> umLivro = cq.from(Livro.class);
            cq.where(cb.equal(umLivro.get(Livro_.editora).get(Editora_.codigo), codigo));
            cq.select(umLivro);
            TypedQuery<Livro> consulta = em.createQuery(cq);
            return consulta.getResultList();
        }catch(Exception e){
            throw new DAOLivroException("Erro na busca", e);
        }
    }

    @Override
    public void excluir(Livro livro) throws DAOLivroException {
        try{
            livro = em.merge(livro);
            em.remove(livro);
        }catch(Exception e){
            throw new DAOLivroException("Erro na remoção", e);
        }
    }

    @Override
    public void alterar(Livro livro) throws DAOLivroException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
