package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyVelibTest {

	@Test
	void testAddStation() {
		assertTrue(true);

	}

	@Test
	void testAddBicycle() {
		assertTrue(true);
	}

	@Test
	void testAddUser() {
		MyVelib mV = new MyVelib();
		User user = new User("Woz",new Location(10.0),new CreditCard(),new Vmax(),mV);
		mV.addUser(user);
		
		assertTrue(true);
	}

}
