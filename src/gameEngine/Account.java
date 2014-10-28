package gameEngine;

public class Account {

	int balance;

	public Account() {
		balance = 1000;
	}

	public String deposit(int amount) {
		if(amount >= 0) {  
			balance += amount;
			return "Deposit succesful";
		} else return "Deposit unsuccesful";
	}

	public String withdraw(int amount) {
		if(amount<=balance) {
			balance -= amount;
			return "Withdrawal succesful";
		} else return "Withdrawal unsuccesful. Cannot withdraw amount larger than balance ";
	}

	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		if(balance >= 0) {
			this.balance = balance;
		} 
	}

	public String toString() {
		return "balance: " + balance;
	}

}
