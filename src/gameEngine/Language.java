package gameEngine;

import boundaryToMatador.GUI;

public class Language {

	
	public void languageSelection(String input) {
		if(input.equals("Dansk")){
			GUI.create("fields-Dansk.txt");
			Game.typeNameOne = "Indtast navn for spiller 1"; 
			Game.typeNameTwo = "Indtast navn for spiller 2";
			Game.rollDice = "Kast Terning";
			Game.won = " VANDT!!!";
			Game.isWinner = " ER VINDEREN!!!";
			Game.draw = "SPILLET BLEV UAFGJORT";
		}else if(input.equals("English")){
			GUI.create("fields-English.txt");
			Game.typeNameOne = "Enter name for player 1";
			Game.typeNameTwo = "Enter name for player 2";
			Game.rollDice = "Roll Dice";
			Game.won = " WON!!!";
			Game.isWinner = " IS THE WINNER!!!";
			Game.draw = "THE GAME WAS A DRAW";
		}		
	}
}
	