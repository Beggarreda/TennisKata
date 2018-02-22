package com.redabeggar.TennisKata.service;

import com.redabeggar.TennisKata.model.Player;

public interface ITennisManager<T> {

	void initialize(T initializer);

	String getScore();

	Player playerWithHighestScore();

	int scoreDifference();

	boolean hasWinner();

}