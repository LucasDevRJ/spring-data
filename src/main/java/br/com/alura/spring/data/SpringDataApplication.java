package br.com.alura.spring.data;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.service.CrudCargoService;

@SpringBootApplication //serve para quando iniciado o Spring percorra as anotações que temos para executa-las
public class SpringDataApplication implements CommandLineRunner{
	
	private CrudCargoService cargoService;
	private Boolean system = true;
	
	//Injeção de dependência
	public SpringDataApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		//serve para iniciar o Spring
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while (system) {
			System.out.println("Qual ação deseja executar? ");
			System.out.println("0 - Sair.");
			System.out.println("1 - Cargo.");
			
			int action = scanner.nextInt();
			
			if (action == 1) {
				cargoService.inicial(scanner);
			} else {
				system = false;
			}
		}
	}

}
