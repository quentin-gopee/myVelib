package myVelib;

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
	 * time of the ride
	 */
	private int time;
	
	/**
	 * Creates a ride
	 * @param plan the plan of the ride
	 * @param user the user of the ride
	 * @param bicycle the bicycle used in the ride
	 */
	public Ride(Plan plan, User user, int time) {
		this.plan = plan;
		this.user = user;
		this.bicycle = plan.getStartParkingSlot().getBicycle();
		this.time = time;
	}
	
	/**
	 * getter for time
	 * @return time
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * setter for time
	 * @param time the new time
	 */
	public void setTime(int time) {
		this.time = time;
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
	
	public void endRide() {
		bicycle.setCurrentRideTime(time); //time of the ride
		if (this.plan.getEndParkingSlot().getStation().getType() == StationType.Plus)
			user.getRegistrationCard().stationPlus();
		if (bicycle instanceof MechanicalBicycle) {
			this.cost = ((MechanicalBicycle) bicycle).accept(user.getRegistrationCard());
		} else if (bicycle instanceof ElectricalBicycle) {
			this.cost = ((ElectricalBicycle) bicycle).accept(user.getRegistrationCard());
		}
		user.getCreditCard().setBalance(user.getCreditCard().getBalance() - cost);
	}
	
}
