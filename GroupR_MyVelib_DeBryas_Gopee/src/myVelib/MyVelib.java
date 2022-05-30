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
	private Map<UUID,RegistrationCard> registrationCards;
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
	public MyVelib(Map<UUID, Station> stations, Map<UUID, Bicycle> bicycles, Map<UUID, User> users,
			Map<UUID, RegistrationCard> registrationCards, double side, Statistics statistics) {
		super();
		this.stations = stations;
		this.bicycles = bicycles;
		this.users = users;
		this.registrationCards = registrationCards;
		this.side = side;
		this.statistics = statistics;
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

	public Map<UUID, RegistrationCard> getRegistrationCards() {
		return registrationCards;
	}

	public void setRegistrationCards(Map<UUID, RegistrationCard> registrationCards) {
		this.registrationCards = registrationCards;
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
	
	public static void main(String[] args) {
		
	}
	
}
