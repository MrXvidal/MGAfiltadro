package com.zetcode.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "game")
public class Game  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idGame")
	
    private int idGame;	

	@Column (name = "idName")
    private String idName;
    
	/*@OneToMany(mappedBy = "game",cascade = CascadeType.ALL )
	@JsonBackReference
    private Set<UserStatus> userstatus = new HashSet<UserStatus>();
	
	
	@OneToMany(mappedBy = "game",cascade = CascadeType.ALL)
	@JsonBackReference
    private Set<Transactions> transactions = new HashSet<Transactions>();*/

	
    public Game() {

	}


	public Game(int idGame,String idName) {
		this.idGame = idGame;
    	this.idName = idName;
    }

 
    public int getIdGame() {
		return idGame;
	}
	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}
	public String getIdName() {
        return this.idName;
    }

		// DE AQUI PARA ABAJO ES PARA MOSTRAR POR CONSOLA LA TABALA "game"
    @Override
    public int hashCode() {

        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idGame);
        hash = 79 * hash + Objects.hashCode(this.idName);

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

        final Game other = (Game) obj;

        if (!Objects.equals(this.idName, other.idName)) {
            return false;
        }

        return Objects.equals(this.idGame, other.idGame);
    }

    @Override
    public String toString() {

        var builder = new StringBuilder();
        builder.append("Game{idGame=").append(idGame).append(", Name=")
                .append(idName);
    
        return builder.toString();
    }
    
        public String toString1() {
            final StringBuilder sb = new StringBuilder("Game{idGame=");sb.append(idGame);sb.append(", Name=")
                    .append(idName);
            return sb.toString();
        } 
    }
    
    
    
