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
		this.display_score_message = "Game Score : "+first_player.getName()
		                        +" vs "+second_player.getName()+ " : ";
	}

	@Override
	public String getScore() {

		if (hasWinner()) {
			return playerWithHighestScore() + " wins";
		}

		if (hasAdvantage()) {
			return "Advantage " + playerWithHighestScore();
		}

		if (isDeuce())
			return "Deuce";

		if (first_player.getGameScore() == second_player.getGameScore()) {
			return display_score_message+translateScore(first_player.getGameScore()) + " all";
		}

		return display_score_message+translateScore(first_player.getGameScore()) + "," + translateScore(second_player.getGameScore());
	}

	private boolean isDeuce() {
		return first_player.getGameScore() >= 3 && first_player.getGameScore() == second_player.getGameScore();
	}

	@Override
	public String playerWithHighestScore() {
		return (first_player.getGameScore() > second_player.getGameScore()) ? first_player.getName() : second_player.getName();
	}

	@Override
	public boolean hasWinner() {
		if (second_player.getGameScore() >= 4 && second_player.getGameScore() >= first_player.getGameScore() + 2) {
			game.setWinner(true);
			return true;
		}

		if (first_player.getGameScore() >= 4 && first_player.getGameScore() >= second_player.getGameScore() + 2) {
			game.setWinner(true);
			return true;
		}
		game.setWinner(false);
		return false;
	}

	private boolean hasAdvantage() {
		if (second_player.getGameScore() >= 4 && second_player.getGameScore() == first_player.getGameScore() + 1) {
			game.setAdvantage(true);
			return true;
		}

		if (first_player.getGameScore() >= 4 && first_player.getGameScore() == second_player.getGameScore() + 1) {
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
