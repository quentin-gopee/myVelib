package myVelib;
import java.util.*;

/**
 * Class to analyze strings and deduce what to do
 * @author Quentin
 *
 */
public class LineToFunction {
	Map<String, MyVelib> myVelibs;
	
	public LineToFunction() {
		myVelibs = new HashMap<String, MyVelib>();
	}
	
	public void Execute(String line) {
		String[] parts = line.split("");
		
		if (parts[0] == "setup") {
			
		} else if (parts[0] == "addUser") {
			
		} else if (parts[0] == "offline") {
			
		} else if (parts[0] == "online") {
			
		} else if (parts[0] == "rentBike") {
			
		} else if (parts[0] == "returnBike") {
			
		} else if (parts[0] == "displayStation") {
			
		} else if (parts[0] == "displayUser") {
			
		} else if (parts[0] == "sortStation") {
			
		} else if (parts[0] == "display") {
			
		}
	}
}
