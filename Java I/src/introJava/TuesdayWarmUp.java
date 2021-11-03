package introJava;

import java.util.Scanner;

public class TuesdayWarmUp {
	private Scanner input = new Scanner(System.in);
	
	public void digits(int n) {
		while (n > 0) {
			System.out.println(n%10);
			n /= 10;
		}
	}
	
	public void rectangle(int x, int y) {
		for (int i = y; i > 0; i--) {
			for (int j = x; j > 0; j--) {
				System.out.print("X");
			}
			System.out.println("");
		}
	}
	
	public void factors(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i % j == 0 ? j + ", ": "");
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		TuesdayWarmUp runner = new TuesdayWarmUp();
		runner.factors(8);
	}
}
