package inheritance;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Shape {

	private int width;
	private int height;
	
	public Oval(int startx, int starty, int w, int h) {
		super(startx, starty);
		width = w;
		height = h;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(getX(), getY(), width, height);
	}
}
