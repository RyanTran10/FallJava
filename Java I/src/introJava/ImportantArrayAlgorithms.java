package introJava;

import java.util.Arrays;
import java.util.Scanner;

public class ImportantArrayAlgorithms {
//	Take an array of integers as parameter. Find the maximum value in the array and return its index (why return its index?).
	public static int biggest(int[] arr) {
		int maxI = 0;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > arr[maxI]) {
				maxI = i;
			}
		}
		return maxI;
	}
//
//	Take an array of strings as parameter. Reverse the array (we did this for HW, try to make your solution efficient now) and return it.
	public static String[] reverse(String[] arr) {
		for (int i = 0; i < arr.length/2; i++) {
			String temp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		}
		return arr;
	}
//	Take an array of integers as parameter. Return the average of the values. 
	
	public static double average(int[] arr ) {
		double sum = 0;
		for (int num: arr) {
			sum += num;
		}
		return sum/arr.length;
	}
	
//	Take two arrays of characters as parameter. Merge these two arrays into one array (first array, followed by the second) and return this.
	public static char[] merge(char[] arr1, char[] arr2) {
		char[] newArr = new char[arr1.length + arr2.length];
		for (int i = 0; i < arr1.length; i++) {
			newArr[i] = arr1[i];
		}
		for (int i = 0; i < arr2.length; i++) {
			newArr[i+arr1.length] = arr2[i];
		}
		return newArr;
	}
	
	public static void main(String[] args) {
		String[] arr = new String[] {"Hi", "Bye", "Hello", "Goodbye"};
		System.out.println(Arrays.toString(reverse(arr)));
	}
}