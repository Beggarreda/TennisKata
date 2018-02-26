package com.redabeggar.TennisKata.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyObject;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.redabeggar.TennisKata.model.Game;
import com.redabeggar.TennisKata.model.Player;
import com.redabeggar.TennisKata.model.TennisSet;
import com.redabeggar.TennisKata.model.Tiebreak;

@RunWith(MockitoJUnitRunner.class)
public class TennisSetServiceTest {

	@InjectMocks
	TennisSetService tennisSetService;

	@Mock
	TennisTiebreakService tennisTiebreakService;

	private Player nadal;
	private Player reda;
	private Game game;
	private TennisSet tennisSet;
	private Tiebreak tiebeak;

	@Before
	public void setUp() {
		nadal = new Player("Nadal");
		reda = new Player("Reda");
		game = new Game(nadal, reda);
		tennisSet = new TennisSet(game);
		tennisSetService.initialize(tennisSet);
		tiebeak = new Tiebreak(tennisSet);
	}

	@Test
	public void should_return_zero_for_all_when_initializing_new_set() {

		assertThat(tennisSet.isInTiebfreak()).isEqualTo(false);
		assertThat(tennisSet.hasWinner()).isEqualTo(false);
		assertThat(tennisSetService.getScore()).isEqualTo("Set Score : Nadal vs Reda : 0 - 0");
	}

	@Test
	public void should_return_2_to_4_in_set_score() {

		createScore(2, 4);
		assertThat(tennisSetService.getScore()).isEqualTo("Set Score : Nadal vs Reda : 2 - 4");
	}

	@Test
	public void should_return_player_one_wins() {

		createScore(6, 4);
		assertThat(tennisSetService.getScore()).isEqualTo("Nadal wins");
	}

	@Test
	public void should_initialize_tiebreak_with_zero_for_all_in_score() {

		given( tennisTiebreakService.getScore()).willReturn("Tie-break Score : Nadal vs Reda : 0 - 0");
		createScore(6, 6);
		assertThat(tennisSetService.getScore()).isEqualTo("Tie-break Score : Nadal vs Reda : 0 - 0");
	}
	
	@Test
	public void should_return_player_one_wins_after_tiebreak() {

		given( tennisTiebreakService.getScore()).willReturn("Nadal wins");
		createScore(6, 6);
		assertThat(tennisSetService.getScore()).isEqualTo("Nadal wins");
	}

	private void createScore(int playerOneGames, int playerTwoGames) {

		IntStream.rangeClosed(1, playerOneGames).forEach((Integer) -> {
			tennisSetService.playerWinAGame(nadal);
		});

		IntStream.rangeClosed(1, playerTwoGames).forEach((Integer) -> {
			tennisSetService.playerWinAGame(reda);
		});
	}

}
