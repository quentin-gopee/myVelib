package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * Class to test UserStatistics
 * @author Quentin
 *
 */
class UserStatisticsTest {

	@Test
	void testNumberOfRides() throws Exception {
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new NoCard(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		u.startRide(new Date(2022, 1, 1, 0, 10));
		u.endRide(new Date(2022, 1, 1, 0, 30));
		
		u.planClassicRide(new Location(10), BicycleType.Mechanical, new Date(2022, 1, 1, 1, 0));
		u.startRide(new Date(2022, 1, 1, 1, 10));
		u.endRide(new Date(2022, 1, 1, 2, 30));
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 2, 0));
		u.startRide(new Date(2022, 1, 1, 3, 10));
		u.endRide(new Date(2022, 1, 1, 3, 40));
		
		UserStatistics uS = new UserStatistics();

		assertTrue(uS.numberOfRides(u) == 3);
	}

	@Test
	void testTotalTimeSpentOnABike() throws Exception {
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new NoCard(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		u.startRide(new Date(2022, 1, 1, 0, 10));
		u.endRide(new Date(2022, 1, 1, 0, 30));
		
		u.planClassicRide(new Location(10), BicycleType.Mechanical, new Date(2022, 1, 1, 1, 0));
		u.startRide(new Date(2022, 1, 1, 1, 10));
		u.endRide(new Date(2022, 1, 1, 2, 30));
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 2, 0));
		u.startRide(new Date(2022, 1, 1, 3, 10));
		u.endRide(new Date(2022, 1, 1, 3, 40));
		
		UserStatistics uS = new UserStatistics();

		assertTrue(uS.totalTimeSpentOnABike(u) == 130);
	}

	@Test
	void testTotalAmmountofCharges() throws Exception {
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new NoCard(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		u.startRide(new Date(2022, 1, 1, 0, 10));
		u.endRide(new Date(2022, 1, 1, 0, 30));
		
		u.planClassicRide(new Location(10), BicycleType.Mechanical, new Date(2022, 1, 1, 1, 0));
		u.startRide(new Date(2022, 1, 1, 1, 10));
		u.endRide(new Date(2022, 1, 1, 2, 30));
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 2, 0));
		u.startRide(new Date(2022, 1, 1, 3, 10));
		u.endRide(new Date(2022, 1, 1, 3, 40));
		
		UserStatistics uS = new UserStatistics();

		assertTrue(uS.totalAmmountofCharges(u) == (double) 50/60*2 + (double) 80/60);
	}

	@Test
	void testTimeCreditEarnedNoCard() throws Exception {
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new NoCard(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		u.startRide(new Date(2022, 1, 1, 0, 10));
		u.endRide(new Date(2022, 1, 1, 0, 30));
		
		u.planClassicRide(new Location(10), BicycleType.Mechanical, new Date(2022, 1, 1, 1, 0));
		u.startRide(new Date(2022, 1, 1, 1, 10));
		u.endRide(new Date(2022, 1, 1, 2, 30));
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 2, 0));
		u.startRide(new Date(2022, 1, 1, 3, 10));
		u.endRide(new Date(2022, 1, 1, 3, 40));
		
		UserStatistics uS = new UserStatistics();

		assertTrue(uS.timeCreditEarned(u) == 0);
	}
	
	@Test
	void testTimeCreditEarnedVmax() throws Exception {
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new Vmax(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		u.startRide(new Date(2022, 1, 1, 0, 10));
		u.endRide(new Date(2022, 1, 1, 0, 30));
		
		u.planClassicRide(new Location(10), BicycleType.Mechanical, new Date(2022, 1, 1, 1, 0));
		u.startRide(new Date(2022, 1, 1, 1, 10));
		u.endRide(new Date(2022, 1, 1, 2, 30));
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 2, 0));
		u.startRide(new Date(2022, 1, 1, 3, 10));
		u.endRide(new Date(2022, 1, 1, 3, 40));
		
		UserStatistics uS = new UserStatistics();

		assertTrue(uS.timeCreditEarned(u) == ((Vmax) u.getRegistrationCard()).getTotalTimeCreditEarned());
	}
	
	@Test
	void testTimeCreditEarnedVlibre() throws Exception {
		MyVelib myVelib = new MyVelib();
		myVelib.createMyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new Vlibre(), myVelib);
		myVelib.addUser(u);
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 0, 0));
		u.startRide(new Date(2022, 1, 1, 0, 10));
		u.endRide(new Date(2022, 1, 1, 0, 30));
		
		u.planClassicRide(new Location(10), BicycleType.Mechanical, new Date(2022, 1, 1, 1, 0));
		u.startRide(new Date(2022, 1, 1, 1, 10));
		u.endRide(new Date(2022, 1, 1, 2, 30));
		
		u.planClassicRide(new Location(10), BicycleType.Electrical, new Date(2022, 1, 1, 2, 0));
		u.startRide(new Date(2022, 1, 1, 3, 10));
		u.endRide(new Date(2022, 1, 1, 3, 40));
		
		UserStatistics uS = new UserStatistics();

		assertTrue(uS.timeCreditEarned(u) == ((Vlibre) u.getRegistrationCard()).getTotalTimeCreditEarned());
	}

}
