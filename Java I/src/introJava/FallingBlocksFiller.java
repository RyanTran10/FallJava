package introJava;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FallingBlocksFiller extends JPanel {
	
	private int WIDTH = 800, HEIGHT = 600, NUMBLOCKS = 50, rectWidth = 10, rectHeight = 10;
	private double[] speeds = new double[NUMBLOCKS];
	private int[] xCords = new int[NUMBLOCKS];
	private double[] yCords = new double[NUMBLOCKS];
	private Color[] colors = new Color[NUMBLOCKS];
	public int blocksReset;
	// instance variables (what kind of data structure should we use?)
	
	// your code here
	
	// fills in your arrays with random x and y values
	public void initializeArrays() {
		// your code here
		for(int i = 0; i < NUMBLOCKS; i++) {
			speeds[i] = (double)(Math.random()*3 + 1);
			xCords[i] = (int)(Math.random()*WIDTH);
			colors[i] = new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
		}
	}
	
	// change your arrays here to make the blocks move
	public void moveblocks() {

		// your code here
		for(int i = 0; i < NUMBLOCKS; i++) {
			yCords[i] += speeds[i];
			if(yCords[i] + rectHeight > HEIGHT) {
				yCords[i] = 0;
				xCords[i] = (int)(Math.random()*WIDTH);
				blocksReset++;
			}
		}
	}
	
	// change the last part of this method!
	public void paint(Graphics g) {
		// give a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// draw your rectangles here! 
		for(int i = 0; i < NUMBLOCKS; i++) {
			//Causes colors to change every time it runs
//			g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
			g.setColor(colors[i]);
			g.fillRect(xCords[i], (int)yCords[i], rectWidth, rectHeight);
			//Writes the number of which rectangle is falling
//			g.drawString("" + i, xCords[i], (int)yCords[i]);
		}
		g.drawString("Blocks Reset: " + blocksReset, WIDTH/2, 20);
	}
	
	// ******** DON'T TOUCH BELOW CODE ***************
	
	// don't touch this method!
	public FallingBlocksFiller() {
		initializeArrays();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		while (true) {
			moveblocks();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			WIDTH = frame.getSize().width;
			HEIGHT = frame.getSize().height;
		}
	}

	// don't touch this method!
	public static void main(String[] args) {
		new FallingBlocksFiller();
	}

}