package myVelib;

import java.util.ArrayList;

/**
 * a Class containing all methods used to compute and display statistics about MyVelib system
 * @author jehandebryas
 *
 */

public class Statistics {

	private MyVelib myVelib;

	/**
	 * constructor
	 * @param myVelib
	 */
	public Statistics(MyVelib myVelib) {
		super();
		this.myVelib = myVelib;
	}

	/*
	 * getters & setters
	 */
	public MyVelib getMyVelib() {
		return myVelib;
	}

	public void setMyVelib(MyVelib myVelib) {
		this.myVelib = myVelib;
	}
	
	/**
	 * statistics for a user
	 */
	public int numberOfRides(User user) {
		return user.getRides().size();
	}
	
	public int totalTimeSpentOnABike(User user) {
		
		ArrayList<Ride> rides = user.getRides();
		int totalTime=0;
		for(Ride r: rides) {
			totalTime += 0 ; //rajouter difference de temps
		}
		
		return totalTime;
		
	}
	
	public double totalAmmountofCharges(User user) {
		
		ArrayList<Ride> rides = user.getRides();
		double totalCharges = 0;
		for(Ride r: rides) {
			totalCharges += r.getCost() ; 
		}
		
		return totalCharges;
	}

	public int timeCreditEarned(User user) {
		int timeCreditEarned = 0;
		//code here
		return timeCreditEarned;
	}
	
	/**
	 * statistics for station
	 */
	public int totalNumberofRentOperation(Station station) {
		int totalNumberofRentOperation = 0;
		for(ParkingSlot pS : station.getParkingSlots()) {
			for(ParkingSlotHistory pSH : pS.getParkingSlotHistories()) {
				if(pSH.getState() == ParkingSlotState.FreeToUse && pSH!=pS.getParkingSlotHistories().get(1)) {
					totalNumberofRentOperation++;
				}
			}
		}
		return totalNumberofRentOperation;
	}
	
	public double avergareRateofOccupation() {
		double avergareRateofOccupation=0;
		//code here
		return avergareRateofOccupation;
	}
	
	public Station mostUsedStation() {
		//code here
		return null;
	}
	
	public Station leastOccupiedStation() {
		//code here
		return null;
	}
}
