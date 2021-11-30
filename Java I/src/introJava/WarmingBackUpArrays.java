package introJava;

import java.util.Arrays;

public class WarmingBackUpArrays {
//	Write a method that takes a number n as parameter.
//	You should then build an array containing the first n values of the Fibonacci sequence. Print this array.
	public static void fibSequence(int n) {
		int[] arr = new int[n];
		arr[0] = 0;
		if(n > 1) {
			arr[1] = 1;
			for(int i = 2; i < n; i++) {
				arr[i] = arr[i-1] + arr[i-2];
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void risingAverage(int[] arr) {
		double[] arr2 = new double[arr.length];
		double total = 0;
		for(int i = 0; i < arr.length; i++) {
			total += arr[i];
			arr2[i] = total/(i+1);
		}
		System.out.println(Arrays.toString(arr2));
	}
	public static void main(String[] args) {
		risingAverage(new int[] {4, 5, 2, 7});
	}
}