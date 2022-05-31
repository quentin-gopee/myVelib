package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

/**
 * Class for testing Vmax
 * @author Quentin
 *
 */

class VmaxTest {

	@Test
	void testVisitMechanicalBicycle() {
		Bicycle b = new MechanicalBicycle();
		RegistrationCard rc = new Vmax();
		((Vmax)rc).setTimeBalance(30);
		b.setCurrentRideTime(120);
		assertTrue(rc.visit((MechanicalBicycle) b) == 0.5);
	}

	@Test
	void testVisitElectricalBicycle() {
		Bicycle b = new ElectricalBicycle();
		RegistrationCard rc = new Vmax();
		((Vmax)rc).setTimeBalance(30);
		b.setCurrentRideTime(120);
		assertTrue(rc.visit((ElectricalBicycle) b) == 0.5);
	}

	@Test
	void testStationPlus() {
		RegistrationCard rc = new Vmax();
		rc.stationPlus();
		assertTrue(((Vmax) rc).getTimeBalance() == 5);
	}


}
