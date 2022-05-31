package myVelib;
import java.util.*;

/**
 * Vlibre registration card
 * @author Quentin
 *
 */
public class Vlibre implements RegistrationCard{
	
	/**
	 * Unique ID
	 */
	private UUID ID;
	
	/**
	 * time balance of the card (free time)
	 * initialization at 0
	 */
	private int timeBalance=0;
	
	private int totalTimeCreditEarned;

	/**
	 * creates a Vlibre card
	 * @param ID id of the card
	 */
	public Vlibre() {
		this.ID = UUID.randomUUID();
	}
	
	@Override
	/**
	 * visitor function
	 * @param mb mechanical bicycle used for the ride
	 * @return the cost of the ride (0€ for the 1st hour then 1€ per hour)
	 */
	public double visit(MechanicalBicycle mb) {
		if (mb.getCurrentRideTime()>60) {
			if (this.timeBalance > mb.getCurrentRideTime()-60) {this.timeBalance -= mb.getCurrentRideTime();}
			else {
				int time = mb.getCurrentRideTime()-60-this.timeBalance;
				this.timeBalance = 0;
				return (double) time/60;
			}
		}
		return 0;
	}

	@Override
	/**
	 * visitor function
	 * @param mb electrical bicycle used for the ride
	 * @return the cost of the ride (1€ for the 1st hour then 2€ per hour)
	 */
	public double visit(ElectricalBicycle eb) {
		if (this.timeBalance > eb.getCurrentRideTime()) {
			this.timeBalance -= eb.getCurrentRideTime();
			return 0;
		} else {
			int time = eb.getCurrentRideTime() - this.timeBalance;
			this.timeBalance = 0;
			if (time>60)
				return (double) 2*(time-60)/60 + 1;
			return time/60;
		}
	}
	
	/**
	 * getter for UUID
	 * @return the id of the card
	 */
	public UUID getID() {
		return ID;
	}
	
	/**
	 * setter for ID
	 * @param iD
	 */
	public void setID(UUID iD) {
		ID = iD;
	}
	
	/**
	 * getter for timeBalance
	 * @return the time balance of the card
	 */
	public int getTimeBalance() {
		return timeBalance;
	}
	
	/**
	 * setter for timeBalance
	 * @param timeBalance
	 */
	public void setTimeBalance(int timeBalance) {
		this.timeBalance = timeBalance;
	}
	
	public int getTotalTimeCreditEarned() {
		return totalTimeCreditEarned;
	}

	public void setTotalTimeCreditEarned(int totalTimeCreditEarned) {
		this.totalTimeCreditEarned = totalTimeCreditEarned;
	}	
	
	@Override
	/**
	 * add 5 minutes to time balance
	 */
	public void stationPlus() {
		this.timeBalance += 5;
		this.totalTimeCreditEarned +=5;
	}
	
}