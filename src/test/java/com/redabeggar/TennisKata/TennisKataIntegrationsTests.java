package com.redabeggar.TennisKata;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.redabeggar.TennisKata.model.Match;
import com.redabeggar.TennisKata.model.Player;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TennisKataIntegrationsTests {

	private Player nadal;
	private Player reda;
	private Match match;
	
	
	@Before
	public void setUp() {
		nadal = new Player("Nadal");
		reda = new Player("Reda");
		match = new Match(nadal,reda,3);
	}
	
	
}
