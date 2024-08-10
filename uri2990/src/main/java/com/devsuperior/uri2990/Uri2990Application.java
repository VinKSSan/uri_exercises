package com.devsuperior.uri2990;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.repositories.EmpregadoRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<EmpregadoDeptProjection> l1 = repository.query1();
		List<EmpregadoDeptDTO> r1 = l1.stream().map(EmpregadoDeptDTO::new).collect(Collectors.toList());
		System.out.println("SQL***");
		for(EmpregadoDeptDTO r:r1){
			System.out.println(r);
		}

		List<EmpregadoDeptDTO> r2 =  repository.query2();
		System.out.println("JPQL***");
		for(EmpregadoDeptDTO r:r2){
			System.out.println(r);
		}
		List<EmpregadoDeptProjection> l2 = repository.query3();
		List<EmpregadoDeptDTO> r3 = l2.stream().map(EmpregadoDeptDTO::new).collect(Collectors.toList());
		System.out.println("SQL-2***");
		for(EmpregadoDeptDTO r:r3){
			System.out.println(r);
		}
	}
}
