package gameEngine;

public class Fields {

	public static String field(boolean p1, boolean p2, Player player1, Player player2, int trow, String i){ 

		if(i.equals("Roll Dice")){

			if(trow==2){
				if(p1){
					player1.playerAcc.deposit(250);
				}
				if(p2){
					player2.playerAcc.deposit(250);
				}
				return "Tower";
			}else
			if(trow==3){
				if(p1){
					player1.playerAcc.withdraw(200);
				}
				if(p2){
					player2.playerAcc.withdraw(200);
				}
				return "Crater";
			}else
			if(trow==4){
				if(p1){
					player1.playerAcc.withdraw(100);
				}
				if(p2){
					player2.playerAcc.withdraw(100);
				}
				return "Palace gates";
			}else
			if(trow==5){
				if(p1){
					player1.playerAcc.withdraw(20);
				}
				if(p2){
					player2.playerAcc.withdraw(20);
				}
				return "Cold Desert";
			}else
			if(trow==6){
				if(p1){
					player1.playerAcc.deposit(180);
				}
				if(p2){
					player2.playerAcc.deposit(180);
				}
				return "Walled city";
			}else
			if(trow==7){
				if(p1){
					player1.playerAcc.withdraw(0);
				}
				if(p2){
					player2.playerAcc.withdraw(0);
				}
				return "Monastrery";
			}else
			if(trow==8){
				if(p1){
					player1.playerAcc.withdraw(70);
				}
				if(p2){
					player2.playerAcc.withdraw(70);
				}
				return "Black cave";
			}else
			if(trow==9){
				if(p1){
					player1.playerAcc.withdraw(60);
				}
				if(p2){
					player2.playerAcc.withdraw(60);
				}
				return "Huts in the mountain";
			}else
			if(trow==10){
				if(p1){
					player1.playerAcc.withdraw(80);
				}
				if(p2){
					player2.playerAcc.withdraw(80);
				}
				return "The Werewall";
			}else
			if(trow==11){
				if(p1){
					player1.playerAcc.withdraw(90);
				}
				if(p2){
					player2.playerAcc.withdraw(90);
				}
				return "The pit";
			}else
			if(trow==12){
				if(p1){
					player1.playerAcc.deposit(650);
				}
				if(p2){
					player2.playerAcc.deposit(650);
				}
				return "The Goldmine";
			}
			else return "Der skal slås mellem 2-12";

		}else return "Skriv Roll Dice";
	}

}


