package gameEngine;

public class Fields {

	Player player1 = new Player("PlayerOne");
	Player player2 = new Player("PlayerTwo");




	public String field(boolean p1, boolean p2, int trow, String i){ 

		if(i.equals("Roll Dice")){

			if(trow==2){
				if(p1){
					player1.playerAcc.deposit(250);
				}
				if(p2){
					player2.playerAcc.deposit(250);
				}
				return "Tower";
			}
			if(trow==3){
				if(p1){
					player1.playerAcc.withdraw(200);
				}
				if(p2){
					player2.playerAcc.withdraw(200);
				}
				return "Crater";
			}
			if(trow==4){
				if(p1){
					player1.playerAcc.withdraw(100);
				}
				if(p2){
					player2.playerAcc.withdraw(100);
				}
				return "Palace gates";
			}
			if(trow==5){
				if(p1){
					player1.playerAcc.withdraw(20);
				}
				if(p2){
					player2.playerAcc.withdraw(20);
				}
				return "Cold Desert";
			}
			if(trow==6){
				if(p1){
					player1.playerAcc.deposit(180);
				}
				if(p2){
					player2.playerAcc.deposit(180);
				}
				return "Walled city";
			}
			if(trow==7){
				if(p1){
					player1.playerAcc.withdraw(0);
				}
				if(p2){
					player2.playerAcc.withdraw(0);
				}
				return "Monastrery";
			}
			if(trow==8){
				if(p1){
					player1.playerAcc.withdraw(70);
				}
				if(p2){
					player2.playerAcc.withdraw(70);
				}
				return "Black cave";
			}
			if(trow==9){
				if(p1){
					player1.playerAcc.withdraw(60);
				}
				if(p2){
					player2.playerAcc.withdraw(60);
				}
				return "Huts in the mountain";
			}
			if(trow==10){
				if(p1){
					player1.playerAcc.withdraw(80);
				}
				if(p2){
					player2.playerAcc.withdraw(80);
				}
				return "The Werewall";
			}
			if(trow==11){
				if(p1){
					player1.playerAcc.withdraw(90);
				}
				if(p2){
					player2.playerAcc.withdraw(90);
				}
				return "The pit";
			}
			if(trow==12){
				if(p1){
					player1.playerAcc.deposit(650);
				}
				if(p2){
					player2.playerAcc.deposit(650);
				}
				return "The Goldmine";
			}

		}
		else return "Skriv Roll Dice";
	}

}


