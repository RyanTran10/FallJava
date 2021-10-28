package introJava;
// filler code for pong provided by Mr. David
// Controls w, s, e, space, up, down, 1, 2, backslash
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
	
	// balls cords and speeds
	private int ballXCord = WIDTH/2;
	private int ballYCord = HEIGHT/2;
	private int ballXSpeed = 3;
	private int ballYSpeed = 4;
	
	//paddles cords and error
	private int paddle1XCord = 0;
	private int paddle1YCord = HEIGHT/2;
	
	private int paddle2XCord = WIDTH - PADDLE_WIDTH;
	private int paddle2YCord = HEIGHT/2;
	
	private double error = 0;
	
	//player scores
	private int player1Score = 0;
	private int player2Score = 0;
	
	//game running booleans
	private boolean ballMoving;
	private boolean pressSpace = true;
	
	//laser variables
	private int laserSpeed = 3, laserWidth = 20, laserHeight = 8;
	
	private boolean laser1 = false, laser2 = false;
	private int laser1XCord = PADDLE_WIDTH, laser1YCord, laser2XCord = paddle2XCord - laserWidth, laser2YCord;
	
	private boolean laser3 = false, laser4 = false;
	private int laser3XCord = PADDLE_WIDTH, laser3YCord, laser4XCord = paddle2XCord - laserWidth, laser4YCord;
	
	
	
	//resets the ball
	public void reset() {
		ballXCord = WIDTH/2;
		ballYCord = HEIGHT/2;
		ballMoving = false;
		pressSpace = true;
		error = 0;
		if (solo) {
			up2 = false;
			down2 = false;
		}
	}
	
	//resets the lasers
	public void resetLaser1() {
		laser1 = false;
		laser1XCord = PADDLE_WIDTH;
	}
	public void resetLaser2() {
		laser2 = false;
		laser2XCord = paddle2XCord - laserWidth;
	}
	public void resetLaser3() {
		laser3 = false;
		laser3XCord = PADDLE_WIDTH;
	}
	public void resetLaser4() {
		laser4 = false;
		laser4XCord = paddle2XCord - laserWidth;
	}
	
	// this method moves the ball at each time step
	public void move_ball() {

		//makes the ball and lasers move
		if (ballMoving) {
			ballYCord += ballYSpeed;
			ballXCord += ballXSpeed;
		}
		
		if (laser1) {
			laser1XCord += laserSpeed;
		}
		if (laser2) {
			laser2XCord -= laserSpeed;
		}
		if (laser3) {
			laser3XCord += laserSpeed;
		}
		if (laser4) {
			laser4XCord -= laserSpeed;
		}
	}
	
	// this method moves the paddles at each time step
	public void move_paddles() {
		
		// checks arrow keys
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
		
		//turns on ai
		if (solo && ballMoving) {
			if (Math.random() >= 0.3) {
				error += Math.random()/10;
				
				if (ballYCord + DIAM/2 > paddle2YCord + PADDLE_HEIGHT/2 + (int)error) {
					up2 = false;
					down2 = true;
				}
				
				if (ballYCord + DIAM/2 < paddle2YCord + PADDLE_HEIGHT/2 + (int)error) {
					down2 = false;
					up2 = true;
				}
				
				
//				paddle2YCord = ballYCord - PADDLE_HEIGHT/2 + (int)error;
			}
			else {
				error -= Math.random()/10;
//				paddle2YCord = ballYCord - PADDLE_HEIGHT/2 + (int)error;

				if (ballYCord + DIAM/2 > paddle2YCord + PADDLE_HEIGHT/2 + (int)error) {
					up2 = false;
					down2 = true;
				}
				
				if (ballYCord + DIAM/2 < paddle2YCord + PADDLE_HEIGHT/2 + (int)error) {
					down2 = false;
					up2 = true;
				}
			}
		}
	}
	
	
	// this method checks if there are any bounces to take care of,
	// and if the ball has reached a left/right wall it adds to 
	// the corresponding player's score
	public void check_collisions() {
		
		//checks if ball hits top or bottom
		if ((ballYCord + DIAM) > HEIGHT || ballYCord < 0) {
			ballYSpeed *= -1;
		}
		
		//checks if someone scores a point
		if (ballXCord < 0) {
			reset();
			player2Score ++;
			ballXSpeed *= -1;
		}
		else if ((ballXCord + DIAM) > WIDTH) {
			reset();
			player1Score ++;
		}
		
		//checks if ball hits either paddle
		if (ballYCord > paddle1YCord && ballYCord < paddle1YCord + PADDLE_HEIGHT && ballXCord < paddle1XCord + PADDLE_WIDTH) {
			ballXSpeed *= -1;
		}
		
		if (ballYCord > paddle2YCord && ballYCord < paddle2YCord + PADDLE_HEIGHT && ballXCord > paddle2XCord) {
			ballXSpeed *= -1;
		}
		
		//makes sure paddles don't go off screen
		if (paddle1YCord + PADDLE_HEIGHT > HEIGHT) {
			paddle1YCord = HEIGHT - PADDLE_HEIGHT;
		}
		if (paddle2YCord + PADDLE_HEIGHT > HEIGHT) {
			paddle2YCord = HEIGHT - PADDLE_HEIGHT;
		}
		if (paddle1YCord < 0) {
			paddle1YCord = 0;
		}
		if (paddle2YCord < 0) {
			paddle2YCord = 0;
		}
		
		//checks if lasers collide with anything and resets them
		if (laser1YCord > paddle2YCord && laser1YCord < paddle2YCord + PADDLE_HEIGHT && laser1XCord + 
				laserWidth > paddle2XCord) {
			resetLaser1();
		}
		
		if (laser1XCord + laserWidth > WIDTH) {
			resetLaser1();
		}
		
		if (laser2YCord > paddle1YCord && laser2YCord < paddle1YCord + PADDLE_HEIGHT && laser2XCord < 
				paddle1XCord + PADDLE_WIDTH) {
			resetLaser2();
		}
		
		if (laser2XCord < 0) {
			resetLaser2();
		}
		
		if (laser3YCord > paddle2YCord && laser3YCord < paddle2YCord + PADDLE_HEIGHT && laser3XCord + 
				laserWidth > paddle2XCord) {
			resetLaser3();
		}
		
		if (laser3XCord + laserWidth > WIDTH) {
			resetLaser3();
		}
		
		if (laser4YCord > paddle1YCord && laser4YCord < paddle1YCord + PADDLE_HEIGHT && laser4XCord < 
				paddle1XCord + PADDLE_WIDTH) {
			resetLaser4();
		}
		
		if (laser4XCord < 0) {
			resetLaser4();
		}
		
		if (laser2YCord + laserHeight/2 > ballYCord && laser2YCord + laserHeight/2 < ballYCord + DIAM 
				&& laser2XCord < ballXCord + DIAM && laser2XCord > ballXCord) {
			resetLaser2();
			
			if (ballXSpeed > 0) {
				ballXSpeed *= -1;
			}
		}
		
		if (laser1YCord + laserHeight/2 > ballYCord && laser1YCord + laserHeight/2 < ballYCord + DIAM && 
				laser1XCord < ballXCord + DIAM && laser1XCord + laserWidth > ballXCord) {
			resetLaser1();
			
			if (ballXSpeed < 0) {
				ballXSpeed *= -1;
			}
		}
		
		if (laser4YCord + laserHeight/2 > ballYCord && laser4YCord + laserHeight/2 < ballYCord + DIAM 
				&& laser4XCord < ballXCord + DIAM && laser4XCord > ballXCord) {
			resetLaser4();
			
			if (ballXSpeed > 0) {
				ballXSpeed *= -1;
			}
		}
		
		if (laser3YCord + laserHeight/2 > ballYCord && laser3YCord + laserHeight/2 < ballYCord + DIAM && 
				laser3XCord < ballXCord + DIAM && laser3XCord + laserWidth > ballXCord) {
			resetLaser3();
			
			if (ballXSpeed < 0) {
				ballXSpeed *= -1;
			}
		}
	}
	

	// defines what we want to happen any time we draw the game
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
		// Draws lasers
		if (laser1) {
			g.setColor(Color.red);
			g.fillRect(laser1XCord, laser1YCord, laserWidth, laserHeight);
		}
		if (laser2) {
			g.setColor(Color.red);
			g.fillRect(laser2XCord, laser2YCord, laserWidth, laserHeight);
		}
		if (laser3) {
			g.setColor(Color.red);
			g.fillRect(laser3XCord, laser3YCord, laserWidth, laserHeight);
		}
		if (laser4) {
			g.setColor(Color.red);
			g.fillRect(laser4XCord, laser4YCord, laserWidth, laserHeight);
		}
		
		// writes the score of the game - you just need to fill the scores in
		Font f = new Font("Arial", Font.BOLD, 14);
		g.setFont(f);
		g.setColor(Color.red);
		g.drawString("P1 Score: " + player1Score, WIDTH/5, 20);
		g.drawString("P2 Score: " + player2Score, WIDTH*3/5, 20);
		if (pressSpace) {
			g.drawString("Press Space to Start!", WIDTH/2 - 50, HEIGHT/2);
		}
		
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
			solo = true;
			restart();
		}
		// turn 2-player mode on
		if (e.getKeyChar() == '2') {
			solo = false;
			restart();
		}
		// starts the ball moving when you press space
		if (e.getKeyChar() == ' ') {
			ballMoving = true;
			pressSpace = false;
		}
		
		// Summon laser1
		if (e.getKeyChar() == 'e' && !laser1) {
			laser1 = true;
			laser1YCord = paddle1YCord + PADDLE_HEIGHT/2;
		}
		// Summon laser3
		else if (e.getKeyChar() == 'e' && !laser3) {
			laser3 = true;
			laser3YCord = paddle1YCord + PADDLE_HEIGHT/2;
		}
		// Summon laser2
		if (e.getKeyChar() == '/' && !laser2) {
			laser2 = true;
			laser2YCord = paddle2YCord + PADDLE_HEIGHT/2;
		}
		// Summon laser4
		else if (e.getKeyChar() == '/' && !laser4) {
			laser4 = true;
			laser4YCord = paddle2YCord + PADDLE_HEIGHT/2;
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

		//resets and sets scores to 0
		reset();
		resetLaser1();
		resetLaser2();
		player1Score = 0;
		player2Score = 0;
;	}

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