package introJava;

import java.awt.Color;
import java.util.Arrays;

public class EvenMoreWith2DArrays {
//	Easy: Write a method that takes a 2d array of characters as parameter. Create a string built out of these characters.
//
//    for example: {{'h', 'e', 'l'}, {'l', 'o'}}   ->  "hello"
//	
	public static void combine(char[][] cArr) {
		String s = "";
		for(int i = 0; i < cArr.length; i++) {
			for(int j = 0; j < cArr[i].length; j++) {
				s += cArr[i][j];
			}
		}
		System.out.println(s);
	}
	
//	Easy: Write a method that takes an integer n as parameter. Create a square 2d array of size nxn. 
//	Fill in the diagonals of this square matrix with n's. 
//
	public static void nXArr(int n) {
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			arr[i][i] = n;
			arr[i][n-i-1] = n;
		}
		for(int[] row: arr) {
			System.out.println(Arrays.toString(row));
		}
	}
//	Medium: Write a method that takes an integer n as parameter. Create a 2d array holding an nxn triangle 
//	of consecutive numbers starting at 1.
//
//    for example: n = 4 ->  {{1},{2,3},{4,5,6},{7,8,9,10}}
//
	public static void nTriArr(int n) {
		int[][] arr = new int[n][];
		int count = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = new int[i+1];
			for(int j = 0; j < i+1; j++) {
				count++;
				arr[i][j] = count;
			}
		}
		for(int[] row: arr) {
			System.out.println(Arrays.toString(row));
		}
	}
//	Medium: Write a method that takes a 2d array of integers as parameter. Create a 2d array that contains 
//	the same number of rows, but twice as many columns, alternating 0's and elements from the parameter array.
//
//    for example: {{1, 2, 3}, {4, 5, 6}} -> {{1, 0, 2, 0, 3, 0}, {4, 0, 5, 0, 6, 0}}
//
	public static void spaceOut(int[][] arr) {
		int[][] arr2 = new int[arr.length][arr[0].length*2];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length*2; j++) {
				if(j%2 == 0) {
					arr2[i][j] = arr[i][j/2];
				} else {
					arr2[i][j] = 0;
				}
				
			}
		}
		for(int[] row: arr2) {
			System.out.println(Arrays.toString(row));
		}
	}
//	Medium: Write a method that takes a 2d array of doubles as parameter. Your method should reverse each row in the array. 
//
	public static void reverse(double[][] arr) {
		for(int i = 0; i < arr.length; i++) {
				double[] temp = new double[arr[i].length];
				for(int j = 0; j < arr[i].length; j++) {
					temp[j] = arr[i][arr[i].length-1-j];
				}
				arr[i] = temp;
		}
		for(double[] row: arr) {
			System.out.println(Arrays.toString(row));
		}
	}
//	Hard: Write a method that takes a 2d array of doubles as a parameter. Your method should create a new 1d 
//	array containing the sum of each column. 
//
	public static void addColumns(double[][] arr) {
		double[] arr2 = new double[arr.length];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr2[i] += arr[i][j];
				System.out.println(Arrays.toString(arr2));
			}
		}
		
		for(double[] row: arr) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println(Arrays.toString(arr2));
	}
//
//
//	Challenge: Write a method that sorts a 2d array of integers.
//
//	Extra-challenge: Write a method that sorts the 2d array snake-style. So the first row will increase left 
//	to right, the second row will increase right to left, third left to right, and so on.
	public static void main(String[] args) {
		addColumns(new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}});
	}
}