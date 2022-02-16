/*package com.zetcode;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.zetcode.model.Game;
import com.zetcode.model.Resultados;
import com.zetcode.model.Transactions;
import com.zetcode.model.UserStatus;
import com.zetcode.model.Users;
import com.zetcode.repository.GameTableRepository;
import com.zetcode.repository.ResultadosTableRepository;
import com.zetcode.repository.TransactionsTableRepository;
import com.zetcode.repository.UserStatusTableRepository;
import com.zetcode.repository.UsersTableRepository;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private GameTableRepository gameTableRepository;
    @Autowired
    private UsersTableRepository usersTableRepository;
    @Autowired
    private UserStatusTableRepository userStatusTableRepository;
    @Autowired
    private TransactionsTableRepository transactionsTableRepository;
    @Autowired
    private ResultadosTableRepository resultadosTableRepository;
   
    @Override
    public void run(String... args) throws Exception {
    	
  /*  	Game g1 = new Game(1,"Western");
    	Game g2 = new Game(2,"GranSafary");
    	
    	gameTableRepository.save(g1);
    	gameTableRepository.save(g2);
    	    	
    	Users u1 = new Users("Paco", "1234", "200");
    	Users u2 = new Users("Kun", "2234", "300");
    	
    	usersTableRepository.save(u1);
    	usersTableRepository.save(u2);
    	
    	UserStatus  us1 = new UserStatus(u1.getIdUser(), g2.getIdGame(), 15, null);
    	UserStatus us2 = new UserStatus(u2.getIdUser(), g1.getIdGame(), 17, null);	
    	
    	   
    	userStatusTableRepository.save(us1);
    	userStatusTableRepository.save(us2);
    	
    	Transactions t1 = new Transactions(u1.getIdUser(),g2.getIdGame(), null, 2, 25);
    		
    	transactionsTableRepository.save(t1); 
    	
    	    	
     	Resultados r1 =  new Resultados(u1.getIdUser(),g1.getIdGame(),0, "DiamantesA", "DiamantesA" , "DiamantesA" , "DiamantesA"); 
        
     	Resultados r2 =  new Resultados(u2.getIdUser(),g2.getIdGame(),0, "DiamantesR", "DiamantesR" , "DiamantesR" , "DiamantesR");

        Resultados r3 =  new Resultados(u2.getIdUser(),g2.getIdGame(),0, "DiamantesV", "DiamantesV" , "DiamantesV" , "DiamantesV ");

        Resultados r4 =  new Resultados(u2.getIdUser(),g2.getIdGame(),0, "Campanas", "Campanas" , "Campanas" , "Campanas");

        Resultados r5 =  new Resultados(u2.getIdUser(),g2.getIdGame(),0, "Fresas", "Fresas" , "Fresas" , "Fresas");

        Resultados r6 =  new Resultados(u2.getIdUser(),g2.getIdGame(),0, "Limones", "Limones" , "Limones" , "Limones");

        Resultados r7 =  new Resultados(u2.getIdUser(),g2.getIdGame(),0, "Ciruelas", "Ciruelas" , "Ciruelas" , "Ciruelas");

        Resultados r8 =  new Resultados(u2.getIdUser(),g2.getIdGame(),0, "Naranjas", "Naranjas" , "Naranjas" , "Naranjas ");

        Resultados r9 =  new Resultados(u2.getIdUser(),g2.getIdGame(),0, "Diamantes3", "Diamantes3" , "Diamantes3" , "Diamantes3");

        Resultados r10 = new Resultados(u2.getIdUser(),g2.getIdGame(),0, "NADA", "NADA" , "NADA" , "NADA "); */
    	
    	/*																																		
    		resultadosTableRepository.save(r1);
    		resultadosTableRepository.save(r2);
    		resultadosTableRepository.save(r3);
    		resultadosTableRepository.save(r4);
    		resultadosTableRepository.save(r5);
    		resultadosTableRepository.save(r6);
    		resultadosTableRepository.save(r7);
    		resultadosTableRepository.save(r8);
    		resultadosTableRepository.save(r9);
    		resultadosTableRepository.save(r10);
    		 */
    	//	Resultados [] Resultados = new Resultados[] {r1}; //,r2,r3,r4,r5,r6,r7,r8,r9,r10};
    	/*
        logger.info("### Juegos registrados: {}", gameTableRepository.count());
        logger.info("### Jugadores registrados: {}", usersTableRepository.count());
        logger.info("### La apuesta es: {}", transactionsTableRepository.count());
      
        
        var game = gameTableRepository.findAll();
        var users = usersTableRepository.findAll();
        var userStatus = userStatusTableRepository.findAll();
        var transactions = transactionsTableRepository.findAll();
        var resultados = resultadosTableRepository.findAll();
        
        
        logger.info("{}", game);
        logger.info("{}", users);
        logger.info("{}", userStatus);
        logger.info("{}", transactions);
        logger.info("{}", resultados); 

        logger.info("------------------------");

        logger.info("--------FIN-----------");
	

    }

}*/