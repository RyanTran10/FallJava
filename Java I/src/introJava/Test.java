package introJava;

import java.util.Scanner;

public class Test {
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
	public static void digital_root(int n) {
	    int answer=0;
			while(n>=1) {
				answer += (n%10);
			  n /=10;
			}
			if (answer >= 10) {
				digital_root(answer);
			}
			else {
				System.out.println(answer);
			}
	  }
	
	public static void main(String[] args) {
		Test runner = new Test();
		runner.digital_root(942);
	}
}
