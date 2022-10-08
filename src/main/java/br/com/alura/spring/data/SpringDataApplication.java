package br.com.alura.spring.data;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeDeTrabalhoService;

@SpringBootApplication //serve para quando iniciado o Spring percorra as anotações que temos para executa-las
public class SpringDataApplication implements CommandLineRunner{
	
	private CrudCargoService cargoService;
	private CrudFuncionarioService funcionarioService;
	private CrudUnidadeDeTrabalhoService unidadeService;
	private Boolean system = true;
	
	//Injeção de dependência
	public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService, CrudUnidadeDeTrabalhoService unidadeService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeService = unidadeService;
	}

	public static void main(String[] args) {
		//serve para iniciar o Spring
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1 - Cargo");
		System.out.println("2 - Funcionário");
		System.out.println("3 - Unidades de Trabalho");
		System.out.println("Digite a tabela desejada");
		int opcao = scanner.nextInt();
		
		while (system) {
			switch (opcao) {
			case 1:
				cargoService.inicial(scanner);
			break;
		
			case 2:
				funcionarioService.inicial(scanner);
			break;
			
			case 3:
				unidadeService.inicial(scanner);
			break;
				
			default:
				system = false;
			break;
			}
		}
	}
}
