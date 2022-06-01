package myVelib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

/**
 * a class that regroups all methods to compute plan for each ride.
 * i.e. start and end parking slots, stations, etc.
 *  
 * @author jehandebryas
 *
 */

public class Plan {
	private ParkingSlot startParkingSlot;
	private ParkingSlot endParkingSlot;
	private MyVelib myVelib;
	
	public Plan(MyVelib myVelib) {
		this.myVelib = myVelib;
		this.startParkingSlot=null;
		this.endParkingSlot=null;
	}

	public ParkingSlot getStartParkingSlot() {
		return startParkingSlot;
	}

	public void setStartParkingSlot(ParkingSlot startParkingSlot) {
		this.startParkingSlot = startParkingSlot;
	}

	public ParkingSlot getEndParkingSlot() {
		return endParkingSlot;
	}

	public void setEndParkingSlot(ParkingSlot endParkingSlot) {
		this.endParkingSlot = endParkingSlot;
	}

	public MyVelib getMyVelib() {
		return myVelib;
	}

	public void setMyVelib(MyVelib myVelib) {
		this.myVelib = myVelib;
	}

	public void ClassicPlan(Location start, Location end, BicycleType type) throws Exception {
				
		/**
		 * checking that location start and location end are valid
		 */
		if(start.getX()> myVelib.getSide()) {
			throw new Exception("location out of the map !");
		}
		if(start.getY()> myVelib.getSide()) {
			throw new Exception("location out of the map !");
		}
		if(end.getX()> myVelib.getSide()) {
			throw new Exception("location out of the map !");
		}
		if(end.getY()> myVelib.getSide()) {
			throw new Exception("location out of the map !");
		}
		if(start.getX()< 0) {
			throw new Exception("location out of the map !");
		}
		if(start.getY()< 0) {
			throw new Exception("location out of the map !");
		}
		if(end.getX()< 0) {
			throw new Exception("location out of the map !");
		}
		if(end.getY()< 0) {
			throw new Exception("location out of the map !");
		}
		
		/**
		 * looking for a start parking slot & station
		 */
		
		//import stations
		Map<UUID,Station> stationsMap = myVelib.getStations();
		ArrayList <Station> stationsList = new ArrayList<Station>(stationsMap.values());
		
		//compare stations in term of distance from starting point
		
		DistanceStationComparator comparator = new DistanceStationComparator(start); 
		Collections.sort(stationsList,comparator);
		
		
		labelStart:
		for(Station s : stationsList) {
			for(ParkingSlot pS : s.getParkingSlots()) {
				if(pS.getState()== ParkingSlotState.Bicycle && pS.getBicycle().getBicycleType() == type) {
					this.startParkingSlot = pS;
					break labelStart;
				}
			}
		}
		
		
		/**
		 * looking for end parking slot & station
		 */
		
		//compare stations in term of distance from ending point
		
		DistanceStationComparator comparator2 = new DistanceStationComparator(end); 
		Collections.sort(stationsList,comparator2);
		
		labelEnd:
		for(Station s : stationsList) {
			for(ParkingSlot pS : s.getParkingSlots()) {
				if(pS.getState()== ParkingSlotState.FreeToUse) {
					this.endParkingSlot = pS;
					break labelEnd;
				}
			}
		}
		
		//checking that it is interesting to really using this bike instead of walking
		
		double walkingDistance = start.distance(end);
		double bikeWalkingDistance = start.distance(startParkingSlot.getStation().getLocation()) + 
				end.distance(endParkingSlot.getStation().getLocation());
		
		if(walkingDistance <= bikeWalkingDistance) {
			System.out.println("it is not interesting to take a bike for the user");
		}if(startParkingSlot==null || endParkingSlot==null) {
			throw new Exception("no bike is available");
		}
		
		
	}
}
