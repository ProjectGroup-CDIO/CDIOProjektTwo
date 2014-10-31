package gameEngine;

import javax.swing.JOptionPane;

import boundaryToMatador.GUI;

public class Game {
	
	int playerOnePoints = 1000;
	int playerTwoPoints = 1000;
	
	int RollOne = 0;
	int RollTwo = 0;
	
	boolean playerOne = true;
	boolean playerTwo = false;
	boolean game = true;
		
	

public void game(){
	
	String playerOneName = ""; 
	String playerTwoName = ""; 
	
	String[] choices = { "English", "Dansk"};
	String input = (String) JOptionPane.showInputDialog(null, "Choose language:",
			"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null,
			choices, 
			choices[1]); 
	System.out.println(input);
	
	if(input.equals("Dansk")){
		GUI.create("dansk.txt");
	}
	else if(input.equals("English")){
		GUI.create("fields2.txt");
	}
	if(input.equals("Dansk")){
		playerOneName = JOptionPane.showInputDialog("Indtast navn for Spiller Et"); //lets the player type in his or her name
		playerTwoName = JOptionPane.showInputDialog("Indtast navn for Spiller To");
	}else if(input.equals("English")){
		playerOneName = JOptionPane.showInputDialog("Enter name for Player One"); 
		playerTwoName = JOptionPane.showInputDialog("Enter name for Player Two");
	}

	
	
	String i = "";

	
	Die dieOne = new Die();
	Die dieTwo = new Die();
	
	GUI.addPlayer(playerTwoName, playerTwoPoints, 255, 255, 255); //last three arguments are RGB-color
	GUI.addPlayer(playerOneName, playerOnePoints, 0, 0, 0);	    
	

	

	Player player1 = new Player("PlayerOne");
	Player player2 = new Player("PlayerTwo");
			
	
	//GUI.addPlayer("PlayerOne", PlayerOnePoints);
	//GUI.addPlayer("PlayerTwo", PlayerTwoPoints);
	
	
	
	
	
	while(game) {
		
		i = GUI.getUserButtonPressed(null, "Roll Dice");
	
	if(i.equals("Roll Dice")){
		dieOne.rollDie();
		dieTwo.rollDie();
		int trow=dieOne.faceValue+dieTwo.faceValue;
		GUI.setDice(dieOne.faceValue, dieTwo.faceValue);
		if(playerOne) {
			GUI.removeCar(trow, playerTwoName);
			GUI.setCar(1, playerTwoName);
			GUI.setCar(trow, playerOneName); //sets car at field corresponding to sum of faceValues
			Fields.field(playerOne, playerTwo, player1, player2, trow, i);
			GUI.showMessage("PlayerTwos turn");
			playerTwo = true;
		}
		if(playerTwo) {
			GUI.removeCar(trow, playerOneName);
			GUI.setCar(1, playerOneName);
			GUI.setCar(trow, playerTwoName); 
			Fields.field(playerOne, playerTwo, player1, player2, trow, i);
			GUI.showMessage("PlayerOnes turn");
			playerOne = true;
		}
	
	
	
	}
	
//deleting the Feilds from Game
	}

}
	
}
