package gameEngine;

public class Account {

	int balance;
	String name;

	public Account(String name) {
		balance = 1000;
		this.name = name;
	}

	public String deposit(int amount) {
		if(amount >= 0) { //eventuel fejlmeddelelse hvis amount<0 ? 
			balance += amount;
			return "Deposit successful";
		} else return "Deposit unsuccessful";
	}

	public void withdraw(int amount) {
		balance -= amount;
	}

	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String toString() {
		return name + " has " + balance;
	}




}
