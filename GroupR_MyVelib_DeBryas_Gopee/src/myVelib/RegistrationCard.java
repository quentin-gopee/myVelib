package myVelib;

/**
 * There exist several types of card, each one has a different cost policy.
 * It is the visitor in the visitor pattern
 * @author Quentin
 *
 */
public abstract class RegistrationCard {
	/**
	 * visitor function
	 * @param mb mechanical bicycle used for the ride
	 * @return the cost of the ride
	 */
	abstract double visit(MechanicalBicycle mb);
	
	/**
	 * visitor function
	 * @param mb electrical bicycle used for the ride
	 * @return the cost of the ride
	 */
	abstract double visit(ElectricalBicycle eb);
	
	/**
	 * add 5 minutes to time balance
	 */
	public abstract void stationPlus();
}
