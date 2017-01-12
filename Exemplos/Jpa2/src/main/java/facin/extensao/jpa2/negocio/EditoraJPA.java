package facin.extensao.jpa2.negocio;

import facin.extensao.jpa2.entidades.Editora;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class EditoraJPA implements EditoraDAO{
    @PersistenceContext
    private EntityManager em;
        
    @Override
    public Editora criar(int codigo, String nome) throws DAOEditoraException {
        Editora editora = new Editora();
        editora.setCodigo(codigo);
        editora.setNome(nome);
        try{
            em.persist(editora);
            return editora;
        }catch(Exception e){
            throw new DAOEditoraException("Erro na criação", e);
        }
    }

    @Override
    public List<Editora> buscar() throws DAOEditoraException {
        //Crie uma consulta via Criteria
        try{
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Editora> cq = cb.createQuery(Editora.class);
            TypedQuery<Editora> consulta =
                    em.createQuery(cq.select(cq.from(Editora.class)));
            return consulta.getResultList();
        }catch(Exception e){
            throw new DAOEditoraException("Erro na busca", e);
        }
    }

    @Override
    public Editora buscar(int codigo) throws DAOEditoraException {
        //Crie uma consulta via JPQL
        try
        {
            Query consulta = em.createQuery("select edt from Editora edt where edt.codigo = :codigo");
            consulta.setParameter("codigo", codigo);
            return (Editora)consulta.getSingleResult();
        }catch(Exception e){
            throw new DAOEditoraException("Erro na busca", e);
        }
    }

    @Override
    public void excluir(Editora editora) throws DAOEditoraException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(Editora editora) throws DAOEditoraException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
