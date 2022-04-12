package AdvCompSci;

public class JosephusProblem {
	
	public static int josephus(int n) {
	    int res = 0;
	    for (int i = 1; i <= n; i++)
	    	res = (res + 2) % i;
	    return res + 1;
	}
	public static void main(String[] args) {
		System.out.println(josephus(6));
	}
}