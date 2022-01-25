package introJava;

import java.util.Arrays;
//deposit(int n): this method should add the given amount of money to the current total in the bank. 
//withdraw(int n): this method should subtract the given amount of money from the current total.
//addInterest(): this method should calculate this month's interest and add it to the current total.
//toString(): this method should simply return a display of how much money is in the account.
public class BankAccount {
	private String name;
	private int balance;
	private double interest;
	
	public BankAccount(String n, int b, double i) {
		this.name = n;
		this.balance = b;
		this.interest = i;
	}
	
	public BankAccount(String n, double i) {
		this.name = n;
		this.balance = 0;
		this.interest = i;
	}
	
	public void desposit(int n) {
		balance += n;
	}
	
	public void withdraw(int n) {
		balance -= n;
	}
	
	public void addInterest() {
		balance += (interest*balance);
	}
	
	public String display() {
		return "The account in the name of " + name + " has a balence of " + balance + " with an interest rate of " + interest;
	}
	
	public static void main(String[] args) {
		
	}
}