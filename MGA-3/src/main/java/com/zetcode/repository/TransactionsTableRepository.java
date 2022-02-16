package com.zetcode.repository;

import javax.persistence.JoinColumn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zetcode.model.Transactions;

@Repository
public interface TransactionsTableRepository extends JpaRepository<Transactions, Integer> {

}