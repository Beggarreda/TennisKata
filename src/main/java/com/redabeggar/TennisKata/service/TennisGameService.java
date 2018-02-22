package com.redabeggar.TennisKata.service;

import org.springframework.stereotype.Service;

import com.redabeggar.TennisKata.model.Game;
import com.redabeggar.TennisKata.model.Player;

@Service
public class TennisGameService implements ITennisGameService {

	private Game game;
	private Player first_player;
	private Player second_player;
	private String display_score_message;

	@Override
	public void initialize(Game game) {

		this.game = game;
		this.first_player = game.getFirst_player();
		this.second_player = game.getSecond_player();
		this.display_score_message = "Game Score : " + first_player.getName() + " vs " + second_player.getName()
				+ " : ";
	}

	@Override
	public String getScore() {

		if (hasWinner()) {
			return playerWithHighestScore().getName() + " wins";
		}

		if (hasAdvantage()) {
			return "Advantage " + playerWithHighestScore().getName();
		}

		if (isDeuce())
			return "Deuce";

		if (first_player.getGameScore() == second_player.getGameScore()) {
			return display_score_message + translateScore(first_player.getGameScore()) + " all";
		}

		return display_score_message + translateScore(first_player.getGameScore()) + ","
				+ translateScore(second_player.getGameScore());
	}

	private boolean isDeuce() {
		return first_player.getGameScore() >= 3 && first_player.getGameScore() == second_player.getGameScore();
	}

	@Override
	public Player playerWithHighestScore() {
		return (first_player.getGameScore() > second_player.getGameScore()) ? first_player : second_player;
	}

	@Override
	public boolean hasWinner() {
		if (scoreDifference() == 2 && playerWithHighestScore().getGameScore() >= 4) {
			game.setWinner(true);
			return true;
		}
		game.setWinner(false);
		return false;
	}

	@Override
	public boolean hasAdvantage() {
		if (scoreDifference() == 1 && playerWithHighestScore().getGameScore() >= 4) {
			game.setAdvantage(true);
			return true;
		}

		game.setAdvantage(false);
		return false;

	}

	@Override
	public void playerScores(Player player) {
		player.scoreAGamePoint();
	}

	@Override
	public int scoreDifference() {
		return Math.abs(first_player.getGameScore() - second_player.getGameScore());
	}

	@Override
	public String translateScore(int score) {
		switch (score) {
		case 3:
			return "Forty";
		case 2:
			return "Thirty";
		case 1:
			return "Fifteen";
		case 0:
			return "Love";
		}
		throw new IllegalArgumentException("Illegal score: " + score);
	}

}
