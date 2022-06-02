package myVelib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class to read a txt file and execute all its commands
 * @author Quentin
 *
 */
public class RunTest {

	public static void main (String[] args) {
		
		
		LineToFunction lTF = new LineToFunction();
		
		FileReader file = null;
		BufferedReader reader = null;
		  
		try {
			 // open input stream pointing at fileName
			 file = new FileReader("RunTest");
			  
			 // open input buffered reader to read file line by line
			 reader = new BufferedReader(file);
			 String line = "";
			  
			 // reading input file line by line
			 while ((line = reader.readLine()) != null) {
				 System.out.println(line);
				 try {
					 lTF.Execute(line);
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
				 System.out.println();
				 
			 }
		} catch (Exception e) {
		     throw new RuntimeException(e);
		} finally {
		   if (file != null) {
			   try {
		       file.close();
		       reader.close();
		       
		     } catch (IOException e) {
		    	 System.out.println("File not found: " + args[0]);
		       // Ignore issues during closing 
		     }
		   }
		}
	}
}
