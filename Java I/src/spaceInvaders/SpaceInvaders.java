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
	private int laserMax = 4;
	
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
	private boolean won = false, boss = false;
	
	// a list of all of the boss summons and the boss itself
	private ArrayList<Boss> BossSummons = new ArrayList<Boss>();
	
	
	// move the aliens, the lasers, and the player. Loops aliens when necessary, 
	// and randomly shoots lasers from the aliens
	public void move() {
		// only runs if we havent won or lost yet
		if(!won && !lost) {
			//moves all of the boss summons (slightly slower than alien speed)
			for(Boss s : BossSummons) {
				s.moveX(ALIENSPEED/2);
				// if the bosses go out of the screen moves it down and to the other side
				if(s.getX() > WIDTH) {
					s.moveY(PLAYERENEMYHEIGHT);
					s.setX(0);
				} 
				// spawns the lasers
				if(DIFFICULTY < Math.random()) {
					alienLasers.add(new Laser(0, (int)(s.getX() + (PLAYERENEMYWIDTH*Math.pow(2, s.getTier()))/2), (int)(s.getY() + PLAYERENEMYHEIGHT), LASERWIDTH, LASERHEIGHT));
				}
	
			}
			// moves all of the aliens
			for(SpaceThing s : aliens) {
				s.moveX(ALIENSPEED);
				// if they move off screen moves them down and to the other side
				if(s.getX() > WIDTH) {
					s.moveY(PLAYERENEMYHEIGHT);
					s.setX(0);
				} 
				// spawns the lasers
				if(DIFFICULTY < Math.random()) {
					alienLasers.add(new Laser(0, (int)(s.getX() + PLAYERENEMYWIDTH/2), (int)(s.getY() + PLAYERENEMYHEIGHT), LASERWIDTH, LASERHEIGHT));
				}
	
			}
			// moves all of the alien lasers and deletes them if they go out of the screen
			for(int i = 0; i < alienLasers.size(); i++) {
				alienLasers.get(i).moveY(LASERSPEED);
				if (alienLasers.get(i).getY() > HEIGHT) {
					alienLasers.remove(i);
				}
				
			}
			// moves all of the player lasers and deletes them if they go out of the screen
			for(int i = 0; i < playerLasers.size(); i++) {
				playerLasers.get(i).moveY(LASERSPEED);
				if (playerLasers.get(i).getY() < 0) {
					playerLasers.remove(i);
				}
				
			}
			// moves the player and makes sure they dont go off the screen
			player.moveX(playerSpeed);
			if(player.getX() > WIDTH) {
				player.setX(WIDTH);
			} else if (player.getX() < 0) {
				player.setX(0);
			}
		}
		
	}
	
	// check for collisions between alien lasers and the player
	// and between player lasers and the aliens
	// check if the aliens have reached the ground
	public void checkCollisions() {
		// calls the boss collisions method if boss has been spawned
		if(boss) {
			bossCollisions();
		} else {
			// if boss hasnt been spawned yet
			// checks if any of the lasers hit the player and removes a life; if out of lives you lose
			for(int i = 0; i < alienLasers.size(); i++) {
				if (alienLasers.get(i).intersects(player)) {
					alienLasers.remove(i);
					lives--;
				}
				if(lives == 0) {
					lost = true;
				}
				
			}
			// checks if any of the lasers hit the player and removes them if so
			for(int i = 0; i < aliens.size(); i++) {
				for(int j = 0; j < playerLasers.size(); j++) {
					if (playerLasers.get(j).intersects(aliens.get(i))) {
						playerLasers.remove(j);
						aliens.remove(i);
						i--;
						break;
					}
				}
			}
			// checks if any of the aliens reach the bottom and makes you lose if so
			for(int i = 0; i < aliens.size(); i++) {
				if(aliens.get(i).getY()+(PLAYERENEMYHEIGHT*2) > HEIGHT) {
					lost = true;
				}
			}
			// if you kill all of the aliens spawn the boss
			if (aliens.size() == 0) {
				boss = true;
				boss();
				return;
			}
		}
		
	}
	// function to spawn the boss also removes the laser limit as boss is hard to kill but you can change to increase difficulty
	public void boss() {
		BossSummons.add(new Boss(WIDTH/2-(PLAYERENEMYWIDTH*4), 0, PLAYERENEMYWIDTH*8, PLAYERENEMYHEIGHT*8, "Images/alien.png", (int)(Math.pow(2, 3)), 3));
		laserMax = 50;
	}
	// collisions for when the boss is here ( different because if they get hit something different happens and it was less confusing for me to have a second method
	public void bossCollisions() {
		// if any of the alien lasers hit you you lose health and if you run out of lives you lose
		for(int i = 0; i < alienLasers.size(); i++) {
			if (alienLasers.get(i).intersects(player)) {
				alienLasers.remove(i);
				lives--;
			}
			if(lives == 0) {
				lost = true;
			}
			
		}
		// checks if any of the lasers hit the bosses. If they do subtracts health and removes laser. spawns the next bosses with respective values if the boss dies
		for(int i = 0; i < BossSummons.size(); i++) {
			for(int j = 0; j < playerLasers.size(); j++) {
				if (playerLasers.get(j).intersects(BossSummons.get(i))) {
					BossSummons.get(i).hit();
					playerLasers.remove(j); 
					if(BossSummons.get(i).getHealth() <= 0) {
						if(BossSummons.get(i).getTier() > 0) {
							BossSummons.add(new Boss(BossSummons.get(i).x, BossSummons.get(i).y, (int)(PLAYERENEMYWIDTH*Math.pow(2, BossSummons.get(i).getTier()-1)), (int)(PLAYERENEMYHEIGHT*Math.pow(2, BossSummons.get(i).getTier()-1)), "Images/alien.png", (int)(Math.pow(2, BossSummons.get(i).getTier()-1)), BossSummons.get(i).getTier()-1));
							BossSummons.add(new Boss(BossSummons.get(i).x, BossSummons.get(i).y + (int)(PLAYERENEMYHEIGHT*Math.pow(2, BossSummons.get(i).getTier()-1)), (int)(PLAYERENEMYWIDTH*Math.pow(2, BossSummons.get(i).getTier()-1)), (int)(PLAYERENEMYHEIGHT*Math.pow(2, BossSummons.get(i).getTier()-1)), "Images/alien.png", (int)(Math.pow(2, BossSummons.get(i).getTier()-1)), BossSummons.get(i).getTier()-1));
							BossSummons.add(new Boss(BossSummons.get(i).x + (int)(PLAYERENEMYWIDTH*Math.pow(2, BossSummons.get(i).getTier()-1)), BossSummons.get(i).y, (int)(PLAYERENEMYWIDTH*Math.pow(2, BossSummons.get(i).getTier()-1)), (int)(PLAYERENEMYHEIGHT*Math.pow(2, BossSummons.get(i).getTier()-1)), "Images/alien.png", (int)(Math.pow(2, BossSummons.get(i).getTier()-1)), BossSummons.get(i).getTier()-1));
							BossSummons.add(new Boss(BossSummons.get(i).x + (int)(PLAYERENEMYWIDTH*Math.pow(2, BossSummons.get(i).getTier()-1)), BossSummons.get(i).y + (int)(PLAYERENEMYHEIGHT*Math.pow(2, BossSummons.get(i).getTier()-1)), (int)(PLAYERENEMYWIDTH*Math.pow(2, BossSummons.get(i).getTier()-1)), (int)(PLAYERENEMYHEIGHT*Math.pow(2, BossSummons.get(i).getTier()-1)), "Images/alien.png", (int)(Math.pow(2, BossSummons.get(i).getTier()-1)), BossSummons.get(i).getTier()-1));
						}
						BossSummons.remove(i);
						i--;
						break;
					}
				}
			}
		}
		// if all boss summons are dead you win
		if (BossSummons.size() == 0) {
			won = true;
			return;
		}
		// if the bosses touch the bottom you lose
		for(int i = 0; i < BossSummons.size(); i++) {
			if(BossSummons.get(i).getY() + (int)(PLAYERENEMYWIDTH*Math.pow(2, BossSummons.get(i).getTier()-1)) > HEIGHT) {
				lost = true;
			}
		}
	}
	
	// set up your variables, lists, etc here
	public void setup() {
		// sets up the first row of aliens
		for(int i = 0; i < NUMALIENS/2; i++) {
			aliens.add(new SpaceThing(i*(WIDTH/(NUMALIENS/2)), 0, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/alien.png"));
		}
		// sets up the second row of aliens
		for(int i = 0; i < NUMALIENS/2; i++) {
			aliens.add(new SpaceThing(i*(WIDTH/(NUMALIENS/2)), PLAYERENEMYHEIGHT, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/alien.png"));
		}
		// sets the player
		player = new SpaceThing(WIDTH/2, HEIGHT - PLAYERENEMYHEIGHT*2, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "Images/playerCannon.jpg");
	}
	
	
	// fires a player laser. if there are currently less than 4 lasers on the screen,
	// adds to the list. if there are 4 lasers on the screen, removes a laser and 
	// replaces it with this new one
	public void fireLaser() {
		// if theres less than the max lasers then spawns a new one
		if(playerLasers.size() < laserMax) {
			playerLasers.add(new Laser(1, (int)(player.getX() + PLAYERENEMYWIDTH/2), (int)(player.getY()), LASERWIDTH, LASERHEIGHT));
		}
	}
	
	// draw a black background along with your lasers, aliens, and player here
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// draws the aliens
		for(SpaceThing s : aliens) {
			s.draw(g);
		}
		// draws the boss summons
		for(Boss s : BossSummons) {
			s.draw(g);
		}
		// draws all of the lasers
		for(Laser l: alienLasers) {
			l.draw(g);
		}
		for(Laser l: playerLasers) {
			l.draw(g);
		}
		// draws the player
		player.draw(g);
		
		// draws the lives display
		g.setColor(Color.red);
		g.drawString("Lives: "+lives, 15, 15);
		
		// tells you when you lose or win
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
