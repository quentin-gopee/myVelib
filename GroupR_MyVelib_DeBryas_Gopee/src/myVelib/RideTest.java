package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

/**
 * Class to test Ride
 * @author Quentin
 *
 */

class RideTest {
	
	@Test
	void testRide() throws Exception {
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new Vlibre(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		
		assertTrue(u.getCurrentRide().getState() == RideState.Planned
				&& u.getCurrentRide().getPlan().getStartParkingSlot().getState() == ParkingSlotState.ReservedBicycle
				&& u.getCurrentRide().getPlan().getEndParkingSlot().getState() == ParkingSlotState.OutOfOrder);
	}

	@Test
	void testStartRide() throws Exception {
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new Vlibre(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		
		u.getCurrentRide().startRide(new Date(2022, 1, 1, 0, 10));
		
		assertTrue(u.getCurrentRide().getState() == RideState.Started
				&& u.getCurrentRide().getPlan().getStartParkingSlot().getState() == ParkingSlotState.FreeToUse);
	}
	
	@Test
	void testStartRideBeforePlanning() throws Exception {
		boolean exception = false;
		
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new Vlibre(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 10));
		
		try {u.getCurrentRide().startRide(new Date(2022, 1, 1, 0, 0));}
		catch (Exception e) {exception = true;}
		
		assertTrue(exception);
	}
	
	@Test
	void testStartRideAlreadyStarted() throws Exception {
		boolean exception = false;
		
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new Vlibre(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		
		u.getCurrentRide().startRide(new Date(2022, 1, 1, 0, 10));
		
		try {
			u.getCurrentRide().startRide(new Date(2022, 1, 1, 0, 20));
		} catch (Exception e){
			exception = true;
		}
		
		assertTrue(exception);
	}

	@Test
	void testEndRide() throws Exception {
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new NoCard(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		
		u.getCurrentRide().startRide(new Date(2022, 1, 1, 0, 10));
		u.getCurrentRide().endRide(new Date(2022, 1, 1, 0, 50));
		
		assertTrue(u.getCurrentRide().getState() == RideState.Ended
				&& u.getCurrentRide().getPlan().getEndParkingSlot().getState() == ParkingSlotState.Bicycle
				&& u.getCurrentRide().getCost() == (double) 40/60*2
				&& u.getRides().get(u.getRides().size()-1) == u.getCurrentRide()
				&& u.getCurrentRide().getBicycle().getHistories().get(u.getCurrentRide().getBicycle().getHistories().size()-1) == u.getCurrentRide());
	}
	
	@Test
	void testEndRideBeforeStart() throws Exception {
		boolean exception = false;
		
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new NoCard(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		
		u.getCurrentRide().startRide(new Date(2022, 1, 1, 0, 10));
		
		try {u.getCurrentRide().endRide(new Date(2022, 1, 1, 0, 0));}
		catch (Exception e) {exception = true;}
		
		assertTrue(exception);
	}
	
	@Test
	void testEndRideNotStarted() throws Exception {
		boolean exception = false;
		
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new NoCard(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		
		try {
			u.getCurrentRide().endRide(new Date(2022, 1, 1, 0, 50));
		} catch(Exception e) {
			exception = true;
		}
		
		assertTrue(exception);
	}
	
	@Test
	void testEndRideAlreadyEnded() throws Exception {
		boolean exception = false;
		
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new NoCard(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		
		u.getCurrentRide().startRide(new Date(2022, 1, 1, 0, 10));
		u.getCurrentRide().endRide(new Date(2022, 1, 1, 0, 50));
		
		try {
			u.getCurrentRide().endRide(new Date(2022, 1, 1, 0, 50));
		} catch(Exception e) {
			exception = true;
		}
		
		assertTrue(exception);
	}

}
