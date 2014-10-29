package gameEngine;

public class Fields {
	
	int trow = 2;
	String i ="";
		{

	if(i.equals("Roll Dice")){
		Player player1 = new Player("PlayerOne");
		Player player2 = new Player("PlayerTwo");

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


}


