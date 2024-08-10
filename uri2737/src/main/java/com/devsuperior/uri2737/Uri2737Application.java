package com.devsuperior.uri2737;

import com.devsuperior.uri2737.dto.LawyerMinDTO;
import com.devsuperior.uri2737.projections.LawyerMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2737.repositories.LawyerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2737Application implements CommandLineRunner {

	@Autowired
	private LawyerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2737Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<LawyerMinProjection> l1 = repository.query1();
		List<LawyerMinDTO> r1 = l1.stream().map(p -> new LawyerMinDTO(p)).collect(Collectors.toList());

		System.out.println("SQL***\n\n");
		System.out.println("[name --- custumers]");
		for(LawyerMinDTO r:r1){
			System.out.println(r);
		}
		List<LawyerMinDTO> r2 = new ArrayList<>();
		LawyerMinDTO rMa = repository.lMax();
		LawyerMinDTO rMi = repository.lMin();
		LawyerMinDTO rA = repository.lAvg();
		r2.add(rMa);
		r2.add(rMi);
		r2.add(rA);
		System.out.println("JPQL***\n\n");
		System.out.println("[name --- custumers]");
		for(LawyerMinDTO r:r2){
			System.out.println(r);
		}
	}
}
