package spaceInvaders;

// Space Invaders Filler Code by Mr. David

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class SpaceInvaders {
	
	// constants for various aspects of the game
	// feel free to change them to make the game harder/easier
	private final int WIDTH = 1000, HEIGHT = 700, NUMALIENS = 40, ALIENSPEED = 4, LASERSPEED = 7, PLAYERSPEED = 6,
			LASERWIDTH = 8, LASERHEIGHT = 25, PLAYERENEMYWIDTH = 50, PLAYERENEMYHEIGHT = 35;
	
	// determines the difficulty. The closer to 1.0, the easier the game 
	private final double DIFFICULTY = .99;
	
	// our list of aliens
	private ArrayList<SpaceThing> aliens = new ArrayList<SpaceThing>();
	
	// our list of list of lasers for both the player and the aliens
	private ArrayList<Laser> alienLasers = new ArrayList<Laser>();
	private ArrayList<Laser> playerLasers = new ArrayList<Laser>();
	
	// the player
	private SpaceThing player;
	
	// the current speed of the player as well as their remaining lives
	private int lives = 3, playerSpeed = 0;
	
	// booleans to keep track of the game's progress
	private boolean lost = false, paused = true;
	private boolean won = false;
	
	
	// move the aliens, the lasers, and the player. Loops aliens when necessary, 
	// and randomly shoots lasers from the aliens
	public void move() {
		if(!won && !lost) {
			for(SpaceThing s : aliens) {
				s.moveX(ALIENSPEED);
				if(s.getX() > WIDTH) {
					s.moveY(PLAYERENEMYHEIGHT);
					s.setX(0);
				} 
				if(DIFFICULTY < Math.random()) {
					alienLasers.add(new Laser(0, (int)(s.getX() + PLAYERENEMYWIDTH/2), (int)(s.getY() + PLAYERENEMYHEIGHT), LASERWIDTH, LASERHEIGHT));
				}
	
			}
			
			for(int i = 0; i < alienLasers.size(); i++) {
				alienLasers.get(i).moveY(LASERSPEED);
				if (alienLasers.get(i).getY() > HEIGHT) {
					alienLasers.remove(i);
				}
				
			}
			
			for(int i = 0; i < playerLasers.size(); i++) {
				playerLasers.get(i).moveY(LASERSPEED);
				if (playerLasers.get(i).getY() < 0) {
					playerLasers.remove(i);
				}
				
			}
			
			player.moveX(playerSpeed);
		}
		
	}
	
	// check for collisions between alien lasers and the player
	// and between player lasers and the aliens
	// check if the aliens have reached the ground
	public void checkCollisions() {
		for(int i = 0; i < alienLasers.size(); i++) {
			if (alienLasers.get(i).intersects(player)) {
				alienLasers.remove(i);
				lives--;
			}
			if(lives == 0) {
				lost = true;
			}
			
		}
		
		for(int i = 0; i < playerLasers.size(); i++) {
			for(int j = 0; j < aliens.size(); j++) {
				if (playerLasers.get(i).intersects(aliens.get(j))) {
					playerLasers.remove(i);
					aliens.remove(j);
				}
			}
		}
		
	}
	
	// set up your variables, lists, etc here
	public void setup() {
		for(int i = 0; i < NUMALIENS/2; i++) {
			aliens.add(new SpaceThing(i*(WIDTH/(NUMALIENS/2)), 0, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/alien.png"));
		}
		for(int i = 0; i < NUMALIENS/2; i++) {
			aliens.add(new SpaceThing(i*(WIDTH/(NUMALIENS/2)), PLAYERENEMYHEIGHT, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/alien.png"));
		}
		player = new SpaceThing(WIDTH/2, HEIGHT - PLAYERENEMYHEIGHT*2, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/playerCannon.jpg");
	}
	
	
	// fires a player laser. if there are currently less than 4 lasers on the screen,
	// adds to the list. if there are 4 lasers on the screen, removes a laser and 
	// replaces it with this new one
	public void fireLaser() {
		if(playerLasers.size() <= 4) {
			playerLasers.add(new Laser(1, (int)(player.getX() + PLAYERENEMYWIDTH/2), (int)(player.getY()), LASERWIDTH, LASERHEIGHT));
		}
	}
	
	// draw a black background along with your lasers, aliens, and player here
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		for(SpaceThing s : aliens) {
			s.draw(g);
		}
		for(Laser l: alienLasers) {
			l.draw(g);
		}
		for(Laser l: playerLasers) {
			l.draw(g);
		}
		
		player.draw(g);
		
		g.setColor(Color.red);
		g.drawString("Lives: "+lives, 15, 15);
		
		if (lost) 
			g.drawString("You lose", WIDTH/2-25, HEIGHT/2);
		if (won) 
			g.drawString("You win!", WIDTH/2-25, HEIGHT/2);
	}
	
	// ******* DON'T TOUCH BELOW CODE ************//
	
	public SpaceInvaders() {
		setup();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {draw(g);}
		};
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Left");
		canvas.getActionMap().put("Left", new LeftAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "LeftRelease");
		canvas.getActionMap().put("LeftRelease", new LeftReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), " ");
		canvas.getActionMap().put(" ", new SpaceAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Right");
		canvas.getActionMap().put("Right", new RightAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "RightRelease");
		canvas.getActionMap().put("RightRelease", new RightReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0, false), "Pause");
		canvas.getActionMap().put("Pause", new PauseAction());
		frame.add(canvas);
		frame.setVisible(true);
		
		while (true) {
			if (!paused) {
				move();
				checkCollisions();
				frame.getContentPane().repaint();
			}
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {}
		}
	}
	
	private class RightAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = PLAYERSPEED;
		}
	}
	private class LeftAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = -PLAYERSPEED;
		}
	}
	private class LeftReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}
	private class RightReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}
	private class SpaceAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			fireLaser();
		}
	}
	private class PauseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			paused = !paused;
		}
	}
	
	public static void main(String[] args) {
		new SpaceInvaders();
	}
}