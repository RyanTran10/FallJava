package introJava;

import java.util.ArrayList;

public class MoreListAlgorithims {

	 

//	Create a method that takes two integers as parameter (n and x), and return a list of n random numbers between -x and x.
//	 
	public static ArrayList<Integer> randomNums(int n, int x) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			a.add((int)(Math.random()*x*2)-x);
		}
		return a;
	}
	
	// double version
	
	public static ArrayList<Double> randomDoubles(int n, int x) {
		ArrayList<Double> a = new ArrayList<Double>();
		for(int i = 0; i < n; i++) {
			a.add((Math.random()*x*2)-x);
		}
		return a;
	}
//
//	Create a method that takes a list of integers as parameter. The method should then separate these numbers into 
//	two ArrayLists: one for positive integers, the other for negative integers. Print both of these lists (we can't return them both).
//	For example, if the random ArrayList was [-9, 3, 42, -17, -19], we would get [3, 42] and [-9, -17, -19].
//
	public static void PosNeg(ArrayList<Integer> a) {
		ArrayList<Integer> pos = new ArrayList<Integer>();
		ArrayList<Integer> neg = new ArrayList<Integer>();
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i) > 0) {
				pos.add(a.get(i));
			} else {
				neg.add(a.get(i));
			}
		}
		System.out.println(pos);
		System.out.println(neg);
	}
//	 
//
//	Create a method that takes a list of doubles as parameter. Reverse this list without creating any new lists. 
//	Do you need to return anything?
	
	public static void reverse(ArrayList<Double> a) {
		for(int i = 0; i < a.size()/2; i++) {
			double temp = a.get(i);
			a.set(i, a.get(a.size()-i-1));
			a.set(a.size()-1-i, temp);
		}
	}

	public static void main(String[] args) {
		ArrayList<Double> a = randomDoubles(10, 10);
		System.out.println(a);
		reverse(a);
		reverse(a);
		System.out.println(a);
	}

}
