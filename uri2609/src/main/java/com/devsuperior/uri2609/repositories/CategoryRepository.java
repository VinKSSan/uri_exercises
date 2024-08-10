package com.devsuperior.uri2609.repositories;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2609.entities.Category;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(nativeQuery = true, value = "SELECT  cat.name,SUM(prod.amount) " +
            "FROM products prod " +
            "INNER JOIN categories cat " +
            "ON prod.id_categories=cat.id " +
            "GROUP BY cat.name")
    List<CategorySumProjection> query1();

    @Query("SELECT new com.devsuperior.uri2609.dto.CategorySumDTO(prod.category.name, SUM(prod.amount)) " +
            " FROM Product prod " +
            "GROUP BY prod.category.name")
    List<CategorySumDTO> query2();
}
