
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

	boolean playerOne = true;
	boolean playerTwo = false;
	boolean game = true;

	//Language used in the code, will be changed by the language setting.
	String typeNameOne = ""; 
	String typeNameTwo = "";
	String rollDice = "";
	String won = "";
	String isWinner = "";
	String draw = "";


	public void game(){
		//variables created for storing the users names for the game
		String playerOneName = ""; 
		String playerTwoName = ""; 
		//The choices of languages that can be used
		String[] choices = { "English", "Dansk"};
		//Selection box in which the user has to choose language
		String input = (String) JOptionPane.showInputDialog(null, "Choose language:",
				"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null,
				choices, 
				choices[1]); 

		//System.out.println(input);

		//language selection, changes variables and sets the game board language.
		if(input.equals("Dansk")){
			GUI.create("fields-Dansk.txt");
			typeNameOne = "Indtast navn for spiller 1"; 
			typeNameTwo = "Indtast navn for spiller 2";
			rollDice = "Kast Terning";
			won = " VANDT!!!";
			isWinner = " ER VINDEREN!!!";
			draw = "Uafgjort";
		}else if(input.equals("English")){
			GUI.create("fields-English.txt");
			typeNameOne = "Type name of player 1";
			typeNameTwo = "Type name of player 2";
			rollDice = "Roll Dice";
			won = " WON!!!";
			isWinner = " IS THE WINNER!!!";
			draw = "Draw";
		}


		//User names are prompted from the users, and store in previous variables
		playerOneName = GUI.getUserString(typeNameOne);
		playerTwoName = GUI.getUserString(typeNameTwo);

		//variable used to store the button pressed value
		String i = "";

		//Dices to be rolled are created.
		Die dieOne = new Die();
		Die dieTwo = new Die();

		//adds player cars to the
		GUI.addPlayer(playerTwoName, player2.getAccount().getBalance(), 255, 255, 255); //last three arguments are RGB-color
		GUI.addPlayer(playerOneName, player1.getAccount().getBalance(), 0, 0, 0);	    


		while(game) {
			//user prompted button, when pressed the value of rollDice is stored in i.
			i = GUI.getUserButtonPressed(null, rollDice);
			
			if(i.equals(rollDice)){
				dieOne.rollDie();
				dieTwo.rollDie();
				int trow=dieOne.faceValue+dieTwo.faceValue;
				GUI.setDice(dieOne.faceValue, dieTwo.faceValue);

				if(playerOne) {
					GUI.removeAllCars(playerOneName);//In case of trow==10. Removes the player from the board.
					GUI.setCar(1, playerOneName);//Sets the player at the first field
					GUI.removeAllCars(playerTwoName);//Resets the postions of the other player
					GUI.setCar(1, playerTwoName);
					GUI.removeCar(1, playerOneName); //Removes the player. So the player can get a new postion
					GUI.setCar(trow, playerOneName); //sets car at field corresponding to sum of faceValues
					Fields.field(player1, trow, i);
					GUI.setBalance(playerOneName, player1.getAccount().getBalance());
					//Sets the player to lose in case of 0 points
					if(player1.getAccount().getBalance()==0){
						playerOneLoss = true;
						trow = 0; //In order for a player not to get an extra turn by trow==10, when player have reached 0 points
					}
					//Sets the player to win in case of >= 3000 points
					if (player1.getAccount().getBalance()>=3000){
						playerOneVic = true;
					}
					 
				}

				if(playerTwo) {
					GUI.removeAllCars(playerOneName);
					GUI.setCar(1, playerOneName);
					GUI.removeAllCars(playerTwoName);//In case of trow == 10
					GUI.setCar(1, playerTwoName);
					GUI.removeCar(1, playerTwoName);
					GUI.setCar(trow, playerTwoName); 
					Fields.field(player2, trow, i);
					GUI.setBalance(playerTwoName, player2.getAccount().getBalance());
					if(player2.getAccount().getBalance()==0){
						playerTwoLoss = true;
						trow = 0; //In order for a player not to get an extra turn by trow==10, when player have reached 0 points
					}
					if (player2.getAccount().getBalance()>=3000){
						playerTwoVic = true;
					}
					if(playerOneVic || playerOneLoss || playerTwoVic || playerTwoLoss){
						game = false;
					}
				}
				//The turn is not switched if a player rolls 10
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
			//If both player have reached >= 3000 points. The player with the most points win.
			if (playerOneVic && playerTwoVic){
				if (player1.getAccount().getBalance() > player2.getAccount().getBalance()){
					GUI.showMessage(playerOneName+won);
					GUI.addPlayer(playerOneName+isWinner, player1.getAccount().getBalance(), 0, 0, 0);
				}
				else if (player1.getAccount().getBalance() < player2.getAccount().getBalance()){
					GUI.showMessage(playerTwoName+won);
					GUI.addPlayer(playerTwoName+isWinner, player2.getAccount().getBalance(), 255, 255, 255);
				}
				//The game will end in a draw if both players have won and their points are equal
				else if (player1.getAccount().getBalance() == player2.getAccount().getBalance()){
					GUI.showMessage(draw);
				}
			}
			else if (playerOneVic && !playerTwoVic){
				GUI.showMessage(playerOneName+won);
				GUI.addPlayer(playerOneName+isWinner, player1.getAccount().getBalance(), 0, 0, 0);
			}
			else if (playerTwoVic && !playerOneVic){
				GUI.showMessage(playerTwoName+won);
				GUI.addPlayer(playerTwoName+isWinner, player2.getAccount().getBalance(), 255, 255, 255);
			}
			if (playerOneLoss && playerTwoLoss){
				GUI.showMessage(draw);
			}
			else if (playerOneLoss && !playerTwoLoss){
				GUI.showMessage(playerTwoName+won);
				GUI.addPlayer(playerTwoName+isWinner, player2.getAccount().getBalance(), 255, 255, 255);
			}
			else if (!playerOneLoss && playerTwoLoss){

				GUI.showMessage(playerOneName+won);
				GUI.addPlayer(playerOneName+isWinner, player1.getAccount().getBalance(), 0, 0, 0);

			}

		}

	}

}

