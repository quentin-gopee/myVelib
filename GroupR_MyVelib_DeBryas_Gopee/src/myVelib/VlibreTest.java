package myVelib;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class VlibreTest {
	
	@Test
	void testVisitMechanicalBicycle() {
		Bicycle b = new MechanicalBicycle();
		RegistrationCard rc = new Vlibre(UUID.randomUUID());
		b.setCurrentRideTime(90);
		assertTrue(rc.visit((MechanicalBicycle) b) == 0.5);
	}

	@Test
	void testVisitElectricalBicycle() {
		Bicycle b = new ElectricalBicycle();
		RegistrationCard rc = new Vlibre(UUID.randomUUID());
		b.setCurrentRideTime(90);
		assertTrue(rc.visit((ElectricalBicycle) b) == 2);
	}

	@Test
	void testStationPlus() {
		RegistrationCard rc = new Vlibre(UUID.randomUUID());
		rc.stationPlus();
		assertTrue(((Vlibre) rc).getTimeBalance() == 5);
	}

}
