package myVelib;

/**
 * Class for the users who don't have any card
 * @author Quentin
 *
 */
public class NoCard implements RegistrationCard{
	
	public NoCard() {}
	
	@Override
	/**
	 * visitor function
	 * @param mb mechanical bicycle used for the ride
	 * @return the cost of the ride (1€ per hour)
	 */
	public double visit(MechanicalBicycle mb) {
		return (double) mb.getCurrentRideTime()/60;
	}

	@Override
	/**
	 * visitor function
	 * @param mb electrical bicycle used for the ride
	 * @return the cost of the ride (2€ per hour)
	 */
	public double visit(ElectricalBicycle eb) {
		return (double) 2*eb.getCurrentRideTime()/60;
	}

	@Override
	/**
	 * useless for this class
	 */
	public void stationPlus() {};
	
}
