package br.com.alura.spring.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //serve para quando iniciado o Spring percorra as anotações que temos para executa-las
public class SpringDataApplication {

	public static void main(String[] args) {
		//serve para iniciar o Spring
		SpringApplication.run(SpringDataApplication.class, args);
	}

}
