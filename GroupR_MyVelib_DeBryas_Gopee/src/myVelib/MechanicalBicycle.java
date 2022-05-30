package myVelib;

import java.util.*;

/**
 * Mechanical bicycle
 * @author Quentin
 *
 */
public class MechanicalBicycle implements Bicycle {
	
	/**
	 * Unique id for the bicycle
	 */
	private UUID ID;
	
	/**
	 * The time time of the current ride in minutes (if any)
	 */
	private int currentRideTime;
	
	/**
	 * History of the bike (rides and parking slots)
	 */
	private ArrayList<History> histories;
	
	/**
	 * creates a mechanical bicycle
	 * @param ID the id of the bicycle
	 */
	public MechanicalBicycle(){
		this.setID(UUID.randomUUID());
	}

	@Override
	/**
	 * visitable function
	 * @param rc the registration card used for the ride
	 * @return the cost of the ride
	 */
	public double accept(RegistrationCard rc) {
		return rc.visit(this);
	}
	
	@Override
	/**
	 * getter for ID
	 * @return the id of the bicycle
	 */
	public UUID getID() {
		return ID;
	}
	
	@Override
	/**
	 * setter for ID
	 * @param iD the new id
	 */
	public void setID(UUID iD) {
		ID = iD;
	}
	
	@Override
	/**
	 * getter for currentRideTime
	 * @return the time of the current ride
	 */
	public int getCurrentRideTime() {
		return currentRideTime;
	}
	
	@Override
	/**
	 * setter for currentRideTime
	 * @param currentRideTime the time of the ride
	 */
	public void setCurrentRideTime(int currentRideTime) {
		this.currentRideTime = currentRideTime;
	}
	
	@Override
	/**
	 * getter for histories
	 * @return the history of the bicycle
	 */
	public ArrayList<History> getHistories() {
		return histories;
	}
	
	@Override
	/**
	 * setter for histories
	 * @param histories the new history
	 */
	public void setHistories(ArrayList<History> histories) {
		this.histories = histories;
	}
	
	@Override
	/**
	 * add a history to the list of histories
	 * @param h the history to add
	 */
	public void addHistory(History h) {
		this.histories.add(h);
	}
}

