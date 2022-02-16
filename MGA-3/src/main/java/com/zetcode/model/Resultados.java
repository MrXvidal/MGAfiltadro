package com.zetcode.model;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "resultados")

public class Resultados {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn (name = "idTransaction")
	private int idTransaction;
	@JoinColumn (name = "idUser")
	private int idUser;
	@JoinColumn (name = "idGame")
	private int idGame;
	@Column
	private String Premio;
	@Column
	private String Rodillo1;
	@Column
	private String Rodillo2;
	@Column
	private String Rodillo3;
	@Column (name = "bet")
	private float bet;
	@Column (name = "saldo")
	private  float saldo;
	@Column (name = "dateTime", length = 19,nullable = false, 
			updatable = false, insertable = false, 
			columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private  Date dateTime;
		
	public Resultados() {

	}

	public Resultados(int idTransaction, int idUser, int idGame, String Premio, String Rodillo1, String Rodillo2, String Rodillo3, float saldo, Date dateTime) {

		this.idTransaction = idTransaction;
		this.idUser = idUser;
		this.idGame = idGame;
		this.Premio = Premio;
		this.Rodillo1 = Rodillo1;
		this.Rodillo2 = Rodillo2;
		this.Rodillo3 = Rodillo3;
		this.saldo =  saldo;
		this.dateTime = dateTime;

	}


	public  Date getDateTime() {
		return dateTime;
	}

	public  void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public float getBet() {
		return bet;
	}

	public void setBet(float bet) {
		this.bet = bet;
	}

	public  double getSaldo() {
		return saldo;
	}

	public  void setSaldo(double d) {
		this.saldo = (float) d;
	}
	public int getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}

	public int getidUser() {
		return idUser;
	}

	public void setidUser(int idUser) {
		this.idUser = idUser;

	}

	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	public String getPremio() {
		return Premio;
	}

	public void setPremio(String premio) {
		Premio = premio;
	}

	public String getRodillo1() {
		return Rodillo1;
	}

	public void setRodillo1(String rodillo1) {
		Rodillo1 = rodillo1;
	}

	public String getRodillo2() {
		return Rodillo2;
	}

	public void setRodillo2(String rodillo2) {
		Rodillo2 = rodillo2;
	}

	public String getRodillo3() {
		return Rodillo3;
	}

	public void setRodillo3(String rodillo3) {
		Rodillo3 = rodillo3;
	}
	public float getbet(){
		return  bet;
	}
	
	public void setbet(float bet) {
		this.bet = bet;
	}
	

	@Override
	public int hashCode() {

		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.idGame);
		hash = 79 * hash + Objects.hashCode(this.idUser);
		hash = 79 * hash + Objects.hashCode(this.Premio);
		hash = 79 * hash + Objects.hashCode(this.Rodillo1);
		hash = 79 * hash + Objects.hashCode(this.Rodillo2);
		hash = 79 * hash + Objects.hashCode(this.Rodillo3);
		hash = 79 * hash + Objects.hashCode(this.idTransaction);
		hash = 79 * hash + Objects.hashCode(this.saldo);
		hash = 79 * hash + Objects.hashCode(this.dateTime);
		

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

		final Resultados other = (Resultados) obj;

		if (!Objects.equals(this.Premio, other.Premio)) {
			return false;
		}

		return Objects.equals(this.idTransaction, other.idTransaction);
	}

	@Override
	public String toString() {

		var builder = new StringBuilder();
		builder.append("Resultado { Premio= ").append(Premio).append
		(" idUser=").append(idUser).append
		(", idGame=").append(idGame).append
		(", idTransaction=").append(idTransaction).append
		(", Rodillo1=").append(Rodillo1).append
		(", Rodillo2=").append(Rodillo2).append
		(", Rodillo3=").append(Rodillo3).append
		(", Saldo=").append(saldo).append
		(", Fecha=").append(dateTime).append
		(" BET = ").append(bet).append("}");
				
		return builder.toString();
	}



}