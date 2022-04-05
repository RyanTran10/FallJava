package ListsAndReferences;

import java.util.ArrayList;

public class Lists {
//	Write a method that takes a list of characters as a parameter. These characters should then be concatenated to form one String. 
//    For example: ['h','e','l','l','o']     -->     "hello"
//	
	public static String formWord(ArrayList<Character> c) {
		String s = "";
		for(int i = 0; i < c.size(); i++) {
			s += c.get(i);
		}
		return s;
	}
//	Write a method that takes a list of doubles as parameter. It should then do the following: average the numbers in the list. 
//	Set the first value in the list to this average. Repeat this step, but now set the second element in the list to the average 
//	with this new value. Repeat until you have changed each element in the list to an average. 
//    For example: [3.0, 6.0, 1.0, 8.0, 19.0] -->  [7.4, 8.3, 8.7, 10.3, 10.7]
//
	public static void average(ArrayList<Double> d) {
		for(int i = 0; i < d.size(); i++) {
			double t = 0;
			for(int j = 0; j < d.size(); j++) {
				t += d.get(j);
			}
			d.set(i, t/d.size());
		}
	}
//    Write a method that takes an array of integers as parameter. It should then do the following: add the first element to the list.
//    Next, add the first two elements to the list. Next, add the first 3 elements to the list. Continue this until you reach a step 
//    where you add all the elements of the array to the list.
//    For example: [3, 1, 4, 2]  --> [3, 3, 1, 3, 1, 4, 3, 1, 4, 2]
	public static ArrayList<Integer> addAllEle(int[] a) {
		ArrayList<Integer> d = new ArrayList<Integer>();
		for(int i = 0; i < a.length+1; i++) {
			for(int j = 0; j < i; j++) {
				d.add(a[j]);
			}
		}
		return d;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {3,1,4,2};
		System.out.println(addAllEle(a));

	}

}
