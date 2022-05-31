package myVelib;
import java.util.*;

/**
 * ParkingSlot is a Class that represents every parking slot of all stations
 * @author jehandebryas
 *
 */

public class ParkingSlot {
	
	/**
	 * elements of the ParkingSlot Class
	 */
	private Station station;
	private UUID ID;
	private ParkingSlotState state;
	private ArrayList<ParkingSlotHistory> parkingSlotHistories;
	private Bicycle bicycle;
	private Date lastChangeDate;
	
	
	/**
	 * initializer of the ParkingSlotclass in state FreeToUse
	 * @param station
	 * @param creationDate
	 */
	public ParkingSlot(Station station, Date creationDate) {
		this.station = station;
		this.ID = UUID.randomUUID();
		this.state = ParkingSlotState.FreeToUse;
		this.parkingSlotHistories = new ArrayList<ParkingSlotHistory>();
		this.bicycle = null;
		this.lastChangeDate = creationDate;
	}
	
	/**
	 * initializer of the ParkingSlotclass with a bicycle
	 * @param station
	 * @param bicycle
	 * @param creationDate
	 */
	public ParkingSlot(Station station, Bicycle bicycle, Date creationDate) {	
		this.station = station;
		this.ID = UUID.randomUUID();
		this.state = ParkingSlotState.Bicycle;
		this.bicycle = bicycle;
		this.lastChangeDate = creationDate;
	}
	
	/**
	 * getter & setters
	 * @return
	 */
	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public UUID getID() {
		return ID;
	}

	public void setID(UUID iD) {
		ID = iD;
	}

	public ParkingSlotState getState() {
		return state;
	}

	public void setState(ParkingSlotState state) {
		this.state = state;
	}

	public ArrayList<ParkingSlotHistory> getParkingSlotHistories() {
		return parkingSlotHistories;
	}

	public void setParkingSlotHistories(ArrayList<ParkingSlotHistory> parkingSlotHistories) {
		this.parkingSlotHistories = parkingSlotHistories;
	}

	public Bicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	public Date getLastChangeDate() {
		return lastChangeDate;
	}

	public void setLastChangeDate(Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}
	
	public void addParkingSlotHistory(ParkingSlotHistory pSH) {
		this.parkingSlotHistories.add(pSH);
	}
	
	
	/**
	 * function for renting a bike on this station
	 * return truye if all happenned well.
	 * return false if not.
	 * @param user
	 * @param parkingSlot
	 * @param newDate is the date at which the bike is rent
	 */
	public void rentaBike(User user, Date newDate) throws Exception {
		
		//check that parking slot is on this station, and available
		
		if(this.getBicycle() == null) {
			throw new Exception("no bicycle in the parking slot");
		}
	
		//the bike is taken in the parkingslot 
		this.addParkingSlotHistory(new ParkingSlotHistory(this.getState(), this, this.getBicycle(), this.getLastChangeDate(), newDate));
		this.setBicycle(null);
		this.setState(ParkingSlotState.FreeToUse);
		this.setLastChangeDate(newDate);
	}
	
	/**
	 * function for returning a bike in this station 
	 * return true or false if happened well or not 
	 * @param user
	 * @param parkingSlot
	 * @param newDate
	 * @return
	 */
	public void returnaBike(User user, Date newDate) throws Exception {
		
			if(this.getBicycle() != null) {
				throw new Exception("There is already a bicycle in the parking slot");
			}
				
			//the bike is returned in the parking slot 
			this.addParkingSlotHistory(new ParkingSlotHistory(this.getState(), this, this.getBicycle(), this.getLastChangeDate(), newDate));
			this.setBicycle(user.getCurrentRide().getBicycle());
			this.setState(ParkingSlotState.Bicycle);
			this.setLastChangeDate(newDate);
	}

	/**
	 * function for reserve a parking slot for your bike in this station 
	 * return true or false if happened well or not 
	 * @param user
	 * @param parkingSlot
	 * @param newDate
	 * @return
	 */
	public boolean reserveaParkingSlot(User user, Date newDate) {
		
		boolean done = false;
		
			if(this.getBicycle() == null) {
				//the free parking slot is reserved 
				this.addParkingSlotHistory(new ParkingSlotHistory(this.getState(), this, this.getBicycle(), this.getLastChangeDate(), newDate));
				this.setState(ParkingSlotState.OutOfOrder);
				this.setLastChangeDate(newDate);
				done=true;
			}
		return done;
	}
}
	
