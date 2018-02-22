package com.redabeggar.TennisKata.model;

import lombok.Data;

@Data
public class TennisSet {

	private Game game;
	private Tiebreak tiebreak;
	private boolean inTiebfreak;
	private boolean winner;

	public TennisSet(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Tiebreak getTiebreak() {
		return tiebreak;
	}

	public void setTiebreak(Tiebreak tiebreak) {
		this.tiebreak = tiebreak;
	}

	public boolean isInTiebfreak() {
		return inTiebfreak;
	}

	public void setInTiebfreak(boolean inTiebfreak) {
		this.inTiebfreak = inTiebfreak;
	}
	
	public boolean hasWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	
	
}
