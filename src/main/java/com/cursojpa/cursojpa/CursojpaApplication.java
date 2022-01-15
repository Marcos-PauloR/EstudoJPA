package com.cursojpa.cursojpa;

import java.util.Arrays;

import com.cursojpa.cursojpa.domain.Categoria;
import com.cursojpa.cursojpa.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursojpaApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CursojpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Mesa");
		
		repository.saveAll(Arrays.asList(cat1, cat2, cat3));
	}


}
