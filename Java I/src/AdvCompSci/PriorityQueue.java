package AdvCompSci;

import java.util.ArrayList;

public class PriorityQueue<T> {
	private class Bundle {

		T element;
		int priority;
		public Bundle(T e, int p) {
			element = e;
			priority = p;
		}
		
		public boolean equals(Object b) {
			return ((Bundle)b).element.equals(element);
		}
	}
	
	ArrayList<Bundle> queue = new ArrayList<Bundle>();
//	 size, put, pop, and toString method. 
	public int size() {
		return queue.size();
	}
	public void put(T info, int p) {
		if(queue.contains(new Bundle(info, p))) {
			for(int i = 0; i < queue.size(); i++) {
				if(queue.get(i).element.equals(info)) {
					queue.remove(i);
					break;
				}
			}
		}
		
		for(int i = 0; i < queue.size(); i++) {
			if(queue.get(i).priority < p) {
				queue.add(i, new Bundle(info, p));
				return;
			}
		}
		queue.add(new Bundle(info, p));
	}
	
	public T pop() {
		return(queue.remove(0).element);
	}
	
	public String toString() {
		String s = "";
		for(Bundle b: queue) {
			s += b.element + " " + b.priority + " / ";
		}
		return s;
	}
	
	public static void main(String[] args) {
		PriorityQueue<String> p = new PriorityQueue<String>();
		p.put("Cooper", 30);
		p.put("Tony", 20);
		p.put("Ryan", 19); 
		p.put("Anika", 5);
		p.put("Cooper", 10);
		p.put("David", 7);
		p.put("Friend", 16);
		p.pop();
		p.pop();
		p.pop();
		System.out.println(p);
	}
}
