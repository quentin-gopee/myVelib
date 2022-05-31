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
	public Station(UUID ID, Location location, StationType type, boolean online, ArrayList<ParkingSlot> parkingSlots) {
		this.ID = ID;
		this.location = location;
		this.type = type;
		this.online = online;
		this.parkingSlots = parkingSlots;
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
	
	/**
	 * function for renting a bike on this station
	 * return truye if all happenned well.
	 * return false if not.
	 * @param user
	 * @param parkingSlot
	 * @param newDate
	 */
	public boolean rentaBike(User user, ParkingSlot parkingSlot, Date newDate) {
		
		//check that parking slot is on this station, and available
		
		boolean done = false;
		
		for(ParkingSlot pS : this.getParkingSlots()){
			if(pS==parkingSlot && pS.getBicycle() != null) {
				//the bike is taken in the parkingslot 
				parkingSlot.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, pS, pS.getBicycle(), pS.getLastChangeDate(), newDate));
				parkingSlot.setBicycle(null);
				parkingSlot.setState(ParkingSlotState.FreeToUse);
				parkingSlot.setLastChangeDate(newDate);
				done=true;
			}
		}
		return done;
	}
	
	public boolean returnaBike(User user, ParkingSlot parkingSlot, Date newDate) {
		
		boolean done = false;
		
		for(ParkingSlot pS : this.getParkingSlots()){
			if(pS==parkingSlot && pS.getBicycle() == null) {
				//the bike is taken in the parkingslot 
				parkingSlot.addParkingSlotHistory(new ParkingSlotHistory(pS.getState(), pS, pS.getBicycle(), pS.getLastChangeDate(), newDate));
				parkingSlot.setBicycle(user.getCurrentRide().getBicycle());
				parkingSlot.setState(ParkingSlotState.Bicycle);
				parkingSlot.setLastChangeDate(newDate);
				done=true;
			}
		}
		return done;
	}

	
	
}

