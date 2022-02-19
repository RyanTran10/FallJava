package inheritance;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	private int width;
	private int height;
	
	public Rectangle(int startx, int starty, int w, int h) {
		super(startx, starty);
		width = w;
		height = h;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(getX(), getY(), width, height);
	}

}
