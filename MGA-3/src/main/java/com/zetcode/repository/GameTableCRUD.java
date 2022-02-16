package com.zetcode.repository;

import org.springframework.data.repository.CrudRepository;
import com.zetcode.model.Game;

public interface GameTableCRUD extends CrudRepository<Game, Integer>{

}
