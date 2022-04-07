package ListsAndReferences;

public class LinkedList<Q> {
	private int size = 0;
	private class Node {

		Q info;
		Node next;
		public Node(Q i, Node n) {
			info = i;
			next = n;
		}
	}
	private Node head;
	
	public void add(Q info) {
		size++;
		Node newNode = new Node(info, null);
		if (head == null) {
			head = newNode;
		} else {
			Node curr = head;
			while( curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;
		}
	}
	
	public void add(int ind, Q info) {
		try {
			Node newNode = new Node(info, null);
			if(ind == 0) {
				newNode.next = head;
				head = newNode;
			} else {
				Node curr = head;
				
				for(int i = 0; i < ind-1; i++) {
					curr = curr.next;
				}
				newNode.next = curr.next.next;
				curr.next = newNode;
				
			}
			size++;
		} catch(NullPointerException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public Q get(int t) {
		try {
			Node curr = head;
				
			for(int i = 0; i < t; i++) {
				curr = curr.next;
			}
			return curr.info;
		} catch(NullPointerException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public Q remove(int t) {
		try {
			if(t == 0) {
				Q inf = head.info;
				head = head.next;
				size--;
				return inf;
			} else {
				Node curr = head;
				
				for(int i = 0; i < t-1; i++) {
					curr = curr.next;
				}
				Q inf = curr.next.info;
				curr.next = curr.next.next;
				size--;
				return inf;
			}
		} catch(NullPointerException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public String toString() {
		String output = "";
		
		Node curr = head;
		while(curr != null) {
			output += curr.info.toString() + " -> ";
			curr = curr.next;
		}
		output += " null";
		return output;
	}
	
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		LinkedList<String> l = new LinkedList<String>();
		l.add("Hello");
		l.add("there");
		l.add("my");
		l.add("friend");
		System.out.println(l.remove(2));
		System.out.println(l.toString());

	}

}
