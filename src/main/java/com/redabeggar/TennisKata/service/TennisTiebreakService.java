package com.redabeggar.TennisKata.service;

import com.redabeggar.TennisKata.model.Game;
import com.redabeggar.TennisKata.model.Player;
import com.redabeggar.TennisKata.model.TennisSet;
import com.redabeggar.TennisKata.model.Tiebreak;

public class TennisTiebreakService implements ITennisTiebreakService {

	private TennisSet tennisSet;
	private Game game;
	private Player first_player;
	private Player second_player;
	private String display_score_message;

	@Override
	public void initialize(Tiebreak tiebreak) {
		this.tennisSet = tiebreak.getTennisSet();
		this.game = this.tennisSet.getGame();
		this.first_player = game.getFirst_player();
		this.second_player = game.getSecond_player();
		this.display_score_message = "Tie-break Score : " + first_player.getName() + " vs " + second_player.getName()
				+ " : ";
	}

	@Override
	public String getScore() {
		if (hasWinner()) {
			return playerWithHighestScore().getName() + " wins";
		}
		return display_score_message + first_player.getTiebreakScore() + " - " + second_player.getTiebreakScore();
	}

	@Override
	public void playerScoreAPoint(Player player) {
		player.scoreATiebreakPoint();
	}

	@Override
	public Player playerWithHighestScore() {
		return (first_player.getTiebreakScore() > second_player.getTiebreakScore()) ? first_player : second_player;
	}

	@Override
	public boolean hasWinner() {
		if (scoreDifference() >= 2 && playerWithHighestScore().getTiebreakScore() >= 7) {
			return true;
		}
		return false;
	}

	@Override
	public int scoreDifference() {
		return Math.abs(first_player.getTiebreakScore() - second_player.getTiebreakScore());
	}

}
