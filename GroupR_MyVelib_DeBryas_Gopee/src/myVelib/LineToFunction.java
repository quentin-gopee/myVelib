package myVelib;
import java.text.SimpleDateFormat;
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
	
	/**
	 * Handle the following commands:
	 * setup <velibnetworkName>
	 * setup <name> <nstations> <nslots> <s> <nbikes>
	 * addUser <userName,cardType, velibnetworkName>
	 * addUser <userName,cardType, velibnetworkName, ID>
	 * offline <velibnetworkName, stationID>
	 * online <velibnetworkName, stationID>
	 * planClassicRide <userID, destinationX, destinationY, bicycleType, year, month, day, hour, minutes, velibnetworkName>
	 * startRide <userID, year, month, day, hour, minutes, velibnetworkName>
	 * endRide <userID, year, month, day, hour, minutes, velibnetworkName>
	 * displayStation <velibnetworkName, stationID>
	 * displayUser <velibnetworkName, userID>
	 * sortStation <velibnetworkName, sortpolicy>
	 * display <velibnetworkName>
	 * 
	 * @param line
	 * @throws Exception
	 */
	public void Execute(String line) throws Exception {
		String[] parts = line.split(" ");
		
		if (parts[0] == "setup") {
			if (parts.length == 2) {
				MyVelib myVelib = new MyVelib();
				myVelib.setUp(10, 10, 4, 75);
				myVelibs.put(parts[1], myVelib);
				System.out.println("setup done");
			} else if (parts.length == 6) {
				MyVelib myVelib = new MyVelib();
				myVelib.setUp(Integer.valueOf(parts[2]), Integer.valueOf(parts[3]), Integer.valueOf(parts[4]), Integer.valueOf(parts[5]));
				myVelibs.put(parts[1], myVelib);
			} else {
				throw new Exception("invalid command");
			}
		}
		
		else if (parts[0] == "addUser") {
			if (parts.length == 4) {
				if (parts[2] == "NoCard") {
					myVelibs.get(parts[3]).addUser(new User(parts[1], new Location(myVelibs.get(parts[3]).getSide()), new CreditCard(), new NoCard(), myVelibs.get(parts[3])));
				} else if (parts[2] == "Vmax") {
					myVelibs.get(parts[3]).addUser(new User(parts[1], new Location(myVelibs.get(parts[3]).getSide()), new CreditCard(), new Vmax(), myVelibs.get(parts[3])));
				} else if (parts[2] == "Vlibre") {
					myVelibs.get(parts[3]).addUser(new User(parts[1], new Location(myVelibs.get(parts[3]).getSide()), new CreditCard(), new Vlibre(), myVelibs.get(parts[3])));
				} else {
					throw new Exception("invalid type of card");
				}
			} else if (parts.length == 5) {
				if (parts[2] == "NoCard") {
					myVelibs.get(parts[3]).addUser(new User(UUID.fromString(parts[4]), parts[1], new Location(myVelibs.get(parts[3]).getSide()), new CreditCard(), new NoCard(), myVelibs.get(parts[3])));
				} else if (parts[2] == "Vmax") {
					myVelibs.get(parts[3]).addUser(new User(UUID.fromString(parts[4]), parts[1], new Location(myVelibs.get(parts[3]).getSide()), new CreditCard(), new Vmax(), myVelibs.get(parts[3])));
				} else if (parts[2] == "Vlibre") {
					myVelibs.get(parts[3]).addUser(new User(UUID.fromString(parts[4]), parts[1], new Location(myVelibs.get(parts[3]).getSide()), new CreditCard(), new Vlibre(), myVelibs.get(parts[3])));
				} else {
					throw new Exception("invalid type of card");
				}
			} else {
				throw new Exception("invalid command");
			}
		}
		
		else if (parts[0] == "offline") {
			if (parts.length == 3) {
				myVelibs.get(parts[1]).getStations().get(UUID.fromString(parts[2])).setOnline(false);
			} else {
				throw new Exception("invalid command");
			}
		}
		
		else if (parts[0] == "online") {
			if (parts.length == 3) {
				myVelibs.get(parts[1]).getStations().get(UUID.fromString(parts[2])).setOnline(true);
			} else {
				throw new Exception("invalid command");
			}
		}
		
		else if (parts[0] == "planClassicRide") {
			if (parts.length == 11) {
				Date planningTime = new Date(Integer.valueOf(parts[5]), Integer.valueOf(parts[6]), Integer.valueOf(parts[7]), Integer.valueOf(parts[8]), Integer.valueOf(parts[9]));
				if (parts[4] == "Mechanical") {
					myVelibs.get(parts[10]).getUsers().get(UUID.fromString(parts[1])).planClassicRide(new Location(Integer.valueOf(parts[2]), Integer.valueOf(parts[3])), BicycleType.Mechanical, planningTime);
				} else if (parts[4] == "Electrical") {
					myVelibs.get(parts[10]).getUsers().get(UUID.fromString(parts[1])).planClassicRide(new Location(Integer.valueOf(parts[2]), Integer.valueOf(parts[3])), BicycleType.Electrical, planningTime);
				} else {
					throw new Exception("invalid bike type");
				}
			} else {
				throw new Exception("invalid command");
			}
		}
		
		else if (parts[0] == "startRide") {
			if (parts.length == 8) {
				Date startingTime = new Date(Integer.valueOf(parts[2]), Integer.valueOf(parts[3]), Integer.valueOf(parts[4]), Integer.valueOf(parts[5]), Integer.valueOf(parts[6]));
				myVelibs.get(parts[7]).getUsers().get(UUID.fromString(parts[1])).startRide(startingTime);
			} else {
				throw new Exception("invalid command");
			}
		}
		
		else if (parts[0] == "endRide") {
			if (parts.length == 8) {
				Date endingTime = new Date(Integer.valueOf(parts[2]), Integer.valueOf(parts[3]), Integer.valueOf(parts[4]), Integer.valueOf(parts[5]), Integer.valueOf(parts[6]));
				myVelibs.get(parts[7]).getUsers().get(UUID.fromString(parts[1])).endRide(endingTime);
			} else {
				throw new Exception("invalid command");
			}
		}
		
		else if (parts[0] == "displayStation") {
			if (parts.length == 3) {
				System.out.println("total number of rent operations: " + myVelibs.get(parts[1]).getStatistics().getsStats().totalNumberofRentOperations(myVelibs.get(parts[1]).getStations().get(UUID.fromString(parts[2]))));
				System.out.println("total number of return operations: " + myVelibs.get(parts[1]).getStatistics().getsStats().totalNumberofReturnOperations(myVelibs.get(parts[1]).getStations().get(UUID.fromString(parts[2]))));
			} else {
				throw new Exception("invalid command");
			}
		}
		
		else if (parts[0] == "displayUser") {
			if (parts.length == 3) {
				System.out.println("number of rides: " + myVelibs.get(parts[1]).getStatistics().getuStats().numberOfRides(myVelibs.get(parts[1]).getUsers().get(UUID.fromString(parts[2]))));
				System.out.println("total time spent on a bike: " + myVelibs.get(parts[1]).getStatistics().getuStats().totalTimeSpentOnABike(myVelibs.get(parts[1]).getUsers().get(UUID.fromString(parts[2]))));
				System.out.println("total charges: " + myVelibs.get(parts[1]).getStatistics().getuStats().totalAmmountofCharges(myVelibs.get(parts[1]).getUsers().get(UUID.fromString(parts[2]))));
				System.out.println("total time credit earned: " + myVelibs.get(parts[1]).getStatistics().getuStats().timeCreditEarned(myVelibs.get(parts[1]).getUsers().get(UUID.fromString(parts[2]))));
			} else {
				throw new Exception("invalid command");
			}
		}
		
		else if (parts[0] == "sortStation") {
			if (parts.length == 3) {
				if (parts[2] == "mostUsed") {
					System.out.println(myVelibs.get(parts[1]).getStatistics().getsStats().mostUsedStation(myVelibs.get(parts[1])));
				} else if (parts[2] == "leastOccupied") {
					System.out.println(myVelibs.get(parts[1]).getStatistics().getsStats().leastOccupiedStation(myVelibs.get(parts[1])));
				} else {
					throw new Exception("invalid command");
				}
			} else {
				throw new Exception("invalid command");
			}
		}
		
		else if (parts[0] == "display") {
			if (parts.length == 2) {
				System.out.println("Stations :" + myVelibs.get(parts[1]).getStations().values());
				System.out.println("Users :" + myVelibs.get(parts[1]).getUsers().values());
				ArrayList<ParkingSlot> ps = new ArrayList<ParkingSlot>();
				for (Station s: myVelibs.get(parts[1]).getStations().values()) {
					for (ParkingSlot p: s.getParkingSlots()) {
						ps.add(p);
					}
				}
				System.out.println("ParkingSlot :" + ps);
			} else {
				throw new Exception("invalid command");
			}
		}
		
		else {
			throw new Exception("invalid command");
		}
	}
}