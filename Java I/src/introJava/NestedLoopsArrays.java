package introJava;

import java.util.Arrays;
import java.util.Scanner;

public class NestedLoopsArrays {
	private Scanner input = new Scanner(System.in);
	
	public static void dupes(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			boolean duplicateFound = false;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] == arr[i]) {
					duplicateFound = true;
				}
			}
			if(!duplicateFound) {
				System.out.println(arr[i]);
			}
		}
	}
	
	public static void common(int[] arr, int[]arr1) {
		for(int i = 0; i < arr.length; i++) {
			boolean duplicateFound = false;
			for(int j = 0; j < arr1.length; j++) {
				if(arr1[j] == arr[i]) {
					duplicateFound = true;
				}
			}
			if(duplicateFound) {
				System.out.println(arr[i]);
			}
		}
	}
	
	public static int[] intToArr(int n) {
		int length = String.valueOf(n).length();
		int[] arr = new int[length];
		for(int i = length-1; i >= 0; i--) {
			arr[i] = n%10;
			n/=10;
		}
		return arr;
	}
	
	public static String[] words(char[] arr, char[] arr1) {
		String[] arr2 = new String[arr.length];
		for(int i = 0; i < arr.length; i++) {
			String temp = arr[i] +"";
			for(int j = 0; j < arr1.length; j++) {
				temp += arr1[j];
			}
			arr2[i] = temp;
		}
		return arr2;
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1, 4, 1, 3, 1, 4, 7};
		int[] arr1 = new int[] {5, 2, 4, 5, 6, 2, 3};
		char[] arr2 = new char[] {'g', 'l', 'e', 't'};
		char[] arr3 = new char[] {'o', 'a', 'd'};
		Arrays.toString(words(arr2, arr3));
	}
}