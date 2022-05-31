package myVelib;

/**
 * Class to count the number of rents and drops
 * @author Quentin
 *
 */
public class Counter {
	
	/**
	 * Count the number of renting operations of a parking slot
	 * @param ps the parking slot
	 * @return the count of renting operations
	 */
	public int countRentingPs(ParkingSlot ps) {
		int count = 0;
		boolean ReservedBicycle = false;
		
		for (ParkingSlotHistory h: ps.getParkingSlotHistories()) {
			if (h.getState() == ParkingSlotState.ReservedBicycle) {
				ReservedBicycle = true;
			} else if (h.getState() == ParkingSlotState.FreeToUse && ReservedBicycle) { // A new rent is characterized by a ReservedBicycle followed by a FreeToUse
				count += 1; // Each time the parking slot is free to use means  bike have been rent
				ReservedBicycle = false;
			} else {
				ReservedBicycle = false;
			}
		}
		
		if (ps.getState() == ParkingSlotState.FreeToUse && ReservedBicycle)
			count += 1; // The last rent isn't in the histories yet
		
		return count;	
	}
	
	/**
	 * Count the number of renting operations of a station
	 * @param s the station
	 * @return the count of renting operations
	 */
	public int countRentingStation(Station s) {
		int count = 0;
		
		for (ParkingSlot ps: s.getParkingSlots()) {
			count += countRentingPs(ps);
		}
		
		return count;
	}
	
	/**
	 * Count the number of dropping operations of a parking slot
	 * @param ps the parking slot
	 * @return the count of dropping operations
	 */
	public int countDroppingPs(ParkingSlot ps) {
		int count = 0;
		boolean OutOfOrder = false;
		
		for (ParkingSlotHistory h: ps.getParkingSlotHistories()) {
			if (h.getState() == ParkingSlotState.OutOfOrder) {
				OutOfOrder = true;
			} else if (h.getState() == ParkingSlotState.Bicycle && OutOfOrder) { // A new drop is characterized by a OutOfOrder followed by a Bicycle
				count += 1; // Each time the parking slot has a bicycle means a bike have been dropped
				OutOfOrder = false;
			} else {
				OutOfOrder = false;
			}
		}
		
		if (ps.getState() == ParkingSlotState.Bicycle && OutOfOrder)
			count += 1; // The last drop isn't in the histories yet
		
		return count;
	}
	
	/**
	 * Count the number of dropping operations of a station
	 * @param s the station
	 * @return the count of dropping operations
	 */
	public int countDroppingStation(Station s) {
		int count = 0;
		
		for (ParkingSlot ps: s.getParkingSlots()) {
			count += countDroppingPs(ps);
		}
		
		return count;
	}
	
}
