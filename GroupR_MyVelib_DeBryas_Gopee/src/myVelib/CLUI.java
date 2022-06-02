package myVelib;

import java.util.Scanner;

/**
 * Command in line user interface for monitoring myVelib networks
 * 
 * Handles the following commands:
 * 
 * setup velibnetworkName
 * Creates a myVelib network with given name and consisting of 10 stations each of which has 10 parking slots and such that stations
 * are arranged on a square grid whose of side 4km and initially populated with a 75% bikes randomly distributed over the 10 stations
 * The creation date is automatically set to 01/01/2022
 * 
 * setup name nstations nslots s nbikes
 * Creates a myVelib network of side s with given name and consisting of nbikes and nstations stations each of which has nslots parking slots
 * The creation date is automatically set to 01/01/2022
 * 
 * addUser userName cardType velibnetworkName
 * Add a new User named userName with a registration card (NoCard, Vmax, Vlibre) in velibnetworkName
 * 
 * addUser userName cardType velibnetworkName ID
 * Add a new User named userName with a registration card (NoCard, Vmax, Vlibre) in velibnetworkName with a specific ID
 * 
 * addStation locationX locationY type nslots nbikes year month day hour minutes velibnetworkName
 * Add a new station in velibnetworkName at a specific location with nslots and nbikes (need to specify the date of creation)
 * 
 * addStation locationX <locationY type nslots nbikes year month day hour minutes velibnetworkName ID
 * Add a new station in velibnetworkName at a specific location with nslots, nbikes and specific ID (need to specify the date of creation)
 * 
 * offline velibnetworkName stationID
 * Put the station stationID in velibnetworkName offline
 * 
 * online velibnetworkName stationID
 * Put the station stationID in velibnetworkName online
 * 
 * planClassicRide userID destinationX destinationY bicycleType year month day hour minutes velibnetworkName
 * Plan a new ride for the user userID going to a specific destination and with a specific type of bicycle in velibnetworkName
 * (need to specify the date of the planning)
 * 
 * startRide userID year month day hour minutes velibnetworkName
 * Start the planned ride for the user userID in velibnetworkName at a specific date
 * 
 * endRide userID year month day hour minutes velibnetworkName
 * Start the current ride for the user userID in velibnetworkName at a specific date
 * 
 * cancelRide userID velibnetworkName
 * Cancel the planned ride of user userID in velibnetworkName
 * 
 * displayStation <elibnetworkName stationID
 * Display the statistics of the station stationID in velibnetworkName
 * 
 * displayUser velibnetworkName userID
 * Display the statistics of the user userID in velibnetworkName
 * 
 * sortStation velibnetworkName sortpolicy
 * Display the stations of velibnetworkName sorted according to the sort policy
 * 
 * display velibnetworkName
 * Display the stations, the users and the parking slots of a network
 * 
 * display
 * Display the list of networks created
 * 
 * @author Quentin
 *
 */

public class CLUI {
	
	public static void main(String[] args) {
		LineToFunction lineToFunction = new LineToFunction();
		while(true) {
			System.out.println("Enter a command:");
			
			Scanner scan = new Scanner(System.in);
			
			
			String s = scan.nextLine();
			
			if(s.equals("EXIT")) {
				break;
			}
					
			try {
				lineToFunction.Execute(s);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("exit with success");
		
	}	
	
	
}
