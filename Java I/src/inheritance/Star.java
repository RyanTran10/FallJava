package inheritance;

import java.awt.Color;
import java.awt.Graphics;

public class Star extends Shape {
	private final int STAR_POINTS = 10;
	private int[] polygonX = new int[STAR_POINTS];
	private int[] polygonY = new int[STAR_POINTS];
	private double rad;


   
	public Star(int startx, int starty, double rad) {
		super(startx, starty);
		this.rad = rad;
		
	}
	
	public void draw(Graphics g) {
		for (int i = 18; i < 360; i += 72) {
			polygonX[(i-18)/36] = getX() + (int) (rad * Math.cos(Math.toRadians(i)));
			polygonY[(i-18)/36] = getY() - (int) (rad * Math.sin(Math.toRadians(i))); 
		}
		
		double innerRadius = rad*Math.sin(Math.toRadians(18)/Math.sin(Math.toRadians(54)));
		
		for (int i = 54; i < 360; i += 72) {
			polygonX[(i-18)/36] = getX() + (int) (innerRadius * Math.cos(Math.toRadians(i)));
			polygonY[(i-18)/36] = getY() - (int) (innerRadius * Math.sin(Math.toRadians(i))); 
		}
		g.setColor(Color.BLACK);
		g.fillPolygon(polygonX, polygonY, STAR_POINTS);
	}

}
