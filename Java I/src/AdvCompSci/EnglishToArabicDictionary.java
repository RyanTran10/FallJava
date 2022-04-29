package AdvCompSci;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class EnglishToArabicDictionary {

	private final String fileName = "EnglishToArabicDictionary.txt";
	private HashMap<String, String> dictionary = new HashMap<String, String>();
	
	public void setUp() {
		try {
			BufferedReader in = new BufferedReader(
					new FileReader(fileName));
			
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				dictionary.put(line, in.readLine());
			}
			
			in.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String translate(String s) {
		return dictionary.get(s);
	}
 	
	public static void main(String[] args) {
		EnglishToArabicDictionary runner = new EnglishToArabicDictionary();
		Scanner s = new Scanner(System.in);
		runner.setUp();
		while(true) {
			System.out.println(runner.translate(s.next()));
		}
	}
	

}
