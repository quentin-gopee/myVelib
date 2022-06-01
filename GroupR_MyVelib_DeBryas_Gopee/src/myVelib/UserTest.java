package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

/**
 * Class to test User
 * @author Quentin
 *
 */
class UserTest {

	@Test
	void testPlanClassicRide() throws Exception {
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
		
		u.startRide(new Date(2022, 1, 1, 0, 10));
		
		assertTrue(u.getCurrentRide().getState() == RideState.Started
				&& u.getCurrentRide().getPlan().getStartParkingSlot().getState() == ParkingSlotState.FreeToUse);
	}

	@Test
	void testEndRide() throws Exception {
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new NoCard(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		
		u.startRide(new Date(2022, 1, 1, 0, 10));
		u.endRide(new Date(2022, 1, 1, 0, 50));
		
		assertTrue(u.getRides().get(u.getRides().size()-1).getState() == RideState.Ended
				&& u.getRides().get(u.getRides().size()-1).getPlan().getEndParkingSlot().getState() == ParkingSlotState.Bicycle
				&& u.getRides().get(u.getRides().size()-1).getCost() == (double) 40/60*2
				&& u.getCurrentRide() == null);
	}

	@Test
	void testCancelRide() throws Exception {
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new NoCard(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		
		ParkingSlot start = u.getCurrentRide().getPlan().getStartParkingSlot();
		ParkingSlot end = u.getCurrentRide().getPlan().getEndParkingSlot();
		
		u.cancelRide();
		
		assertTrue(u.getCurrentRide() == null
				&& start.getState() == ParkingSlotState.Bicycle
				&& end.getState() == ParkingSlotState.FreeToUse);
	}
	
	@Test
	void testCancelRideAlreadyStarted() throws Exception {
		boolean exception = false;
		
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new NoCard(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		u.startRide(new Date(2022, 1, 1, 0, 10));
		
		try {u.cancelRide();}
		catch (Exception e) {exception = true;}
		
		assertTrue(exception);
	}
	
	@Test
	void testCancelNoRide() throws Exception {
		boolean exception = false;
		
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new NoCard(), myVelib);
		myVelib.addUser(u);
		
		try {u.cancelRide();}
		catch (Exception e) {exception = true;}
		
		assertTrue(exception);
	}

}
