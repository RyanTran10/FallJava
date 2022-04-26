package AdvCompSci;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class FileReadingExample {
	
	
	public static void main(String[] args)  {
		
		try {
			BufferedReader in = new BufferedReader(
					new FileReader("UserInputs.txt"));
			
			for (String line = in.readLine(); line != null; 
					line = in.readLine()) {
				
				System.out.println(line);
				
			}
			
			in.close();
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
