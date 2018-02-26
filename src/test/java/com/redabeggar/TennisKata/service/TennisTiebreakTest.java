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
import com.redabeggar.TennisKata.model.TennisSet;
import com.redabeggar.TennisKata.model.Tiebreak;

@RunWith(MockitoJUnitRunner.class)
public class TennisTiebreakTest {

	@InjectMocks
	TennisTiebreakService tennisTiebeakService;

	private Player nadal;
	private Player reda;
	private Game game;
	private TennisSet tennisSet;

	@Before
	public void setUp() {
		nadal = new Player("Nadal");
		reda = new Player("Reda");
		game = new Game(nadal, reda);
		tennisSet = new TennisSet(game);
		Tiebreak tiebreak = new Tiebreak(tennisSet);
		tennisTiebeakService.initialize(tiebreak);
	}

	@Test
	public void should_return_zero_for_all_when_initializing_new_tiebreak() {

		assertThat(tennisTiebeakService.getScore()).isEqualTo("Tie-break Score : Nadal vs Reda : 0 - 0");
	}
	
	@Test
	public void should_return_4_to_1_in_tiebeak_score() {
		
		createScore(4,1);
		assertThat(tennisTiebeakService.getScore()).isEqualTo("Tie-break Score : Nadal vs Reda : 4 - 1");
	}
	
	@Test
	public void should_return_player_one_wins() {
		
		createScore(7,4);
		assertThat(tennisTiebeakService.getScore()).isEqualTo("Nadal wins");
	}


	private void createScore(int playerOnePoints, int playerTwoPoints) {

		IntStream.rangeClosed(1, playerOnePoints).forEach((Integer) -> {
			tennisTiebeakService.playerScoreAPoint(nadal);
			;
		});

		IntStream.rangeClosed(1, playerTwoPoints).forEach((Integer) -> {
			tennisTiebeakService.playerScoreAPoint(reda);
		});
	}

}
