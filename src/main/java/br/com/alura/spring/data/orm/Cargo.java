package br.com.alura.spring.data.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Indica ao Spring Data que esta classe é uma entidade, para assim criar uma entidade a partir desta classe
@Table(name = "cargos") //Permite alterar atributos da entidade criadas, como nesse caso, o nome
public class Cargo {
	@Id //indica que o atributo é um ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gerar os valores automaticamente
	private Integer id;
	private String descricao;
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
	@Override
	public String toString() {
		return "Cargo [id=" + id + ", descricao=" + descricao + "]";
	}
}
