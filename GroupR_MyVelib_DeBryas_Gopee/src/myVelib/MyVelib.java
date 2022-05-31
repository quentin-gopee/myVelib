package myVelib;
import java.util.*;

/**
 * Class representing the whole system
 * @author jehandebryas
 *
 */

public class MyVelib {

	private Map<UUID,Station> stations;
	private Map<UUID,Bicycle> bicycles;
	private Map<UUID,User> users;
	private double side;
	private Statistics statistics;
	
	/**
	 * constructor
	 * @param stations
	 * @param bicycles
	 * @param users
	 * @param registrationCards
	 * @param side
	 * @param statistics
	 */
	public MyVelib(Map<UUID, Station> stations, Map<UUID, Bicycle> bicycles, Map<UUID, User> users, double side, Statistics statistics) {
		super();
		this.stations = stations;
		this.bicycles = bicycles;
		this.users = users;
		this.side = side;
		this.statistics = statistics;
	}
	
	public MyVelib() {
		super();
	}
	
	
	/**
	 * getters & setters
	 * @return
	 */
	
	public Map<UUID, Station> getStations() {
		return stations;
	}

	public void setStations(Map<UUID, Station> stations) {
		this.stations = stations;
	}

	public Map<UUID, Bicycle> getBicycles() {
		return bicycles;
	}

	public void setBicycles(Map<UUID, Bicycle> bicycles) {
		this.bicycles = bicycles;
	}

	public Map<UUID, User> getUsers() {
		return users;
	}

	public void setUsers(Map<UUID, User> users) {
		this.users = users;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
	
	/**
	 * adders to all the maps 
	 * @param args
	 */
	
	public void addStation(Station station) {
		this.stations.put(station.getID(), station);
	}
	
	public void addBicycle(Bicycle bicycle) {
		this.bicycles.put(bicycle.getID(), bicycle);
	}
	
	public void addUser(User user) {
		this.users.put(user.getID(), user);
	}
	
	
	/**
	 * main to create the ecosystem
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyVelib myVelib = new MyVelib();
		
		//create stations, each are the same
		/**
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
		**/
		
		int numberofStations = 20;
		myVelib.setSide(10);
		
		Map<UUID,Station> stations =  Map.of();
		//for each station create random number of parking slots, with random number of bicycle
		for(int i = 0 ; i < numberofStations; i++) {
			//each station has between 5 and 25 parking slots
			Station station = new Station();
			station.setLocation(new Location(myVelib.getSide()));
			station.setOnline(true);
			station.setType((new Random().nextDouble())<0.5 ? StationType.Plus : StationType.Standard);
			
			for(int j = 0 ; j< new Random().nextInt(25-5+1)-5;j++) {
				
			}
			stations.put(station.getID(),station);

		}
		
		
		
		
		
		
		
		
	}
	
}
