package inheritance;

import java.awt.Color;

public class SineBall extends BouncingBall {

	public SineBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	
	public void move() {
		super.move();
		setY((int) (100*Math.sin(getX()/50.0)+(HEIGHT/2)));
	}

}
