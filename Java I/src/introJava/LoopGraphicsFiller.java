package introJava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoopGraphicsFiller extends JPanel {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 1000, HEIGHT = 590;

	public void nCircles(int n, Graphics g, int DIAM, int yCord) {
		g.setColor(new Color(50,100,200));
		for (int i = 0; i < n; i++) {
			g.fillOval(i * DIAM + 10 * i, yCord, DIAM, DIAM);
		}
	}
	
	public void tenByTen(Graphics g, int DIAM) {
		g.setColor(Color.red);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				g.fillOval(i * DIAM, DIAM * j, DIAM, DIAM);
			}
		} 
	}
	
	public void checkerBoard(Graphics g, int DIAM) {
		g.setColor(Color.black);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				g.drawRect(i * DIAM, j * DIAM, DIAM, DIAM);
			}
		} 
	}
	
	public void rectangles(Graphics g, int n, int DIAM, int yCord) {
		for (int i = 0; i < n; i++) {
			int c1 = (int)(Math.random()*255);
			int c2 = (int)(Math.random()*255);
			int c3 = (int)(Math.random()*255);
			g.setColor(new Color(c1,c2,c3));
			g.fillRect(i * DIAM + 10 * i, yCord, DIAM, DIAM);
		}
	}
	
	public void shapes(Graphics g, int n, int DIAM, int yCord) {
		for (int i = 0; i < n; i++) {
			if (i % 3 == 0) {
				g.setColor(Color.red);
				g.fillRect(i * DIAM + 10 * i, yCord, DIAM, DIAM);
			}
			else if (i % 3 == 1) {
				g.setColor(Color.blue);
				g.fillOval(i * DIAM + 10 * i, yCord, DIAM, DIAM);
			}
			else {
				g.setColor(Color.pink);
				g.fillPolygon(new int[] {(i * DIAM + 10 * i), i * DIAM + 10 * i, i * DIAM + 10 * i + DIAM}, new int[] {0, DIAM, DIAM}, 3);

			}
		}
	}
	// defines what we want to happen anytime we draw the graphics
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// call your methods here
		
		shapes(g, 20, 30, 0);
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual program.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws
			//repaint();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new LoopGraphicsFiller();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public LoopGraphicsFiller() {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		this.setFocusable(true);
		
		run();
	}
}