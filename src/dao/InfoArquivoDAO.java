package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.InfoArquivo;
//implements ArquivoInDAO
public class InfoArquivoDAO {
	Connection conexao;
	public InfoArquivoDAO(Connection _conexao) {
		this.conexao = _conexao;
	}
	//@Override
	public void Inserir(InfoArquivo _objeto) throws SQLException {
		String SQL = "INSERT INTO arquivo ( id, titulo, tipo, autor, dataPubli) values ( ?, ?, ?, ?, ?)";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _objeto.getIdInfoArquivo());
		ps.setString(2, _objeto.getTipo());
		ps.setString(3, _objeto.getAutor());
		ps.setDate(4, _objeto.getDataPubli());
		ps.setInt(5, 1);
	}
	//@Override
	public ArrayList<InfoArquivo> listarTodos() throws SQLException {
		ArrayList<InfoArquivo> InfoArquivos = new ArrayList<InfoArquivo>();
		ResultSet rs = null;
		String SQL = "SELECT id, titulo, tipo, autor, dataPubli from arquivo";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		rs = ps.executeQuery();
		while (rs.next()) {
			InfoArquivo infoArquivo = new InfoArquivo();
			infoArquivo.setIdInfoArquivo(rs.getInt(1));
			infoArquivo.setTipo(rs.getString(2));
			infoArquivo.setAutor(rs.getString(3));
			infoArquivo.setDataPubli(rs.getDate(4));			
			InfoArquivos.add(infoArquivo);
		}
		return InfoArquivos;
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
	public void Atualizar(InfoArquivo _objeto) {       
		String SQL = "UPDATE user SET id= ? , titulo = ?, tipo = ?, autor = ?, WHERE id = ?";
		try {
            	PreparedStatement Query = conexao.prepareStatement(SQL);                
            	Query.setInt(1, _objeto.getIdInfoArquivo());
                Query.setString(2, _objeto.getTipo());
                Query.setString(3, _objeto.getAutor());
                Query.setDate(4, _objeto.getDataPubli());
                Query.execute();                                              
		} catch (SQLException e) {			
			e.printStackTrace();			
		}
	}
	//@Override
	public InfoArquivo buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;
		String SQL = "select id, titulo, conteudoTipo, autor from arquivo where username = ?";
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _id);
		rs = ps.executeQuery();
		InfoArquivo infoArquivo = null;
		if (rs.next()) {
			infoArquivo = new InfoArquivo();
			infoArquivo.setIdInfoArquivo(rs.getInt(1));
			infoArquivo.setTipo(rs.getString(2));
			infoArquivo.setAutor(rs.getString(3));
			infoArquivo.setDataPubli(rs.getDate(4));

		}
		return infoArquivo;
	}
}
