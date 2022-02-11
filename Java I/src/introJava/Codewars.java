package introJava;

public class Codewars {

	public static int calculateYears(double principal, double interest,  double tax, double desired) {
		double current = principal;
		int count = 0;
		while(current < desired) {
			count++;
			current *= (interest+1);
			System.out.println("interest = " + (interest+1));
			System.out.println();
			System.out.println("interest = " + (interest+1));
			System.out.println();
			current -= current*interest*tax;
			System.out.println("tax = " + (current*tax));
			System.out.println();
			System.out.println("bal = " + current);
			System.out.println();

			if(count > 5) {
				return -1;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(calculateYears(1000,0.01625,0.18,1200));
	}

}
