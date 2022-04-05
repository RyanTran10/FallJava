package FallingBlocks;

import java.awt.Color;
import java.awt.Graphics;

public class Block {
	private int x;
	private int y;
	private int s;
	private Color c;
	public static final int SIZE = 10;
	
	public Block(int x, int y, int s, Color c) {
		this.x = x;
		this.y = y;
		this.s = s;
		this.c = c;
	}
	
	public int getY() {
		return y;
	}

	public void move() {
		y += s;
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fill3DRect(x, y, SIZE, SIZE, true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
