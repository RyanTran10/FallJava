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
	
	public void primes(int x) {
		for (int i = 0; i < 10000; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j != 0) {
					System.out.print(j + ", ");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		NestedLoops runner = new NestedLoops();
		runner.primes(5);
	}
}
