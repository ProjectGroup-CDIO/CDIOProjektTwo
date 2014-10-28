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
	
	GUI.addPlayer("Lars", 0, 0, 0, 0);	  // De tre sidste tal angiver farve på bilen   
	GUI.addPlayer("Poul", 0, 255, 255, 255); // De tre sidste tal angiver farve på bilen

	int felt = (dieOne.faceValue + dieTwo.faceValue) - 1;
	
	GUI.setDice(dieOne.faceValue, dieTwo.faceValue);
    GUI.setCar(felt, "Lars");
	
	GUI.addPlayer("PlayerOne", PlayerOnePoints);
	GUI.addPlayer("PlayerTwo", PlayerTwoPoints);
	
	
int trow=0;
	
	if(trow==2){
		System.out.println("Tower");
	}
	if(trow==3){
		System.out.println("Crater");
	}
	if(trow==4){
		System.out.println("Palace gates");
	}
	if(trow==5){
		System.out.println("Cold Desert");
	}
	if(trow==6){
		System.out.println("Walled city");
	}
	if(trow==7){
		System.out.println("Monastrery");
	}
	if(trow==8){
		System.out.println("Black cave");
	}
	if(trow==9){
		System.out.println("Huts in the mountain");
	}
	if(trow==10){
		System.out.println("The Werewall");
	}
	if(trow==11){
		System.out.println("The pit");
	}
	if(trow==12){
		System.out.println("The Goldmine");
	}

}
	
}
