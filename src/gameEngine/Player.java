package gameEngine;

public class Player {
	
	String name;
	
	Account playerAcc = new Account(); 
	
	public Player(String name) {
		this.name = name; 
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	public String getName() {
		return name; 
	}
	
	public String toString() {
		return name + "'s" + playerAcc.toString();
	}
	
	

}
