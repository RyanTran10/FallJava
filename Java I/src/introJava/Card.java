package introJava;

import java.util.Arrays;

public class Card {
//	suit (a string which can be "clubs", "hearts", "diamonds", or "spades")
//	num (an int which can be between 1 and 13). 
//	It should also have some methods: 
//
//	a constructor
//	toString
//	any appropriate get methods you may need
	private String suit;
	private int num;
	
	public Card(String suit, int num) {
		this.suit = suit;
		this.num = num;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public int getNum() {
		return num;
	}
	
	public String toString() {
		return("This card is a " + num + " of " + suit);
	}
 	public static void main(String[] args) {
	}
}