package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

/**
 * Class for testing MechanicalBicycle
 * @author Quentin
 *
 */

class MechanicalBicycleTest {

	@Test
	void acceptNoCardTest() {
		Bicycle b = new MechanicalBicycle();
		RegistrationCard rc = new NoCard();
		b.setCurrentRideTime(30);
		assertTrue(b.accept(rc) == 0.5);
	}
	
	@Test
	void acceptVlibreTest() {
		Bicycle b = new MechanicalBicycle();
		RegistrationCard rc = new Vlibre();
		((Vlibre)rc).setTimeBalance(30);
		b.setCurrentRideTime(120);
		assertTrue(b.accept(rc) == 0.5);
	}
	
	@Test
	void acceptVmaxTest() {
		Bicycle b = new MechanicalBicycle();
		RegistrationCard rc = new Vmax();
		((Vmax)rc).setTimeBalance(30);
		b.setCurrentRideTime(120);
		assertTrue(b.accept(rc) == 0.5);
	}

}
