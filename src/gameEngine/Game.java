
package gameEngine;

import javax.swing.JOptionPane;
import boundaryToMatador.GUI;
import boundaryToMatador.Car; //in order to create a custom car
import java.awt.Color; //in order to change color of the car 

public class Game {

	private boolean playerOneVic = false;
	private boolean playerTwoVic = false;
	private boolean playerOneLoss = false;
	private boolean playerTwoLoss = false;

	Player player1 = new Player("PlayerOne");
	Player player2 = new Player("PlayerTwo");
	
	Language language = new Language(); 

	private boolean playerOne = true;
	private boolean playerTwo = false;
	private boolean game = true;

	//Language used in the code, will be changed by the language setting.
	private static String typeNameOne = ""; 
	private static String typeNameTwo = "";
	private static String rollDice = "";
	private static String won = "";
	private static String isWinner = "";
	private static String draw = "";



	public void game(){
		//variables created for storing the users names for the game
		String playerOneName = ""; 
		String playerTwoName = ""; 
		//The choices of languages that can be used
		String[] choices = { "English", "Dansk", "Deutsch"};
		//Selection box in which the user has to choose language
		String input = (String) JOptionPane.showInputDialog(null, "Choose language:",
				"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null,
				choices, 
				choices[1]); 

		//System.out.println(input);

		//language selection, changes variables and sets the game board language.
		language.languageSelection(input);


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
				int trow=dieOne.getFaceValue()+dieTwo.getFaceValue();
				GUI.setDice(dieOne.getFaceValue(), dieTwo.getFaceValue());

				if(playerOne) {
					GUI.removeAllCars(playerOneName);//Removes the player from the board. Only used in case of trow == 10, as the car would have otherwise been removed on playerTwos turn
					GUI.setCar(1, playerOneName);//Sets the player at Start (field1)
					GUI.removeAllCars(playerTwoName);//Resets the positions of the other player
					GUI.setCar(1, playerTwoName);
					GUI.removeCar(1, playerOneName); //Removes the car from Start
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
					GUI.removeAllCars(playerTwoName);
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
			Car car = new Car.Builder()
			.typeRacecar()
			.primaryColor(Color.BLACK)
			.secondaryColor(Color.WHITE)
			.patternDiagonalDualColor()
			.build();
			//If both player have reached >= 3000 points. The player with the most points win.
			if (playerOneVic && playerTwoVic){
				if (player1.getAccount().getBalance() > player2.getAccount().getBalance()){
					GUI.showMessage(playerOneName+won);
					GUI.addPlayer(playerOneName+isWinner, player1.getAccount().getBalance(), car);
				}
				else if (player1.getAccount().getBalance() < player2.getAccount().getBalance()){
					GUI.showMessage(playerTwoName+won);
					GUI.addPlayer(playerTwoName+isWinner, player2.getAccount().getBalance(), car);
				}
				//The game will end in a draw if both players have won and their points are equal
				else if (player1.getAccount().getBalance() == player2.getAccount().getBalance()){
					GUI.showMessage(draw);
					GUI.addPlayer(draw, 0, car);
				}
			}
			else if (playerOneVic && !playerTwoVic){
				GUI.showMessage(playerOneName+won);
				GUI.addPlayer(playerOneName+isWinner, player1.getAccount().getBalance(), car);
			}
			else if (playerTwoVic && !playerOneVic){
				GUI.showMessage(playerTwoName+won);
				GUI.addPlayer(playerTwoName+isWinner, player2.getAccount().getBalance(), car);
			}
			if (playerOneLoss && playerTwoLoss){
				GUI.showMessage(draw);
			}
			else if (playerOneLoss && !playerTwoLoss){
				GUI.showMessage(playerTwoName+won);
				GUI.addPlayer(playerTwoName+isWinner, player2.getAccount().getBalance(), car);
			}
			else if (!playerOneLoss && playerTwoLoss){

				GUI.showMessage(playerOneName+won);
				GUI.addPlayer(playerOneName+isWinner, player1.getAccount().getBalance(), car);

			}

		}

	}
	
	//Language Strings getters and setters
	public static void setTypeNameOne(String typeNameOne) {
		Game.typeNameOne = typeNameOne;
	}
	public static void setTypeNameTwo(String typeNameTwo) {
		Game.typeNameTwo = typeNameTwo;
	}
	public static String getRollDice() {
		return rollDice;
	}
	public static void setRollDice(String rollDice) {
		Game.rollDice = rollDice;
	}
	public static void setWon(String won) {
		Game.won = won;
	}
	public static void setIsWinner(String isWinner) {
		Game.isWinner = isWinner;
	}
	public static void setDraw(String draw) {
		Game.draw = draw;
	}

}

