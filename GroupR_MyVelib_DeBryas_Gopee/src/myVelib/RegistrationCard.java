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
	abstract int visit(MechanicalBicycle mb);
	
	/**
	 * visitor function
	 * @param mb electrical bicycle used for the ride
	 * @return the cost of the ride
	 */
	abstract int visit(ElectricalBicycle eb);
}
