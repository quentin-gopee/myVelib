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
public class StationStatistics{
	
	public int totalNumberofRentOperations(Station station) {
		Counter c = new Counter();
		return c.countRentingStation(station);
	}

	public int totalNumberofReturnOperations(Station station) {
		Counter c = new Counter();
		return c.countDroppingStation(station);
	}
	
	/**
	 * average rate of occupation of a station over a certain time window
	 * @return
	 */
	public double averageRateofOccupation(Station station, Date ts, Date te) {
		
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
	public ArrayList<Station> mostUsedStation(MyVelib myVelib) {
		
		ArrayList<Station> ListStation = new ArrayList<Station>(myVelib.getStations().values()); 	
		
		UsedStationComparator comparator = new UsedStationComparator();
		Collections.sort(ListStation, comparator);;
		return ListStation;
	}
	
	/**
	 * return the least occupied station
	 * @return
	 */
	public ArrayList<Station> leastOccupiedStation(MyVelib myVelib) {
		
		ArrayList<Station> ListStation = new ArrayList<Station>(myVelib.getStations().values()); 	
		
		OccupiedStationComparator comparator = new OccupiedStationComparator();
		Collections.sort(ListStation, comparator);;
		return ListStation;
	}
}
