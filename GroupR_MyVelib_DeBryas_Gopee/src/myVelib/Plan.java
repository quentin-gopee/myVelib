package myVelib;
import java.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

/**
 * a class that regroups all methods to compute plan for each ride.
 * i.e. start and end parking slots, stations, etc. 
 * @author jehandebryas
 *
 */

public class Plan {
	private ParkingSlot startParkingSlot;
	private ParkingSlot endParkingSlot;
	private MyVelib myVelib;
	
	public Plan(MyVelib myVelib) {
		this.myVelib= myVelib;
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
	
	public void PlanifyClassic(Location start, Location end){
		
		/**
		 * cheking that location start and location end are valid
		 */
		if(start.getX()> myVelib.getSide()) {
			System.out.println("location out of the map !");
			return;
		}
		if(start.getY()> myVelib.getSide()) {
			System.out.println("location out of the map !");
			return;
		}
		if(end.getX()> myVelib.getSide()) {
			System.out.println("location out of the map !");
			return;
		}
		if(end.getY()> myVelib.getSide()) {
			System.out.println("location out of the map !");
			return;
		}
		if(start.getX()< 0) {
			System.out.println("location out of the map !");
			return;
		}
		if(start.getY()< 0) {
			System.out.println("location out of the map !");
			return;
		}
		if(end.getX()< 0) {
			System.out.println("location out of the map !");
			return;
		}
		if(end.getY()< 0) {
			System.out.println("location out of the map !");
			return;
		}
		
		// looking for a start parking slot & station
		
		//import stations
		Map<UUID,Station> stations = myVelib.getStations();
		//compare stations in term of distance from 
		//DistanceStationComparator comparator = new DistanceStationComparator(start); 
		
		// looking for end parking slot & station
	}
}
