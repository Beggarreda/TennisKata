package com.redabeggar.TennisKata.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.redabeggar.TennisKata.model.Game;
import com.redabeggar.TennisKata.model.Player;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {
	
	
	@InjectMocks
	GameService gameService;
	
	
	private Player nadal;
	private Player reda;
	private Game game;
	
	@Before
	public void setUp() {
		nadal = new Player("Nadal");
		reda = new Player("Reda");
	    game = new Game(nadal,reda);
	}
	
	@Test
	public void should_return_love_all_when_initializing_new_game() {
		
		gameService.initialize(game);
		assertThat(game.isDeuce()).isEqualTo(false);
		assertThat(game.hasWinner()).isEqualTo(false);
		assertThat(gameService.dispalyScore()).isEqualTo("Game Score : Nadal vs Reda : Love all");
		
	}
	
	

}
