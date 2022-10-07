package br.com.alura.spring.data.service;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.repository.CargoRepository;

@Service //indica para o Spring que é uma Service
public class CrudCargoService {

	private final CargoRepository cargoRepository;
	
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
}
