package spaceInvaders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Laser extends Rectangle {
	
	private int team;
	public Laser(int team, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.team = team;
	}
	
	// moves y by the inputted amount
	public void moveY(int dY) {
		if(team == 0) {
			y += dY;
		} else { 
			y -= dY;
		}
	}
	
	public int getTeam() {
		return team;
	}
	
	// draws the image corresponding with this alien/player
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}

}
