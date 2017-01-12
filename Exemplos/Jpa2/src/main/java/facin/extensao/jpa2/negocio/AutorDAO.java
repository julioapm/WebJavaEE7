package facin.extensao.jpa2.negocio;

import facin.extensao.jpa2.entidades.Autor;
import java.util.List;

public interface AutorDAO {
        Autor buscar(int codigo) throws DAOAutorException;
	List<Autor> buscar() throws DAOAutorException;
	List<Autor> buscarPorUltimoNome(String nome) throws DAOAutorException;
	Autor criar(String primeiroNome, String ultimoNome) throws DAOAutorException;
	void alterar(Autor autor) throws DAOAutorException;

}
