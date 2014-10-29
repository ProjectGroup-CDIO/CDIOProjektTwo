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
	
	String playerOneName = JOptionPane.showInputDialog("Enter name for Player One"); //lets the player type in his or her name
	String playerTwoName = JOptionPane.showInputDialog("Enter name for Player Two");
		
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
	
	
		
	GUI.create("fields2.txt");
	
	String i = "";

	i = GUI.getUserButtonPressed(null, "Roll Dice");
	
	Die dieOne = new Die();
	dieOne.rollDie();
	Die dieTwo = new Die();
	dieTwo.rollDie();
	
	GUI.addPlayer(playerTwoName, playerTwoPoints, 255, 255, 255); //last three arguments are RGB-color
	GUI.addPlayer(playerOneName, playerOnePoints, 0, 0, 0);	    

	// TEST MED GUI
	
	int felt = dieOne.faceValue + dieTwo.faceValue;
	
	GUI.setDice(dieOne.faceValue, dieTwo.faceValue);
    GUI.setCar(felt, playerOneName);

	Player player1 = new Player("PlayerOne");
	Player player2 = new Player("PlayerTwo");
			
	GUI.setCar(1, playerTwoName);
	
	//GUI.addPlayer("PlayerOne", PlayerOnePoints);
	//GUI.addPlayer("PlayerTwo", PlayerTwoPoints);
	
	GUI.showMessage("OK");
	GUI.setCar(1, playerOneName);
	GUI.removeCar(felt, playerOneName);
	
	// Tilf�jet spiller-navnene, s�ledes at bilerne f�lger den spiller navnet tilh�rer
	
	// SLUT TEST MED GUI
	
	while(game) {
		
	
	if(i.equals("Roll Dice")){
	int trow=dieOne.rollDie()+dieTwo.rollDie();
	
	Fields.field(playerOne, playerTwo, player1, player2, trow, i);
	
	}
//deleting the Feilds from Game
	}

}
	
}
