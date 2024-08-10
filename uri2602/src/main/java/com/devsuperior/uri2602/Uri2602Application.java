package com.devsuperior.uri2602;

import com.devsuperior.uri2602.dto.CustomerMinDto;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {
	@Autowired
	private CustomerRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<CustomerMinProjection> list = repo.query1("RS");
		List<CustomerMinDto> listDTO = list.stream().map(p -> new CustomerMinDto(p)).collect(Collectors.toList());
		System.out.println("\n *** SQL RAIZ");
		for(CustomerMinDto obj : listDTO){
			System.out.println(obj);
		}
		System.out.println("\n\n");
		List<CustomerMinDto> list2 = repo.query2("rs");
		System.out.println("\n *** JPQL Result");
		for(CustomerMinDto obj : list2){
			System.out.println(obj);
		}
	}
}
