package com.zetcode.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.RNG.RandomX;
import com.zetcode.model.Resultados;
import com.zetcode.model.Transactions;
import com.zetcode.model.Users;
import com.zetcode.repository.ResultadosTableRepository;
import com.zetcode.repository.TransactionsTableRepository;
import com.zetcode.repository.UsersTableRepository;


@Controller
@RestController
@RequestMapping(path="/resultados")
public class ResultadosController {
	
	@Autowired
	ResultadosTableRepository resultadosTableRepository;
	@Autowired
    UsersTableRepository userAccountRepository;
	@Autowired
	TransactionsTableRepository transactionsTableRepository;
	@Autowired
    UsersTableRepository userTableRepository;
	
	private Users usuarioConectado = new Users( "Test", "test","0",0);

	
	@RequestMapping("/all")
	public String getResultados() {
		RandomX rand = new RandomX();
		String resultado = rand.rtp();
		
		return resultado;
    }
	/*
     * Mapping url exmaple: http://localhost:8080/resultados/updateUser
     */
    

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
        	Users usuario = userList.get(i);
        	if(usuario.getName().equals(user.getName()) && usuario.getPassword().equals(user.getPassword())) {
     		
        		System.out.println("CONECTADO " + usuario); 
        		Map<String,String> usuarioConectado = new HashMap<>();
        		usuarioConectado.put("idUser", String.valueOf(usuario.getIdUser()));
        		usuarioConectado.put("Saldo", String.valueOf(usuario.getSaldo()));
        		System.out.println(usuarioConectado);
        		
        		this.usuarioConectado = usuario;
        		
				return usuarioConectado;}
            
        	
        }
        
        System.out.println("NO CONECTADO");
        Map<String, String> usuarioNOCONECTADO = new HashMap<>();
		return usuarioNOCONECTADO;     

    }

	@GetMapping(path = "/all2", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String,String> sayResultados() {
		HashMap<String,String> tirada = new HashMap<>();	
		String premiooo = getResultados();
		Resultados resu = new Resultados();

		if(premiooo == "DiamantesA")
		{
		tirada.put("rodillo1","DiamantesA");
		tirada.put("rodillo2","DiamantesA");
		tirada.put("rodillo3","DiamantesA");
		tirada.put("IdGame","1");	 
		tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
		tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo() + 79.8));
		tirada.put("Premio", "80");
		tirada.put("GameMode", "DEMO");
		
		usuarioConectado.setSaldo(usuarioConectado.getSaldo() + 79.8f);
		
		resu.setIdGame(1);
		resu.setIdTransaction(0);
		resu.setidUser(usuarioConectado.getIdUser());
		resu.setRodillo1("DiamantesA");
		resu.setRodillo2("DiamantesA");
		resu.setRodillo3("DiamantesA");
		resu.setPremio(premiooo);
		resu.setbet((float) 0.20);
		resu.setSaldo(usuarioConectado.getSaldo() + 79.8);
		

		userTableRepository.save(usuarioConectado);
		resultadosTableRepository.save(resu);
		
		System.out.println(resu);
		System.out.println(tirada);
		System.out.println(premiooo);
		return tirada;
		}
	
		else if(premiooo == "DiamantesR")
		{
			tirada.put("rodillo1","DiamantesR");
			tirada.put("rodillo2","DiamantesR");
			tirada.put("rodillo3","DiamantesR");
			tirada.put("IdGame","1");
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo() + 19.8));
			tirada.put("Premio", "20");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() + 19.8f);
	
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());
			resu.setRodillo1("DiamantesR");
			resu.setRodillo2("DiamantesR");
			resu.setRodillo3("DiamantesR");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() + 19.8);

			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
						
			System.out.println(resu);
			System.out.println(premiooo);
			System.out.println(tirada);
			
			return tirada;
			}
		else if(premiooo == "DiamantesV")
		{
			tirada.put("rodillo1","DiamantesV");
			tirada.put("rodillo2","DiamantesV");
			tirada.put("rodillo3","DiamantesV");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "8");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() + 7.8f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());
			resu.setRodillo1("DiamantesV");
			resu.setRodillo2("DiamantesV");
			resu.setRodillo3("DiamantesV");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() + 7.8);
			

			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
				
			System.out.println(resu);
			System.out.println(premiooo);
			System.out.println(tirada);
			return tirada;
			}
		else if(premiooo == "Campanas")
		{
			tirada.put("rodillo1","Campanas");
			tirada.put("rodillo2","Campanas");
			tirada.put("rodillo3","Campanas");
			tirada.put("IdGame","1");		 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "4");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() + 3.8f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());
			resu.setRodillo1("Campanas");
			resu.setRodillo2("Campanas");
			resu.setRodillo3("Campanas");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() + 3.8);
			

			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);

			
			System.out.println(resu);
			System.out.println(tirada);
			System.out.println(premiooo);
			
			return tirada;
			}
		else if(premiooo == "Fresas")
		{
			tirada.put("rodillo1","Fresas");
			tirada.put("rodillo2","Fresas");
			tirada.put("rodillo3","Fresas");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "3.20");
			tirada.put("GameMode", "DEMO");
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());
			resu.setRodillo1("Fresas");
			resu.setRodillo2("Fresas");
			resu.setRodillo3("Fresas");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() + 3);
	

			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
	
			System.out.println(resu);
			System.out.println(tirada);
			System.out.println(premiooo);
			
			return tirada;
			}
	
		else if(premiooo == "Limones")
		{
			tirada.put("rodillo1","Limones");
			tirada.put("rodillo2","Limones");
			tirada.put("rodillo3","Limones");
			tirada.put("IdGame","1");	 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "2.40");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() + 2.2f);
			
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());
			resu.setRodillo1("Limones");
			resu.setRodillo2("Limones");
			resu.setRodillo3("Limones");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() + 2.2);
				

			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
			
			System.out.println(resu);
			System.out.println(tirada);	
			System.out.println(premiooo);
			
			return tirada;
			}
	
		else if(premiooo == "Ciruelas")
		{
			tirada.put("rodillo1","Ciruelas");
			tirada.put("rodillo2","Ciruelas");
			tirada.put("rodillo3","Ciruelas");
			tirada.put("IdGame","1"); 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "1.60");
			tirada.put("GameMode", "DEMO");
			
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("Ciruelas");
			resu.setRodillo2("Ciruelas");
			resu.setRodillo3("Ciruelas");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() + 1.4);
			

			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
			
			System.out.println(resu);
			System.out.println(tirada);	
			System.out.println(premiooo);
			
			return tirada;
			}
		else if(premiooo == "Naranjas")
		{
			tirada.put("rodillo1","Naranjas");
			tirada.put("rodillo2","Naranjas");
			tirada.put("rodillo3","Naranjas");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0.80");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() + 0.6f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("Naranjas");
			resu.setRodillo2("Naranjas");
			resu.setRodillo3("Naranjas");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() + 0.6);
			

			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
			
			System.out.println(resu);	
			System.out.println(tirada);
			System.out.println(premiooo);
			
			return tirada;
			}
		else if(premiooo == "Diamantes3")
		{
			tirada.put("rodillo1","Diamantes3");
			tirada.put("rodillo2","Diamantes3");
			tirada.put("rodillo3","Diamantes3");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0.40");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() + 0.2f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("Diamantes3");
			resu.setRodillo2("Diamantes3");
			resu.setRodillo3("Diamantes3");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() + 0.2);
			
			
			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
			
			System.out.println(resu);
			System.out.println(tirada);
			System.out.println(premiooo);
			
			return tirada;
			
			}
		else if(premiooo == "Nada1")
		{
			tirada.put("rodillo1","DiamantesA");
			tirada.put("rodillo2","DiamantesA");
			tirada.put("rodillo3","Naranjas");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() - 0.2f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("DiamantesA");
			resu.setRodillo2("DiamantesA");
			resu.setRodillo3("Naranjas");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() - 0.2);
			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
			
			System.out.println(resu);
			System.out.println(tirada);
			System.out.println(premiooo);
			
			return tirada;
			
			}
		else if(premiooo == "Nada2") //hecho
		{
			tirada.put("rodillo1","DiamantesA");
			tirada.put("rodillo2","Naranjas");
			tirada.put("rodillo3","Fresas");
			tirada.put("IdGame","1");	 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() - 0.2f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("DiamantesA");
			resu.setRodillo2("Naranjas");
			resu.setRodillo3("Fresas");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() - 0.2);
			
			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);

			System.out.println(resu);
			System.out.println(premiooo);
			System.out.println(tirada);
			
			return tirada;
			
			}
		else if(premiooo == "Nada3") //hecho
		{
			tirada.put("rodillo1","Fresas");
			tirada.put("rodillo2","DiamantesA");
			tirada.put("rodillo3","Fresas");
			tirada.put("IdGame","1");		 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() - 0.2f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("Fresas");
			resu.setRodillo2("DiamantesA");
			resu.setRodillo3("Fresas");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() - 0.2);
			
			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
		
			System.out.println(resu);
			System.out.println(premiooo);
			System.out.println(tirada);
			
			return tirada;
			}
		else if(premiooo == "Nada4")
		{
			tirada.put("rodillo1","Limones"); //hecho
			tirada.put("rodillo2","DiamantesA");
			tirada.put("rodillo3","DiamantesA");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() - 0.2f);		
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("Limones");
			resu.setRodillo2("DiamantesA");
			resu.setRodillo3("DiamantesA");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() - 0.2);
			
			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
			
			System.out.println(resu);
			System.out.println(premiooo);
			System.out.println(tirada);
			
			return tirada;
			}
		else if(premiooo == "Nada5") //hecho
		{
			tirada.put("rodillo1","DiamantesA");
			tirada.put("rodillo2","Naranjas");
			tirada.put("rodillo3","Limones");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() - 0.2f);		
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("DiamantesA");
			resu.setRodillo2("Naranjas");
			resu.setRodillo3("Limones");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() - 0.2);
				
			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
			
			System.out.println(resu);
			System.out.println(tirada);
			System.out.println(premiooo);
			return tirada;
			}
		else if(premiooo == "Nada6") //hecho
		{
			tirada.put("rodillo1","Naranjas");
			tirada.put("rodillo2","Limones");
			tirada.put("rodillo3","DiamantesA");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() - 0.2f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("Naranjas");
			resu.setRodillo2("Limones");
			resu.setRodillo3("DiamantesA");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() - 0.2);
		
			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
		
			System.out.println(resu);
			System.out.println(tirada);
			System.out.println(premiooo);
			
			return tirada;
			}
		else if(premiooo == "Nada7") //hecho
		{
			tirada.put("rodillo1","Fresas");
			tirada.put("rodillo2","DiamantesV");
			tirada.put("rodillo3","DiamantesA");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() - 0.2f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("Fresas");
			resu.setRodillo2("DiamantesV");
			resu.setRodillo3("DiamantesA");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() - 0.2);
			
			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
		
			System.out.println(resu);
			System.out.println(premiooo);
			System.out.println(tirada);
			
			return tirada;
			
			}
		else if(premiooo == "Nada8") //hecho
		{
			tirada.put("rodillo1","DiamantesA");
			tirada.put("rodillo2","Limones");
			tirada.put("rodillo3","Limones");
			tirada.put("IdGame",".1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() - 0.2f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("DiamantesA");
			resu.setRodillo2("Limones");
			resu.setRodillo3("Limones");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() - 0.2);
		
			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
			
			System.out.println(resu);
			System.out.println(premiooo);
			System.out.println(tirada);
			
			return tirada;
			}
		else if(premiooo == "Nada9") //hecho
		{
			tirada.put("rodillo1","Limones");
			tirada.put("rodillo2","DiamantesV");
			tirada.put("rodillo3","Limones");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() - 0.2f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("Limones");
			resu.setRodillo2("DiamantesV");
			resu.setRodillo3("Limones");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() - 0.2);
			
			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
		
			System.out.println(resu);
			System.out.println(premiooo);
			System.out.println(tirada);
			return tirada;
			}
		else if(premiooo == "Nada10") //hecho
		{
			tirada.put("rodillo1","Fresas");
			tirada.put("rodillo2","Limones");
			tirada.put("rodillo3","Naranjas");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() - 0.2f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("Fresas");
			resu.setRodillo2("Limones");
			resu.setRodillo3("Naranjas");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() - 0.2);
			
			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
		
			System.out.println(resu);
			System.out.println(premiooo);
			System.out.println(tirada);
			
			return tirada;
			}
		else if(premiooo == "Nada11")
		{
			tirada.put("rodillo1","Limones");
			tirada.put("rodillo2","Fresas");
			tirada.put("rodillo3","Fresas");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() - 0.2f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("Limones");
			resu.setRodillo2("Fresas");
			resu.setRodillo3("Fresas");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() - 0.2);
		
			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
			
			System.out.println(resu);
			System.out.println(premiooo);
			System.out.println(tirada);
			return tirada;
			}
		else if(premiooo == "Nada12")
		{
			tirada.put("rodillo1","DiamantesA");
			tirada.put("rodillo2","Fresas");
			tirada.put("rodillo3","Ciruelas");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() - 0.2f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("DiamantesA");
			resu.setRodillo2("Fresas");
			resu.setRodillo3("Ciruelas");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() - 0.2);
			
			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
		
			System.out.println(resu);
			System.out.println(tirada);
			System.out.println(premiooo);
			
			return tirada;
			}
		else if(premiooo == "Nada13")
		{
			tirada.put("rodillo1","Fresas");
			tirada.put("rodillo2","Ciruelas");
			tirada.put("rodillo3","DiamantesA");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0");
			tirada.put("GameMode", "DEMO");
						
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() - 0.2f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());	
			resu.setRodillo1("Fresas");
			resu.setRodillo2("Ciruelas");
			resu.setRodillo3("DiamantesA");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() - 0.2);
			
			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
		
			
			System.out.println(resu);
			System.out.println(tirada);	
			System.out.println(premiooo);
			
			return tirada;
			}
		else if(premiooo == "Nada14")
		{
			tirada.put("rodillo1","DiamantesA");
			tirada.put("rodillo2","Fresas");
			tirada.put("rodillo3","DiamantesR");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()));
			tirada.put("Premio", "0");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() - 0.2f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);
			resu.setidUser(usuarioConectado.getIdUser());		
			resu.setRodillo1("DiamantesA");
			resu.setRodillo2("Fresas");
			resu.setRodillo3("DiamantesR");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setSaldo(usuarioConectado.getSaldo() - 0.2);
			
			
			System.out.println(resu);
			System.out.println(tirada);		
			System.out.println(premiooo);
			
			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
		
			return tirada;
			
			}
		else if(premiooo == "Nada15")
		{
			tirada.put("rodillo1","Ciruelas");
			tirada.put("rodillo2","Ciruelas");
			tirada.put("rodillo3","DiamantesA");
			tirada.put("IdGame","1");			 
			tirada.put("idUser", String.valueOf(usuarioConectado.getIdUser()));
			tirada.put("Saldo", String.valueOf(usuarioConectado.getSaldo()- 0.2));
			tirada.put("Premio", "0");
			tirada.put("GameMode", "DEMO");
			
			usuarioConectado.setSaldo(usuarioConectado.getSaldo() - 0.2f);
			
			resu.setIdGame(1);
			resu.setIdTransaction(0);			
			resu.setRodillo1("Ciruelas");
			resu.setRodillo2("Ciruelas");
			resu.setRodillo3("DiamantesA");
			resu.setPremio(premiooo);
			resu.setbet((float) 0.20);
			resu.setidUser(usuarioConectado.getIdUser());
			resu.setSaldo(usuarioConectado.getSaldo());

			userTableRepository.save(usuarioConectado);
			resultadosTableRepository.save(resu);
			
			System.out.println(resu);
			System.out.println(tirada);		
			System.out.println(premiooo);
			
			return tirada;
			
			}
		
		else return tirada;
	}
	

}