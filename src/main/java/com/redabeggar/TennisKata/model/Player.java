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

	public void WinASet() {
		this.setScore++;
	}

	public int getTiebreakScore() {
		return tiebreakScore;
	}

	public void scoreATiebreakPoint() {
		this.tiebreakScore++;
	}
	
	
	
	
	

}
