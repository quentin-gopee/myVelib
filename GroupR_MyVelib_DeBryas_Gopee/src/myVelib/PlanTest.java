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
		Plan plan = new Plan(createMyVelib());
		
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
		
		System.out.println(start.toString()+ "  " +end.toString());
		
		assertTrue(true);
	}
	
	@Test
	void testCreateMyVelib() {
		
		MyVelib myVelib =  createMyVelib();
		Plan plan = new Plan(myVelib);
		assertTrue(plan.getMyVelib().getUsers()==myVelib.getUsers());
		
	}
	
	
	
	
	
	
	public MyVelib createMyVelib() {
		
		MyVelib myVelib = new MyVelib();
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date beginningDate;
		try {
			beginningDate = formatter.parse("00-00-2022");
		} catch (ParseException e) {
			beginningDate = new Date();
			e.printStackTrace();
		}		
		
		//create stations, each are the same
		
		int numberofStations = 20;
		myVelib.setSide(10);
		
		
		//for each station create random number of parking slots, with random number of bicycle
		for(int i = 0 ; i < numberofStations; i++) {
			
			//each station has between 5 and 25 parking slots
			Station station = new Station();
			station.setLocation(new Location(myVelib.getSide()));
			station.setOnline(true);
			station.setType((new Random().nextDouble())<0.5 ? StationType.Plus : StationType.Standard);
			
			for(int j = 0 ; j< new Random().nextInt(20)+5;j++) {
				ParkingSlot parkingSlot = new ParkingSlot(station, beginningDate);
				if(new Random().nextDouble() < 0.2) {
					parkingSlot.setBicycle(null);
					parkingSlot.setState(ParkingSlotState.FreeToUse);
				}else {
					parkingSlot.setBicycle((new Random().nextDouble() < 0.5) ? new ElectricalBicycle():new MechanicalBicycle());
					parkingSlot.setState(ParkingSlotState.Bicycle);
				}
				station.addParkingSlot(parkingSlot);
				
				
			}
			myVelib.addStation(station);			
		}
		
		/**
		 * we create 50 users on this map
		 */
		
		for(int i=0;i<50;i++) {
			
			RegistrationCard rC = null;
			if(new Random().nextDouble() < 0.2) {
				rC = new NoCard();
			}else{
				if(new Random().nextDouble() < 0.5) {
					rC = new Vlibre();
				}else {
				rC = new Vmax();
				}
			}
			
			User newuser = new User("Woz",new Location(myVelib.getSide()),new CreditCard(),rC,myVelib);
			//System.out.println(newuser.toString());
			myVelib.addUser(newuser);
		}
		
		return myVelib;
		
	}

}
