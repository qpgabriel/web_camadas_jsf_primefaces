package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;

public class UserDAO implements UserInDAO {	
	Connection conexao;
	public UserDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	//@Override
	public void Inserir(User _objeto) throws SQLException {
		String SQL = "INSERT INTO user ( username, password) values ( ?, ?)";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setString(1, _objeto.getUsername());
		ps.setString(2, _objeto.getPassword());
		ps.execute();
	}
	//@Override
	public ArrayList<User> listarTodos() throws SQLException {
		ArrayList<User> Users = new ArrayList<User>();
		ResultSet rs = null;
		String SQL = "SELECT username, password from user";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		rs = ps.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			Users.add(user);
		}
		return Users;
	}	
	//@Override
	public Boolean Excluir(String _username) throws SQLException {
		String SQL = "DELETE FROM user where username = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setString(1, _username);
		ps.execute();
		return true;
	}	
	//@Override
	public void Atualizar(User _objeto) {       
		String SQL = "UPDATE user SET username= ? , password = ? WHERE username = ?";
		try {
            	PreparedStatement Query = conexao.prepareStatement(SQL);                
            	Query.setString(1, _objeto.getUsername());
                Query.setString(2, _objeto.getPassword());
                Query.execute();                                                
		} catch (SQLException e) {			
			e.printStackTrace();			
		}
	}
	//@Override
	public User buscarPorUsername(String _username) throws SQLException {
		ResultSet rs = null;
		String SQL = "select username, password from usuarios where username = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setString(1, _username);
		rs = ps.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
		}
		return user;
	}
}
