package com.zetcode.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.zetcode.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zetcode.model.Users;
import com.zetcode.repository.UsersTableCRUD;
import com.zetcode.repository.UsersTableRepository;
import java.util.Iterator;



@Controller
@RequestMapping(path = "/userAccount")
public class UserAccountController extends UsersController{
	@Autowired
    UsersTableRepository userAccountRepository;
 
    @GetMapping(path = "/add") // Funcion para agregar una cuenta nueva
    @ResponseBody
    public String addUser(@RequestParam String name, @RequestParam String pass) {
        Users users = new Users(name, pass, null, 0);
        users.setName(name);
        users.setPassword(pass);
        String ret = "User account has been added, user name = " + name + ", password = " + pass;
        userAccountRepository.save(users);
      
        return ret;
    }
    

    /*
     * Mapping url exmaple: http://localhost:8080/userAccount/findAll
     */
    
    @GetMapping(path = "/findAll") // Nos muestra todos los USERS
    @ResponseBody
    public String findAllUser() {
        StringBuffer retBuf = new StringBuffer();
        List<Users> userAccountList = (List<Users>) userAccountRepository.findAll();
       System.out.println(userAccountList);
        if (userAccountList != null) {
            for (Users users : userAccountList) {
                retBuf.append(" \n user name = ");
                retBuf.append(users.getName());
                retBuf.append(", password = ");
                retBuf.append(users.getPassword());
           
            }
        }
        if (retBuf.length() == 0) {
            retBuf.append("No record find.");
        } else {
            retBuf.insert(0, "<pre>");
            retBuf.append("</pre>");
        }
        return retBuf.toString();
    }
 
    
    
    @GetMapping(path = "/updateUser", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map updateUser(@RequestParam(required = true) String name, @RequestParam(required = true) String pass) { // CONTRUCTOR QUE RECOGERA LOS NOMBRES Y PASS
      
        int numClientes = 0; // DECLARACION PARA LA COMPROBACIÓN
        Users user = new Users (name, pass, "0", 0);            
        List<Users> userList = (List<Users>) userAccountRepository.findAll(); // LISTAMOS LA TABLA USERS
        for (Users usuario : userList) {
        	System.out.println("LISTA DE TODOS " + usuario.toString());
        	numClientes++; 
        }   
        
        
        //FUNCION QUE CONECTA AL JUGADOR Y MANDA LA ID Y EL BALANCE
        
        
        for(int i = 0; i < numClientes; i++) // BUSCAMOS EN EL ARRAY EL USURUARIO Y CONTRASEÑA
        {
        	Users usuarios = userList.get(i);
        	if(usuarios.getName().equals(user.getName()) && usuarios.getPassword().equals(user.getPassword())) {
     		
        		System.out.println("CONECTADO " + usuarios); 
        		Map<String,String> usuarioconectado = new HashMap<>();
        		usuarioconectado.put("idUser", String.valueOf(usuarios.getIdUser()));
        		usuarioconectado.put("Saldo", String.valueOf(usuarios.getSaldo()));
        		System.out.println(usuarioconectado);
				return usuarioconectado;}
            
        	
        }
        
        System.out.println("NO CONECTADO");
        Map<String, String> usuarioNOCONECTADO = new HashMap<>();
		return usuarioNOCONECTADO;     

    }
}   


