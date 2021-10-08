package introJava;

import java.util.Scanner;

public class StartingWithLoops {
	private Scanner input = new Scanner(System.in);
//	Get 2 integers from the user. Print out all numbers (inclusive) between the two integers. 
//	Do not assume the first number is smaller than the second.
//    (for inputs 7 and 3, the output should be 3,4,5,6,7)
//
//Get 2 doubles from the user. The first number is our base (b), the second is our coefficient (a). 
//Print out the first 6 terms (x = 0 to x = 5) of an exponential sequence abx using these numbers.
//   (for inputs 2 and 3, the output should be 3, 6, 12, 24, 48, 96)
//
//Get an integer from the user. Use a while loop (no using Math.sqrt!) to calculate the square root of the integer, 
//if it is a perfect square. You may only use your 5 basic math operators for this problem.
//   (for input 36, the output should be 6. For input 30, the output should be "does not have a root")
//
//Let the user provide an integer, call it n. Then, allow the user to enter n integer inputs using the scanner. 
//Print the largest of these integers.
	
	// Definite Finite
	public void printInclusive(int x, int y) {
		if (x == y) {
			return;
		}
		else if (x > y) {
			int holder = x;
			x = y;
			y = holder;
		}
	}
	
	//Definite Finite
	public void baseCoefficient(double base, double coeff) {
		int x = 0;
		while (x <= 5) {
			System.out.println(coeff* (Math.pow(base, x)));
			x++;
		}
	}
	
	//Definite Finite
	public void sqrt() {
		System.out.println("Enter a number: ");
		int num = input.nextInt();
		int root = 0;
		while (Math.pow(root, 2) <= num) {
			if (Math.pow(root, 2) == num) {
				System.out.println("The root of " + num + " is " + root);
				return;
			}
			root++;
		}
		System.out.println("There is no perfect root of " + num);
	}
	
	public void biggestNum() {
		System.out.println("Enter a number: ");
		int n = input.nextInt();
		int counter = 0;
		int biggest = Integer.MIN_VALUE;
		while (counter < n) {
			System.out.println("Enter another number: ");
			int num = input.nextInt();
			
			if (num > biggest) {
				biggest = num;
			}
			counter++;
		}
		System.out.println("The biggest number is: " + biggest);
	}
	public static void main(String[] args) {
		StartingWithLoops runner = new StartingWithLoops();
		runner.biggestNum();
		
	}
}
