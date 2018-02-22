package com.redabeggar.TennisKata.service;

import com.redabeggar.TennisKata.model.Game;
import com.redabeggar.TennisKata.model.Player;

public interface IGameService {

	public void initialize(Game game);

	public String getScore();

	public String playerWithHighestScore();

	public boolean hasWinner();

	public void playerScores(Player player);

	public String translateScore(int score);

}