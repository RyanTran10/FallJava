package introJava;

import java.util.Scanner;

//Write a method that takes 5 integers as parameters. Assume each of these integers will be 0 or 1. 
//This is binary code. Calculate the base-10 value of the input. 
//For example, (1, 0, 1, 1, 1) --> 24 + 22 + 21 + 20 = 16 + 4 + 2 + 1 = 23
//
//Write a method that gets 2 strings as input via the scanner. 
//Name the first str1 and the second str2. Your program should switch the values of the two variables. 
//So at the end of the method, str1 should hold str2's original value and vice versa. 
// 
//Write a method that takes an integer as parameter. Assume this integer will consist of 5 digits. 
//Print the remainder when the first two digits are divided by each of the ones, tens, and hundreds digits. 
//For example, an input of 34924 would print "2", "0", "7". 
//
//Write a method that takes two characters as parameters. 
//If their sum represents a letter, print the letter. 
//If not, print whichever letter is closest to this sum's value.
public class FinalIfs {
	
	private Scanner input = new Scanner(System.in);
	
	public void binaryToBase10(int num1, int num2, int num3, int num4, int num5) {
		System.out.println(num5*1 + num4*2 + num3*4 + num2*8 + num1*16);
	}
	public void stringSwitch() {
		System.out.println("Say something: ");
		String str1 = input.next();
		System.out.println("Say something else: ");
		String str2 = input.next();
		String holder;
		holder = str1;
		str1 = str2;
		str2 = holder;
	}
	public void remainder(int num) {
		int first2 = num/1000;
		int ones = num%10;
		int tens = num%100/10;
		int hundreds = num%1000/100;
		System.out.println(first2 % ones+" "+first2 % tens+" "+first2 % hundreds);
	}
	public void twoCharsToLet(char char1, char char2) {
		if (char1 + char2 <= 65) {
			System.out.println("A");
		}
		else if (char1 + char2 >= 122) {
			System.out.println("z");
		}
		else if (char1 + char2 > 90 && char1 + char2 <= 93) {
			System.out.println("Z");
		}
		else if (char1 + char2 > 93 && char1 + char2 <= 96) {
			System.out.println("a");
		}
		else {
			System.out.println((char)(char1 + char2));
		}
	}
	
	public static void main(String[] args) {
		FinalIfs runner = new FinalIfs();
		
		runner.twoCharsToLet('3', '3');
	}
}
