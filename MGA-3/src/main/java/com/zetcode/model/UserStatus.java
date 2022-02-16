package com.zetcode.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "userStatus")
public class UserStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idStatus")
	private Integer idStatus;

	@JoinColumn (name = "idUser", nullable = false)
	private int idUser;	
	
	@JoinColumn (name = "idGame", nullable =  false)
	private int idGame;
	
	@Column (name = "bonos")
	private int bonos;
 
	public UserStatus() {
		
	}

    public UserStatus(Integer idUser, Integer idGame, Integer bonos, Integer idStatus) {
    	super();
        this.idUser = idUser; 
        this.idGame = idGame;
        this.bonos = 0;
        this.idStatus = idStatus;
    }
  
    public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	public int getBonos() {
		return bonos;
	}

	public void setBonos(int bonos) {
		this.bonos = bonos;
	}

	@Override
    public int hashCode() {

        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idUser);
        hash = 79 * hash + Objects.hashCode(this.idGame);
        hash = 79 * hash + this.bonos;
        
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

        final UserStatus other = (UserStatus) obj;
        
        if (this.bonos != other.bonos) {
            return false;
        }
        if (!Objects.equals(this.idUser, other.idUser)) {
            return false;
        }

        return Objects.equals(this.idGame, other.idGame);
    }

    @Override
    public String toString() {

        var builder = new StringBuilder();
        builder.append("UserStatus{idUser=").append(idUser).append(", idGame=")
                .append(idGame).append(", Bonos=")
                .append(bonos).append("}");

        return builder.toString();
        
        
        }

}