package br.com.alura.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.UnidadeDeTrabalho;

@Repository //para o Spring ler essa anotação
public interface UnidadeDeTrabalhoRepository extends CrudRepository<UnidadeDeTrabalho, Integer>{

}
