package AdvCompSci;

import java.util.ArrayList;

public class Editor {
	private String s = "";
	private ArrayList<String> moves = new ArrayList<String>();
	private int ind = 0;

	public Editor(String s) {
		this.s = s;
		moves.add(s);
	}
	
	public String change(String s) {
		this.s = s; 
		moves.add(s);
		ind++;
		return s;
	}
	
	public String delete() {
		s = s.substring(0, s.length()-1);
		moves.add(s);
		ind++;
		return s;
	}
	
	public String undo() {
		if(ind == 0) {
			System.out.println("Can not undo again");
			return null;
		}	
		ind--;
		s = moves.get(ind);
		return s;
	}
	
	public String redo() {
		if(ind == moves.size()) {
			System.out.println("Can not redo");
			return null;
		}
		ind++;
		s = moves.get(ind);
		return s;
	}
	
	public String get() {
		return s;
	}
	
	public void trace() {
		System.out.println(moves.toString());
		System.out.println(ind);
	}
	
	public static void main(String[] args) {
		Editor e = new Editor("conversion");
		System.out.println(e.get());

	}
}