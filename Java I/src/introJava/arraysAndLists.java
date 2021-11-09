package introJava;

import java.util.Scanner;

public class arraysAndLists {
	
	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}
	
	public static void oneToN(int n) {
		int[] arr = new int[n];
		for (int i = 1; i <= n; i++) {
			arr[i - 1] = i;
		}
		display(arr);
	}
	
	public static void swap(int[] arr) {
		int x = arr[0];
		arr[0] = arr[arr.length-1];
		arr[arr.length-1] = x;
		display(arr);
	}
	
	public static void userArray(int n) {
		Scanner input = new Scanner(System.in);
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Pick a number!");
			arr[i] = input.nextInt();
		}
		display(arr);
	}
	
	public static void reverse(int[] arr) {
		int[] arr2 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = arr[arr.length -1 - i]; 
		}
		display(arr2);
	}
	
	public static void main(String[] args) {
		int[] arr = {6, 7, 8, 9, 5};
		reverse(arr);
		
	}
}
