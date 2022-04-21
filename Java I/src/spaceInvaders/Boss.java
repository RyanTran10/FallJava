package spaceInvaders;

public class Boss extends SpaceThing {
	private int health;
	private int tier;
	public Boss(int x, int y, int w, int h, String imgName, int health, int t) {
		super(x, y, w, h, imgName);
		this.health = health;
		tier = t;
	}
	
	public int getHealth() {
		return health;
	}
	
	public int hit() {
		health--;
		return health;
	}
	
	public int getTier() {
		return tier;
	}
}
