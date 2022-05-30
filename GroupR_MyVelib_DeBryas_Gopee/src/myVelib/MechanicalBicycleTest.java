package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

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
		RegistrationCard rc = new Vlibre(UUID.randomUUID());
		((Vlibre)rc).setTimeBalance(30);
		b.setCurrentRideTime(120);
		assertTrue(b.accept(rc) == 0.5);
	}
	
	@Test
	void acceptVmaxTest() {
		Bicycle b = new MechanicalBicycle();
		RegistrationCard rc = new Vmax(UUID.randomUUID());
		((Vmax)rc).setTimeBalance(30);
		b.setCurrentRideTime(120);
		assertTrue(b.accept(rc) == 0.5);
	}

}
