package spaceInvaders;

public class Boss extends SpaceThing {
	// how many hits it takes to kill this particular boss
	private int health;
	// determines how many times to split
	private int tier;
	
	public Boss(int x, int y, int w, int h, String imgName, int health, int t) {
		super(x, y, w, h, imgName);
		this.health = health;
		tier = t;
	}
	
	public int getHealth() {
		return health;
	}
	
	//tells what to do when hit with a laser
	public int hit() {
		health--;
		return health;
	}
	
	//returns the tier so that you know how many times to split
	public int getTier() {
		return tier;
	}
}
