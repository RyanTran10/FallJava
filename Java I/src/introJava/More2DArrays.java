package introJava;

import java.util.Arrays;

public class More2DArrays {
	
	public static void makeArr(int n, int m) {
		int[][] arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				arr[i][j] = i*m+j+1;
			}
		}
		display(arr);
	}
	
	public static void maximum(int[][] arr) {
		int max = arr[0][0];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] > max) {
					max = arr[i][j];
				}
			}
		}
		System.out.println(max);
	}
	
	public static void average(int[][] arr) {
		int total = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
			}
		}
		System.out.println(total/(arr.length*arr[0].length));
	}
	
	public static void adding(int[][] arr) {
		int[] arr1 = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			int total = 0;
			for(int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
			}
			arr1[i] = total;
		}
		display1D(arr1);
	}
	
	public static boolean magic(int[][] arr) {
		int len = arr.length;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].length != arr.length) {
				return false;
			}
		}
		int magicnum = 0;
		for(int i =0; i < len; i++) {
			magicnum += arr[0][i];
		}
		
		for(int i = 0; i < len; i++) {
			int total = 0;
			int total1 = 0;
			for(int j = 0; j < len; j++) {
				total += arr[i][j];
				total1 += arr[j][i];
			}
			if(total != magicnum || total1 != magicnum) {
				return false;
			}
		}
		int total = 0;
		int total1 = 0;
		for(int i = 0; i < len; i++) {
			total += arr[i][i];
			total1 += arr[len-1-i][len-1-i];
		}
		return(total == magicnum && total1 == magicnum);
	}
	
	public static void display1D(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}
	public static void display(int[][] arr) {
		for(int[] rows : arr) {
			System.out.println(Arrays.toString(rows));
		}
	}

	public static void main(String[] args) {
		System.out.println(magic(new int[][] {{1,3,5,2,4}, {5,2,4,1,3}, {4,1,3,5,2}, {3,5,2,4,1}, {2,4,1,3,5}}));
	}
}