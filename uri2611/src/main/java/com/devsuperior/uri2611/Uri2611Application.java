package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.MovMinDTO;
import com.devsuperior.uri2611.projections.MovMinProjection;
import com.devsuperior.uri2611.repository.MovRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	private MovRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<MovMinProjection> l1 = repo.query1("Action");
		List<MovMinDTO> r1 = l1.stream().map(MovMinDTO::new).collect(Collectors.toList());

		System.out.println("\n*** SQL Raiz");
		for(MovMinDTO mmd : r1){
			System.out.println(mmd);
		}
		System.out.println("\n\n");

		List<MovMinDTO> r2 = repo.query2("Action");

		System.out.println("\n*** JSQL");
		for(MovMinDTO mmd : r2){
			System.out.println(mmd);
		}
		System.out.println("\n\n");


	}
}
