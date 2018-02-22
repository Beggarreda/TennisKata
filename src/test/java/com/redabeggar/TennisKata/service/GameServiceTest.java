package com.redabeggar.TennisKata.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.redabeggar.TennisKata.model.Game;
import com.redabeggar.TennisKata.model.Player;

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
	    gameService.initialize(game);
	}
	
	@Test
	public void should_return_love_all_when_initializing_new_game() {
		
		assertThat(game.isDeuce()).isEqualTo(false);
		assertThat(game.hasWinner()).isEqualTo(false);
		assertThat(gameService.dispalyScore()).isEqualTo("Game Score : Nadal vs Reda : Love all");
		
	}
	
	@Test
	public void should_return_player_one_wins_first_ball() {
		
		gameService.playerScores(nadal);
		assertThat(gameService.dispalyScore()).isEqualTo("Game Score : Nadal vs Reda : Fifteen,Love");
		
	}
	
	@Test
	public void should_return_score_fifteen_all() {
		
		gameService.playerScores(nadal);
		gameService.playerScores(reda);
		assertThat(gameService.dispalyScore()).isEqualTo("Game Score : Nadal vs Reda : Fifteen all");
		
	}
	
	@Test
	public void should_return_player_two_wins_first_two_ball() {
		
		createScore(0,2);
		assertThat(gameService.dispalyScore()).isEqualTo("Game Score : Nadal vs Reda : Love,Thirty");
		
	}
	
	@Test
	public void should_return_players_are_deuce() {
		
		createScore(3,3);
		assertThat(gameService.dispalyScore()).isEqualTo("Deuce");
		
	}
	
	@Test
	public void should_return_player_two_has_advantage() {
		
		createScore(3,4);
		assertThat(gameService.dispalyScore()).isEqualTo("Advantage Reda");
		
	}
	
	@Test
	public void should_return_players_are_deuce_for_the_second_time() {
		
		createScore(4,4);
		assertThat(gameService.dispalyScore()).isEqualTo("Deuce");
		
	}
	
	@Test
	public void should_return_player_one_wins_the_game() {
		
		createScore(6,4);
		assertThat(gameService.dispalyScore()).isEqualTo("Nadal wins");
		
	}
	
	
	
	
	
	
	
	
	private void createScore(int playerOneBalls, int playerTwoBalls ) {
		IntStream.rangeClosed(1, playerOneBalls).forEach((Integer) -> {
    		gameService.playerScores(nadal);
        });
		
		IntStream.rangeClosed(1, playerTwoBalls).forEach((Integer) -> {
    		gameService.playerScores(reda);
        });
	}
	
	

}
