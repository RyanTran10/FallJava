package introJava;

import java.awt.Color;
import java.util.Arrays;

public class Wrestler {
	
	private double weight;
	private String outFitcolor;
	private int wins;
	private String name;
	
	public Wrestler(int w, String o, int wins, String n) {
		weight = w;
		outFitcolor = o;
		this.wins = wins;
		name = n;
	}
	
	public void intimidate() {
		System.out.println("I will tear you apart");
	}
	
	public String toString() {
		return("Wrestler " + name + " has " + wins + " wins and weighs " + weight + " with an outfit of color " + outFitcolor);
	}
	
	public void lift(int n) {
		weight += .01*n;
	}
	
	public void won() {
		wins++;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean fight(Wrestler w) {
		if(weight > w.weight) {
			wins++;
			return true;
		} else if (weight < w.weight) {
			w.won();
			return false;
		} else if (name.compareToIgnoreCase(w.getName()) < 0) {
			wins++;
			return true;
		} else {
			w.won();
			return false;
		}
	}
	public void setColor(String s) {
		outFitcolor = s;
	}
	
	public String getColor() {
		return outFitcolor;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void tagTeam(Wrestler[] w, Wrestler[] w2) {
		double total = getWeight();
		double total1 = 0;
		for(int i = 0; i < w.length; i++) {
			w[i].setColor(getColor());
			total += w[i].getWeight();
		}
		for(int i = 0; i < w2.length; i++) {
			w[i].setColor(w[0].getColor());
			total1 += w2[i].getWeight();
		}
		if(total1 > total) {
			for(int i = 0; i < w2.length; i++) {
				w2[i].won();
			}
		} else {
			for(int i = 0; i < w.length; i++) {
				w[i].won();
			}
		}
	}
	
//	Tag Team: This method takes two arrays of wrestlers as opponents. The first array represents our wrestler's 
//	allies. The second represents the opponents. First off, the allies' all need to change into our wrestler's 
//	outfit color so that they match. The opponents will all wear the same color as the first wrestler in the opponent 
//	array. Then, a winning team is determined by the higher total weight (make sure you include our wrestler). 
//	In the case of a tie, our wrestler's team wins. Each of the winning wrestlers need their win total to increase by 1. 

	public static void main(String[] args) {
	}
}