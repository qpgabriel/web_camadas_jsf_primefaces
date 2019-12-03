package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Pessoa;

public class PessoaDAO implements PessoaInDAO {

	private Connection conexao = null;
	
	public PessoaDAO(Connection _conn) {
		this.conexao = _conn;
	}
	
	@Override
	public void Inserir(Pessoa _objeto) throws SQLException {
		
		String SQL = "INSERT INTO pessoa (nome, email, nascimento, endereco_padrao) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getEmail());
		ps.setString(3, _objeto.getNascimento());
		ps.setInt(4, _objeto.getEndPadrao().getId());
		
		ps.execute();

	}

	@Override
	public List<Pessoa> listarTodos() throws SQLException {
		
		//System.out.println();
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		ResultSet rs = null;
		
		String SQL = "SELECT id, nome, email, nascimento, endereco_padrao FROM pessoa";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			String nascimento = rs.getString(4);
			int idEndPadrao = rs.getInt(5);
			int idUserPadrao = rs.getInt(5);
			
			EnderecoDAO daoEnd = new EnderecoDAO(this.conexao);
			List<Endereco> enderecos = daoEnd.listarEnderecosPorPessoa(id);
			
			Endereco endPadrao = daoEnd.buscarPorId(idEndPadrao);
			
			EnderecoDAO daoUser = new UserDAO(this.conexao);
			List<User> users = daoUser.listarUserPorPessoa(id);
			
			Endereco endPadrao = daoEnd.buscarPorId(idEndPadrao);
			
			Pessoa p = new Pessoa(id, nome, email, nascimento, endPadrao, enderecos, userPadrao, users);
			
			pessoas.add(p);
		}
		
		return pessoas;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
	
		String SQL = "DELETE FROM pessoa WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		return ps.execute();
	}

	@Override
	public Boolean Atualizar(Pessoa _objeto) throws SQLException {

		String SQL = "UPDATE pessoa SET nome = ?, email = ?, nascimento = ?, endereco_padrao = ? WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getEmail());
		ps.setString(3, _objeto.getNascimento());
		ps.setInt(4, _objeto.getEndPadrao().getId());
		
		ps.setInt(5, _objeto.getId());
		
		return ps.execute();
	}

	@Override
	public Pessoa buscarPorId(int _id) throws SQLException {
		
		ResultSet rs = null;
		Pessoa p = null;
		
		String SQL = "SELECT id, nome, email, nascimento, endereco_padrao FROM pessoa WHERE id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.executeQuery();
		
		if (rs.next()) {
			
			int id = rs.getInt(1);
			String nome = rs.getString(2);
			String email = rs.getString(3);
			String nascimento = rs.getString(4);
			int idEndPadrao = rs.getInt(5);
			
			EnderecoDAO daoEnd = new EnderecoDAO(this.conexao);
			List<Endereco> enderecos = daoEnd.listarEnderecosPorPessoa(id);
			
			Endereco endPadrao = daoEnd.buscarPorId(idEndPadrao);
			
			p = new Pessoa(id, nome, email, nascimento, endPadrao, enderecos, userPadrao, users);
		}
		
		return p;
	}

}
