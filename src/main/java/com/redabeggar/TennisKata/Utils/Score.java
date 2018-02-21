package com.redabeggar.TennisKata.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Score<ScoreType>{

	private PlayerScore first_player;
	private PlayerScore second_player;
	
	
	
}
