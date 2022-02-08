package introJava;

public class InterestAccount extends BankAccount {
	private double interest;
	public InterestAccount(String n, double b, double i) {
		super(n, b);
		interest = i;
	}

	public InterestAccount(String n, double i) {
		super(n);
		interest = i;
	}
	
	public void addInterest() {
		deposit(getBal()*interest);
	}
	
	public String toString() {
		return "The account in the name of " + getName() + " has a balence of " + getBal() + " and has an interest rate of " + interest;
	}
	
	public static void main(String[] args) {

	}

}