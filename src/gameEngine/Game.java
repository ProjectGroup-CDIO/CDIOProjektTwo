package gameEngine;

import boundaryToMatador.GUI;

public class Game {
	
	//test - GUI

public void game(){
	GUI.create("fields2.txt");
	
	Die dieOne = new Die();
	dieOne.rollDie();
	Die dieTwo = new Die();
	dieTwo.rollDie();
	
	GUI.addPlayer("Lars", 0, 0, 0, 0);	  // De tre sidste tal angiver farve på bilen   
	GUI.addPlayer("Poul", 0, 255, 255, 255); // De tre sidste tal angiver farve på bilen

	int felt = (dieOne.faceValue + dieTwo.faceValue) - 1;
	
	GUI.setDice(dieOne.faceValue, dieTwo.faceValue);
    GUI.setCar(felt, "Lars");
	
}
	
}
