package inheritance;

import java.awt.Color;
import java.awt.Graphics;

public class ColorBall extends BouncingBall {

	private int count = 0;
	public ColorBall(int startx, int starty, int startrad, int startxspeed, int startyspeed) {
		super(startx, starty, startrad, startxspeed, startyspeed, new Color(255,255,255));
	}
	
	public void draw(Graphics g) {
		count++;
		if(count % 100 == 0 || count == 1) {
			setColor(new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255)));
		}
		super.draw(g);	
	}

	public static void main(String[] args) {

	}

}
