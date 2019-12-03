package dao;

import java.sql.SQLException;
import java.util.List;
import model.Arquivo;

public interface ArquivoInDAO {
	
void Inserir(Arquivo _objeto) throws SQLException;
	
	List<Arquivo> listarTodos() throws SQLException;
	
	Boolean Excluir(String _titulo) throws SQLException;
	
	void Atualizar(Arquivo _objeto) throws SQLException;
	
	Arquivo buscarPorId(String _titulo) throws SQLException;
}