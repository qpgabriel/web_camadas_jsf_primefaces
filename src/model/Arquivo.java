package model;

import java.sql.Blob;
import java.sql.Date;
import java.io.Serializable;

public class Arquivo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int idarquivo;
	private String titulo;
	private Date  dataUpload;
	private Blob arquivo;

	
	
	public Arquivo() {
		
	}
	
	public Arquivo(int _idarquivo, String _titulo, Date _dataUpload, Blob _arquivo) {
		super();
		this.idarquivo = _idarquivo;
		this.titulo = _titulo;
		this.dataUpload = _dataUpload;
		this.arquivo = _arquivo;
	}

	public int getId() {
		return idarquivo;
	}
	public void setId(int id) {
		this.idarquivo = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getDataUpload() {
		return dataUpload;
	}
	public void setDataUpload(Date dataCriacao) {
		this.dataUpload = dataCriacao;
	}
	public Blob getArquivo() {
		return arquivo;
	}
	public void setArquivo(Blob arquivo) {
		this.arquivo = arquivo;
	}
}
