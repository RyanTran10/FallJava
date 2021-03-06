package Photoshop;
// Photoshop program that can run several manipulations on 
// an image
// filler code by Mr. David

import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class PhotoshopFiller extends Component {

	// the name of the output file. will be determined by which methods are called
    private String outputName;
    
    // the 2d array of colors representing the image
    private Color[][] pixels;
    
    // the width and height of the image 
    private int w,h;
    

    // this method increases each color's rgb value by a given amount.
    // don't forget that rgb values are limited to the range [0,255]
    public void brighten(int amount) {
        outputName = "brightened_" + outputName;
        //goes through every pixel
        for(int i = 0; i < pixels.length; i++) {
        	for(int j = 0; j < pixels[i].length; j++) {
        		//sets each color of each pixel to its own color + the amount of brighten 
        		int r = pixels[i][j].getRed() + amount;
        		int g = pixels[i][j].getGreen() + amount;
        		int b = pixels[i][j].getBlue() + amount;
        		//checks to make sure the colors arent out of bounds and sets the to the max or min if they are
        		if(r > 255) r = 255;
        		else if(r < 0) r = 0;
        		if(g > 255) g = 255;
        		else if(g < 0) g = 0;
        		if(b > 255) b = 255;
        		else if(b < 0) b = 0;
        		
        		//sets each pixel to the new color
        		pixels[i][j] = new Color(r, g, b);
        	}
        }
    }
    
    // flip an image either horizontally or vertically.
    public void flip(boolean horizontally) {
        outputName = (horizontally?"h":"v") + "_flipped_" + outputName;
        
       	if (horizontally) {
       		// goes through each pixel array and flips it around
       		for(int i = 0; i < pixels.length; i++) {
       			Color[] temp = new Color[pixels[i].length];
       			for(int j = 0; j < pixels[i].length; j++) {
       				temp[j] = pixels[i][pixels[i].length-1-j];
       			}
       			pixels[i] = temp;
       		}
       	//makes a temporary 2d array and goes through the first one setting each spot to an array
       	}else {
       		Color[][] pixels1 = new Color[pixels.length][pixels[0].length];
       		for(int i = 0; i < pixels.length; i++) {
       			pixels1[i] = pixels[pixels.length-i-1];
       		}
       		pixels = pixels1;
       	}
    }
    
    // negates an image
    // to do this: subtract each pixel's rgb value from 255 
    // and use this as the new value
    public void negate() {
        outputName = "negated_" + outputName;
        
        //goes through each pixel
        for(int i = 0; i < pixels.length; i++) {
        	for(int j = 0; j < pixels[i].length; j++) {
        		//subtracts the current rgb values from 255 
        		int r = 255 - pixels[i][j].getRed();
        		int g = 255 - pixels[i][j].getGreen();
        		int b = 255 - pixels[i][j].getBlue();
        		//sets each pixel to the new color
        		pixels[i][j] = new Color(r, g, b);
        	}
        }
    }
    
    // this makes the image 'simpler' by redrawing it using only a few colors
    // to do this: for each pixel, find the color in the list that is closest to
    // the pixel's rgb value. 
    // use this predefined color as the rgb value for the changed image.
    public void simplify() {
    
    		// the list of colors to compare to. Feel free to change/add colors
    		Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
                Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.CYAN};
        outputName = "simplified_" + outputName;
        
        // goes through each pixel
        for(int i = 0; i < pixels.length; i++) {
        	for(int j = 0; j < pixels[i].length; j++) {
        		Color closest = colorList[0];
            	double distance = distance(pixels[i][j], colorList[0]);
            	//goes through the list of colors and finds 
        		for(int k = 1; k < colorList.length; k++) {
        			// checks if the new distance is closer and sets distance to that
        			if(distance(pixels[i][j], colorList[k]) < distance) {
        				distance = distance(pixels[i][j], colorList[k]);
        				closest = colorList[k];
        			}
        		}
        		// sets each pixel to the closest color
        		pixels[i][j] = closest;
        	}
        }
         
    }
    
    // optional helper method (recommended) that finds the 'distance' 
    // between two colors.
    // use the 3d distance formula to calculate
    public double distance(Color c1, Color c2) {
    	return Math.sqrt(Math.pow((c1.getRed()-c2.getRed()), 2)+Math.pow((c1.getGreen()-c2.getGreen()), 2)+Math.pow((c1.getBlue()-c2.getBlue()), 2));	
//    	return Math.sqrt(*(c1.getRed()-c2.getRed())+(c1.getGreen()-c2.getGreen())*(c1.getGreen()-c2.getGreen()+(c1.getBlue()-c2.getBlue())*(c1.getBlue()-c2.getBlue())));	// fix this
    }
    
    
    // this blurs the image
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values 
    // with the current pixel's own rgb value. 
    // divide this sum by 9, and set it as the rgb value for the blurred image
    public void blur() {
		outputName = "blurred_" + outputName;
		// creates a temporary array 
		Color[][] temp = new Color[pixels.length][pixels[0].length];
		// radius of bluring amount 
		int blurAmount = 1;
		// goes through every pixel
		for(int i = blurAmount; i < pixels.length - blurAmount; i++) {
			for(int j = blurAmount; j < pixels[i].length - blurAmount; j++) {
				int totalr = 0, totalg = 0, totalb = 0;
				// goes through the border and sums up the colors
				for(int k = -1*blurAmount; k <= blurAmount; k++) {
					for(int l = -1*blurAmount; l <= blurAmount; l++) {
						totalr += pixels[i-k][j-l].getRed();
						totalg += pixels[i-k][j-l].getGreen();
						totalb += pixels[i-k][j-l].getBlue();
					}
				}
//				pixels[i][j] = new Color(totalr/((blurAmount*2+1)*(blurAmount*2+1)), totalg/((blurAmount*2+1)*(blurAmount*2+1)), totalb/((blurAmount*2+1)*(blurAmount*2+1)));
				// sets the pixel to the averaged color
				temp[i][j] = new Color(totalr/((blurAmount*2+1)*(blurAmount*2+1)), totalg/((blurAmount*2+1)*(blurAmount*2+1)), totalb/((blurAmount*2+1)*(blurAmount*2+1)));
			}
		}
		
		// checks if any of the pixels are null
		for(int i = 0; i < temp.length; i++) {
        	for(int j = 0; j < temp[i].length; j++) {
        		if(temp[i][j] == null) {
        			temp[i][j] = pixels[i][j];
        		}
        	}
        }
		// sets the pixels to the new colors
        pixels = temp;
       
	}
    
    // this highlights the edges in the image, turning everything else black. 
    // to do this: at each pixel, sum the 8 surrounding pixels' rgb values. 
    // now, multiply the current pixel's rgb value by 8, then subtract the sum.
    // this value is the rgb value for the 'edged' image
    public void edge() {
        outputName = "edged_" + outputName;
        Color[][] temp = new Color[pixels.length][pixels[0].length];
        int edgeSize = 1;
        // goes through every pixel
        for(int i = edgeSize; i < pixels.length-edgeSize; i++) {
			for(int j = edgeSize; j < pixels[i].length-edgeSize; j++) {
				// goes through the surrounding pixels and sums the colors
				int r = 0, g = 0, b = 0;
				for(int k = -1*edgeSize; k <= edgeSize; k++) {
					for(int l = -1*edgeSize; l <= edgeSize; l++) {
						r += pixels[i-k][j-l].getRed();
						g += pixels[i-k][j-l].getGreen();
						b += pixels[i-k][j-l].getBlue();
					}
				}
				// sets the new color
				r = pixels[i][j].getRed()*8-(r-pixels[i][j].getRed());
				g = pixels[i][j].getGreen()*8-(g-pixels[i][j].getGreen());
				b = pixels[i][j].getBlue()*8-(b-pixels[i][j].getBlue());
				// checks if it is our of bounds
				if(r > 255) r = 255;
        		else if(r < 0) r = 0;
        		if(g > 255) g = 255;
        		else if(g < 0) g = 0;
        		if(b > 255) b = 255;
        		else if(b < 0) b = 0;
				
        		// sets the new array to the color
				temp[i][j] = new Color(r,g,b);
			}
		}
        // checks for null pixels
        for(int i = 0; i < temp.length; i++) {
        	for(int j = 0; j < temp[i].length; j++) {
        		if(temp[i][j] == null) {
        			temp[i][j] = new Color(0,0,0);
        		}
        	}
        }
        //sets the picture to the new array
        pixels = temp;
    }
    // another distance formula
    public double distance1(Color c1, Color c2) {
		return Math.sqrt((c1.getRed()-c2.getRed())*(c1.getRed()-c2.getRed())+(c1.getGreen()-c2.getGreen())*(c1.getGreen()-c2.getGreen()+(c1.getBlue()-c2.getBlue())*(c1.getBlue()-c2.getBlue())));	// fix this
    }
    
    // finds the distance between 2 color arrays
    public double distanceArr(Color[] c1, Color[] c2) {
    	double total = 0;
    	for(int i = 0; i < c1.length; i++) {
    		total += distance(c1[i], c2[i]);
    	}
    	return total/c1.length;
    }
    
    // kmeans method
    public void kmeans(int n) {
    	outputName = "kmeans_" + outputName;
    	ArrayList<ArrayList<Color>> colors = new ArrayList<ArrayList<Color>>();
    	
    	//defines starting colors
    	Color[] colorList = {Color.BLUE, Color.RED,Color.ORANGE, Color.MAGENTA,
                Color.BLACK, Color.WHITE, Color.GREEN, Color.YELLOW, Color.CYAN};
    	for(int i = 0; i < n; i++) {
    		colors.add(new ArrayList<Color>());
    		colors.get(i).add(colorList[i]);
    	}
    	

    	//sorts
    	int count = 0;
    	boolean run = true;
    	while(run) {
    		run = false;
    		Color[] first = new Color[n];
    		Color[] second = new Color[n];
	    	for(int i = 0; i < pixels.length; i++) {
	        	for(int j = 0; j < pixels[i].length; j++) {
	        		
	        		int lowest = (int) distance(pixels[i][j], colors.get(0).get(0));
	        		int lowind = 0;
	        		
	        		for(int k = 1; k < colors.size(); k++) {
	        			if(lowest > (int) distance(pixels[i][j], colors.get(k).get(0))) {
	        				lowest = (int) distance(pixels[i][j], colors.get(k).get(0));
	        				lowind = k;
	        			}
	        		}
	        		colors.get(lowind).add(pixels[i][j]);
	        		
	        		
	        	}
	    	}
	    	count++;
	    	//averages pixels 
	    	for(int i = 0; i < colors.size(); i++) {
	    		int size = colors.get(i).size();
	    		int totalr = 0, totalg = 0, totalb = 0;
	    		for(int j = 0; j < colors.get(i).size(); j++) {
	    			totalr += colors.get(i).get(j).getRed();
	    			totalg += colors.get(i).get(j).getGreen();
	    			totalb += colors.get(i).get(j).getBlue();
	    		}
	    		first[i] = colors.get(i).get(0);
	    		colors.get(i).clear();
				colors.get(i).add(new Color(totalr/size, totalg/size, totalb/size));
				second[i] = colors.get(i).get(0);
	    	}
	    	if (distanceArr(first, second) > 0) {
//	    		System.out.println(distanceArr(first, second));
	    		run = true;
	    	}
	    	if(count > 110) {
	    		break;
	    	}
    	}
//    	System.out.println("runs = " + count);
    	

    	//simplify 
    	for(int i = 0; i < pixels.length; i++) {
        	for(int j = 0; j < pixels[i].length; j++) {
        		Color closest = colors.get(0).get(0);
            	double distance = distance(pixels[i][j], colors.get(0).get(0));
        		for(int k = 1; k < colors.size(); k++) {
        			if(distance(pixels[i][j], colors.get(k).get(0)) < distance) {
        				distance = distance(pixels[i][j], colors.get(k).get(0));
        				closest = colors.get(k).get(0);
        			}
        		}
        		pixels[i][j] = closest;
        	}
        }
    }
    
    
    // *************** DON'T MESS WITH THE BELOW CODE **************** //
    
    // feel free to check it out, but don't change it unless you've consulted 
    // with Mr. David and understand what the code's doing
    
    

    public void run() {
    	JFileChooser fc = new JFileChooser();
		File workingDirectory = new File(System.getProperty("user.dir")+System.getProperty("file.separator")+ "Images");
		fc.setCurrentDirectory(workingDirectory);
		fc.showOpenDialog(null);
		File my_file = fc.getSelectedFile();
		if (my_file == null)
			System.exit(-1);
		
		// reads the image file and creates our 2d array
        BufferedImage image;
		try {
			image = ImageIO.read(my_file);
		
	        BufferedImage new_image = new BufferedImage(image.getWidth(),
	                        image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	        create_pixel_array(image);
			outputName = my_file.getName();
			
			// runs the manipulations determined by the user
			System.out.println("Enter the manipulations you would like to run on the image.\nYour "
					+ "choices are: brighten, flip, negate, blur, edge, or simplify.\nEnter each "
					+ "manipulation you'd like to run, then type in 'done'.");
			Scanner in = new Scanner(System.in);
			String action = in.next().toLowerCase();
			while (!action.equals("done")) {
	    			try {
		    			if (action.equals("brighten")) {
		    				System.out.println("enter an amount to increase the brightness by");
		    				int brightness = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, brightness);
		    			}
		    			else if (action.equals("flip")) {
		    				System.out.println("enter \"h\" to flip horizontally, anything else to flip vertically.");
		        			Method m = getClass().getDeclaredMethod(action, boolean.class);
		        			m.invoke(this, in.next().equals("h"));
		    			}
		    			else if (action.equals("kmeans")) {
		    				System.out.println("enter a number of colors to use");
		    				int n = in.nextInt();
		        			Method m = getClass().getDeclaredMethod(action, int.class);
		        			m.invoke(this, n);
		    			}
		    			else {
		        			Method m = getClass().getDeclaredMethod(action);
		        			m.invoke(this, new Object[0]);
		    			}
		    			System.out.println("done. enter another action, or type 'done'");
	    			}
	    			catch (NoSuchMethodException e) {
	    				System.out.println("not a valid action, try again");
	    			} catch (IllegalAccessException e) {e.printStackTrace();System.exit(1);} 
	    			catch (IllegalArgumentException e) {e.printStackTrace();System.exit(1);}
	    			catch (InvocationTargetException e) {e.printStackTrace();System.exit(1);}
	    			
	    			action = in.next().toLowerCase();
	    		} 
	        in.close();
	        
	        // turns our 2d array of colors into a new png file
	        create_new_image(new_image);
	        File output_file = new File("ImagesOutput/" + outputName);
	        ImageIO.write(new_image, "png", output_file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
		
    
    public void create_pixel_array(BufferedImage image) {
        w = image.getWidth();
        h = image.getHeight();
        pixels = new Color[h][];
        for (int i = 0; i < h; i++) {
            pixels[i] = new Color[w];
            for (int j = 0; j < w; j++) {
                pixels[i][j] = new Color(image.getRGB(j,i));
            }
        }
    }

    public void create_new_image(BufferedImage new_image) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
            		new_image.setRGB(j, i, pixels[i][j].getRGB());
            }
        }
    }

    public static void main(String[] args) {
		new PhotoshopFiller();
	}

    public PhotoshopFiller() {
		run();
    }
}