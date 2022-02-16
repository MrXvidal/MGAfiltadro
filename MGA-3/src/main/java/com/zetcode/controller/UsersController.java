package com.zetcode.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zetcode.model.Users;
import com.zetcode.repository.UsersTableCRUD;
import com.zetcode.repository.UsersTableRepository;

	@Controller
	@RestController
	@RequestMapping(path="/users")
	public class UsersController {
		private static final HashMap<String, Object> HashMap = null;
		private static final Map CONECTADO = null;
		private static final Map NOCONECTADO = null;
		@Autowired
		private UsersTableRepository usersRepository;
		private JpaRepository<Users, Integer> usersTableRepository;
		
		@RequestMapping("/all")
		public Iterable<Users> getUsers() {
	        return usersRepository.findAll();
	    }

		public Optional<Users> findById(Integer idUser) {
		
			return null;
		}
		
		@PostMapping(value = "/carga")
		public Map updateUser(@RequestParam(required = true) String name, @RequestParam(required = true) String pass) {
			ArrayList<Users> lista = new ArrayList<Users>();
			lista = UsersController.findAll();
			for (Users user : lista) 
			{
				if(user.getPassword().equals(pass))
				{
					if(user.getName().equals(name)) 
					{
						return CONECTADO;
					}
						
				} else {
					return NOCONECTADO;
			}				
		}
			return NOCONECTADO;
	}

		public static ArrayList<Users> findAll() {
			
			return null;
		}
		
		
}
