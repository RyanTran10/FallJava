package introJava;

public class GreatAccount extends BankAccount {
	private int totalWithdraws = 0;
	private int withdraws = 0;
	private int currentMonth = 0;
	
	public GreatAccount(String n, double b) {
		super(n, b);
	}

	public GreatAccount(String n) {
		super(n);
	}
	
	public void withdraw(double n) {
		if(withdraws >= 3) {
			System.out.println("You've reached your withdraw limit for this month!");
		} else {
			withdraws++;
			super.withdraw(n);
		}
	}
	
	public void nextMonth() {
		totalWithdraws += withdraws;
		withdraws = 0;
		currentMonth++;
		if(currentMonth == 12 && totalWithdraws == 0) {
			deposit(getBal());
			currentMonth= 0;
		} else if(currentMonth == 12){
			currentMonth = 0;
			totalWithdraws = 0;
		}
	}
	
	public String toString() {
		return "The account in the name of " + getName() + " has a balence of " + getBal() + ". You have " + totalWithdraws + " total withdraws this year. You are on month " + currentMonth + " and have " + withdraws + " withdraws this month";
	}

	public static void main(String[] args) {
		BankAccount b1 = new BankAccount("B1");
		b1.deposit(500);
		b1.withdraw(200);
		System.out.println(b1.toString());
		InterestAccount b2 = new InterestAccount("B2", 500, 0.01);
		b2.addInterest();
		System.out.println(b2.toString());
		CreditCard b3 = new CreditCard("B3", 500, 0.01);
		b3.addInterest();
		b3.withdraw(405);
		GreatAccount b4 = new GreatAccount("B4", 500);
		b4.withdraw(0);
		b4.withdraw(0);
		b4.withdraw(0);
		b4.withdraw(0);
		System.out.println(b4.toString());
		GreatAccount b5 = new GreatAccount("B5", 500);
		for(int i = 0; i < 12; i++) {
			b5.nextMonth();
		}
		System.out.println(b5.toString());
		b5.withdraw(0);
		for(int i = 0; i < 12; i++) {
			b5.nextMonth();
		}
		System.out.println(b5.toString());
	}

}
