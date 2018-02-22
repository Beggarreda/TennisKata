package com.redabeggar.TennisKata.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Game {

	@NonNull
	private Player first_player;
	@NonNull
	private Player second_player;
	private boolean deuce;
	private boolean winner;
	private boolean advantage;
	private String playerWithHighestScore;

	public Game(Player first_player, Player second_player) {

		this.first_player = first_player;
		this.second_player = second_player;
	}

	public Player getFirst_player() {
		return first_player;
	}

	public void setFirst_player(Player first_player) {
		this.first_player = first_player;
	}

	public Player getSecond_player() {
		return second_player;
	}

	public void setSecond_player(Player second_player) {
		this.second_player = second_player;
	}


	public boolean isDeuce() {
		return deuce;
	}

	public void setDeuce(boolean deuce) {
		this.deuce = deuce;
	}

	public boolean hasWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public boolean hasAdvantage() {
		return advantage;
	}

	public void setAdvantage(boolean advantage) {
		this.advantage = advantage;
	}

	public String getPlayerWithHighestScore() {
		return playerWithHighestScore;
	}

	public void setPlayerWithHighestScore(String playerWithHighestScore) {
		this.playerWithHighestScore = playerWithHighestScore;
	}

    
    

	

}
