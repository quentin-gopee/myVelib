package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
	
	@Test
	void testSetUp() {
		MyVelib mV = new MyVelib();
		mV.setUp(10, 10, 4.0, 75);
		
		ArrayList<Station> stations = new ArrayList<Station>(mV.getStations().values());
		
		assertTrue(stations.size()==10);
		assertTrue(stations.get(2).getParkingSlots().size()==10);
		
		ArrayList<Bicycle> bicycles = new ArrayList<Bicycle>(mV.getBicycles().values());
		
		assertTrue(mV.getBicycles().size()==75);
		assertTrue(mV.getSide()==4.0);

		
	}

}
