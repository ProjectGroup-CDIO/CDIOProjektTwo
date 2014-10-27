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
			return "Deposit succesful";
		} else return "Deposit unsuccesful";
	}

	public String withdraw(int amount) {
		if(amount<=balance) {
			balance -= amount;
			return "Withdrawal succesful";
		} else return "Withdrawal unsuccesful";
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
