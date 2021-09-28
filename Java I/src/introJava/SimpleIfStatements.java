package introJava;

public class SimpleIfStatements {

	public void positive(int x) {
		if (x > 0) {
			System.out.println("Positive!");
		}
		else if (x < 0) {
			System.out.println("Negative!");
		}
		else {
			System.out.println("It is a zero!");
		}
	}
	
	public void evenOrOdd(int x) {

		if (x%2 == 0) {
			System.out.println("Even");
		}
		else {
			System.out.println("Odd");
		}
	}
	
	public void whatCase(char x) {
		if (x > 64 && x < 91) {
			System.out.println("Uppercase!");
		}
		else if (x > 96 && x < 121) {
			System.out.println("Lowercase!");
		}
		else {
			System.out.println("Neither!");
		}
	}
	
	public void multipleOfTen(int x) {
		if ((x%10) == 0) {
			System.out.println("Multiple of 10!");
		}
		else {
			System.out.println("Not a multiple of 10");
		}
	}
	
	public void biggest(double x, double y, double z) {
		if (x > y && x > z) {
			System.out.println(x);
		}
		else if (y > z) {
			System.out.println(y);
		}
		else {
			System.out.println(z);
		}
	}
	
	public static void main(String[] args) {
		SimpleIfStatements runner = new SimpleIfStatements();
		runner.biggest(5263, 5325, 2141);
		runner.positive(142);
		runner.evenOrOdd(34);
		runner.whatCase('a');
		runner.multipleOfTen(32450);
		
	}
}
