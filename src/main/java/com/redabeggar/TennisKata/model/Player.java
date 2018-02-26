package com.redabeggar.TennisKata.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Player {

	@NonNull
	private String name;
	private int gameScore ;
	private int setScore;
	private int matchScore;
	private int tiebreakScore;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGameScore() {
		return gameScore;
	}

	public void scoreAGamePoint() {
		this.gameScore++;
	}

	public int getSetScore() {
		return setScore;
	}

	public void WinAGame() {
		this.setScore++;
	}

	public int getTiebreakScore() {
		return tiebreakScore;
	}

	public void scoreATiebreakPoint() {
		this.tiebreakScore++;
	}

	public int getMatchScore() {
		return matchScore;
	}

	public void winASet() {
		this.matchScore++;
	}

	public void setGameScore(int gameScore) {
		this.gameScore = gameScore;
	}

	public void setSetScore(int setScore) {
		this.setScore = setScore;
	}

	public void setMatchScore(int matchScore) {
		this.matchScore = matchScore;
	}

	public void setTiebreakScore(int tiebreakScore) {
		this.tiebreakScore = tiebreakScore;
	}
	
	
	
	
	
	
	
	

}
