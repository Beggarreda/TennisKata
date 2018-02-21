package com.redabeggar.TennisKata.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Player {

	private Long id;
	@NonNull
	private String name;

	public Player(String name) {
		this.name = name;
	}

}
