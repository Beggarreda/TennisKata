package com.redabeggar.TennisKata.service;

import com.redabeggar.TennisKata.model.Player;
import com.redabeggar.TennisKata.model.Tiebreak;

public interface ITennisTiebreakService extends ITennisManager<Tiebreak>{


	void playerScoreAPoint(Player player);


}