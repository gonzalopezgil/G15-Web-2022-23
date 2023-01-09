package com.uah.gestion_de_practicas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GestionDePracticasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDePracticasApplication.class, args);
	}

}
