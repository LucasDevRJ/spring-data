package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.UnidadeDeTrabalho;
import br.com.alura.spring.data.repository.UnidadeDeTrabalhoRepository;

@Service //indica para o Spring que é uma Service
public class CrudUnidadeDeTrabalhoService {

	private final UnidadeDeTrabalhoRepository unidadeRepository;
	private Boolean system = true;
	
	public CrudUnidadeDeTrabalhoService(UnidadeDeTrabalhoRepository unidadeRepository) {
		this.unidadeRepository = unidadeRepository;
	}
	
	public void inicial(Scanner scanner) {
		
		while (system) {
			System.out.println("Qual ação deseja executar? ");
			System.out.println("0 - Sair.");
			System.out.println("1 - Salvar.");
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
		System.out.println("Digite a descrição da unidade");
		String descricao = scanner.next();
		
		System.out.println("Digite o endereço");
		String endereco = scanner.next();
		
		UnidadeDeTrabalho unidade = new UnidadeDeTrabalho();
		unidade.setDescricao(descricao);
		unidade.setDescricao(endereco);
		
		unidadeRepository.save(unidade);
		System.out.println("Unidade salva com sucesso!");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Digite o ID");
		Integer id = scanner.nextInt();
		
		System.out.println("Digite a descrição da unidade");
		String descricao = scanner.next();
		
		System.out.println("Digite o endereço");
		String endereco = scanner.next();
		
		UnidadeDeTrabalho unidade = new UnidadeDeTrabalho();
		unidade.setId(id);
		unidade.setDescricao(descricao);
		unidade.setEndereco(endereco);
		
		unidadeRepository.save(unidade);
		System.out.println("Unidade atualizado com sucesso!");
	}
	
	private void visualizar() {
		Iterable<UnidadeDeTrabalho> unidades = unidadeRepository.findAll();
		unidades.forEach(un -> System.out.println(un));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("ID");
		int id = scanner.nextInt();
		unidadeRepository.deleteById(id);
		System.out.println("Unidade deletada com sucesso!");
	}
} 
