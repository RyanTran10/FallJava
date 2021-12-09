package introJava;

import java.util.Arrays;

public class MoreWithStrings {
	
	public static void f2l2(String s) {
		System.out.println(s.substring(0,2).equals(s.substring(s.length()-2)));
	}
	
	public static void containsLetters(String s, String s1) {
		for(int i = 0; i < s1.length(); i++) {
			System.out.println(s.contains(s1.charAt(i) +""));
		}
	}
	
	public static void countWords(String s) {
		System.out.println(s.split(" ").length);
	}
	
	public static void stringToArr(String s) {
		System.out.println(Arrays.toString(s.split(" ")));
	}
	
	public static void replaceChars(String s, String c) {
		System.out.println(s.replaceAll(c, ""));
	}
	
	public static void main(String[] args) {
		replaceChars("let's eat there", "e");
	}
}