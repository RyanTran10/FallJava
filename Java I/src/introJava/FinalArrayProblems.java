package introJava;

public class FinalArrayProblems {
	public static void indexWeighted(double[] arr) {
		double total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += i *arr[i];
		}
		System.out.println(total);
	}
	
	public static void addAdjacent(int[] arr, int n) {
		for(int i = 1; i < arr.length; i++) {
			if(arr[i]+arr[i-1] == n) {
				System.out.println("Yes");
				return;
			}
		}
		System.out.println("No");
	}
	
	public static void lowerCaseString(char[] arr) {
		String str = "";
		for(int i = 0; i < arr.length; i++) {
			if((int)(arr[i]) > 96 && (int)(arr[i]) < 123) {
				str += arr[i];
			}
		}
		System.out.println(str);
	}
	
	public static void anagram(int[] arr, int[] arr2) {
		boolean found = false;
		int lastFound = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i] == arr2[j]) {
					arr2[j] = Integer.MAX_VALUE;
					found = true;
				}
			}
			if (!found) {
				System.out.println("False");
				return;
			}
			found = false;
		}
		System.out.println("True");
		
	}
	
	public static void main(String[] args) {
		anagram(new int[] {1, 3, 5, 2, 8, 9}, new int[] {3, 5, 1, 8, 9, 2});
	}
}