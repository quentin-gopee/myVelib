package myVelib;
import java.util.*;

public class ParkingSlot {
	Station station;
	UUID ID;
	String state;
	ArrayList<ParkingSlotHistory> parkingSlotHistories;
	
	public ParkingSlot(Station station, UUID ID, String state) {
		this.station = station;
		this.ID = ID;
		this.state = state;
	}

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ArrayList<ParkingSlotHistory> getParkingSlotHistories() {
		return parkingSlotHistories;
	}

	public void setParkingSlotHistories(ArrayList<ParkingSlotHistory> parkingSlotHistories) {
		this.parkingSlotHistories = parkingSlotHistories;
	}
}
