package gameEngine;

import javax.swing.JOptionPane;

import boundaryToMatador.GUI;

public class Game {

	boolean playerOneVic = false;
	boolean playerTwoVic = false;
	boolean playerOneLoss = false;
	boolean playerTwoLoss = false;

	Player player1 = new Player("PlayerOne");
	Player player2 = new Player("PlayerTwo");

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

		String typeNameOne = ""; 
		String typeNameTwo = "";
		String rollDice = "";
		String won = "";
		String isWinner = "";
		String draw = "";


		//language selection variables are created
		if(input.equals("Dansk")){
			typeNameOne = "Indtast navn spiller 1"; 
			typeNameTwo = "Indtast navn spiller 2";
			rollDice = "Kast Terning";
			won = " vandt";
			isWinner = " er vinderen";
			draw = "Uafgjort";

		}else if(input.equals("English")){
			typeNameOne = "Type name of player 1";
			typeNameTwo = "Type name of player 2";
			rollDice = "Roll Dice";
			won = " won";
			isWinner = " is the winner";
			draw = "Draw";
		}


		playerOneName = GUI.getUserString(typeNameOne);

		playerTwoName = GUI.getUserString(typeNameTwo);



		String i = "";


		Die dieOne = new Die();
		Die dieTwo = new Die();

		GUI.addPlayer(playerTwoName, player2.playerAcc.balance, 255, 255, 255); //last three arguments are RGB-color
		GUI.addPlayer(playerOneName, player1.playerAcc.balance, 0, 0, 0);	    


		while(game) {

			i = GUI.getUserButtonPressed(null, rollDice);

			if(i.equals(rollDice)){
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
					Fields.field(player1, trow, i);
					GUI.setBalance(playerOneName, player1.playerAcc.balance);
					if(player1.playerAcc.balance==0){
						playerOneLoss = true;
						trow = 0;
					}
					if (player1.playerAcc.balance>=3000){
						playerOneVic = true;
					}
					if(playerTwoVic || playerTwoLoss){
						game = false;
					}
				}

				if(playerTwo) {
					GUI.removeAllCars(playerOneName);
					GUI.setCar(1, playerOneName);
					GUI.removeAllCars(playerTwoName);//In case of trow == 
					GUI.setCar(1, playerTwoName);
					GUI.removeCar(1, playerTwoName);
					GUI.setCar(trow, playerTwoName); 
					Fields.field(player2, trow, i);
					GUI.setBalance(playerTwoName, player2.playerAcc.balance);
					if(player2.playerAcc.balance==0){
						playerTwoLoss = true;
						trow = 0;
					}
					if (player2.playerAcc.balance>=3000){
						playerTwoVic = true;
					}
					if(playerOneVic || playerOneLoss){
						game = false;
					}
				}

				if(trow==10){
					continue;
				}
				else if(playerOne){
					playerOne = false;
					playerTwo = true;
				}
				else if(playerTwo){
					playerOne = true;
					playerTwo = false;
				}

			}

		}
		if (game != true){

			if (playerOneVic && playerTwoVic){
				if (player1.playerAcc.balance > player2.playerAcc.balance){
					GUI.showMessage(playerOneName+won);
					GUI.addPlayer(playerOneName+isWinner, player1.playerAcc.balance);
				}
				else if (player1.playerAcc.balance < player2.playerAcc.balance){
					GUI.showMessage(playerTwoName+won);
					GUI.addPlayer(playerTwoName+isWinner, player2.playerAcc.balance);
				}
				else if (player1.playerAcc.balance == player2.playerAcc.balance){
					GUI.showMessage(draw);
				}
			}
			else if (playerOneVic && !playerTwoVic){
				GUI.showMessage(playerOneName+won);
				GUI.addPlayer(playerOneName+isWinner, player1.playerAcc.balance);
			}
			else if (playerTwoVic && !playerOneVic){
				GUI.showMessage(playerTwoName+won);
				GUI.addPlayer(playerTwoName+isWinner, player2.playerAcc.balance);
			}
			if (playerOneLoss && playerTwoLoss){
				GUI.showMessage(draw);
			}
			else if (playerOneLoss && !playerTwoLoss){
				GUI.showMessage(playerTwoName+won);
				GUI.addPlayer(playerTwoName+isWinner, player2.playerAcc.balance);
			}
			else if (!playerOneLoss && playerTwoLoss){

				GUI.showMessage(playerOneName+won);
				GUI.addPlayer(playerOneName+isWinner, player1.playerAcc.balance);

			}

		}

	}

}
