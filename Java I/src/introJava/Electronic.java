package introJava;

public class Electronic {
	private int age;
	private String cpu;
	private String name;
	private int memory;
	
	public Electronic(int age, int mem, String n, String cpu) {
		this.age = age;
		memory = mem;
		name = n;
		this.cpu = cpu;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int newAge) {
		age = newAge;
	}

	public String getName() {
		return name;
	}
	public void changeName(String newname) {
		name = newname;
	}
	
	public void getOlder() {
		age++;
	}
	
	public String display() {
		return "Your electronic," + name + ", is " + age + " years old. It has " + memory + " gigabytes of memory and has a " + cpu + " cpu"; 
	}
	
	public int getMem() {
		return memory;
	}
	
	public void upgrade(int n) {
		memory += n;
	}
	
	public void setMemory(int n) {
		memory = n;
	}
	
	public static void main(String[] args) {
	}
}