package myVelib;
import java.util.*;

/**
 * Class for representing a user
 * @author jehandebryas & Quentin
 *
 */

public class User {
	private UUID ID;
	private String name;
	private Location location;
	private CreditCard creditCard;
	private RegistrationCard registrationCard;
	private ArrayList<Ride> rides;
	private Ride currentRide;
	private MyVelib myVelib;
	
	
	/**
	 * initializer
	 * @param ID
	 * @param name
	 * @param location
	 * @param creditCard
	 * @param registrationCard
	 */
	public User(String name, Location location, CreditCard creditCard, RegistrationCard registrationCard, MyVelib myVelib) {
		this.ID = UUID.randomUUID();
		this.name = name;
		this.location = location;
		this.creditCard = creditCard;
		this.registrationCard = registrationCard;
		this.rides = new ArrayList<Ride>();
		this.currentRide = null;
		this.myVelib = myVelib;
	}
	
	public User(UUID ID, String name, Location location, CreditCard creditCard, RegistrationCard registrationCard, MyVelib myVelib) {
		this.ID = ID;
		this.name = name;
		this.location = location;
		this.creditCard = creditCard;
		this.registrationCard = registrationCard;
		this.rides = new ArrayList<Ride>();
		this.currentRide = null;
		this.myVelib = myVelib;
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

	public Ride getCurrentRide() {
		return currentRide;
	}

	public void setCurrentRide(Ride currentRide) {
		this.currentRide = currentRide;
	}
	
	public MyVelib getMyVelib() {
		return myVelib;
	}

	public void setMyVelib(MyVelib myVelib) {
		this.myVelib = myVelib;
	}

	/**
	 * Plan a new ride
	 * @param destination the destination of the ride
	 * @param btype the type of the bicycle the user wants for his ride
	 * @throws Exception when a ride is already planned (a user cannot order two bicycles)
	 */
	public void planClassicRide(Location destination, BicycleType btype, Date planningTime) throws Exception {
		if (currentRide != null)
			throw new Exception("A ride is already planned!");
			
		Plan plan = new Plan(myVelib);
		plan.ClassicPlan(this.location, destination, btype);
		currentRide = new Ride(plan, this, planningTime);
	}
	
	/**
	 * Start the ride when the user takes the bicycle
	 * @param startingTime the date of the start
	 * @throws Exception if the ride has already started
	 */
	public void startRide(Date startingTime) throws Exception {
		currentRide.startRide(startingTime);
		location = currentRide.getPlan().getStartParkingSlot().getStation().getLocation();
	}
	
	/**
	 * End the ride when the user returns the bicycle
	 * @param endingTime the date of the end
	 * @throws Exception if the ride is already finished or not started
	 */
	public void endRide(Date endingTime) throws Exception {
		currentRide.endRide(endingTime);
		location = currentRide.getPlan().getEndParkingSlot().getStation().getLocation();
		currentRide = null;
	}
	
	/**
	 * Cancel the current ride
	 */
	public void cancelRide() throws Exception {
		if (currentRide == null) {
			throw new Exception("No ride planned");
		}
		
		if (currentRide.getState() != RideState.Planned) {
			throw new Exception("Cannot cancel a ride that has already started");
		}
		
		currentRide.getPlan().getStartParkingSlot().setState(ParkingSlotState.Bicycle);
		currentRide.getPlan().getEndParkingSlot().setState(ParkingSlotState.FreeToUse);
		currentRide = null;
		
	}

	/**
	 * add a ride to rides history
	 * @param ride
	 */
	public void addRide(Ride ride) {
		this.rides.add(ride);
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", name=" + name + ", location=" + location + "]";
	}
}
