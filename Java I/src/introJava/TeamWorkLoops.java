package introJava;

import java.util.Scanner;

public class TeamWorkLoops {
//	Write a method that takes a double x and an integer n as parameters. Print the first n powers of x, starting at x1.
//	 
//
//	Write a method that takes an integer n as parameter. Print the sum of the numbers 1 to n (inclusive). 
//	 
//
//	Write a method that uses the scanner to take integers as input from the user until they enter -1. Once they enter -1, print the average of all entered numbers, excluding -1.
//	 
//
//	Write a method that takes an integer as parameter. Reverse it. So, 12345 would become 54321. No using strings!
//	 
//
//	Write a method that "decodes" a number in the following way: 656770 would be broken into 65, 67, and 70. Then, get these 
//	numbers' corresponding characters, and put them together. So, 656770 would output "ACF". Assume that the number will only 
//	represent uppercase letters, and that it will have an even number of digits.
//	
	private Scanner input = new Scanner(System.in);
	
//	public void forloop() {
//		for (int i = 0; i < 100; i++) {
//			
//		}
//		
//		// Can access i after for loop
//		int i = 0;
//		for (i = 0; i < 100; i++) {
//			
//		}
//	}
	
	public void firstNPoweres(double x, int n) {
		for(int i = 1; i <= n; i++) {
			System.out.print(Math.pow(x, i) + ", ");
		}
	}
	
	public void sum(int n) {
		System.out.println(n * (n + 1)/2);
	}
	public void average() {
		int currentNum = 0;
		int amount = 0;
		double totalNum = 0;
		while (currentNum != -1) {
			System.out.println("Enter a num: ");
			currentNum = input.nextInt();
			if (currentNum != -1) {
				totalNum += currentNum;
				amount ++;
			}
		}
		System.out.println(totalNum/amount);
	}
	

	public static void main(String[] args) {
		TeamWorkLoops runner = new TeamWorkLoops();
		runner.sum(10);
	}
}
