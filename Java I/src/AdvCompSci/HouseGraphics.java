package AdvCompSci;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HouseGraphics {
	
	public static final int WIDTH = 800, HEIGHT = 800;
	
	public void setup() {
		
		// any setup (creating your building) should be done here
	}
	
	public void draw(Graphics g) {
		// white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// your graphics code here	
	}
	
	
	// don't touch below.
	public HouseGraphics() {
		setup();
		
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.add(new JPanel() {
			public void paint(Graphics g) {
				draw(g);
			}
		});
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new HouseGraphics();
	}

}
