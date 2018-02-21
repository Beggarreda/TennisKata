package com.redabeggar.TennisKata.model;

import java.util.ArrayList;

public class Match {
	
	private Player first_player; 
	private Player second_player; 
	private ArrayList<Set> sets;
	
	public Match(Player first_player, Player second_player) {
		
		this.first_player = first_player;
		this.second_player = second_player;
	}
	
}
