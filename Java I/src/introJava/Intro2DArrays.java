package introJava;
// 1. A6 B1 COut of bounds D3 Ek FOut of bounds G105 Hk I{7, 6}
import java.util.Arrays;

public class Intro2DArrays {
	
	public static void numsArr(int n) {
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] =i*n + j;
			}
		}
		for(int[] rows: arr) {
			System.out.println(Arrays.toString(rows));
		}
	}
	
	public static void countSize(String[][] s) {
		System.out.println(s[0].length +" "+ s.length);
	}
	
	public static void include(int i1, int i2, int i3, int i4, int i5, int i6) {
		int[][] arr = {{i1}, {i2, i3}, {i4, i5, i6}};
		for(int[] rows: arr) {
			System.out.println(Arrays.toString(rows));
		}
	}
	
	public static void main(String[] args) {
		include(1,2,3,4,5,6);
	}
}