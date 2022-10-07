package br.com.alura.spring.data.orm;

import javax.persistence.OneToMany;

public class UnidadeDeTrabalho {
	
	private Integer id;
	private String descricao;
	private String endereco;
	@OneToMany
	private Funcionario funcionario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

}
