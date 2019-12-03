package dao;
import java.sql.SQLException;
import java.util.List;
import model.User;
public interface UserInDAO {

	void Inserir(User _objeto) throws SQLException;
	
	List<User> listarTodos() throws SQLException;
	
	Boolean Excluir(String _username) throws SQLException;
	
	void Atualizar(User _objeto) throws SQLException;
	
	User buscarPorUsername(String _username) throws SQLException;
}

