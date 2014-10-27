package gameEngine;

public class Die {
	
	
	private final int MAX = 6; //maximal værdi på terningen
	
	public int faceValue; // viser ternigens aktuelle værdi
	
	public int rollDie(){
		
		faceValue = (int) (Math.random() * MAX) + 1;
		
		return faceValue;
		
	}
	
	
	

}

