package introJava;

public class CreditCard extends InterestAccount {

	public CreditCard(String n, double b, double i) {
		super(n, b, i);
	}

	public CreditCard(String n, double i) {
		super(n, i);
	}
	
	public void addInterest() {
		super.addInterest();
		withdraw(10);
	}
	
	public void withdraw(double n) {
		if(getBal() - n > 100) {
			super.withdraw(n);
		} else {
			System.out.println("Withdrawing " + n + " dollars will cause you an overdraft fee");
		}
	}

	public static void main(String[] args) {
	}

}
