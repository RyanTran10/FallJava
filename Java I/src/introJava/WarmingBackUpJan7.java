package introJava;

import java.util.ArrayList;
import java.util.Arrays;

public class WarmingBackUpJan7 {
	public static void alphabetical(String s) {
		s.toLowerCase();
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i-1) > s.charAt(i)) {
				System.out.println("False");
				return;
			}
		}
		System.out.println("True");
	}
	
	public static void grades(String[] students, int[] grades) {
		int ind = 0;
		for(int i = 1; i < grades.length; i++) {
			if(grades[ind] > grades[i]) {
				ind = i;
			}
		}
		System.out.println(students[ind]);
	}
	
	public static void perfectSquares(int n) {
		int[] arr = new int[n];
		int count = 1;
		for(int i = 0; i < n; i++) {
			if((count*count)%2 == 1) {
				arr[i] = count*count;
				count++;
			}
			else {
				i--;
				count++;
				continue;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void threes(String s) {
		String str = "";
		int count = 0;
		for(int i = 0; i <s.length(); i++) {
			if(count < 3) {
				str += s.charAt(i);
				count++;
			} else {
				i += 2;
				count = 0;
			}
		}
		System.out.println(str);
	}
	
	public static ArrayList<Integer> prime(int n){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		for(int i = 3; i <= n; i++) {
			boolean divisor = false;
			for (int factor = 2; factor <= i/2; factor++) {
				if (i%factor == 0) {
					divisor = true;
					break; 
				}
			}
			if (!divisor) {
				primes.add(i);
			}
		}
		return primes;
	}
	private static ArrayList<Integer> primes = prime(298778);
	
	public String primeFactorization(int n, ArrayList<Integer> primes) {
		for(int i = 0; i < primes.size(); i++) {
			if(n%primes.get(i) == 0) {
				return primes.get(i)+" "+primeFactorization(n/primes.get(i), primes);
			}
		}
		return "";
	}

	public static void main(String[] args) {
		WarmingBackUpJan7 runner = new WarmingBackUpJan7();
		System.out.println(runner.primeFactorization(298778, primes));
	}
}