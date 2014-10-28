package gameEngine;

public class Die 
{
	
	
	private final int MAX = 6; //maximal v�rdi p� terningen
	
	public int faceValue; // viser ternigens aktuelle v�rdi
	
	public int rollDie()
	{
		
		faceValue = (int) (Math.random() * MAX) + 1;
		
		return faceValue;
	}

}


