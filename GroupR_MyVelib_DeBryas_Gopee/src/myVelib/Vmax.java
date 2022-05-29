package myVelib;
import java.util.*;

/**
 * Vmax registration card
 * @author Quentin
 *
 */
public class Vmax extends RegistrationCard{
	
	/**
	 * Unique ID
	 */
	private UUID ID;
	
	/**
	 * time balance of the card (free time)
	 * initialization at 0
	 */
	private int timeBalance=0;
	
	/**
	 * creates a Vmax card
	 * @param ID id of the card
	 */
	public Vmax(UUID ID) {
		this.ID = ID;
	}
	
	@Override
	/**
	 * visitor function
	 * @param mb mechanical bicycle used for the ride
	 * @return the cost of the ride (0€ for the 1st hour then 1€ per hour)
	 */
	double visit(MechanicalBicycle mb) {
		if (mb.getCurrentRideTime()>60) {
			if (this.timeBalance > mb.getCurrentRideTime()-60) {this.timeBalance -= mb.getCurrentRideTime();}
			else {
				this.timeBalance = 0;
				return (mb.getCurrentRideTime()-60-this.timeBalance)/60;
			}
		}
		return 0;
	}

	@Override
	/**
	 * visitor function
	 * @param mb electrical bicycle used for the ride
	 * @return the cost of the ride (0€ for the 1st hour then 1€ per hour)
	 */
	double visit(ElectricalBicycle eb) {
		if (eb.getCurrentRideTime()>60) {
			if (this.timeBalance > eb.getCurrentRideTime()-60) {this.timeBalance -= eb.getCurrentRideTime();}
			else {
				this.timeBalance = 0;
				return (eb.getCurrentRideTime()-60-this.timeBalance)/60;
			}
		}
		return 0;
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
	
	@Override
	/**
	 * add 5 minutes to time balance
	 */
	public void stationPlus() {
		this.timeBalance += 5;
	}
	
}