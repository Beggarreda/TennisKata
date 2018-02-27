package com.redabeggar.TennisKata.service;

import com.redabeggar.TennisKata.model.Match;
import com.redabeggar.TennisKata.model.Player;

public interface ITennisMatchService  extends ITennisManager<Match>{

	void PlayerWinASet(Player player);

}