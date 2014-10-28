package gameEngine;

import boundaryToMatador.GUI;

public class Game {
	
	int PlayerOnePoints = 1000;
	int PlayerTwoPoints = 1000;
	
	int RollOne = 0;
	int RollTwo = 0;
	
	boolean playerOne = true;
	boolean playerTwo = false;
	boolean game = true;
	
	static String Felt = "";
	int feltPoint = 0;
	

public void game(){
	GUI.create("fields2.txt");
	
	Die dieOne = new Die();
	dieOne.rollDie();
	Die dieTwo = new Die();
	dieTwo.rollDie();
	
	GUI.setDice(dieOne.faceValue, dieTwo.faceValue);
	
	GUI.addPlayer("PlayerOne", PlayerOnePoints);
	GUI.addPlayer("PlayerTwo", PlayerTwoPoints);
	
	GUI.addPlayer("Lars", 0, 0, 0, 0);
	GUI.addPlayer("Poul", 0, 255, 255, 255);
}
	
}
