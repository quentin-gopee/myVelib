package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.Test;

class PlanTest {

	@Test
	void testClassicPlan() {
		
		//crée un plan avec un objet myVelib dedans
		MyVelib mV = new MyVelib();
		mV.createMyVelib();
		Plan plan = new Plan(mV);
		
		//prend la liste des utilisateurs de cet objet
		ArrayList<User> users = new ArrayList<User>(plan.getMyVelib().getUsers().values());
		
		//prend un utilisateur et prend ses coordonées
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
			assertTrue(start.distance(plan.getStartParkingSlot().getStation().getLocation()) <= start.distance(s.getLocation()) );
		}
		
		
		//check that the endingStation is the nearest from the ending point
		for(Station s : stations) {
			assertTrue(end.distance(plan.getEndParkingSlot().getStation().getLocation()) <= end.distance(s.getLocation()) );
		}
		
		
	}	
	
	@Test
	void iftheNearestStationIsFullgoToAnOtherOne() {
		
		//crée un plan avec un objet myVelib dedans
				MyVelib mV = new MyVelib();
				mV.createMyVelib();
				Plan plan = new Plan(mV);
				
				
	}
	

}
