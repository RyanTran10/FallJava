package introJava;


public class MoreWithNestedLoops {

//	
//	public void loopingBox(int x) {
//		for (int i = 0; i < x; i++) {
//			for (int j = 1; j <= x; j++) {
//				System.out.print(j + " ");
//			}
//			System.out.println("");
//		} 
//	}
	
	public void triangle(int x) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("X");
			}
			System.out.println("");
		} 
	}
	
	public void what_power(int x, int y) {
		for (int i = 0; Math.pow(x, i) <= y; i++) {
			if (Math.pow(x, i) == y) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		MoreWithNestedLoops runner = new MoreWithNestedLoops();
		runner.what_power(9, 9);
	}
}
