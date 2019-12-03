package model;

import java.io.Serializable;
import java.sql.Date;

public class InfoArquivo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int idInfoArquivo;
	private String tipo;
	private String autor;
	private Date dataPubli;
	
	public InfoArquivo() {
		
	}
	
	public InfoArquivo(int _idinfoArquivo, String _tipo, String _autor, Date _dataPubli) {
		super();
		this.idInfoArquivo = _idinfoArquivo;
		this.tipo = _tipo;
		this.autor = _autor;
		this.dataPubli = _dataPubli;
	}

	public int getIdInfoArquivo() {
		return idInfoArquivo;
	}

	public void setIdInfoArquivo(int idInfoArquivo) {
		this.idInfoArquivo = idInfoArquivo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getDataPubli() {
		return dataPubli;
	}

	public void setDataPubli(Date dataPubli) {
		this.dataPubli = dataPubli;
	}


}
