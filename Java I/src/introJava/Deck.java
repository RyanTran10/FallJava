package introJava;

import java.util.Arrays;


public class Deck {
//a constructor (which fills the array with the 52 possible different cards)
//toString (which uses all 52 Cards' toString methods to return a string showing the contents of the Deck)
//getRandom (which returns a random Card from the Deck)
//getFirstN (which takes a parameter n, and returns an array of Cards containing the first n Cards in the Deck)
//shuffle (which randomly mixes the Cards. How you shuffle the deck is up to you. If you'd like a challenge, try to simulate a real-life shuffle)
//sort (which sorts the cards by num. Ignore the suit when sorting, so a sorted deck will be: 2,2,2,2,3,3,3,3,4,4,...)
	private Card[] deck = new Card[52];
	private String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
	
	public Deck() {
		
		for(int i = 0; i < suits.length; i++) {
			for(int j = 0; j < 13; j++) {
				deck[i*13 + j] = new Card(suits[i], j+1);
			}
		}
	}
	
	public Card[] getDeck() {
		return deck;
	}
	
	public Card getRandom() {
		return(deck[(int) (Math.random()*52)]);
	}
	
	public Card[] getFirstN(int n) {
		Card[] c = new Card[n];
		for(int i = 0; i < n; i++) {
			c[i] = deck[i];
		}
		return c;
	}
	
	public Card[] getLastN(int n) {
		Card[] c = new Card[n];
		for(int i = 51; i >= n; i--) {
			c[i-n] = deck[i];
		}
		return c;
	}
	public void shuffle() {
		Card[] c1 = getFirstN(26);
		Card[] c2 = getLastN(26);
		Card[] d1 = new Card[52];
		int count = 0;
		int c1Count = 0;
		int c2Count = 0;
		boolean current = true;
		
		for(int i = 52; i > 0;) {
			int temp = (int)(Math.random()*5)+1;
			if(current && 26 - c1Count > 5) {
				for(int j = 0; j < temp; j++) {
					d1[count] = c1[c1Count];
					count++;
					c1Count++;
					i--;
				}
				current = false;
			} else if(current) {
				for(int j = c1Count; j < 26; j++) {
					d1[count] = c1[c1Count];
					count++;
					c1Count++;
					i--;
				}
				current = false;
			} else if(!current && 26 - c2Count > 5) {
				for(int j = 0; j < temp; j++) {
					d1[count] = c2[c2Count];
					count++;
					c2Count++;
					i--;
				}
				current = true;
			} else {
				for(int j = c2Count; j < 26; j++) {
					d1[count] = c2[c2Count];
					count++;
					c2Count++;
					i--;
				}
				current = true;
			}
		deck = d1;
		}
	}
	
	public void sort() {
		for(int i = 0; i < deck.length; i++) {
			int min = Integer.MAX_VALUE;
			int minInd = i;
			for(int j = i; j < deck.length; j++) {
				if(deck[j].getNum() < min) {
					min = deck[j].getNum();
					minInd = j;
				}
			}
			Card temp = deck[i];
			deck[i] = deck[minInd];
			deck[minInd] = temp;
		}
	}
	
	public String toString() {
		String s = "";
		for(Card c: deck) {
 			s += c.toString() + "\n";
 		}
		return s;
	}
 	public static void main(String[] args) {
 		Deck deck1 = new Deck();
 		System.out.println(deck1.toString());
	}
}