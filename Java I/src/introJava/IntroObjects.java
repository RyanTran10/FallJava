package introJava;

import java.util.Arrays;

public class IntroObjects {
	public static void main(String[] args) {
		BankAccount b = new BankAccount("Ryan", 100, 0.06);
		BankAccount b1 = new BankAccount("Tiffany", 0.06);
		
		System.out.println(b1.display());
		System.out.println(b.display());
		b.desposit(100);
		System.out.println(b.display());
		b.addInterest();
		System.out.println(b.display());
	}
}