package com.redabeggar.TennisKata.service;

import com.redabeggar.TennisKata.model.Game;
import com.redabeggar.TennisKata.model.Player;
import com.redabeggar.TennisKata.model.TennisSet;
import com.redabeggar.TennisKata.model.Tiebreak;

public class TennisSetService implements ITennisSetService {

	private TennisSet tennisSet;
	private Game game;
	private Tiebreak tiebreak;
	private Player first_player;
	private Player second_player;
	private String display_score_message;

	@Override
	public void initialize(TennisSet tennisSet) {
		this.tennisSet = tennisSet;
		this.game = tennisSet.getGame();
		this.tiebreak = tennisSet.getTiebreak();
		this.first_player = game.getFirst_player();
		this.second_player = game.getSecond_player();
		this.display_score_message = "Set Score : " + first_player.getName() + " vs " + second_player.getName()
				+ " : ";
	}

	/* (non-Javadoc)
	 * @see com.redabeggar.TennisKata.service.ITennisSetService#getScore()
	 */
	@Override
	public String getScore() {
		if (hasWinner()) {
			return playerWithHighestScore().getName() + " wins";
		}

		if (isInTiebreak()) {
			return getTiebreakScore();
		}

		return display_score_message + first_player.getSetScore() + " - " + second_player.getSetScore();
	}

	@Override
	public boolean hasWinner() {
		if (scoreDifference() == 2 && playerWithHighestScore().getSetScore() >= 6) {
			tennisSet.setWinner(true);
			return true;
		}
	
		if(isInTiebreak())
		if (tiebreak.hasWinner())
				return true;

		return false;

	}

	@Override
	public int scoreDifference() {
		return Math.abs(first_player.getSetScore() - second_player.getSetScore());
	}

	@Override
	public Player playerWithHighestScore() {
		return (first_player.getSetScore() > second_player.getSetScore()) ? first_player : second_player;
	}
	
	@Override
	public void playerWinAGame(Player player) {
		player.WinAGame();
	}

	@Override
	public String getTiebreakScore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInTiebreak() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
