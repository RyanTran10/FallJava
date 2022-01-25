package introJava;

import java.util.Arrays;

public class Human {
	
//	Your job is to create a Human object - similar to the one I made an example of in class, but with more functionality. 
//	Your human should keep track of a few pieces of information (at least its age and name, if not more), have a constructor 
//	to set the values of this data, and have a few simple methods. There should be a display method that prints out the information 
//	for this human, a getOlder method that increases its age by 1, a changeName method that allows the user to change this human's 
//	name, a canVote method that takes a year as input: if the year is an election year (2012, 2016, 2020, etc) and the human is at 
//	least 18, this human can vote. 
	
	private int age;
	private int height;
	private String name;
	
	public Human(int age, int height, String name) {
		this.age = age;
		this.height = height;
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int newAge) {
		age = newAge;
	}
	
	public String getName() {
		return name;
	}
	public void changeName(String newname) {
		name = newname;
	}
	
	public void getOlder() {
		age++;
	}
	
	public void growTaller() {
		height++;
	}
	
	public boolean canVote(int year) {
		return age >= 18 && year % 4 == 0;
	}
	
	public String display() {
		return "I am " + name + ", I am " + age + " years old. I am " + height + " inches tall."; 
	}
	
	public static void main(String[] args) {
		
	}
}