package introJava;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JeopardyBoardFiller {
	
	private int gridWidth = 800, gridHeight = 600, textHeight = 50;
	
	private final int NUMQUESTIONS = 5, NUMCATEGORIES = 5;
	
	private int score = 0;
	
	// instance variables...?
	// tells me which box was the last clicked one (starts off as none)
	private int boxXNum = -1;
	private int boxYNum = -1; 
	
	// how to draw your jeopardy board (categories going across, questions going down
	public void draw(Graphics g) {
		// fills in the background
		g.setColor(Color.blue);
		g.fillRect(0, 0, gridWidth, gridHeight);
		
		// loops to draw each box
		for (int i = 0; i <= NUMCATEGORIES; i++) {
			for (int j = 0; j <= NUMQUESTIONS; j++) {
				
				g.setColor(Color.green);
				// changes last box clicked to red text
				if (i == boxXNum && j == boxYNum) {
					g.setColor(Color.red);
				}
				//draws the points and boxes
				g.drawString((100*j + 100) + "", ((gridWidth/NUMCATEGORIES) * i) + (gridWidth/NUMCATEGORIES)/2, ((gridHeight/NUMQUESTIONS) * j) + (gridHeight/NUMQUESTIONS)/2);
				g.setColor(Color.green);
				g.drawRect((gridWidth/NUMCATEGORIES) * i, (gridHeight/NUMQUESTIONS) * j, gridWidth/NUMCATEGORIES, gridHeight/NUMQUESTIONS);
				
			}
		}
	}
	
	// what you want to happen when the user clicks
	public void click(int mouseX, int mouseY) {
		// adds the score based
		score += ((mouseY/(gridHeight/NUMQUESTIONS)) * 100) + 100;
		// remembers the box that was last clicked
		boxXNum = mouseX/(gridWidth/NUMCATEGORIES);
		boxYNum = mouseY/(gridHeight/NUMQUESTIONS);
	}
	
	
	// DO NOT TOUCH BELOW CODE //
	
	public JeopardyBoardFiller() {
		
		JFrame window = new JFrame();
		window.setTitle("Jeopardy!");
		window.setSize(gridWidth, gridHeight + textHeight);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		JTextArea scoreDisplay = new JTextArea();
		scoreDisplay.setEditable(false);
		scoreDisplay.setText("\t\tScore: 0");
		
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {
				gridWidth = window.getWidth();
				gridHeight = window.getHeight() - textHeight;
				draw(g);
			}
		};
		canvas.setPreferredSize(new Dimension(gridWidth, gridHeight));
		
		canvas.addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				click(e.getX(), e.getY());
				scoreDisplay.setText("\t\tScore: " + score);
				window.getContentPane().repaint();
			}

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		container.add(canvas);
		container.add(scoreDisplay);
		window.add(container);
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JeopardyBoardFiller();
	}

}
