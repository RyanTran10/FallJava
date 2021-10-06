package introJava;
// filler code for pong provided by Mr. David

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

public class Pong extends JPanel implements KeyListener {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 600, HEIGHT = 600, WINDOW_HEIGHT = 650;
	private final int PADDLE_WIDTH = 20, DIAM = 8, PADDLE_HEIGHT = 100;
	private final int PADDLE_SPEED = 4;

	
	// your instance variables here, I've given you a few 
	private boolean up1, down1, up2, down2; 		// booleans to keep track of paddle movement
	private boolean solo = false;
	
	private int ballXCord = WIDTH/2;
	private int ballYCord = HEIGHT/2;
	private int ballXSpeed = 3;
	private int ballYSpeed = 5;
	
	private int paddle1XCord = 0;
	private int paddle1YCord = HEIGHT/2;
	
	private int paddle2XCord = WIDTH - PADDLE_WIDTH;
	private int paddle2YCord = HEIGHT/2;
	
	// this method moves the ball at each timestep
	public void move_ball() {

		// your code here //
		ballYCord += ballYSpeed;
		ballXCord += ballXSpeed;
	}
	
	// this method moves the paddles at each timestep
	public void move_paddles() {
		
		// your code here // 
		if (up1 == true) {
			paddle1YCord -= PADDLE_SPEED;
		}
		if (down1 == true) {
			paddle1YCord += PADDLE_SPEED;
		}
		if (up2 == true) {
			paddle2YCord -= PADDLE_SPEED;
		}
		if (down2 == true) {
			paddle2YCord += PADDLE_SPEED;
		}
	}
	
	// this method checks if there are any bounces to take care of,
	// and if the ball has reached a left/right wall it adds to 
	// the corresponding player's score
	public void check_collisions() {
		
		// your code here
		if ((ballYCord + DIAM) > HEIGHT || ballYCord < 0) {
			ballYSpeed *= -1;
		}
		
		if (ballXCord < 0 || (ballXCord + DIAM) > WIDTH) {
			ballXSpeed *= -1;
		}
	}
	

	// defines what we want to happen anytime we draw the game
	// you simply need to fill in a few parameters here
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// draw your rectangles and circles here
		g.setColor(new Color(50,100,200));
		g.fillOval(ballXCord, ballYCord, DIAM, DIAM);
		g.setColor(new Color(0,255,0));
		g.fillRect(paddle1XCord, paddle1YCord, PADDLE_WIDTH, PADDLE_HEIGHT);
		g.fillRect(paddle2XCord, paddle2YCord, PADDLE_WIDTH, PADDLE_HEIGHT);
		// writes the score of the game - you just need to fill the scores in
		Font f = new Font("Arial", Font.BOLD, 14);
		g.setFont(f);
		g.setColor(Color.red);
		g.drawString("P1 Score: ", WIDTH/5, 20);
		g.drawString("P2 Score: ", WIDTH*3/5, 20);
	}

	// defines what we want to happen if a keyboard button has 
	// been pressed - you need to complete this
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// changes paddle direction based on what button is pressed
		if (keyCode == KeyEvent.VK_DOWN) {
			down2 = true;
		}
		if (keyCode == KeyEvent.VK_UP) {
			up2 = true;
		}
		if (e.getKeyChar() == 'w') {
			up1 = true;
		}
		if (e.getKeyChar() =='s') {
			down1 = true;
		}
		// turn 1-player mode on
		if (e.getKeyChar() == '1') {
			// fill this in
		}
		// turn 2-player mode on
		if (e.getKeyChar() == '2') {
			// fill this in
		}
	}

	// defines what we want to happen if a keyboard button
	// has been released - you need to complete this
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// stops paddle motion based on which button is released
		if (keyCode == KeyEvent.VK_DOWN) {
			down2 = false;
		}
		if (keyCode == KeyEvent.VK_UP) {
			up2 = false;
		}
		if (e.getKeyChar() == 'w') {
			up1 = false;
		}
		if (e.getKeyChar() =='s') {
			down1 = false;
		}
	}
	
	// restarts the game, including scores
	public void restart() {

		// your code here
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual game.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws the game
			repaint();
			
			// we move the ball, paddle, and check for collisions
			// every hundredth of a second
			move_ball();
			move_paddles();
			check_collisions();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new Pong();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public Pong() {
		JFrame frame = new JFrame();
		JButton button = new JButton("restart");
		frame.setSize(WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.add(button, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
				Pong.this.requestFocus();
			}
		});
		this.addKeyListener(this);
		this.setFocusable(true);
		
		run();
	}
	
	// method does nothing
	public void keyTyped(KeyEvent e) {}
}