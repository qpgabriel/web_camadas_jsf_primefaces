package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Arquivo;
//implements ArquivoInDAO
public class ArquivoDAO {
	Connection conexao;
	public ArquivoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	//@Override
	public void Inserir(Arquivo _objeto) throws SQLException {
		String SQL = "INSERT INTO arquivo ( id, titulo, conteudoTipo, autor, dataUpload, arquivo) values ( ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setString(1, _objeto.getTitulo());
		ps.setBlob(2, _objeto.getArquivo());
		ps.setDate(3, _objeto.getDataUpload());
		ps.setInt(4, 1);
	}
	//@Override
	public ArrayList<Arquivo> listarTodos() throws SQLException {
		ArrayList<Arquivo> Arquivos = new ArrayList<Arquivo>();
		ResultSet rs = null;
		String SQL = "SELECT id, titulo, dataUpload, arquivo from arquivo";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		rs = ps.executeQuery();
		while (rs.next()) {
			Arquivo arquivo = new Arquivo();
			arquivo.setId(rs.getInt(1));
			arquivo.setTitulo(rs.getString(2));
			arquivo.setArquivo(rs.getBlob(3));
			arquivo.setDataUpload(rs.getDate(4));
			
			Arquivos.add(arquivo);
		}
		return Arquivos;
	}	
	//@Override
	public Boolean Excluir(int _id) throws SQLException {
		String SQL = "DELETE FROM user where id = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);
		ps.execute();
		return true;
	}	
	//@Override
	public void Atualizar(Arquivo _objeto) {       
		String SQL = "UPDATE user SET id= ? , titulo = ?, dataUpload = ?, arquivo = ? WHERE id = ?";
		try {
            	PreparedStatement Query = conexao.prepareStatement(SQL);                
            	Query.setInt(1, _objeto.getId());
            	Query.setString(2, _objeto.getTitulo());
                Query.setBlob(3, _objeto.getArquivo());
                Query.setDate(4, _objeto.getDataUpload());
                Query.setInt(5, _objeto.getId());
                Query.execute();                                              
		} catch (SQLException e) {			
			e.printStackTrace();			
		}
	}
	//@Override
	public Arquivo buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;
		String SQL = "select id, titulo, dataUpload, arquivo from arquivo where username = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);
		rs = ps.executeQuery();
		Arquivo arquivo = null;
		if (rs.next()) {
			arquivo = new Arquivo();
			arquivo.setId(rs.getInt(1));
			arquivo.setTitulo(rs.getString(2));
			arquivo.setArquivo(rs.getBlob(3));
			arquivo.setDataUpload(rs.getDate(4));
		}
		return arquivo;
	}
}
