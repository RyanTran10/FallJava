package inheritance;

public class Hulk extends Monster{

	public Hulk(int w) {
		super("Hulk", w);
	}
	public boolean canLift(int kilos) { 
		return true;
	} 
}
