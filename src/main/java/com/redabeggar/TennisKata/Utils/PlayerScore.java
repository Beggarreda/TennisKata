package com.redabeggar.TennisKata.Utils;

import com.redabeggar.TennisKata.model.Player;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerScore<ScoreType> {
	
	private Player player;
    private ScoreType score;
	
}
