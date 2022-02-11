package inheritance;

import java.awt.Color;

public class ShrinkingBall extends BouncingBall {
	private boolean growing = false;
	public ShrinkingBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	
	public void move() {
		super.move();
		if(getRad() < 1) {
			growing = true;
		} else if (getRad() >= 30) {
			growing = false;
		}
		if(growing) {
			setRad(getRad()+1);
		} else {
			setRad(getRad()-1);
		}
	}
}
