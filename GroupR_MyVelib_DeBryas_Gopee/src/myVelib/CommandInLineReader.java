package myVelib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class to read a txt file and execute all its commands
 * @author Quentin
 *
 */
public class CommandInLineReader {

	public static String readTextFile(String fileName) {
		  
		  String returnValue = "";
		  FileReader file = null;
		  BufferedReader reader = null;
		  
		  try {
			  // open input stream pointing at fileName
			  file = new FileReader(fileName);
			  
			  // open input buffered reader to read file line by line
			  reader = new BufferedReader(file);
			  String line = "";
			  
			  // reading input file line by line
			  while ((line = reader.readLine()) != null) {
				  returnValue += line + "\n";
			  }
		  } catch (Exception e) {
		      throw new RuntimeException(e);
		  } finally {
		    if (file != null) {
		      try {
		        file.close();
		        reader.close();
		       
		      } catch (IOException e) {
		    	  System.out.println("File not found: " + fileName);
		        // Ignore issues during closing 
		      }
		    }
		  }
		  return returnValue;
		}
}
