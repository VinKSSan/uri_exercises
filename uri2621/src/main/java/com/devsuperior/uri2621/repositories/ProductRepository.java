package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.dto.ProdMinDTO;
import com.devsuperior.uri2621.projections.ProdMinProjections;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "SELECT prod.name FROM products prod " +
            "JOIN providers prov " +
            "ON prod.id_providers=prov.id " +
            "WHERE prod.amount BETWEEN :min AND :max " +
            "AND prov.name LIKE CONCAT(:beginName, '%')")
    List<ProdMinProjections> query1(Integer min, Integer max, String beginName );

    @Query("SELECT new com.devsuperior.uri2621.dto.ProdMinDTO(prod.name) FROM Product prod " +
            "WHERE prod.amount BETWEEN :min AND :max " +
            "AND prod.provider.name LIKE CONCAT(:beginName, '%')")
    List<ProdMinDTO> query2(Integer min, Integer max, String beginName );


}
