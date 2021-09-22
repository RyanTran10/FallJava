package introJava;

public class OperationsWorksheet {
	
	public void lastDigit(int x) {
		System.out.println(x%10);
	}
	public void numToChar(int x) {
		System.out.println((char)x);
	}
	public void exactAverage(double x, double y) {
		System.out.println((x+y)/2);
	}
	
	public static void main(String[] args) {
		
		OperationsWorksheet runner = new OperationsWorksheet();
		
		runner.numToChar(1000);
		runner.lastDigit(1423);
		runner.exactAverage(24, 4214);
		
	}
}
