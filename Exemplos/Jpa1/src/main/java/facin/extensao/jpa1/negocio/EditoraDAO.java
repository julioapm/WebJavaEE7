package facin.extensao.jpa1.negocio;

import facin.extensao.jpa1.entidades.Editora;
import java.util.List;

public interface EditoraDAO {
	List<Editora> buscar() throws DAOEditoraException;
	Editora buscar(int codigo) throws DAOEditoraException;
	Editora criar(int codigo, String nome) throws DAOEditoraException;
	void excluir(Editora editora) throws DAOEditoraException;
	void alterar(Editora editora) throws DAOEditoraException;
}
