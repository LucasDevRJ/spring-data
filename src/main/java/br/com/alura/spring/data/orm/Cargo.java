package br.com.alura.spring.data.orm;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity //Indica ao Spring Data que esta classe é uma entidade, para assim criar uma entidade a partir desta classe
@Table(name = "cargos") //Permite alterar atributos da entidade criadas, como nesse caso, o nome
public class Cargo {

}
