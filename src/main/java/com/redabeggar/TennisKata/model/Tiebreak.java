package com.redabeggar.TennisKata.model;

public class Tiebreak {

	private boolean winner;
	private TennisSet tennisSet;

	public Tiebreak(TennisSet tennisSet) {
		this.tennisSet = tennisSet;
	}

	public boolean hasWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public TennisSet getTennisSet() {
		return tennisSet;
	}

	public void setTennisSet(TennisSet tennisSet) {
		this.tennisSet = tennisSet;
	}
	
	

}
