package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Class to test UserStatistics
 * @author Quentin
 *
 */
class UserStatisticsTest {

	@Test
	void testNumberOfRides() {
		MyVelib myVelib = new MyVelib();
		
		User u = new User("user", new Location(0,0), new CreditCard(), new NoCard(), myVelib);
		u.addRide(new Ride())
		fail("Not yet implemented");
	}

	@Test
	void testTotalTimeSpentOnABike() {
		fail("Not yet implemented");
	}

	@Test
	void testTotalAmmountofCharges() {
		fail("Not yet implemented");
	}

	@Test
	void testTimeCreditEarned() {
		fail("Not yet implemented");
	}

}
