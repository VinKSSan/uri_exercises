package com.devsuperior.uri2609;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.repositories.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<CategorySumProjection> l1 = repository.query1();
		List<CategorySumDTO> r1 = l1.stream().map(p->new CategorySumDTO(p)).collect(Collectors.toList());

		System.out.println("Query 1 SQL***\n");
		for(CategorySumDTO r:r1){
			System.out.println(r);
		}

		List<CategorySumDTO> r2 = repository.query2();
		System.out.println("Query 2 JPQL***\n");
		for (CategorySumDTO r:r2){
			System.out.println(r);
		}


	}
}
