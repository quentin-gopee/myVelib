package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class ParkingSlotTest {

	@Test
	void testrentBicycle() {
		
		MyVelib mV = new MyVelib();
		User user = new User("John", new Location(0.0, 0.0), new CreditCard(), new Vlibre(), mV);
		Station s = new Station();
		ParkingSlot pS = new ParkingSlot(s, new Date());
		
		//for now it doesn't have any bicycle
		
		try {
			//if it allows to rent a bicycle:  error
			pS.rentBicycle(user, new Date());
			assertTrue(false);
		} catch (Exception e) {
			//if it dont allows to rent a bicycle:  good
			assertTrue(true);
			e.printStackTrace();
		}
		
		pS.setBicycle(new MechanicalBicycle());
		
		//now it has a bicycle
		
		
		try {
			//if it allows to rent a bicycle:  error
			pS.rentBicycle(user, new Date());
			assertTrue(true);
		} catch (Exception e) {
			//if it dont allows to rent a bicycle:  good
			assertTrue(false);
			e.printStackTrace();
		}
		
		//it doesn't have bicycle anymore
		assertTrue(pS.getBicycle()==null);
		assertTrue(pS.getState()==ParkingSlotState.FreeToUse);
		assertFalse(pS.getParkingSlotHistories().isEmpty());
	}

	@Test
	void testreturnBicycle() {
		MyVelib mV = new MyVelib();
		mV.createMyVelib();	
		
		
		Plan plan = new Plan(mV);
		try {
			plan.ClassicPlan(new Location(mV.getSide()), new Location(mV.getSide()), BicycleType.Mechanical);
		} catch (Exception e1) {
			System.out.println("hyperchelou l'erreur");	
			e1.printStackTrace();
		}

		
		User user = new User("John", new Location(0.0, 0.0), new CreditCard(), new Vlibre(), mV);
		Station s = new Station();
		ParkingSlot pS = new ParkingSlot(s, new Date());
		pS.setBicycle(new MechanicalBicycle());
		
		//the parkingslot is occupied by a bicycle
		
		//we give a bicycle to a user
		try {
			Ride r= new Ride(plan, user, new Date());
			r.setBicycle(new ElectricalBicycle());
			user.setCurrentRide(r);
		} catch (Exception e) {
			System.out.println("erreur pas reussi a créer un ride ligne 62");
			assertTrue(false);
			e.printStackTrace();
		}
		
		//we try to return a bicycle : it shouldn't work
		
		try {
			pS.returnBicycle(user, new Date());
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
			e.printStackTrace();
		}
		
		//we put the bicycle out of the parkingslot
		pS.setBicycle(null);
		
		//we try to return a bicycle : it should work
		
		try {
			pS.returnBicycle(user, new Date());
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
			e.printStackTrace();
		}
		
		assertTrue(pS.getState()==ParkingSlotState.Bicycle);
		assertTrue(pS.getBicycle() != null);
		assertFalse(pS.getParkingSlotHistories().isEmpty());
		
	
	}
	
	@Test
	void testreserveParkingSlot() {
		
		MyVelib mV = new MyVelib();
		
		User user = new User("John", new Location(0.0, 0.0), new CreditCard(), new Vlibre(), mV);
		Station s = new Station();
		ParkingSlot pS = new ParkingSlot(s, new Date());
		pS.setBicycle(new MechanicalBicycle());
		
		try {
			pS.reserveParkingSlot(user, new Date());
			assertTrue(pS.getState()==ParkingSlotState.OutOfOrder);
			assertTrue(false);
			} catch (Exception e) {
			assertTrue(true);
			e.printStackTrace();
		}
		
		pS.setBicycle(null);
		
		try {
			pS.reserveParkingSlot(user, new Date());
			assertTrue(pS.getState()==ParkingSlotState.OutOfOrder);
			assertTrue(true);
			} catch (Exception e) {
			assertTrue(false);
			e.printStackTrace();
		}
		
		
		
	}

	@Test
	void testreserveBicycle() {
		MyVelib mV = new MyVelib();
		
		User user = new User("John", new Location(0.0, 0.0), new CreditCard(), new Vlibre(), mV);
		Station s = new Station();
		ParkingSlot pS = new ParkingSlot(s, new Date());
		
		
		//no bicycle it shouldn't be possible to reserve a bicycle
		try {
			pS.reserveBicycle(user, new Date());
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
			e.printStackTrace();
		}
		
		
		//we add a bicycle in the parking slot
		pS.setBicycle(new ElectricalBicycle());
		
		
		//we check that it's possible to reserve it
		try {
			pS.reserveBicycle(user, new Date());
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
			e.printStackTrace();
		}
		
		assertTrue(pS.getBicycle()!=null);
		assertTrue(pS.getState()==ParkingSlotState.ReservedBicycle);
		assertFalse(pS.getParkingSlotHistories().isEmpty());
		
	}
}
