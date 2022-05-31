package myVelib;
import java.util.*;

/**
 * Class for representing a user
 * @author jehandebryas
 *
 */

public class User {
	UUID ID;
	String name;
	Location location;
	CreditCard creditCard;
	RegistrationCard registrationCard;
	ArrayList<Ride> rides;
	double totalCharges;
	Ride currentRide;
	
	/**
	 * initializer
	 * @param ID
	 * @param name
	 * @param location
	 * @param creditCard
	 * @param registrationCard
	 */
	public User(UUID ID, String name, Location location, CreditCard creditCard, RegistrationCard registrationCard) {
		this.ID = ID;
		this.name = name;
		this.location = location;
		this.creditCard = creditCard;
		this.registrationCard = registrationCard;
		this.rides = new ArrayList<Ride>();
		this.totalCharges = 0;
		this.currentRide = null;
	}

	
	/**
	 * getters & setters
	 * @return
	 */
	public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public RegistrationCard getRegistrationCard() {
		return registrationCard;
	}

	public void setRegistrationCard(RegistrationCard registrationCard) {
		this.registrationCard = registrationCard;
	}

	public ArrayList<Ride> getRides() {
		return rides;
	}

	public void setRides(ArrayList<Ride> rides) {
		this.rides = rides;
	}
	
	public double getTotalCharges() {
		return totalCharges;
	}

	public void setTotalCharges(double totalCharges) {
		this.totalCharges = totalCharges;
	}

	public Ride getCurrentRide() {
		return currentRide;
	}

	public void setCurrentRide(Ride currentRide) {
		this.currentRide = currentRide;
	}

	/**
	 * add a ride to rides history
	 * @param ride
	 */
	public void addRide(Ride ride) {
		this.rides.add(ride);
	}
}
