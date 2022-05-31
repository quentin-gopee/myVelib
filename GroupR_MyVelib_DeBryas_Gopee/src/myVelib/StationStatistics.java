package myVelib;


/**
 * All statistics about the Stations
 * @author jehandebryas
 *
 */
public class StationStatistics extends Statistics{

	public StationStatistics(MyVelib myVelib){
		super(myVelib);
	}
	
	public int totalNumberofRentOperation(Station station) {
		int totalNumberofRentOperation = 0;
		for(ParkingSlot pS : station.getParkingSlots()) {
			for(ParkingSlotHistory pSH : pS.getParkingSlotHistories()) {
				if(pSH.getState() == ParkingSlotState.FreeToUse && pSH!=pS.getParkingSlotHistories().get(1)) {
					totalNumberofRentOperation++;
				}
			}
		}
		return totalNumberofRentOperation;
	}
	
	public double avergareRateofOccupation() {
		double avergareRateofOccupation=0;
		//code here
		return avergareRateofOccupation;
	}
	
	public Station mostUsedStation() {
		//code here
		return null;
	}
	
	public Station leastOccupiedStation() {
		//code here
		return null;
	}
}
