 package com.zetcode.model;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "transactions")

public class Transactions {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column
		private int idTransaction;
		@JoinColumn
		@JsonManagedReference
		private int idUser;
		@JoinColumn
		@JsonManagedReference
		private int idGame;
		@Column (name = "dateTime")
		private Date dateTime;
		@Column (name = "bet")
		private float bet;
		@Column (name = "profits")
		private float profits;
		 
		public Transactions() {
			
		}

		public Transactions(int idUser, int idGame, Date dateTime, float bet, float profits) {

		        this.idUser = idUser; 
		        this.idGame =  idGame;
		        this.dateTime = dateTime;
		        this.bet = bet;
		        this.profits = profits;
		}

			public int getidUser(){
				return  idUser;
			}
			
			public void setidUser(int idUser) {
				this.idUser = idUser;
				
			}
			
			public int getIdGame(){
				return  idGame;
			}
			
			public void setIdGame(int idGame) {
				this.idGame = idGame;
			}
			
			public Date getdateTime(){
				return  dateTime;
			}
			
			public void setdateTime(Date dateTime) {
				this.dateTime = dateTime;
				
			}
			
			public float getbet(){
				return  bet;
			}
			
			public void setbet(float bet) {
				this.bet = bet;
			}
			
			public float getprofits(){
				return  profits;
			}
			
			public void setprofits(float profits) {
				this.profits = profits;
			}
			@Override
		    public int hashCode() {

		        int hash = 7;
		        hash = 79 * hash + Objects.hashCode(this.idGame);
		        hash = 79 * hash + Objects.hashCode(this.idUser);
		        hash = 79 * hash + Objects.hashCode(this.dateTime);
		        hash = 79 * hash + Objects.hashCode(this.bet);
		        hash = 79 * hash + Objects.hashCode(this.profits);

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

		        final Transactions other = (Transactions) obj;

		        if (!Objects.equals(this.idUser, other.idUser)) {
		            return false;
		        }

		        return Objects.equals(this.idGame, other.idGame);
		    }

		    @Override
		    public String toString() {

		        var builder = new StringBuilder();
		        builder.append("Transactions{idUser=").append(idUser).append(", idGame=")
		                .append(idGame).append(", DateTime=")
		                .append(dateTime).append(", Bet=")
		                .append(bet).append(", Profits=").append(profits).append("}");

		        return builder.toString();
		    }

/*			public void setGames(Game ga) {
				// TODO Auto-generated method stub
				
			}

			public void setUsers(Users usu) {
				// TODO Auto-generated method stub
				
			}
*/
			
}
