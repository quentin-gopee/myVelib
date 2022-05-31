package myVelib;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.math.*;


/**
 * All statistics about the Stations
 * @author jehandebryas
 *
 */
public class StationStatistics extends Statistics{

	/**
	 * Constructor
	 * @param myVelib
	 */
	public StationStatistics(MyVelib myVelib){
		super(myVelib);
	}
	
	public int totalNumberofRentOperations(Station station) {
		int totalNumberofRentOperation = 0;
		for(ParkingSlot pS : station.getParkingSlots()) {
			for(int i=1 ; i<pS.getParkingSlotHistories().size();i++) {
				if(pS.getParkingSlotHistories().get(i).getState()==ParkingSlotState.FreeToUse && pS.getParkingSlotHistories().get(i-1).getState()==ParkingSlotState.Bicycle){
					totalNumberofRentOperation++;
				}
			}
		}
		return totalNumberofRentOperation;
	}

	public int totalNumberofReturneOperations(Station station) {
		int totalNumberofReturneOperations = 0;
		for(ParkingSlot pS : station.getParkingSlots()) {
			for(int i=1 ; i<pS.getParkingSlotHistories().size();i++) {
				if(pS.getParkingSlotHistories().get(i).getState()==ParkingSlotState.Bicycle && (pS.getParkingSlotHistories().get(i-1).getState()==ParkingSlotState.OutOfOrder || pS.getParkingSlotHistories().get(i-1).getState()==ParkingSlotState.FreeToUse)){
					totalNumberofReturneOperations++;
				}
			}
		}
		return totalNumberofReturneOperations;
	}
	
	/**
	 * average rate of occupation of a station over a certain time window
	 * @return
	 */
	public double avergareRateofOccupation(Station station, Date ts, Date te) {
		
		double avergareRateofOccupation = 0;

		int Width = (int) (te.getTime()-ts.getTime())/(1000*60);
		int NumberofParkingSlots = station.getParkingSlots().size();
		double SumofTimes = 0;
				
		for(ParkingSlot pS : station.getParkingSlots()) {
			for(ParkingSlotHistory pSH : pS.getParkingSlotHistories()) {
				if((pSH.getState()==ParkingSlotState.Bicycle) || (ParkingSlotState.OutOfOrder==pSH.getState())) {
					double start = pSH.getStartingTime().getTime();
					double end = pSH.getEndingTime().getTime();
					SumofTimes += Math.min(te.getTime(),end)-Math.max(start, ts.getTime());
				}
			}
		}
		
		avergareRateofOccupation = SumofTimes/(Width*NumberofParkingSlots);
		
		return avergareRateofOccupation;
	}

	/**
	 * return the most used station
	 * @return
	 */
	public ArrayList<Station> mostUsedStation() {
		
		ArrayList<Station> ListStation = new ArrayList<Station>(super.getMyVelib().getStations().values()); 	
		
		UsedStationComparator comparator = new UsedStationComparator();
		Collections.sort(ListStation, comparator);;
		return ListStation;
	}
	
	/**
	 * return the least occupied station
	 * @return
	 */
	public Station leastOccupiedStation() {
		
		return null;
	}
}
