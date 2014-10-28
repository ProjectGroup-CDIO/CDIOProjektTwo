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
		

public void game(){
	GUI.create("fields2.txt");
	
	Die dieOne = new Die();
	dieOne.rollDie();
	Die dieTwo = new Die();
	dieTwo.rollDie();
	
	GUI.addPlayer("Lars", 0, 0, 0, 0);	  // De tre sidste tal angiver farve p� bilen   
	GUI.addPlayer("Poul", 0, 255, 255, 255); // De tre sidste tal angiver farve p� bilen

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
		player1.playerAcc.deposit(250);
		player2.playerAcc.deposit(250);
	}
	if(trow==4){
		System.out.println("Palace gates");
		player1.playerAcc.deposit(250);
		player2.playerAcc.deposit(250);
	}
	if(trow==5){
		System.out.println("Cold Desert");
		player1.playerAcc.deposit(250);
		player2.playerAcc.deposit(250);
	}
	if(trow==6){
		System.out.println("Walled city");
		player1.playerAcc.deposit(250);
		player2.playerAcc.deposit(250);
	}
	if(trow==7){
		System.out.println("Monastrery");
		player1.playerAcc.deposit(250);
		player2.playerAcc.deposit(250);
	}
	if(trow==8){
		System.out.println("Black cave");
		player1.playerAcc.deposit(250);
		player2.playerAcc.deposit(250);
	}
	if(trow==9){
		System.out.println("Huts in the mountain");
		player1.playerAcc.deposit(250);
		player2.playerAcc.deposit(250);
	}
	if(trow==10){
		System.out.println("The Werewall");
		player1.playerAcc.deposit(250);
		player2.playerAcc.deposit(250);
	}
	if(trow==11){
		System.out.println("The pit");
		player1.playerAcc.deposit(250);
		player2.playerAcc.deposit(250);
	}
	if(trow==12){
		System.out.println("The Goldmine");
		player1.playerAcc.deposit(250);
		player2.playerAcc.deposit(250);
	}

}
	
}
