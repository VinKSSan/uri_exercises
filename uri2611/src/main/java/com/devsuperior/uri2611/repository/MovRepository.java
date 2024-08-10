package com.devsuperior.uri2611.repository;

import com.devsuperior.uri2611.dto.MovMinDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = "SELECT mov.id, mov.name " +
            "FROM movies mov " +
            "JOIN genres gen " +
            "ON gen.id=mov.id_genres " +
            "WHERE gen.description = :genName")
    List<MovMinProjection> query1(String genName);

    @Query("SELECT new com.devsuperior.uri2611.dto.MovMinDTO(mov.id, mov.name) " +
            "FROM Movie mov " +
            "WHERE mov.genre.description = :genName")
    List<MovMinDTO> query2(String genName);
}
