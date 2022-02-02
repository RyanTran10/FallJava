package introJava;

import java.util.Arrays;

public class Classroom {
	
	private String className; 
	private Human[] roster;
	
	public Classroom(String className, int numStudents) {
		this.className = className;
		roster = new Human[numStudents];
	}
	
	public void addStudent(int age, int height, String name, int i) {
		roster[i] = new Human(age, height, name);
	}
	
	public void ages() {
		for(Human a : roster) {
			if(a != null) 
				System.out.println(a.getAge());
			else
				System.out.println("This person is null");
		}
	}
	
	public static void main(String[] args) {
	}
}