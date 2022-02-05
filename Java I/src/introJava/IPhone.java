package introJava;

public class IPhone extends Computer{
	
	private String cellServiceProvider;
	private String Generation;
	
	public IPhone(int age, int mem, String n, String cpu, String s, int h, String p, String g) {
		super(age, mem, n, cpu, s, h);
		cellServiceProvider = p;
		Generation = g;
	}
	
	public void upgrade(int n, int n1, String n2) {
		super.upgrade(n, n1);
		Generation = n2;
	}
	
	public void changeProvider(String newP) {
		cellServiceProvider = newP;
	}
	
	public static void main(String[] args) {
		IPhone phone = new IPhone(0, 2000, "Ryan's IPhone", "Apple C1", "6in", 128000, "At&T", "IPhone 13");
		phone.getAge();
		phone.upgrade(1000, 10000, "IPhone 13 Pro");
		phone.changeProvider("H2O");
		phone.changeSize("6.5in");
	}
}