package gameEngine;

import javax.swing.JOptionPane;

import boundaryToMatador.GUI;

public class Game {
	
	Player player1 = new Player("PlayerOne");
	Player player2 = new Player("PlayerTwo");
	
	/*int playerOnePoints = player1.playerAcc.balance;
	int playerTwoPoints = player2.playerAcc.balance;
	*/
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
		playerOneName = GUI.getUserString("Indtast Navn - Spiller 1");
		playerTwoName = GUI.getUserString("Indtast Navn - Spiller 2");

	}else if(input.equals("English")){
		playerOneName = GUI.getUserString("Type name - Player 1");
		playerTwoName = GUI.getUserString("Type name - Player 2");
		
	}
	
	
	
	String i = "";

	
	Die dieOne = new Die();
	Die dieTwo = new Die();
	
	GUI.addPlayer(playerTwoName, player2.playerAcc.balance, 255, 255, 255); //last three arguments are RGB-color
	GUI.addPlayer(playerOneName, player1.playerAcc.balance, 0, 0, 0);	    
	
	
	while(game) {
		
		i = GUI.getUserButtonPressed(null, "Roll Dice");
	
	if(i.equals("Roll Dice")){
		dieOne.rollDie();
		dieTwo.rollDie();
		int trow=dieOne.faceValue+dieTwo.faceValue;
		GUI.setDice(dieOne.faceValue, dieTwo.faceValue);
		if(playerOne) {
			GUI.removeAllCars(playerOneName);//In case of throw == 7
			GUI.setCar(1, playerOneName);
			GUI.removeAllCars(playerTwoName);
			GUI.setCar(1, playerTwoName);
			GUI.removeCar(1, playerOneName);
			GUI.setCar(trow, playerOneName); //sets car at field corresponding to sum of faceValues
			Fields.field(playerOne, playerTwo, player1, player2, trow, i);
			GUI.setBalance(playerOneName, player1.playerAcc.balance);
			//GUI.showMessage("PlayerTwos turn");
		}
		if(playerTwo) {
			GUI.removeAllCars(playerOneName);
			GUI.setCar(1, playerOneName);
			GUI.removeAllCars(playerTwoName);//In case of trow == 7
			GUI.setCar(1, playerTwoName);
			GUI.removeCar(1, playerTwoName);
			GUI.setCar(trow, playerTwoName); 
			Fields.field(playerOne, playerTwo, player1, player2, trow, i);
			GUI.setBalance(playerTwoName, player2.playerAcc.balance);
			//GUI.showMessage("PlayerOnes turn");
		}
		if(trow==7){
			continue;
		}
		else if(playerOne){
			playerOne = false;
			playerTwo =true;
		}
		else if(playerTwo){
			playerOne = true;
			playerTwo = false;
		}
	
	}
	
	}

}
	
}
