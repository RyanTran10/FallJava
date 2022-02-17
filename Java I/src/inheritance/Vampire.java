package inheritance;

public class Vampire extends Monster {

	public Vampire(String n, int w) {
		super("Vampire", w);
	}
	
	public boolean canLift(int kilos) { 
		if (getWeight() >= kilos) 
			return true; 
	 	return false; 
	} 
	
	public void inSun() {
		setHealth(getHealth()-10);
	}

	public void feed() {
		setHealth(100);
	}
}
