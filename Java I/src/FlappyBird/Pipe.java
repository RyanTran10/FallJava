package FlappyBird;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pipe extends Rectangle {
	private Image img;
	
	// constructor takes a location and the name of the image file as parameters
	public Pipe(int x, int y, int w, int h, Image img) {
		super(x, y, w, h);
		this.img = img;
	}

	// moves x by the inputted amount
	public void moveX(int dX) {
		x += dX;
	}
	
	// moves y by the inputted amount
	public void moveY(int dY) {
		y += dY;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	// draws the image corresponding with this alien/player
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
		g.drawRect(x, y, width, height);
	}
		
}
