package com.zetcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zetcode.model.Game;

@Repository
public interface GameTableRepository extends JpaRepository<Game, Integer> {

	
}