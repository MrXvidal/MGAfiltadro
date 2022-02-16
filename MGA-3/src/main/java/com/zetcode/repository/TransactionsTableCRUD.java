package com.zetcode.repository;

import org.springframework.data.repository.CrudRepository;

import com.zetcode.model.Transactions;

public interface TransactionsTableCRUD extends CrudRepository<Transactions, Integer>{

}
