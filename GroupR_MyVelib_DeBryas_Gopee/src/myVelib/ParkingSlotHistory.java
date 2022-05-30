package myVelib;

/**
 * class for an history of a parking slot
 * @author jehandebryas
 *
 */

public class ParkingSlotHistory extends History {
	
	private ParkingSlotState state;
	private ParkingSlot parkingSlot;
	private Bicycle bicycle;
	
	/**
	 * initializer
	 * @param state
	 * @param parkingSlot
	 * @param bicycle
	 */
	public ParkingSlotHistory(ParkingSlotState state, ParkingSlot parkingSlot, Bicycle bicycle) {
		super();
		this.state = state;
		this.parkingSlot = parkingSlot;
		this.bicycle = bicycle;
	}

	/**
	 * getters & setters
	 */
	
	public ParkingSlotState getState() {
		return state;
	}

	public void setState(ParkingSlotState state) {
		this.state = state;
	}

	public ParkingSlot getParkingSlot() {
		return parkingSlot;
	}

	public void setParkingSlot(ParkingSlot parkingSlot) {
		this.parkingSlot = parkingSlot;
	}

	public Bicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}
	
	
	
	
	

}
