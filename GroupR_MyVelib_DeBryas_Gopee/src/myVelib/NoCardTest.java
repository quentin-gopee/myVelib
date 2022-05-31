package myVelib;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing NoCard
 * @author Quentin
 *
 */

import org.junit.jupiter.api.Test;

class NoCardTest {

	@Test
	void testVisitMechanicalBicycle() {
		Bicycle b = new MechanicalBicycle();
		RegistrationCard rc = new NoCard();
		b.setCurrentRideTime(30);
		assertTrue(rc.visit((MechanicalBicycle) b) == 0.5);
	}

	@Test
	void testVisitElectricalBicycle() {
		Bicycle b = new ElectricalBicycle();
		RegistrationCard rc = new NoCard();
		b.setCurrentRideTime(30);
		assertTrue(rc.visit((ElectricalBicycle) b) == 1);
	}

}
