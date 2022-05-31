package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Test for the class Location
 * @author Quentin
 *
 */
class LocationTest {

	@Test
	void testDistance() {
		Location l1 = new Location(0,1);
		Location l2 = new Location(1,0);
		assertTrue(l1.distance(l2) == Math.pow(2,0.5));
	}

}
