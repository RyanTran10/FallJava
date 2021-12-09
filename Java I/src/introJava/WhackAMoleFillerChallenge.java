package introJava;

import java.awt.Color;

// Filler code for Whack a Mole by Mr. Friedman
// Extra feature is a big mole and lives system
// Must click big mole 5 times before the timestep happens otherwise you lose lives
// if you run out of lives game ends

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.Timer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
// if you see a big mole, click it 5 times before BIGMOLETIMESTEP runs out to not lose lives
// if you lose too many lives you lose
// click jumpscare 20 times for it to go away
public class WhackAMoleFillerChallenge {

	// size of the display area
    private int windowWidth = 800, windowHeight = 600, textHeight = 35;
    // images
    private Image Mole, BackgroundGrass, BackgroundSky, Mound, Jump;
    // constants
    private int MOUNDS = 10, MOLESAPPEARING = 2, TIMESTEP = 2000, BIGMOLETIMESTEP = 2000;
    // big mole variables
    private boolean bigMole = false;
    private int bigHealth = 5, jumpClicks = 20;
    
    // mound and mole sizes
    private int moundWidth = windowWidth/10, moundHeight = moundWidth/2, moleWidth = moundWidth, moleHeight = moundHeight*2;
    // displayed text
    private int score = 0, lives = 100;
    // important booleans
    private boolean lost = false, jumpHappened = false, jump = false;
    // arrays
    private int[] moundX = new int[MOUNDS];
    private int[] moundY = new int[MOUNDS];
    private boolean[] moles = new boolean[MOUNDS];
    // makes window and lives display an instance variable so i can repaint
    private JFrame window = new JFrame();
    private JTextArea livesDisplay = new JTextArea(); // sets the text area to show lives
    
    // timer to make big mole attack
    private Timer attackTimer = new Timer(BIGMOLETIMESTEP, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
        	bigMoleAttack();
        }
    });
    
    
    // sets up my images to use
    public void defineImgs(){
    	 Mole = Toolkit.getDefaultToolkit().getImage("CompSciMole-removebg-preview.png");
    	 BackgroundGrass = Toolkit.getDefaultToolkit().getImage("CompSciGrass.jpeg");
    	 BackgroundSky = Toolkit.getDefaultToolkit().getImage("CompSciSky.jpeg");
    	 Mound = Toolkit.getDefaultToolkit().getImage("CompSciMound-removebg-preview.png");
    	 Jump = Toolkit.getDefaultToolkit().getImage("testing.jpeg");
    }
    
    // sets up my arrays
    public void defineArrs() {
   	 	for (int i = 0; i < MOUNDS; i++) {
   	 		moundX[i] = (int)(Math.random() * (windowWidth - moleWidth));
   	 		moundY[i] = (int)(Math.random() * (windowHeight/2 - moleHeight) + windowHeight/2);
   	 	}
   	 	// spawn moles because of initial delay
   	 	spawnMoles();
   	 	// redefines mole and mound sizes for when you scale window
   	 	moundWidth = windowWidth/10;
   	 	moundHeight = moundWidth/2;
   	 	moleWidth = moundWidth;
   	 	moleHeight = moundHeight*2;
    }
    // show how to spawn moles
    public void spawnMoles() {
    	// only checks if you havent lost yet
    	if(!lost) {
    		// sets all of the moles to false
	    	moles = new boolean[MOUNDS];
	    	// spawns moles until it hits the amount appearing
	    	for (int i = 0; i < MOLESAPPEARING; i++) {
	    		int randNum = (int)(Math.random()*MOUNDS);
	    		// checks if the index is already true to make sure we actually spawn the correct amount of moles
	    		if(moles[randNum]) {
	    			i--;
	    			continue;
	    		}
	    		else {
	    			moles[randNum] = true;	
	    		}
	    	}
    	}
    }
    
    // what happens when big mole attacks
    public void bigMoleAttack() {
    	if(bigMole) {
	    	lives -= (int)(Math.random()*10 + 25);
	    	bigMole = false;
	    	bigHealth = 5;
	    	livesDisplay.setText("\t\tLives: " + lives);
	        window.getContentPane().repaint();
	    	if(lives <= 0) {
	    		lost = true;
	    	}
    	}
    	attackTimer.stop();
    }
    
    // draws images
    public void draw(Graphics g) {
    	if(!lost) {
	    	// draws backgrounds
	    	g.drawImage(BackgroundSky, 0, 0, windowWidth, windowHeight/3, null);
	    	g.drawImage(BackgroundGrass, 0, windowHeight/3, windowWidth, windowHeight/3 * 2, null);
	    	// draws the mounds
	    	for (int i = 0; i < MOUNDS; i++) {
	    		g.drawImage(Mound, moundX[i], moundY[i], moundWidth, moundHeight, null);
	   	 	}
	    	// draws moles if they are supposed to be on
	    	for (int i = 0; i < MOUNDS; i++) {
	    		if (moles[i] == true) {
	    			g.drawImage(Mole, moundX[i], moundY[i] - moleHeight/2, moleWidth, moleHeight, null);
	    		}
	    	}
	    	// draws big moles if it is there
	    	if(bigMole) {
	    		g.drawImage(Mole, windowWidth/4, windowHeight/4, windowWidth/2, windowHeight/2, null);
	    		attackTimer.start();
	    	}
	    	if(jump) {
	    		g.setColor(new Color(0,0,0));
	    		g.fillRect(0, 0, windowWidth, windowHeight);
	    		g.drawImage(Jump, (windowWidth-225)/2, (windowHeight-225)/2, 225, 225, null);
	    	}
	    // shows lost screen if you lose
    	} else {
    		g.drawImage(BackgroundSky, 0, 0, windowWidth, windowHeight/3, null);
        	g.drawImage(BackgroundGrass, 0, windowHeight/3, windowWidth, windowHeight/3 * 2, null);
        	g.drawString("You Lost!", windowWidth/2, windowHeight/2);
    	}
    	
    }


    // what you want to happen when the mouse is clicked
    public void click(int mouseX, int mouseY) {
    	if(jump) {
    		if(jumpClicks <= 0) {
    			jump = false;
    			jumpHappened = true;
    		}
    		else {
    			jumpClicks--;
    		}
    	}
    	else if(!lost) {
	    	// checks if you click on the big mole
	    	if (bigMole && bigHealth > 1) {
	    		if (mouseX > windowWidth/4 && mouseX < (windowWidth/4)*3 && mouseY > windowHeight/4 && mouseY < (windowHeight/4)*3) {
	    			bigHealth--;
	    		}	
	    	}
	    	// resets the mole
	    	else {
	    		bigMole = false;
	    		bigHealth = 5;
	    		for (int i = 0; i < MOUNDS; i++) {
	    			// checks if you click where a mole is
		    		if (moles[i] == true && mouseX > moundX[i] && mouseX < moundX[i] + moleWidth && mouseY > moundY[i] - moleHeight/2 && mouseY < moundY[i] + moleHeight) {
	    				score++;
	    				moles[i] = false;
	    				
	    				// chance to spawn big mole on mole click
	    				if ((int)(Math.random() * 10) == 1) {
	    					if(jumpHappened) {
	    						bigMole = true;
	    					} else {
	    						jump = true;
	    					}
	    				}
		    		}
		    	}
	    	}
    	}
    }
    
    // reset the game
    public void reset() {
    	defineArrs();
    	score = 0;
    	lives = 100;
    	bigMole = false;
    	bigHealth = 5;
    	lost = false;
    	livesDisplay.setText("\t\tLives: " + lives);
    	window.getContentPane().repaint();
    	jumpHappened = false;
    	jumpClicks = 20;
    }


    // MAYBE TOUCH THE BELOW CODE? //

    public WhackAMoleFillerChallenge() {
    	defineArrs();
    	defineImgs();
        window.setTitle("Whack A Mole");
        window.setSize(windowWidth, windowHeight + textHeight);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JTextArea scoreDisplay = new JTextArea();
        scoreDisplay.setEditable(false);
        scoreDisplay.setText("\t\tScore: " + score);
        
       
        livesDisplay.setEditable(false);
        livesDisplay.setText("\t\tLives: " + lives);
        
        
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
				window.getContentPane().repaint();
			}
        });
        
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
        topPanel.add(resetButton);
        scoreDisplay.setBackground(topPanel.getBackground());
        
        topPanel.add(scoreDisplay);
        
        livesDisplay.setBackground(topPanel.getBackground()); // adds the lives display to the top panel
        
        topPanel.add(livesDisplay);
       

        

        JPanel canvas = new JPanel() {
            public void paint(Graphics g) {
                draw(g);
                scoreDisplay.setText("\t\tScore: " + score);
            }
        };
        canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));

        canvas.addMouseListener(new MouseListener() {

            @Override
            public void mousePressed(MouseEvent e) {
                click(e.getX(), e.getY());
                scoreDisplay.setText("\t\tScore: " + score);
                livesDisplay.setText("\t\tLives: " + lives);
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
        
        window.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                windowWidth = window.getWidth();
                windowHeight = window.getHeight() - textHeight;
                topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
                canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));
                defineArrs();
                window.getContentPane().repaint();
            }
        });

        container.add(topPanel);
        container.add(canvas);
        window.add(container);
        window.setVisible(true);
        canvas.revalidate();
        window.getContentPane().repaint();
        canvas.repaint();
 
        
        Timer spawnTimer = new Timer(TIMESTEP, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	spawnMoles();
            	window.getContentPane().repaint();
            }
        });
        spawnTimer.setInitialDelay(0);
        spawnTimer.start();
    }
    

    public static void main(String[] args) {
        new WhackAMoleFillerChallenge();
    }

}