package myVelib;
import java.util.*;

/**
 * Station is a class that represent a station
 * @author jehandebryas
 *
 */

public class Station {
	
	/** 
	 * elements of a station object
	 */
	private UUID ID;
	private Location location;
	private StationType type;
	private boolean online;
	private ArrayList<ParkingSlot> parkingSlots;
	
	
	/**
	 * initializer
	 * @param ID
	 * @param location
	 * @param type
	 * @param online
	 * @param parkingSlots
	 */
	public Station(Location location, StationType type, boolean online, ArrayList<ParkingSlot> parkingSlots) {
		this.ID = UUID.randomUUID();
		this.location = location;
		this.type = type;
		this.online = online;
		this.parkingSlots = parkingSlots;
	}
	
	public Station() {
		this.ID=UUID.randomUUID();
	}
	
	/**
	 * getters & setters
	 * @return
	 */
	public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		ID = iD;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public StationType getType() {
		return type;
	}

	public void setType(StationType type) {
		this.type = type;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public ArrayList<ParkingSlot> getParkingSlots() {
		return parkingSlots;
	}

	public void setParkingSlots(ArrayList<ParkingSlot> parkingSlots) {
		this.parkingSlots = parkingSlots;
	}
	
}

