package com.devsuperior.uri2737.repositories;

import com.devsuperior.uri2737.dto.LawyerMinDTO;
import com.devsuperior.uri2737.projections.LawyerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2737.entities.Lawyer;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
    @Query(nativeQuery = true, value = "(SELECT name, customers_number AS customersNumber " +
            "FROM lawyers " +
            "WHERE customers_number=( " +
            "SELECT MAX(customers_number) " +
            "FROM lawyers)) " +
            "UNION ALL " +
            "(SELECT name, customers_number " +
            "FROM lawyers " +
            "WHERE customers_number=( " +
            "SELECT MIN(customers_number) " +
            "FROM lawyers)) " +
            "UNION ALL " +
            "(SELECT 'Average', ROUND(AVG(customers_number)) " +
            "FROM lawyers)")
    List<LawyerMinProjection> query1();

    @Query("SELECT new com.devsuperior.uri2737.dto.LawyerMinDTO(l.name, l.customersNumber)" +
            "FROM Lawyer l " +
            "WHERE customersNumber=( " +
            "SELECT MAX(customersNumber) " +
            "FROM Lawyer l)")
    LawyerMinDTO lMax();

    @Query("SELECT new com.devsuperior.uri2737.dto.LawyerMinDTO(l.name, l.customersNumber)" +
            "FROM Lawyer l " +
            "WHERE customersNumber=( " +
            "SELECT MIN(customersNumber) " +
            "FROM Lawyer l)")
    LawyerMinDTO lMin();
    @Query("SELECT new com.devsuperior.uri2737.dto.LawyerMinDTO('Average', CAST(AVG(l.customersNumber) AS int)) " +
            "FROM Lawyer l")
    LawyerMinDTO lAvg();
}
