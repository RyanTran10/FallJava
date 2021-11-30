package introJava;

import java.util.Arrays;

public class WarmingBackUpArrays {
	public static void printEach(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
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
	
	public static void trim(int[] arr) {
		int[] arr2 = new int[arr.length-2];
		int min = arr[0];
		int max = arr[0];
		int error = 0;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}else if(arr[i] < min) {
				min = arr[i];
			}
		}
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != min && arr[i] != max) {
				arr2[i-error] = arr[i];
			}else {
				error++;
			}
		}
		System.out.println(Arrays.toString(arr2));
	}
	
	public static void divAhead(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			if(arr[i]%arr[i-1] == 0) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}
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
	
	public static void reverse(String[] arr, int n) {
		for (int i = 0; i < n; i++) {
			String temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public static void dotProduct(int[] arr, int[] arr2) {
		int total = 0;
		for(int i = 0; i < arr.length; i++) {
			total += arr[i] * arr2[i];
		}
		System.out.println(total);
	}
	
	public static void main(String[] args) {
	}
}