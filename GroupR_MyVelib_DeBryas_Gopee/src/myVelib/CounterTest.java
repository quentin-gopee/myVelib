package myVelib;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.Test;

/**
 * Class to test the Counter class
 * @author Quentin
 *
 */
class CounterTest {

	@Test
	void testCountRentingPs() {
		Station s = new Station(new Location(0,0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		ParkingSlot ps = new ParkingSlot(s, new Date(2020, 1, 1, 0, 0));
		
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Rent
		
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Rent
		
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		// Rent
		
		Counter c = new Counter();
		
		assertTrue(c.countRentingPs(ps) == 3);
	}

	@Test
	void testCountRentingStation() {
		Station s = new Station(new Location(0,0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		ParkingSlot ps1 = new ParkingSlot(s, new Date(2020, 1, 1, 0, 0));
		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Rent
		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Rent
		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		// Rent
		
		ParkingSlot ps2 = new ParkingSlot(s, new Date(2020, 1, 1, 0, 0));
		
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Rent
		
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		// Rent
		
		s.addParkingSlot(ps1);
		s.addParkingSlot(ps2);
		
		Counter c = new Counter();
		
		assertTrue(c.countRentingStation(s) == 5);
	}

	@Test
	void testCountDroppingPs() {
		Station s = new Station(new Location(0,0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		ParkingSlot ps = new ParkingSlot(s, new Date(2020, 1, 1, 0, 0));
		
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));		
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));		
		ps.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps, null, ps.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		
		ps.setState(ParkingSlotState.Bicycle); // Drop
		
		Counter c = new Counter();
		
		assertTrue(c.countDroppingPs(ps) == 3);
	}

	@Test
	void testCountDroppingStation() {
		Station s = new Station(new Location(0,0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		ParkingSlot ps1 = new ParkingSlot(s, new Date(2020, 1, 1, 0, 0));
		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		
		ps1.setState(ParkingSlotState.Bicycle); // Drop
		
		ParkingSlot ps2 = new ParkingSlot(s, new Date(2020, 1, 1, 0, 0));
		
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		s.addParkingSlot(ps1);
		s.addParkingSlot(ps2);
		
		Counter c = new Counter();
		
		assertTrue(c.countDroppingStation(s) == 5);
	}

}
