package myVelib;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing ElectricalBicycle
 * @author Quentin
 *
 */

import java.util.UUID;

import org.junit.jupiter.api.Test;

class ElectricalBicycleTest {

	@Test
	void acceptNoCardTest() {
		Bicycle b = new ElectricalBicycle();
		RegistrationCard rc = new NoCard();
		b.setCurrentRideTime(30);
		assertTrue(b.accept(rc) == 1);
	}
	
	@Test
	void acceptVlibreTest() {
		Bicycle b = new ElectricalBicycle();
		RegistrationCard rc = new Vlibre();
		((Vlibre)rc).setTimeBalance(30);
		b.setCurrentRideTime(120);
		assertTrue(b.accept(rc) == 2);
	}
	
	@Test
	void acceptVmaxTest() {
		Bicycle b = new ElectricalBicycle();
		RegistrationCard rc = new Vmax();
		((Vmax)rc).setTimeBalance(30);
		b.setCurrentRideTime(120);
		assertTrue(b.accept(rc) == 0.5);
	}

}
