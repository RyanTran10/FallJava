package introJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class IntroLists {

//	Complete each of the following 4 problems, and a main method. Each of these methods returns a list, 
//	your main method should print the value returned by each method.
//
//	Create a method that takes a list of characters as a parameter. Remove every second element from the list, 
//	then return the list.
//	For example: ['d', 'k', 'e', 'p', 'w', 's', 'f'] --> ['k', 'p', 's']
	public static ArrayList<Character> removeEverySecond(ArrayList<Character> a) {
		int count = 1;
		while(count < a.size()) {
			a.remove(count);
			count++;
		}
		return(a);
	}
//
//	Create a method that takes an array of strings as a parameter. Create a new list, and add each of the elements 
//	of the array to the list in reverse order. Return this list.
//	For example: {"lists", "are", "great"} --> ["great", "are", "lists"]
	
	public static ArrayList<String> arrayToList(String[] s) {
		ArrayList a = new ArrayList<String>();
		for(int i = 0; i < s.length; i++) {
			a.add(0,s[i]);
		}
		return a;
	}
//
//	Create a method that takes a list of doubles as parameter. Set each element in the list equal to double its 
//	original value. Return this list. 
//	 
	public static ArrayList<Double> Doubling(ArrayList<Double> a) {
		for(int i = 0; i < a.size(); i++) {
			a.set(i, a.get(i)*2);
		}
		return a;
	}
//	Create a method takes a parameter n. It should first create a new list of characters. The letters of the 
//	alphabet should then be added in this way: add 'a' to the front of the list, then add 'b' to the back of the list,
//	then add 'c' to the front of the list, then add 'd' to the back of the list, and so on. Do this n times. 
//	For example if n = 5, the list would be ['e', 'c',' a', 'b', 'd']
	
	public static ArrayList<Character> weirdAlpha(int n) {
		ArrayList<Character> a = new ArrayList<Character>();
		for(int i = 97; i < 97+n; i++) {
			if(i % 2 == 1) {
				a.add(0,(char)(i));
			} else {
				a.add((char)(i));
			}
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(weirdAlpha(5));
		
	}

}
