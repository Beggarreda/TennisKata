package com.redabeggar.TennisKata.service;

import com.redabeggar.TennisKata.model.Player;
import com.redabeggar.TennisKata.model.TennisSet;

public interface ITennisSetService  extends ITennisManager<TennisSet>{
	
	void playerWinAGame(Player player);

	String getTiebreakScore();

	boolean isInTiebreak();

}