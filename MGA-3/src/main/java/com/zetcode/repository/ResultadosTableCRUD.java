package com.zetcode.repository;

import org.springframework.data.repository.CrudRepository;
import com.zetcode.model.Resultados;

public interface ResultadosTableCRUD extends CrudRepository<Resultados, Integer>{

}
