package com.redabeggar.TennisKata.service;

import com.redabeggar.TennisKata.model.Game;
import com.redabeggar.TennisKata.model.Player;

public interface ITennisGameService extends ITennisManager<Game> {

	void playerScores(Player player);

	boolean hasAdvantage();
	
	String translateScore(int score);

}