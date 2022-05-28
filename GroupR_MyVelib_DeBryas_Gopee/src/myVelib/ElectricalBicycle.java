package myVelib;

import java.util.*;
import java.lang.*;


public class ElectricalBicycle extends Bicycle {
	
	private UUID ID;
	private int currentRideTime;
	private ArrayList<History> histories;
	
	public ElectricalBicycle(){
		this.setID(UUID.randomUUID());
	}

	@Override
	public double accept(RegistrationCard rc) {
		// TODO Auto-generated method stub
		return 0;
	}

	public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		ID = iD;
	}

	public int getCurrentRideTime() {
		return currentRideTime;
	}

	public void setCurrentRideTime(int currentRideTime) {
		this.currentRideTime = currentRideTime;
	}

	public ArrayList<History> getHistories() {
		return histories;
	}

	public void setHistories(ArrayList<History> histories) {
		this.histories = histories;
	}
	
	
	

}
