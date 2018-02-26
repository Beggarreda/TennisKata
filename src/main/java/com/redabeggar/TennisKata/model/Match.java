package com.redabeggar.TennisKata.model;

import java.util.ArrayList;

public class Match {
	
	private Player first_player; 
	private Player second_player; 
	private ArrayList<TennisSet> sets;
	private boolean winner;
	
	public Match(Player first_player, Player second_player, int nbrSets) {
		
		this.first_player = first_player;
		this.second_player = second_player;
		this.sets = new  ArrayList<>(nbrSets);
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

	public ArrayList<TennisSet> getSets() {
		return sets;
	}

	public void setSets(ArrayList<TennisSet> sets) {
		this.sets = sets;
	}

	public boolean hasWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	
	
	
	
	
}
