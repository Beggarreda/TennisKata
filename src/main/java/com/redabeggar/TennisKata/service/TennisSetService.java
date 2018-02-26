package com.redabeggar.TennisKata.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.redabeggar.TennisKata.model.Game;
import com.redabeggar.TennisKata.model.Player;
import com.redabeggar.TennisKata.model.TennisSet;
import com.redabeggar.TennisKata.model.Tiebreak;

public class TennisSetService implements ITennisSetService {

	private TennisSet tennisSet;
	private Game game;
	private Tiebreak tiebreak;
	private Player first_player;
	private Player second_player;
	private String display_score_message;
	
	@Autowired
	TennisTiebreakService tennisTiebreakService;

	@Override
	public void initialize(TennisSet tennisSet) {
		this.tennisSet = tennisSet;
		this.game = tennisSet.getGame();
		this.tiebreak = tennisSet.getTiebreak();
		this.first_player = game.getFirst_player();
		this.second_player = game.getSecond_player();
		this.display_score_message = "Set Score : " + first_player.getName() + " vs " + second_player.getName() + " : ";
	}

	@Override
	public String getScore() {
		if (hasWinner()) {
			return playerWithHighestScore().getName() + " wins";
		}

		if (isInTiebreak()) {
			return getTiebreakScore();
		}

		return display_score_message + first_player.getSetScore() + " - " + second_player.getSetScore();
	}

	@Override
	public boolean hasWinner() {
		if (scoreDifference() >= 2 && playerWithHighestScore().getSetScore() >= 6) {
			tennisSet.setWinner(true);
			return true;
		}

		if (isInTiebreak())
			if (tennisTiebreakService.hasWinner())
				return true;

		return false;

	}

	@Override
	public int scoreDifference() {
		return Math.abs(first_player.getSetScore() - second_player.getSetScore());
	}

	@Override
	public Player playerWithHighestScore() {
		return (first_player.getSetScore() > second_player.getSetScore()) ? first_player : second_player;
	}

	@Override
	public void playerWinAGame(Player player) {
		player.WinAGame();
	}

	@Override
	public String getTiebreakScore() {
		return tennisTiebreakService.getScore();
	}

	@Override
	public boolean isInTiebreak() {
		if (first_player.getGameScore() == 6 && first_player.getGameScore() == second_player.getGameScore()) {
			tennisTiebreakService.initialize(createATiebreak());
			return true;
		}
		return false;

	}

	private Tiebreak createATiebreak() {
		this.tiebreak = new Tiebreak(this.tennisSet);
		this.tennisSet.setTiebreak(this.tiebreak);
		return this.tiebreak;
	}

}
