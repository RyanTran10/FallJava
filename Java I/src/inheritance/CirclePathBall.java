package inheritance;

import java.awt.Color;

public class CirclePathBall extends BouncingBall {
	private double count;
	public CirclePathBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	
	public void move() {
		count++;
		setX((int)(WIDTH/5*Math.cos(DegreeToRad(count)))+WIDTH/2);
		setY((int)(WIDTH/5*Math.sin(DegreeToRad(count)))+HEIGHT/2);
		
	}
	
	public double DegreeToRad(double d) {
		return d*0.01745;
	}

}
