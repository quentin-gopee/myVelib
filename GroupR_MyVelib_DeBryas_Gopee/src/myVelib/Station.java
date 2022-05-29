package myVelib;
import java.util.*;

public class Station {
	UUID ID;
	Location location;
	String type;
	boolean online;
	ArrayList<ParkingSlot> parkingSlots;
	
	public Station(UUID ID, Location location, String type, boolean online, ArrayList<ParkingSlot> parkingSlots) {
		this.ID = ID;
		this.location = location;
		this.type = type;
		this.online = online;
		this.parkingSlots = parkingSlots;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
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
