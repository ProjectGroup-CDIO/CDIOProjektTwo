package gameEngine;

import boundaryToMatador.GUI;

public class Language {

	
	public void languageSelection(String input) {
		if(input.equals("Dansk")){
			GUI.create("fields-Dansk.txt");
			Game.setTypeNameOne("Indtast navn for spiller 1"); 
			Game.setTypeNameTwo("Indtast navn for spiller 2");
			Game.setRollDice("Kast Terning");
			Game.setWon(" VANDT!!!");
			Game.setIsWinner(" ER VINDEREN!!!");
			Game.setDraw("SPILLET BLEV UAFGJORT");
		}else if(input.equals("English")){
			GUI.create("fields-English.txt");
			Game.setTypeNameOne("Enter name for player 1");
			Game.setTypeNameTwo("Enter name for player 2");
			Game.setRollDice("Roll Dice");
			Game.setWon(" WON!!!");
			Game.setIsWinner(" IS THE WINNER!!!");
			Game.setDraw("THE GAME WAS A DRAW");
		}		
	}
}
	