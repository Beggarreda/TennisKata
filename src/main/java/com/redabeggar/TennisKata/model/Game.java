package com.redabeggar.TennisKata.model;

import com.redabeggar.TennisKata.Utils.Score;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Game {

	@NonNull
	private Player fisrt_player;
	@NonNull
	private Player second_player;
	private Score<String> score;
	private Score<Integer> score_helper;
	
}
