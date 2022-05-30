package myVelib;

/**
 * There exist several types of card, each one has a different cost policy.
 * It is the visitor in the visitor pattern
 * @author Quentin
 *
 */
public interface RegistrationCard {
	/**
	 * visitor function
	 * @param mb mechanical bicycle used for the ride
	 * @return the cost of the ride
	 */
	public double visit(MechanicalBicycle mb);
	
	/**
	 * visitor function
	 * @param mb electrical bicycle used for the ride
	 * @return the cost of the ride
	 */
	public double visit(ElectricalBicycle eb);
	
	/**
	 * add 5 minutes to time balance
	 */
	public void stationPlus();
}
