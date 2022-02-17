package inheritance;

public class Monster { 
	
	private String name; 
	private int weight, health; 
	 
	public Monster(String n, int w) { 
		name = n; 
		weight = w; 
		health = 100; 
	} 
	
	public boolean canLift(int kilos) { 
		if (weight*2 >= kilos) 
			return true; 
	 	return false; 
	} 
	
	public int getWeight() { 
		return weight; 
	} 
	
	public String getName() { 
		return name; 
	} 
	
	public int getHealth() { 
		return health; 
	} 
	
	public void setHealth(int newhealth) { 
		health = newhealth; 
	} 
}