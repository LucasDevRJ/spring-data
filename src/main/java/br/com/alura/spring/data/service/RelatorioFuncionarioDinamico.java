package br.com.alura.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.specification.SpecificationFuncionario;

public class RelatorioFuncionarioDinamico {

	private final FuncionarioRepository funcionarioRepository;
	
	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		System.out.println("Digite o nome");
		String nome = scanner.next();
		
		System.out.println("Digite o cpf");
		String cpf = scanner.next();
		
		System.out.println("Digite o salário");
		Double salario = scanner.nextDouble();
		
		List<Funcionario> funcionarios = funcionarioRepository.findAll(Specification.where(
				SpecificationFuncionario.nome(nome),
				SpecificationFuncionario.cpf(cpf), 
				SpecificationFuncionario.salario(salario), 
				SpecificationFuncionario.data(data)));
		
	}
}
