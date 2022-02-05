package introJava;

public class Computer extends Electronic{
	private String screenSize;
	private int hardDriveSpace;
	
	public Computer(int age, int mem, String n, String cpu, String s, int h) {
		super(age, mem, n, cpu);
		this.screenSize = s;
		hardDriveSpace = h;
	}
	
	public void upgrade(int n, int n1) {
		super.upgrade(n);
		hardDriveSpace += n1;
	}
	
	public void changeSize(String s) {
		screenSize = s;
	}
	
	public static void main(String[] args) {
	}
}