package FlappyBird;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
public class FlappyBird {
	private final int WIDTH = 1300, HEIGHT = 800, playerSize = 100, gameSpeed = 4, flapPower = gameSpeed*20, pipeGapSize = 300, pipeTotalSize = HEIGHT-pipeGapSize;
	private int playerY = HEIGHT/2 - playerSize;
	private Bird player = new Bird(50, playerY, playerSize, playerSize, "Images/flappyBird.png");
	private Image bg;
	private boolean lost = false, paused = true, won = false, showHitBoxes = true;
	
	private int pipeW = 150, pipeTimeOut = 120, pipeTimeCount = 120;
	
	private int score = 0;
	
	
	ArrayList<ArrayList<Pipe>> pipes = new ArrayList<ArrayList<Pipe>>();
	
	public void setup() {
		try {
			bg = ImageIO.read(new File("Images/flappyBg.png")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.println("Image file not found");
			e.printStackTrace();
		}
		
	}
	
	public void move() {
		player.moveY((int) (gameSpeed * 1.5));
		if(pipeTimeCount < pipeTimeOut) {
			pipeTimeCount++;
		} else {
			pipeTimeCount = 0;
			try {
				int topsize = (int) (Math.random()*(pipeTotalSize-100)+100);
				pipes.add(new ArrayList<Pipe>());
				pipes.get(pipes.size()-1).add(new DownPipe(WIDTH, 0, pipeW, topsize));
				pipes.get(pipes.size()-1).add(new UpPipe(WIDTH, HEIGHT-(pipeTotalSize-topsize), pipeW, pipeTotalSize-topsize));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		for(int i = 0; i < pipes.size(); i++) {
			for(int j = 0; j < pipes.get(0).size(); j++) {
				pipes.get(i).get(j).moveX(-1*gameSpeed);
				if(pipes.get(i).get(j).getX() < 0-pipeW) {
					pipes.remove(i);
					score++;
				}
			}
		}
 	}
	
	public void checkCollisions() {
		for(int i = 0; i < pipes.size(); i++) {
			for(int j = 0; j < pipes.get(i).size(); j++) {
				if(pipes.get(i).get(j).intersects(player)) {
					lost = true;
				}
			}
		}
		if(player.getY() > HEIGHT || player.getY() < 0) {
			lost = true;
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		for(int i = 0; i < pipes.size(); i++) {
			for(int j = 0; j < pipes.get(i).size(); j++) {
				pipes.get(i).get(j).draw(g);
			}
		}
		
		g.drawString("Score: " + score, WIDTH/2 -10, 20);
		
		player.draw(g);
	}
	
	public FlappyBird() {
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
			if (!paused && !lost && !won) {
				move();
				checkCollisions();
			}
			frame.getContentPane().repaint();
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {}
		}
	}
	
	private class RightAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class LeftAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class LeftReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class RightReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SpaceAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			if (!paused && !lost && !won) {
				player.moveY(-1*flapPower);
			}
		}
	}
	private class PauseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			paused = !paused;
		}
	}
	
	public static void main(String[] args) {
		new FlappyBird();
	}
}


