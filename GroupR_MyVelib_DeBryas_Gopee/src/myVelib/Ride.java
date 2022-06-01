package myVelib;
import java.util.*;

/**
 * Contains all the information about a ride
 * Client in the visitor pattern
 * @author Quentin
 *
 */
public class Ride extends History{
	
	/**
	 * Plan for the ride (contains start and end parking slots)
	 */
	private Plan plan;
	
	/**
	 * Cost of the ride
	 */
	private double cost;
	
	/**
	 * User of the ride
	 */
	private User user;
	
	/**
	 * Bicycle used in the ride
	 */
	private Bicycle bicycle;
	
	/**
	 * The state of the ride
	 */
	private RideState state;
	
	/**
	 * Creates a ride
	 * @param plan the plan of the ride
	 * @param user the user of the ride
	 * @param bicycle the bicycle used in the ride
	 */
	public Ride(Plan plan, User user, Date planningTime) throws Exception{
		super();
		this.plan = plan;
		this.user = user;
		this.bicycle = plan.getStartParkingSlot().getBicycle();
		this.state = RideState.Planned;
		plan.getStartParkingSlot().reserveBicycle(user, planningTime);
		plan.getEndParkingSlot().reserveParkingSlot(user, planningTime);
	}

	/**
	 * getter for plan
	 * @return plan
	 */
	public Plan getPlan() {
		return plan;
	}
	
	/**
	 * setter for plan
	 * @param plan the new plan
	 */
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	/**
	 * getter for cost
	 * @return cost
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * setter for cost
	 * @param cost the new cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * getter for user
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * setter for user
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * getter for bicycle
	 * @return bicycle
	 */
	public Bicycle getBicycle() {
		return bicycle;
	}

	/**
	 * setter for bicycle
	 * @param bicycle the new bicycle
	 */
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}
	
	public RideState getState() {
		return state;
	}

	public void setState(RideState state) {
		this.state = state;
	}

	/**
	 * Start the ride
	 * @param startingTime the date of the start
	 */
	public void startRide(Date startingTime) throws Exception{
		if (state != RideState.Planned) {
			throw new Exception("Ride already started!");
		}
		
		plan.getStartParkingSlot().rentBicycle(user, startingTime);
		
		super.setStartingTime(startingTime); // set the start of the ride
		state = RideState.Started;
	}
	
	/**
	 * function for ending a ride
	 * @param endingTime the date of the end
	 */
	public void endRide(Date endingTime) throws Exception {
		if (state == RideState.Planned) {
			throw new Exception("Ride not started!");
		} else if (state == RideState.Ended) {
			throw new Exception("Ride already finished!");
		}
		
		plan.getStartParkingSlot().returnBicycle(user, endingTime);
		
		super.setEndingTime(endingTime);
		
		// Calculate the time of the ride
		int time = (int) ((super.getEndingTime().getTime() - super.getStartingTime().getTime())/ (1000 * 60));
		bicycle.setCurrentRideTime(time);
		
		// If Station PLus, add free time
		if (this.plan.getEndParkingSlot().getStation().getType() == StationType.Plus)
			user.getRegistrationCard().stationPlus();
		
		// Compute the cost
		// I coudn't make a perfect visitor pattern because the bicycles are registered as Bicycle
		if (bicycle instanceof MechanicalBicycle) {
			this.cost = ((MechanicalBicycle) bicycle).accept(user.getRegistrationCard());
		} else if (bicycle instanceof ElectricalBicycle) {
			this.cost = ((ElectricalBicycle) bicycle).accept(user.getRegistrationCard());
		} else {
			throw new Exception("Bicycle type unknown");
		}
		
		// Debit the card
		user.getCreditCard().setBalance(user.getCreditCard().getBalance() - cost);
		
		// Add the ride to the histories
		bicycle.addHistory(this);
		user.addRide(this);	
	}
}
