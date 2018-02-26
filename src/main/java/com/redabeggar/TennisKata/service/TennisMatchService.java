package com.redabeggar.TennisKata.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.redabeggar.TennisKata.model.Game;
import com.redabeggar.TennisKata.model.Match;
import com.redabeggar.TennisKata.model.Player;
import com.redabeggar.TennisKata.model.TennisSet;
import com.redabeggar.TennisKata.model.Tiebreak;

public class TennisMatchService implements ITennisManager<Match> {

	private Match match;
	private TennisSet tennisSet;
	private Game game;
	private Tiebreak tiebreak;
	private Player first_player;
	private Player second_player;
	private String display_score_message;

	@Autowired
	ITennisTiebreakService tennisTiebreakService;

	@Override
	public void initialize(Match match) {
		this.match = match;
//		this.tennisSet = tennisSet;
//		this.game = tennisSet.getGame();
//		this.tiebreak = tennisSet.getTiebreak();
		this.first_player = match.getFirst_player();
		this.second_player = match.getSecond_player();
		this.display_score_message = "Match Score : " + first_player.getName() + " vs " + second_player.getName() + " : ";
	}

	@Override
	public String getScore() {
		if (hasWinner()) {
			return playerWithHighestScore().getName() + " wins";
		}

		return display_score_message + first_player.getMatchScore() + " - " + second_player.getMatchScore();
	}

	@Override
	public Player playerWithHighestScore() {
		return (first_player.getMatchScore() > second_player.getMatchScore()) ? first_player : second_player;

	}

	@Override
	public int scoreDifference() {
		return Math.abs(first_player.getMatchScore() - second_player.getMatchScore());
	}

	@Override
	public boolean hasWinner() {
		if (playerWithHighestScore().getMatchScore() == 2) {
			return true;
		}
		return false;

	}
	
	public void PlayerWinASet(Player player) {
		player.winASet();		
	}

}
