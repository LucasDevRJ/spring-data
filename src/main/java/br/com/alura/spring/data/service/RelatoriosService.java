package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import net.bytebuddy.asm.Advice.Local;

@Service
public class RelatoriosService {

	private final FuncionarioRepository funcionarioRepository;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private Boolean system = true;
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		
		while (system) {
			System.out.println("Qual ação deseja executar? ");
			System.out.println("1 - Buscar funcionário pelo nome.");
			System.out.println("2 - Buscar funcionário pelo nome, salário e data de contratação.");
			System.out.println("3 - Buscar funcionário pela data de contratação maior.");
			System.out.println("4 - Listar funcionários com a ID, nome e salário.");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				buscarFuncionarioNome(scanner);
			break;
			
			case 2:
				buscarFuncionarioNomeSalarioMaiorDataContratacao(scanner);
			break;
			
			case 3:
				buscarFuncionarioComDataMaior(scanner);
			break;
			
			case 4:
				buscarIdNomeSalarioFuncionario();;
			break;
		
			default:
				system = false;
				break;
			}
		}
	}

	private void buscarFuncionarioNome(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar");
		String nome = scanner.next();
		List<Funcionario> funcionarios = funcionarioRepository.findByNome(nome);
		funcionarios.forEach(fn -> System.out.println(fn));
	}
	
	private void buscarFuncionarioNomeSalarioMaiorDataContratacao(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar");
		String nome = scanner.next();
		
		System.out.println("Qual data contratação deseja pesquisar");
		String data = scanner.next();
		
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		System.out.println("Qual salário deseja pesquisar");
		Double salario = scanner.nextDouble();
		
		List<Funcionario> funcionarios = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
		funcionarios.forEach(fn -> System.out.println(fn));
	}
	
	private void buscarFuncionarioComDataMaior(Scanner scanner) {
		System.out.println("Qual data contratação deseja pesquisar");
		String data = scanner.next();
		
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		List<Funcionario> funcionarios = funcionarioRepository.findFuncionarioDataContratacao(localDate);
		funcionarios.forEach(fn -> System.out.println(fn));
	}
	
	private void buscarIdNomeSalarioFuncionario() {
		List<FuncionarioProjecao> funcionarios = funcionarioRepository.findFuncionarioSalario();
		funcionarios.forEach(fn -> System.out.println("ID: " + fn.getId() + "\nNome: " + fn.getNome() + "\nSalário: " + fn.getSalario() + "\n"));
	}
}
