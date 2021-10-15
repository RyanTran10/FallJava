package introJava;

import java.util.Scanner;

public class MoreWithLoops {
	private Scanner input = new Scanner(System.in);
	
	public void negToPos() {
		System.out.println("Enter a number: ");
		int num = input.nextInt();
		int num2 = num*-1;
		while (num2 <= num) {
			System.out.println(num2);
			num2 ++;
		}
	}
	
	public void hi() {
		System.out.println("Enter a number: ");
		int num = input.nextInt();
		for (int i = 0; i < num; i++) {
			System.out.println("Hi");
		}
	}
	
	public void factorial() {
		System.out.println("Enter a number: ");
		int num = input.nextInt();
		int finalNum = num;
		while (num > 1) {
			num --;
			finalNum *= num;
		}
		System.out.println(finalNum);
	}
	
	public void keepPlaying() {
		while (true) {
			System.out.println("Do you want to keep playing? (All lowercase)");
			String input = this.input.next();
			if (input.equals("no")) {
				System.out.println("Gameover!");
				return;
			}
		}
	}
	
	public void divisibleNums() {
		System.out.println("Enter a number: ");
		int num = input.nextInt();
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				System.out.println(i);
			}
		}
	}
	
	public void prime() {
		System.out.println("Enter a number: ");
		int num = input.nextInt();
		if (num == 1 || num == 0) {
			System.out.println("Not Prime!");
			return;
		}
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				System.out.println("Not Prime!");
				return;
			}
		}
		System.out.println("Prime!");
	}
	
	public int sqrt(int num) {
		int root = 0;
		while (Math.pow(root, 2) <= num) {
			if (Math.pow(root, 2) == num) {
				System.out.println(num);
				return num;
			}
			root++;
		}
		System.out.println("-1");
		return -1;
	}
	
	public int addUpTo(int num) {
		int count = 0;
		for (int i = 0; i < num; i++) {
			count += i;
			if (count == num) {
				System.out.println(num);
				return num;
			}
		}
		System.out.println("-1");
		return -1;
	}
	
	public void magicSquare() {
		System.out.println("Enter a number: ");
		int num = input.nextInt();
		for (int i = 0; i < num; i++) {
			int count = 2;
			while (true) {
				int current = sqrt(count);
				if (current > 0) {
					if (current > 0) {
						System.out.println(current);
						return;
					}
				}
				count++;
			}	
		}
	}
	
	public static void main(String[] args) {
		MoreWithLoops runner = new MoreWithLoops();
		runner.magicSquare();
	}
}
