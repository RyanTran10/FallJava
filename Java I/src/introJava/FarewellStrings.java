package introJava;

import java.util.Arrays;

public class FarewellStrings {
	public static void pigLatin(String s) {
		String[] words = s.split(" ");
		for(int i = 0; i < words.length; i++) {
			words[i] = words[i].substring(1) + words[i].charAt(0) + "ay";
		}
		System.out.println(Arrays.toString(words));
	}
	
	public static void seperate(String s, char c) {
		for(int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i) == c ? "$" : s.charAt(i));
		}
	}
	
	private static void longestWord(String[] words) {
		String longest = "";
		for(int i = 0; i < words.length; i++) {
			if(words[i].length() > longest.length()) {
				longest = words[i];
			}
		}
		System.out.println(longest);
	}
	public static void main(String[] args) {
	}
}