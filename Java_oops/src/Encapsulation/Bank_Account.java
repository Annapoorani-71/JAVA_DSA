package Encapsulation;

import java.util.*;

class BankAccountNumber
{
	
	private long accno;
	private String acc_name;
	private int balance;
	
	BankAccountNumber(long a, String name,int b)
	{
		this.acc_name=name;
		this.accno=a;
		this.balance=b;
	}
	public void displaybalance()
	{
		System.out.println(balance);
	}
	 public long getAccountNumber() {
	        return accno;
	    }

	   
	    public String getAccountHolderName() {
	        return acc_name;
	    }
	    
	    // Public method to deposit money
	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("Deposited: $" + amount);
	            displaybalance();
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }

	    // Public method to withdraw money
	    public void withdraw(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrew: $" + amount);
	            displaybalance();
	        } else {
	            System.out.println("Insufficient funds or invalid amount.");
	        }
	    }


}


class Bank_Account {
    public static void main(String[] args) {

    	BankAccountNumber b=new BankAccountNumber(123456789,"Das",140000);
    	b.displaybalance();
    	
    	b.withdraw(140000);
        b.deposit(150000);
        
    }
}