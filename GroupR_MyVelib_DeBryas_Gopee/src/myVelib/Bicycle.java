package myVelib;

import java.util.ArrayList;
import java.util.UUID;

/**
 * There exist several types of bicycle, and their cost can vary
 * It is the visitable in the visitor pattern
 * @author Quentin
 *
 */
public abstract class Bicycle {
	/**
	 * visitable function
	 * @param rc the registration card used for the ride (visitor)
	 * @return the cost of the ride
	 */
	public abstract double accept(RegistrationCard rc);
	
	/**
	 * getter for ID
	 * @return the id of the bicycle
	 */
	public abstract UUID getID();
	
	/**
	 * setter for ID
	 * @param iD the new id
	 */
	public abstract void setID(UUID iD);
	
	/**
	 * getter for currentRideTime
	 * @return the time of the current ride
	 */
	public abstract int getCurrentRideTime();
	
	/**
	 * setter for currentRideTime
	 * @param currentRideTime the time of the ride
	 */
	public abstract void setCurrentRideTime(int currentRideTime);
	
	/**
	 * getter for histories
	 * @return the history of the bicycle
	 */
	public abstract ArrayList<History> getHistories();
	
	/**
	 * setter for histories
	 * @param histories the new history
	 */
	public abstract void setHistories(ArrayList<History> histories);
	
	/**
	 * add a history to the list of histories
	 * @param h the history to add
	 */
	public abstract void addHistory(History h);
}