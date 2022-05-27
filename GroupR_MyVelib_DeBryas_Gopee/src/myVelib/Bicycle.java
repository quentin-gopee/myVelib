package myVelib;

/**
 * There exist several types of bicycle, and their cost can vary
 * It is the visitable in the visitor pattern
 * @author Quentin
 *
 */
public abstract class Bicycle {
	/**
	 * visitable function
	 * @param rc the registration card used for the ride (visitor)
	 * @return the cost of the ride
	 */
	public abstract double accept(RegistrationCard rc);
}