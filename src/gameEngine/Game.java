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
	
	String i = "";

	i = GUI.getUserButtonPressed(null, "Roll Dice");
	
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
	
	
	if(i.equals("Roll Dice")){
		
	int trow=dieOne.rollDie()+dieTwo.rollDie();

	if(trow==2){
		System.out.println("Tower");
		if(playerOne){
			player1.playerAcc.deposit(250);
		}else
		player2.playerAcc.deposit(250);
		
	}
	if(trow==3){
		System.out.println("Crater");
		if(playerOne){
			player1.playerAcc.withdraw(200);
		}else
		player2.playerAcc.withdraw(200);

	}
	if(trow==4){
		System.out.println("Palace gates");
		if(playerOne){
			player1.playerAcc.withdraw(100);
		}else
		player2.playerAcc.withdraw(100);
	}
	if(trow==5){
		System.out.println("Cold Desert");
		if(playerOne){
			player1.playerAcc.withdraw(20);
		}else
		player2.playerAcc.withdraw(20);
	}
	if(trow==6){
		System.out.println("Walled city");
		if(playerOne){
			player1.playerAcc.deposit(180);
		}else
		player2.playerAcc.deposit(180);
	}
	if(trow==7){
		System.out.println("Monastrery");
		if(playerOne){
			player1.playerAcc.withdraw(0);
		}else
		player2.playerAcc.withdraw(0);
	}
	if(trow==8){
		System.out.println("Black cave");
		if(playerOne){
			player1.playerAcc.withdraw(70);
		}else
		player2.playerAcc.withdraw(70);
	}
	if(trow==9){
		System.out.println("Huts in the mountain");
		if(playerOne){
			player1.playerAcc.withdraw(60);
		}else
		player2.playerAcc.withdraw(60);
	}
	if(trow==10){
		System.out.println("The Werewall");
		if(playerOne){
			player1.playerAcc.withdraw(80);
		}else
		player2.playerAcc.withdraw(80);
	}
	if(trow==11){
		System.out.println("The pit");
		if(playerOne){
			player1.playerAcc.withdraw(90);
		}else
		player2.playerAcc.withdraw(90);
	}
	if(trow==12){
		System.out.println("The Goldmine");
		if(playerOne){
			player1.playerAcc.deposit(650);
		}else
		player2.playerAcc.deposit(650);
	}
	}
	}

}
	

