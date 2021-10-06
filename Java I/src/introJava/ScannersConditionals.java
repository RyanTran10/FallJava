package introJava;

import java.util.Scanner;

public class ScannersConditionals {
	
	private Scanner input = new Scanner(System.in);
	
	public void fourNums() {
	
		System.out.println("Enter a num: ");
		int num1 = input.nextInt();
		System.out.println("Enter another num: ");
		int num2 = input.nextInt();
		System.out.println("Enter another num: ");
		int num3 = input.nextInt();
		System.out.println("Enter another num: ");
		int num4 = input.nextInt();
		System.out.print(num4+""+num3+""+num2+""+num1);
		
	}
	
	public void operator() {
		System.out.println("Write a mathmatical operator!");
		String mathOp = input.next();
		System.out.println("Enter a num: ");
		int num1 = input.nextInt();
		System.out.println("Enter another num: ");
		int num2 = input.nextInt();
		
		if (mathOp.equals("+")) {
			System.out.println(num1 + num2);
		}
		else if (mathOp.equals("-")) {
			System.out.println(num1 - num2);
		}
		else if (mathOp.equals("*")) {
			System.out.println(num1*num2);
		}
		else if (mathOp.equals("/")) {
			System.out.println(num1/num2);
		}
		else if (mathOp.equals("%")) {
			System.out.println(num1 % num2);
		}
		else {
			System.out.println(mathOp + (char)num1 + (char)num2);
		}
		
		
	}
//	Suppose in football the only way to score is via touchdowns (always 7 points) and field goals (always 3 points). 
//	Take as input 3 numbers: a number of touchdowns, a number of field goals, and a total score. 
//	Determine whether the total score can be reached exactly using the given number of touchdowns/field goals. 
//	Note that you do not need to use all of the touchdowns/field goals. 
//	For example, (3, 5, 27) would determine "yes", because you can use all 3 touchdowns and 2 of the 5 field goals to reach 27 points. 

//	For example, (4, 1, 25) would determine "no" because there is no way to reach exactly 25 points. 
	
	public void possible() {
		
		System.out.println("Pick a number of Touchdowns: ");
		int touchdowns = input.nextInt();
		System.out.println("Pick a number of Field Goals: ");
		int fieldGoals = input.nextInt();
		System.out.println("Pick a number of Total points: ");
		int points = input.nextInt();
		// Idk where to go from here other than doing brute force if for loops
		
	
		
		
	}
	
	public void largestNum() {
		System.out.println("Pick a num between 0 and 999! ");
		int num = input.nextInt();
		int ones = num % 10;
		int tens = num % 100;
		int hundreds = num;
		
		tens = tens/10;
		hundreds = hundreds/100;
		
		if (ones > tens && ones > hundreds) {
			System.out.println(ones);
		}
		else if (tens > hundreds) {
			System.out.println(tens);
		}
		else {
			System.out.println(hundreds);
		}
	}
	public static void main(String[] args) {
		ScannersConditionals runner = new ScannersConditionals();
		runner.largestNum();
	}
}
