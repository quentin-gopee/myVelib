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
		this.parkingSlots = new ArrayList<ParkingSlot>();
		this.online=true;
	}
	
	public Station(UUID ID, Location location, StationType type, boolean online, int numberParkingSlots, int numberBicycles, Date date) {
		this.ID=ID;
		this.parkingSlots = new ArrayList<ParkingSlot>();
		this.location = location;
		this.type = type;
		this.online = online;
		
		if(numberBicycles>numberParkingSlots) {
			System.out.println("number of bikes must be inferior than the number of parking slots");
			numberBicycles=numberParkingSlots;
		}
		
		
		for(int j = 0 ; j< numberParkingSlots;j++) {
			ParkingSlot parkingSlot = new ParkingSlot(this, date);
			Bicycle newBicycle = (new Random().nextDouble() < 0.5) ? new ElectricalBicycle():new MechanicalBicycle();
			
			if(numberBicycles>0) {
				parkingSlot.setBicycle(newBicycle);
				parkingSlot.setState(ParkingSlotState.Bicycle);
				parkingSlot.setLastChangeDate(date);
				numberBicycles--;
			}else {
				parkingSlot.setBicycle(null);
				parkingSlot.setState(ParkingSlotState.FreeToUse);
				parkingSlot.setLastChangeDate(date);
			}
			
			this.addParkingSlot(parkingSlot);
		}
	}

	
	public Station(Location location, StationType type, boolean online, int numberParkingSlots, int numberBicycles, Date date) {
		this.ID=UUID.randomUUID();
		this.parkingSlots = new ArrayList<ParkingSlot>();
		this.location = location;
		this.type = type;
		this.online = online;
		
		if(numberBicycles>numberParkingSlots) {
			System.out.println("number of bikes must be inferior than the number of parking slots");
			numberBicycles=numberParkingSlots;
		}
		
		
		for(int j = 0 ; j< numberParkingSlots;j++) {
			ParkingSlot parkingSlot = new ParkingSlot(this, date);
			Bicycle newBicycle = (new Random().nextDouble() < 0.5) ? new ElectricalBicycle():new MechanicalBicycle();
			
			if(numberBicycles>0) {
				parkingSlot.setBicycle(newBicycle);
				parkingSlot.setState(ParkingSlotState.Bicycle);
				parkingSlot.setLastChangeDate(date);
				numberBicycles--;
			}else {
				parkingSlot.setBicycle(null);
				parkingSlot.setState(ParkingSlotState.FreeToUse);
				parkingSlot.setLastChangeDate(date);
			}
			
			this.addParkingSlot(parkingSlot);
		}
	}
	
	/**
	 * getters & setters
	 * @return
	 */
	public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		this.ID = iD;
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
	
	public void addParkingSlot(ParkingSlot ps) {
		parkingSlots.add(ps);
	}

	@Override
	public String toString() {
		return "Station [ID=" + ID + ", location=" + location + ", type=" + type + ", online=" + online + "]";
	}
	
}

