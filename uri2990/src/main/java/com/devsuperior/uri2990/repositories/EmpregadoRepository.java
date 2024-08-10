package com.devsuperior.uri2990.repositories;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2990.entities.Empregado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
    @Query(nativeQuery = true, value = "SELECT emp.cpf, emp.enome, dep.dnome \n" +
            "\tFROM empregados emp\n" +
            "\tINNER JOIN departamentos dep ON emp.dnumero=dep.dnumero\n" +
            "\tWHERE emp.cpf NOT IN (\n" +
            "\t\tSELECT tra.cpf_emp FROM trabalha tra\n" +
            "\t)\n" +
            "ORDER BY emp.cpf")
    List<EmpregadoDeptProjection> query1();

    @Query("SELECT new com.devsuperior.uri2990.dto.EmpregadoDeptDTO( emp.cpf, emp.enome, emp.departamento.dnome) " +
            "FROM Empregado emp " +
            "WHERE emp.cpf NOT IN ( " +
            "SELECT emp.cpf FROM Empregado emp JOIN emp.projetosOndeTrabalha ) " +
            "ORDER BY emp.cpf")
    List<EmpregadoDeptDTO> query2();


    @Query(nativeQuery = true, value = "SELECT emp.cpf, emp.enome, dep.dnome \n" +
            "\tFROM empregados emp\n" +
            "\tINNER JOIN departamentos dep ON emp.dnumero=dep.dnumero\n" +
            "\tLEFT JOIN trabalha tra ON tra.cpf_emp=emp.cpf\n" +
            "\tWHERE tra.cpf_emp IS NULL\n" +
            "ORDER BY emp.cpf")
    List<EmpregadoDeptProjection> query3();
}
