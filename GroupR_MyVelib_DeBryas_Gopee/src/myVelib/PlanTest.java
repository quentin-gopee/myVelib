package myVelib;
/**
 * test for the plan class
 */

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.Test;

class PlanTest {

	/**
	 * test that the startStation is the closest available station of the starting point.
	 * same for the endStation for the ending point.
	 */
	@Test
	void testifstationsaretheclosestforendandstartpoints() {
		
		//crée un plan avec un objet myVelib dedans
		MyVelib mV = new MyVelib();
		mV.createMyVelib();
		Plan plan = new Plan(mV);
		
		//prend la liste des utilisateurs de cet objet
		ArrayList<User> users = new ArrayList<User>(plan.getMyVelib().getUsers().values());
		
		//get the coordinates of a random user 
		Location start = users.get(new Random().nextInt(49)).getLocation();
		Location end = new Location(plan.getMyVelib().getSide());
		BicycleType bT = BicycleType.Electrical;
		if(new Random().nextDouble()<0.5)bT=BicycleType.Mechanical;
		
		try {
			plan.ClassicPlan(start, end, bT);
		} catch (Exception e) {
			System.out.println("function doesn't work");
			e.printStackTrace();
		}
		
		ArrayList<Station> stations = new ArrayList<Station>(plan.getMyVelib().getStations().values());
		
		
		//check that the starting station is the nearest from the depart point
		for(Station s : stations) {
			for(ParkingSlot pS : s.getParkingSlots()) {
				if(pS.getState()==ParkingSlotState.Bicycle)assertTrue(start.distance(plan.getStartParkingSlot().getStation().getLocation()) <= start.distance(s.getLocation()) );
			}
		}
		
		
		//check that the endingStation is the nearest from the ending point
		for(Station s : stations) {
			for(ParkingSlot pS : s.getParkingSlots()) {
				if(pS.getState()==ParkingSlotState.FreeToUse ||pS.getState()==ParkingSlotState.OutOfOrder) {
					assertTrue(end.distance(plan.getEndParkingSlot().getStation().getLocation()) <= end.distance(s.getLocation()));
				}
			}
			
		}
		
		
	}	
	
	/**
	 * test if the nearest station is not available it goes to the second nearest one
	 */
	@Test
	void testiftheNearestStationIsFullgoToAnOtherOne() {
		
		//crée un plan avec un objet myVelib dedans
				MyVelib mV = new MyVelib();
				mV.createMyVelib();
				Station s = new Station();
				s.setLocation(new Location(mV.getSide()));
				mV.addStation(s);
				Plan plan = new Plan(mV);
				
				ArrayList<User> users = new ArrayList<User>(plan.getMyVelib().getUsers().values());
				
				Location start = users.get(new Random().nextInt(49)).getLocation();
				Location end = s.getLocation();
				
				BicycleType bT = BicycleType.Electrical;
				if(new Random().nextDouble()<0.5)bT=BicycleType.Mechanical;
				
				try {
					plan.ClassicPlan(start, end, bT);
				} catch (Exception e) {
					System.out.println("function doesn't work");
					e.printStackTrace();
				}
				
				assertTrue(plan.getEndParkingSlot().getStation()!=s);

				

				
	}
	
	/**
	 * test if the location entered is out of the map, it doesn't compute anything
	 */
	@Test
	void testifenteralocationoutofthemap() {
		MyVelib mV = new MyVelib();
		mV.createMyVelib();
		
		Plan plan = new Plan(mV);
		
		try {
			plan.ClassicPlan(new Location(1000.0,1000.0), new Location(0.0,0.0), BicycleType.Electrical);
			assertFalse(true);
		} catch (Exception e) {
			assertFalse(false);
			e.printStackTrace();
		}
		
	}

}
