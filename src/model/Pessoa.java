package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String email;
	private String nascimento;
	private Endereco endPadrao;
	private User userPadrao;
	
	private List<Endereco> enderecos;
	private List<User> users;

	
	
	public Pessoa() {
		this.enderecos = new ArrayList<Endereco>();
		this.users = new ArrayList<User>();
	}
	
	
	public Pessoa(int id, String nome, String email, String nascimento, Endereco _endPadrao, List<Endereco> enderecos, User _userPadrao, List<User> users) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		this.endPadrao = _endPadrao;
		this.enderecos = enderecos;
		this.userPadrao = _userPadrao;
		this.users = users;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public Endereco getEndPadrao() {
		return endPadrao;
	}

	public void setEndPadrao(Endereco endPadrao) {
		this.endPadrao = endPadrao;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public void restaurarPessoa(Pessoa _pessoa) {
		this.id = _pessoa.id;
		this.nome = _pessoa.nome;
		this.email = _pessoa.email;
		this.nascimento = _pessoa.nascimento;
		this.enderecos = _pessoa.enderecos;
		this.users = _pessoa.users;
	}
	
	@Override
	public Pessoa clone() {
		return new Pessoa(this.id, this.nome, this.email, this.nascimento, this.endPadrao, this.enderecos, this.userPadrao, this.users);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", nascimento=" + nascimento + "]";
	}
}
