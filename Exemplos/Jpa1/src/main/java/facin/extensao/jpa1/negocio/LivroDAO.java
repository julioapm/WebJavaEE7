package facin.extensao.jpa1.negocio;

import facin.extensao.jpa1.entidades.Autor;
import facin.extensao.jpa1.entidades.Livro;
import java.util.List;

public interface LivroDAO {
	List<Livro> buscar() throws DAOLivroException;
	Livro buscar(int codigo) throws DAOLivroException;
	List<Livro> buscarPorEditora(int codigo) throws DAOLivroException;
	Livro criar(String titulo, int ano, int codigoEditora, Autor[] autores) throws DAOLivroException;
	void excluir(Livro livro) throws DAOLivroException;
	void alterar(Livro livro) throws DAOLivroException;
}
