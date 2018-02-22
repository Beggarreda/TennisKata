package com.redabeggar.TennisKata.service;

import com.redabeggar.TennisKata.model.Game;
import com.redabeggar.TennisKata.model.Player;
import com.redabeggar.TennisKata.model.TennisSet;
import com.redabeggar.TennisKata.model.Tiebreak;

public class TennisSetService {

	private TennisSet tennisSet;
	private Game game;
	private Tiebreak tiebreak;
	private Player first_player;
	private Player second_player;
	private String display_score_message;

	public void initialize(TennisSet tennisSet) {
		this.tennisSet = tennisSet;
		this.game = tennisSet.getGame();
		this.tiebreak = tennisSet.getTiebreak();
		this.first_player = game.getFirst_player();
		this.second_player = game.getSecond_player();
		this.display_score_message = "Set Score : " + first_player.getName() + " vs " + second_player.getName()
				+ " : ";
	}

	public String getScore() {
		if (hasWinner()) {
			return playerWithHighestScore().getName() + " wins";
		}

		if (isInTiebreak()) {
			return getTiebreakScore();
		}

		return display_score_message + first_player.getSetScore() + " - " + second_player.getSetScore();
	}

	public boolean hasWinner() {
		if (scoreDifference() == 2 && playerWithHighestScore().getSetScore() >= 6)
			return true;

		if (tiebreak != null)
			if (tiebreak.hasWinner())
				return true;

		return false;

	}

	private int scoreDifference() {
		return Math.abs(first_player.getSetScore() - second_player.getSetScore());
	}

	public Player playerWithHighestScore() {
		return (first_player.getSetScore() > second_player.getSetScore()) ? first_player : second_player;
	}
	
	public void playerWinAGame(Player player) {
		player.WinAGame();
	}

	private String getTiebreakScore() {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean isInTiebreak() {
		// TODO Auto-generated method stub
		return false;
	}

}
