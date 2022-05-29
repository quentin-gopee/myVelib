package myVelib;
import java.util.*;

public class User {
	UUID ID;
	String name;
	Location location;
	CreditCard creditCard;
	RegistrationCard registrationCard;
	ArrayList<Ride> rides;
	
	public User(UUID ID, String name, Location location, CreditCard creditCard, RegistrationCard registrationCard, ArrayList<Ride> rides) {
		this.ID = ID;
		this.name = name;
		this.location = location;
		this.creditCard = creditCard;
		this.registrationCard = registrationCard;
		this.rides = rides;
	}

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
}
