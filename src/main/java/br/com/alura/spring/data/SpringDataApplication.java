package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@SpringBootApplication //serve para quando iniciado o Spring percorra as anotações que temos para executa-las
public class SpringDataApplication implements CommandLineRunner{
	
	private CargoRepository repository;
	private Boolean system = true;
	
	//Injeção de dependência
	public SpringDataApplication(CargoRepository repository) {
		this.repository = repository;
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
		}
		
		Cargo cargo = new Cargo();
		cargo.setDescricao("DESENVOLVEDOR DE SOFTWARE");
		
		repository.save(cargo);
	}

}
