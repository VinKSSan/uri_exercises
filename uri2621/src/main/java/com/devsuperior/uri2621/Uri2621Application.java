package com.devsuperior.uri2621;

import com.devsuperior.uri2621.dto.ProdMinDTO;
import com.devsuperior.uri2621.projections.ProdMinProjections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.repositories.ProductRepository;

import  java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<ProdMinProjections> l1 = repository.query1(10,20,"P");
		List<ProdMinDTO> r1 = l1.stream().map(ProdMinDTO::new).collect(Collectors.toList());
		System.out.println("SQL Raiz*** \n ");
		for (ProdMinDTO p : r1){
			System.out.println(p);
		}
		System.out.println("\n\n");
		List<ProdMinDTO> r2 = repository.query2(10,20,"P");

		System.out.println("JSQL*** \n ");
		for (ProdMinDTO p : r2){
			System.out.println(p);
		}

	}
}
