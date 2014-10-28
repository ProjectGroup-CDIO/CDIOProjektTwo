package gameEngine;

import javax.swing.JOptionPane;

import boundaryToMatador.GUI;

public class Game {
	
	int PlayerOnePoints = 1000;
	int PlayerTwoPoints = 1000;
	
	int RollOne = 0;
	int RollTwo = 0;
	
	boolean playerOne = true;
	boolean playerTwo = false;
	boolean game = true;
		

public void game(){
	
	String characterOne = JOptionPane.showInputDialog("Enter name for Player One");
		char c = characterOne.charAt(0);
	String characterTwo = JOptionPane.showInputDialog("Enter name for Player Two");
		char v = characterTwo.charAt(0);
	
		
	GUI.create("fields2.txt");
	
	Die dieOne = new Die();
	dieOne.rollDie();
	Die dieTwo = new Die();
	dieTwo.rollDie();
	
	GUI.addPlayer(characterOne, 0, 0, 0, 0);	  // De tre sidste tal angiver farve p� bilen   
	GUI.addPlayer(characterTwo, 0, 255, 255, 255); // De tre sidste tal angiver farve p� bilen

	int felt = dieOne.faceValue + dieTwo.faceValue;
	
	GUI.setDice(dieOne.faceValue, dieTwo.faceValue);
    GUI.setCar(felt, "Lars");

	Player player1 = new Player("PlayerOne");
	Player player2 = new Player("PlayerTwo");
			
	GUI.setCar(1, "Poul");
	
	//GUI.addPlayer("PlayerOne", PlayerOnePoints);
	//GUI.addPlayer("PlayerTwo", PlayerTwoPoints);
	
	GUI.showMessage("OK");
	GUI.setCar(1, "Lars");
	GUI.removeCar(felt, "Lars");
	
	int trow=0;

	if(trow==2){
		System.out.println("Tower");
		player1.playerAcc.deposit(250);
		player2.playerAcc.deposit(250);
		
	}
	if(trow==3){
		System.out.println("Crater");
		player1.playerAcc.withdraw(200);
		player2.playerAcc.withdraw(200);
	}
	if(trow==4){
		System.out.println("Palace gates");
		player1.playerAcc.withdraw(100);
		player2.playerAcc.withdraw(100);
	}
	if(trow==5){
		System.out.println("Cold Desert");
		player1.playerAcc.withdraw(20);
		player2.playerAcc.withdraw(20);
	}
	if(trow==6){
		System.out.println("Walled city");
		player1.playerAcc.deposit(180);
		player2.playerAcc.deposit(180);
	}
	if(trow==7){
		System.out.println("Monastrery");
		player1.playerAcc.withdraw(0);
		player2.playerAcc.withdraw(0);
	}
	if(trow==8){
		System.out.println("Black cave");
		player1.playerAcc.withdraw(70);
		player2.playerAcc.withdraw(70);
	}
	if(trow==9){
		System.out.println("Huts in the mountain");
		player1.playerAcc.withdraw(60);
		player2.playerAcc.withdraw(60);
	}
	if(trow==10){
		System.out.println("The Werewall");
		player1.playerAcc.withdraw(80);
		player2.playerAcc.withdraw(80);
	}
	if(trow==11){
		System.out.println("The pit");
		player1.playerAcc.withdraw(90);
		player2.playerAcc.withdraw(90);
	}
	if(trow==12){
		System.out.println("The Goldmine");
		player1.playerAcc.deposit(650);
		player2.playerAcc.deposit(650);
	}

}
	
}
