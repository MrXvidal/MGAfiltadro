package com.zetcode.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;	
	import com.zetcode.model.Transactions;
import com.zetcode.repository.TransactionsTableRepository;
	 
	@Controller
	@RestController
	@RequestMapping(path="/transactions")
	public class TransactionsController {
		@Autowired
		private TransactionsTableRepository transactionsRepository;
		
		
		@RequestMapping("/all")
		public Iterable<Transactions> getTransactions() {
	        return transactionsRepository.findAll();
	    }
	}