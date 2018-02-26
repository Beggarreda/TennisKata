package com.redabeggar.TennisKata.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.redabeggar.TennisKata.model.Game;
import com.redabeggar.TennisKata.model.Match;
import com.redabeggar.TennisKata.model.Player;
import com.redabeggar.TennisKata.model.TennisSet;

@RunWith(MockitoJUnitRunner.class)
public class TennisMatchServiceTest {

	@InjectMocks
	TennisMatchService tennisMatchService;
	
	@Mock
	TennisSetService tennisSetService;

	private Player nadal;
	private Player reda;
	private Game game;
	private TennisSet tennisSet;
	private Match tennisMatch;

	@Before
	public void setUp() {
		nadal = new Player("Nadal");
		reda = new Player("Reda");
		game = new Game(nadal, reda);
		tennisSet = new TennisSet(game);
		tennisMatch = new Match(nadal, reda,3);
		tennisMatchService.initialize(tennisMatch);
	}
	
	@Test
	public void should_return_zero_set_for_all_when_initializing_new_match(){
		
		assertThat(tennisMatch.hasWinner()).isEqualTo(false);
		assertThat(tennisMatchService.getScore()).isEqualTo("Match Score : Nadal vs Reda : 0 - 0");
	}
	
	@Test
	public void should_return_one_set_for_all_when_initializing_new_match(){
		tennisMatchService.PlayerWinASet(nadal);
		tennisMatchService.PlayerWinASet(reda);
		assertThat(tennisMatch.hasWinner()).isEqualTo(false);
		assertThat(tennisMatchService.getScore()).isEqualTo("Match Score : Nadal vs Reda : 1 - 1");
	}
	@Test
	public void should_return_player_one_wins_the_match(){
		tennisMatchService.PlayerWinASet(nadal);
		tennisMatchService.PlayerWinASet(reda);
		tennisMatchService.PlayerWinASet(nadal);
		assertThat(tennisMatch.hasWinner()).isEqualTo(false);
		assertThat(tennisMatchService.getScore()).isEqualTo("Nadal wins");
	}

}
