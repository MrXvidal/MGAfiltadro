package com.zetcode.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.zetcode.model.UserStatus;
import com.zetcode.repository.UserStatusTableRepository;
	
	@Controller
	@RestController
	@RequestMapping(path="/userStatus")
	public class UserStatusController {
		@Autowired
		private UserStatusTableRepository userStatusRepository;
		private JpaRepository<UserStatus, Integer> userStatusTableRepository;
		
		@RequestMapping("/all")
		public Iterable<UserStatus> getUserStatus() {
	        return userStatusRepository.findAll();
	    }
	}