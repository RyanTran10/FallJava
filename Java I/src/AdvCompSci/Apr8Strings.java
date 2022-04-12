package AdvCompSci;

import java.util.ArrayList;

public class Apr8Strings {
	
	public static ArrayList<Integer> relativeMaximum(double[] d) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i = 1; i < d.length-1; i++) {
			if(d[i] > d[i-1] && d[i] > d[i+1]) {
				a.add(i);
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		System.out.println(relativeMaximum(new double[] {5.5,6.3,4.4,9.2,7.7}));
	}
}
