package com.zetcode.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idUser;
	@Column (name = "Name")
	private String Name;
	@Column (name = "password")
	private String password;
	@Column (name = "balance")
	private String balance;
	@Column (name = "saldo")
	private float saldo;


		public Users(String Name, String Password, String Balance, float Saldo) {
	        this.Name = Name; 
	        this.password =  Password;
	        this.balance = Balance;
	        this.saldo = Saldo;
	    }
		
		
	public Users() {
		
	}
	public int getIdUser(){
		return  idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
		
	}
	
	public String getName(){
		return  Name;
	}
	
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getPassword(){
		return  password;
	}
	
	public void setPassword(String password) {
		this.password = password;
		
	}
	
	public String getBalance(){
		return  balance;
	}
	
	public void setBalance(String balance) {
		this.balance = balance;
	}
   public float getSaldo() {
    	return saldo;
    }
    public void setSaldo(float saldo) {
    	this.saldo = saldo;
    }
	 @Override
	    public int hashCode() {

	        int hash = 7;
	        hash = 79 * hash + Objects.hashCode(this.idUser);
	        hash = 79 * hash + Objects.hashCode(this.Name);
	        hash = 79 * hash + Objects.hashCode(this.password);
	        hash = 79 * hash + Objects.hashCode(this.balance);
	        hash = 79 * hash + Objects.hashCode(this.saldo);
	        return hash;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }

	        final Users other = (Users) obj;

	        if (!Objects.equals(this.idUser, other.idUser)) {
	            return false;
	        }

	        return Objects.equals(this.Name, other.Name);
	    }

	    @Override
	    public String toString() {

	        var builder = new StringBuilder();
	        builder.append("Users{idUser=").append(idUser).append
	        (", Name=").append(Name).append
	        (", Password=").append(password).append
	        (", Balance=").append(balance).append
	        (", Saldo=").append(saldo).append("}");


	        return builder.toString();
	    }

}
