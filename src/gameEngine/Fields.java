package gameEngine;

public class Fields {

	public static String field(Player player, int trow, String i){ 

		if(i.equals("Roll Dice")){

			if(trow==2){
				player.playerAcc.deposit(250);
				return "Tower";
			}else
			if(trow==3){
				player.playerAcc.withdraw(200);
				return "Crater";
			}else
			if(trow==4){
				player.playerAcc.withdraw(100);
				return "Palace gates";
			}else
			if(trow==5){
				player.playerAcc.withdraw(20);
				return "Cold Desert";
			}else
			if(trow==6){
				player.playerAcc.deposit(180);
				return "Walled city";
			}else
			if(trow==7){
				player.playerAcc.withdraw(0);
				return "Monastery";
			}else
			if(trow==8){
				player.playerAcc.withdraw(70);
				return "Black cave";
			}else
			if(trow==9){
				player.playerAcc.withdraw(60);
				return "Huts in the mountain";
			}else
			if(trow==10){
				player.playerAcc.withdraw(80);
				return "The Werewall";
			}else
			if(trow==11){
				player.playerAcc.withdraw(90);
				return "The pit";
			}else
			if(trow==12){
				player.playerAcc.deposit(650);
				return "The Goldmine";
			}
			else return "There must be rolled a valid dice";

		}else return "Roll Dice not recieved properly";
	}
}




