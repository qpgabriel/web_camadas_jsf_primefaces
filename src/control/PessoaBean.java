package control;

import java.io.Serializable;
import java.sql.Connection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import dao.PessoaDAO;
import model.Pessoa;
import util.FabricaConexao;
import util.JSFUtil;

@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	private ListDataModel<Pessoa> pessoas;
	private Boolean editando;
	private Pessoa pessoaAntesDaEdicao;
	
	public PessoaBean() {
		this.pessoa = new Pessoa();
		this.pessoas = new ListDataModel<Pessoa>();
		this.editando = false;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public ListDataModel<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ListDataModel<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public Boolean getEditando() {
		return editando;
	}

	public void setEditando(Boolean editando) {
		this.editando = editando;
	}
	
	public void Limpar() {
		this.pessoa = new Pessoa();
	}
	
	public void Editar(Pessoa _pessoa) {
		this.pessoaAntesDaEdicao = _pessoa.clone();
		this.pessoa = _pessoa;
		this.editando = true;
	}
	
	public void CancelarEdicao() {
		this.pessoa.restaurarPessoa(this.pessoaAntesDaEdicao);
		this.pessoa = new Pessoa();
		this.editando = false;
	}
	
	public void PrepararExcluir() 
	{
		this.pessoa = this.pessoas.getRowData();
	}
	
	//------------ OPERAÇÕES COM A BASE DE DADOS
	
	public void SalvarEdicao() {
		//DAO
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			PessoaDAO dao = new PessoaDAO(conexao);
			
			dao.Atualizar(this.pessoa);
			
			JSFUtil.adicionarMensagemSucesso("Pessoa alterada com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		this.pessoa = new Pessoa();
		this.editando = false;
	}
	
	public void Adicionar() {
		//DAO
		try {
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			PessoaDAO dao = new PessoaDAO(conexao);
			
			dao.Inserir(this.pessoa);
			
			ListDataModel<Pessoa> listaPessoas = new ListDataModel<>(dao.listarTodos());
			this.pessoas = listaPessoas;
			
			this.pessoa = new Pessoa();
			
			JSFUtil.adicionarMensagemSucesso("Pessoa cadastrado com sucesso!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Excluir() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			PessoaDAO dao = new PessoaDAO(conexao);
			
			dao.Excluir(this.pessoa.getId());
			
			ListDataModel<Pessoa> listaPessoas = new ListDataModel<>(dao.listarTodos());
			this.pessoas = listaPessoas;
			
			this.pessoa = new Pessoa();
			
			JSFUtil.adicionarMensagemSucesso("Pessoa excluída com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.adicionarMensagemErro(e.getMessage());
		}
	}
	
	@PostConstruct
	public void init() {
		try {
			
			FabricaConexao fabrica = new FabricaConexao();
			Connection conexao = fabrica.fazerConexao();
			
			PessoaDAO dao = new PessoaDAO(conexao);
			
			this.pessoas = new ListDataModel<>(dao.listarTodos());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
