package br.com.alura.spring.data.orm;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Funcionario {

	private Integer id;
	private String nome;
	private String cpf;
	private float salario;
	private Date dataContratacao;
	@ManyToOne
	private Cargo cargo;
	@OneToMany
	private UnidadeDeTrabalho unidade;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public Date getDataContratacao() {
		return dataContratacao;
	}
	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	public void setUnidade(UnidadeDeTrabalho unidade) {
		this.unidade = unidade;
	}
	
	public UnidadeDeTrabalho getUnidade() {
		return unidade;
	}
}
