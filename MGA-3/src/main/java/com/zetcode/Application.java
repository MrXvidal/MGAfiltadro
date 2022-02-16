package com.zetcode;

import java.sql.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.RNG.*;

@SpringBootApplication

public class Application {
	    public static void main( String[] args ) {
	    SpringApplication.run(Application.class, args);

        String jdbcUrl="jdbc:Mysql://localhost:3306/prueba?useSSL=false";
    	String usuario="root";
    	String password="Papelera5"; 
    	
    	try {
    		System.out.println("Conectando..." + jdbcUrl);
    		
    		Connection miConexion=(Connection) DriverManager.getConnection(jdbcUrl, usuario, password);
    		
    		System.out.println("CONECTADO");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
      
	    }
}

	    
	    
