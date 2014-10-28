package gameEngine;

import boundaryToMatador.GUI;

public class Game {
	
	//test - GUI

public void Game(){
	GUI.create("fields2.txt");
	
	Die dieOne = new Die();
	dieOne.rollDie();
	Die dieTwo = new Die();
	dieTwo.rollDie();
	
	GUI.setDice(dieOne.faceValue, dieTwo.faceValue);
	
	
	GUI.addPlayer("Lars", 0, 255, 0, 0);
	GUI.addPlayer("Poul", 0, 0, 0, 255);
}
	
}
