package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service //indica para o Spring que é uma Service
public class CrudCargoService {

	private final CargoRepository cargoRepository;
	private Boolean system = true;
	
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner scanner) {
		
		while (system) {
			System.out.println("Qual ação deseja executar? ");
			System.out.println("0 - Sair.");
			System.out.println("1 - Cargo.");
			System.out.println("2 - Atualizar.");
			System.out.println("3 - Visualizar.");
			System.out.println("4 - Deletar.");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				salvar(scanner);
			break;
			
			case 2:
				atualizar(scanner);
			break;
			
			case 3:
				visualizar();
			break;

			case 4:
				deletar(scanner);
			break;

			default:
				system = false;
				break;
			}
		}
		
		salvar(scanner);
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Descrição do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Cargo salvo com sucesso!");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("ID");
		int id = scanner.nextInt();
		System.out.println("Descrição do cargo");
		String descricao = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Cargo atualizado com sucesso!");
	}
	
	private void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cg -> System.out.println(cg));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("ID");
		int id = scanner.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Cargo deletado com sucesso!");
	}
} 
