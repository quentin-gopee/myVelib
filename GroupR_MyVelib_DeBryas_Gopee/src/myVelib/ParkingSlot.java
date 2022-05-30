package myVelib;
import java.util.*;

/**
 * ParkingSlot is a Class that represents every parking slot of all stations
 * @author jehandebryas
 *
 */

public class ParkingSlot {
	
	/**
	 * elements of the ParkingSlot Class
	 */
	private Station station;
	private UUID ID;
	private ParkingSlotState state;
	private ArrayList<ParkingSlotHistory> parkingSlotHistories;
	private Bicycle bicycle;
	
	
	/**
	 * initializer of the ParkingSlotclass
	 * @param station
	 * @param ID
	 * @param state
	 */
	public ParkingSlot(Station station, UUID ID, ParkingSlotState state) {
		this.station = station;
		this.ID = ID;
		this.state = state;
	}
	
	/**
	 * getter & setters
	 * @return
	 */
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		ID = iD;
	}

	public ParkingSlotState getState() {
		return state;
	}

	public void setState(ParkingSlotState state) {
		this.state = state;
	}

	public ArrayList<ParkingSlotHistory> getParkingSlotHistories() {
		return parkingSlotHistories;
	}

	public void setParkingSlotHistories(ArrayList<ParkingSlotHistory> parkingSlotHistories) {
		this.parkingSlotHistories = parkingSlotHistories;
	}

	public Bicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}
}
	
