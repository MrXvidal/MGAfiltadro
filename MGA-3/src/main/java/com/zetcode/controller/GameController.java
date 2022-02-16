package com.zetcode.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zetcode.model.Game;
import com.zetcode.repository.GameTableRepository;
 
@Controller
@RestController
@RequestMapping(path="/game")
public class GameController {
	@Autowired
	private GameTableRepository gameRepository;
	private JpaRepository<Game, Integer> gameTableRepository;
	
	@RequestMapping("/all")
	public Iterable<Game> getGame() {
        return gameRepository.findAll();
    }
}