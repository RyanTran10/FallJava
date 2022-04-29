package AdvCompSci;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MoreWithMaps {
	private Scanner s = new Scanner(System.in);
//	Take a String -> Integer map as parameter. This map holds the stock value of companies. Let the user choose a company name. 
//	Print out the value for this company. Except, if they type "average", print the average value of all companies. If they type 
//	in a company name that doesn't exist in the map, print out the most value company. 
//	 
	public void stocks(HashMap<String, Integer> st) {
		while(true) {
			String curr = s.next();
			if(curr.equals("average")) {
				Integer a = 0; 
				for(Integer i: st.values()) {
					a += i;
				}
				System.out.println(a/st.size());
			} else if (st.containsKey(curr)) {
				System.out.println(st.get(curr));
			} else {
				Integer max = Integer.MIN_VALUE; 
				for(Integer i: st.values()) {
					if(i > max) {
						max = i;
					}
				}
				System.out.println(max);
			}
		}
	}
//
//	Take a String -> String map as parameters. This map holds a person and their 009 target. So the entire map will be circular. 
//	Let the user choose a name. Start at this person, and print out their target. Then print this target's target. Continue doing 
//	this until you return to the original person. For example, if the map is [Ryan -> Yumna, Cooper -> Anika, Anika -> Ryan, 
//	Yumna -> Cooper] and the user enters "Cooper", 
//	we would see Cooper, Anika, Ryan, Yumna. 
	
	public void doubleONine(HashMap<String, String> players) {
		String name = s.next();
		String curr = players.get(name);
		System.out.println(name + " -> " + players.get(name));
		while(!name.equals(curr)) {
			System.out.println(curr + " -> " + players.get(curr));
			curr = players.get(curr);
		}
	}

//	Create a map that represents Morse Code. Then use this map to convert user messages from English to Morse Code.
	public void englishToMorse(HashMap<Character, String> m) {
		String[] str = s.nextLine().split("");
		System.out.println(Arrays.toString(str));
		System.out.println("");
		for(int i = 0; i < str.length; i++) {
			System.out.print(m.get(str[i].charAt(0)));
		}
	}
	
//	Use a map to find the 5 most common words in a text file.
	
	public void mostCommonWord(String fileName) {
		HashMap<String, Integer> count = new HashMap<String, Integer>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				String temp = line.replaceAll("[^a-zA-Z0-9 ']", "");
				String[] str = temp.split(" ");
				for(int i = 0; i < str.length; i++) {
					if(count.containsKey(str[i])) {
						count.put(str[i], count.get(str[i]) + 1);
					} else {
						count.put(str[i], 1);
					}
				}
			}
			
			in.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] keys = new String[5];
		Integer[] counts = new Integer[]{0,0,0,0,0};
		for(String s : count.keySet()) {
			for(int i = 0; i < counts.length; i++) {
				if(count.get(s) > counts[i]) {
					counts[i] = count.get(s);
					keys[i] = s;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(keys));
	}
	public static void main(String[] args) {

		HashMap<String, Integer> comps = new HashMap<String, Integer>();
		comps.put("apple", 700);
		comps.put("ibm", 400);
		comps.put("tesla", 1000);
	
		MoreWithMaps runner = new MoreWithMaps();
//		runner.stocks(comps);
		
		HashMap<String, String> people = new HashMap<String, String>();
		people.put("Ryan", "Yumna");
		people.put("Cooper", "Anika");
		people.put("Anika", "Ryan");
		people.put("Yumna", "Cooper");
		
//		runner.doubleONine(people);
		
		
		 HashMap<Character, String> morse = new HashMap<Character, String>();
         morse.put('a', ".-");
         morse.put('b', "-...");
         morse.put('c',  "-.-");
         morse.put('d',  "-..");
         morse.put('e',    ".");
         morse.put('f', "..-.");
         morse.put('g',  "--.");
         morse.put('h', "....");
         morse.put('i',   "..");
         morse.put('j', ".---");
         morse.put('k',   "-.");
         morse.put('l', ".-..");
         morse.put('m',   "--");
         morse.put('n',   "-.");
         morse.put('o',  "---");
         morse.put('p', ".--.");
         morse.put('q', "--.-");
         morse.put('r', ".-.");
         morse.put('s',  "...");
         morse.put('t',   "-");
         morse.put('u',  "..-");
         morse.put('v', "...-");
         morse.put('w',  ".--");
         morse.put('x', "-..-");
         morse.put('y', "-.--");
         morse.put('z', "--..");
         morse.put('1', ".----");
         morse.put('2',"..---");
         morse.put('3', "...--");
         morse.put('4', "....-");
         morse.put('5', ".....");
         morse.put('6', "-....");
         morse.put('7', "--...");
         morse.put('8', "---..");
         morse.put('9', "----.");
         morse.put('0', "-----");
         morse.put(' ', "/");
//       runner.englishToMorse(morse);
         runner.mostCommonWord("Song");
	}

}
