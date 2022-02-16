package com.zetcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zetcode.model.Resultados;

@Repository
public interface ResultadosTableRepository extends JpaRepository<Resultados, Integer> {


}