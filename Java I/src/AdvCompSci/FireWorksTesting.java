package AdvCompSci;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FireWorksTesting extends JPanel {
	
	private int WIDTH = 800, HEIGHT = 600, maxFireWorks = 100;
	private int[] xCords = new int[maxFireWorks];
	private int[] yCords = new int[maxFireWorks];

	
	// instance variables (what kind of data structure should we use?)
	
	// your code here
	// fills in your arrays with random x and y values
	public void initializeArrays() {
		// your code here
		for(int i = 0; i < maxFireWorks; i++) {
			
		}
	}
	
	// change your arrays here to make the blocks move
	public void moveblocks() {
		// your code here
	}
	
	// change the last part of this method!
	public void paint(Graphics g) {
		// give a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
	}
	// ******** DON'T TOUCH BELOW CODE ***************
	
	// don't touch this method!
	public FireWorksTesting() {
		initializeArrays();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		frame.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}


		});
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
		new FireWorksTesting();
	}

}