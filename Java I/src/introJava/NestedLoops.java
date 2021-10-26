package introJava;

import java.util.Scanner;

public class NestedLoops {
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
	
	public void nByM(int n, int m) {
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void allLetters() {
		for (int i = 65; i < 91; i++) {
			System.out.print((char)i);
		}
	}
	
	public void multipleTable() {
		for (int i = 1; i < 13; i++) {
			for (int j = 1; j < 13; j++) {
				System.out.print(j*i + ", ");
			}
			System.out.println();
		}
	}
	
	public void primes(int n) {
		for(int i = 1; i <= n; i++) {
			boolean divisor = false;
			for (int factor = 2; factor <= i/2; factor++) {
				if (i%factor == 0) {
					divisor = true;
					break; 
				}
			}
			if (!divisor) {
				System.out.println(i++);
			}
		}
	}
	
	public void starX(int n) {
		int error = 0;
		for (int row = 1; row <= n; row++) {
			for (int j = 0; j < error; j++) {
				System.out.print(" ");
			}
			if (row != (n+1)/2 && n%2 != 0) {
				System.out.print("*");
			}
			else if (n%2 == 0){
				System.out.print("*");
			}
			for (int mid = 1; mid <= n - 2*row; mid++) {
				System.out.print(" ");
			}
			if (row > (n+1)/2) {
				for (int mid = 3; mid <= 2*row - n; mid++) {
					System.out.print(" ");
				}
			}
			System.out.print("*");
			System.out.println("");
			if (row <= (n-1)/2) {
				error++;
			}
			if (row > n/2) {
				error--;
			}
		}
	}
	
	public static void main(String[] args) {
		NestedLoops runner = new NestedLoops();
		runner.starX(16);
	}
}
