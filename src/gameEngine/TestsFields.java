package gameEngine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestsFields {

	Player testPlay;
	
	@Before
	public void setup() throws Exception{
	testPlay = new Player("PlayerOne");
	}
	
	@Test //tower test
	public void testTower() {
	Fields.field(testPlay, 2, "Roll Dice");
	assertEquals(testPlay.playerAcc.balance,1250);
	}
	@Test //crater test
	public void testCrater() {
	Fields.field(testPlay, 3, "Roll Dice");
	assertEquals(testPlay.playerAcc.balance,800);
	}
	@Test //Palace gates test
	public void testPalaceGates() {
	Fields.field(testPlay, 4, "Roll Dice");
	assertEquals(testPlay.playerAcc.balance,900);
	}
	@Test //Cold Desert test
	public void testColdDesert() {
	Fields.field(testPlay, 5, "Roll Dice");
	assertEquals(testPlay.playerAcc.balance,980);
	}
	@Test //walled city test
	public void testWalledCity() {
	Fields.field(testPlay, 6, "Roll Dice");
	assertEquals(testPlay.playerAcc.balance,1180);
	}
	
	@Test //Monestary testx
	public void testMonestary() {
	Fields.field(testPlay, 7, "Roll Dice");
	assertEquals(testPlay.playerAcc.balance,1000);
	}
}
