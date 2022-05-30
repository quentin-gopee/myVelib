package myVelib;

import java.util.ArrayList;
import java.util.UUID;

/**
 * There exist several types of bicycle, and their cost can vary
 * It is the visitable in the visitor pattern
 * @author Quentin
 *
 */
public interface Bicycle {
	/**
	 * visitable function
	 * @param rc the registration card used for the ride (visitor)
	 * @return the cost of the ride
	 */
	public double accept(RegistrationCard rc);
	
	/**
	 * getter for ID
	 * @return the id of the bicycle
	 */
	public UUID getID();
	
	/**
	 * setter for ID
	 * @param iD the new id
	 */
	public void setID(UUID iD);
	
	/**
	 * getter for the type of the bicycle
	 * @return
	 */
	public BicycleType getBicycleType();

	
	/**
	 * getter for currentRideTime
	 * @return the time of the current ride
	 */
	public int getCurrentRideTime();
	
	/**
	 * setter for currentRideTime
	 * @param currentRideTime the time of the ride
	 */
	public void setCurrentRideTime(int currentRideTime);
	
	/**
	 * getter for histories
	 * @return the history of the bicycle
	 */
	public ArrayList<History> getHistories();
	
	/**
	 * setter for histories
	 * @param histories the new history
	 */
	public void setHistories(ArrayList<History> histories);
	
	/**
	 * add a history to the list of histories
	 * @param h the history to add
	 */
	public void addHistory(History h);
		
}