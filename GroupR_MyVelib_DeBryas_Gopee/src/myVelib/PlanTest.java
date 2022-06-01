package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class PlanTest {

	@Test
	void testClassicPlan() {
		
		Plan plan = new Plan(createMyVelib());
		Collection<User> users = plan.getMyVelib().getUsers().values();
		ArrayList<User> userS =  (ArrayList<User>)users;
		Location start = userS.get(new Random().nextInt(50)).getLocation();
		Location end = new Location(plan.getMyVelib().getSide());
		BicycleType bT = BicycleType.Electrical;
		Plan.ClassicPlan(start, end, bT);
		
		
		fail("Not yet implemented");
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
		/**
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
		**/
		
		int numberofStations = 20;
		myVelib.setSide(10);
		
		Map<UUID,Station> stations =  new HashMap<UUID,Station>();
		
		//for each station create random number of parking slots, with random number of bicycle
		for(int i = 0 ; i < numberofStations; i++) {
			//each station has between 5 and 25 parking slots
			Station station = new Station();
			station.setLocation(new Location(myVelib.getSide()));
			station.setOnline(true);
			station.setType((new Random().nextDouble())<0.5 ? StationType.Plus : StationType.Standard);
			
			for(int j = 0 ; j< new Random().nextInt(25-5+1)-5;j++) {
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
			stations.put(station.getID(),station);
			
		}
		
		/**
		 * we create 50 users on this map
		 */
		
		
		for(int i=0;i<50;i++) {
			RegistrationCard rC = null;
			if(new Random().nextDouble() < 0.2) {
				rC = new NoCard();
			}else if(new Random().nextDouble() < 0.5) {
				rC = new Vlibre();
			}else {
				rC = new Vmax();
			}
			User newuser = new User("Woz",new Location(myVelib.getSide()),new CreditCard(),rC,myVelib);
			myVelib.addUser(newuser);
		}
		
		return myVelib;
		
	}

}
