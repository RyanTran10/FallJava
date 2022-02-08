package introJava;

import java.util.Arrays;
//deposit(int n): this method should add the given amount of money to the current total in the bank. 
//withdraw(int n): this method should subtract the given amount of money from the current total.
//addInterest(): this method should calculate this month's interest and add it to the current total.
//toString(): this method should simply return a display of how much money is in the account.
public class BankAccount {
	private String name;
	private double balance;
	
	public BankAccount(String n, double b) {
		this.name = n;
		this.balance = b;
	}
	
	public BankAccount(String n) {
		this.name = n;
		this.balance = 0;
	}
	
	public void deposit(double n) {
		balance += n;
	}
	
	public void withdraw(double n) {
		balance -= n;
	}
	
	public double getBal() {
		return balance;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "The account in the name of " + name + " has a balence of " + balance;
	}
	
	public static void main(String[] args) {
		
	}
}