package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

/**
 * Class to test StationStatistics
 * @author Quentin
 *
 */
class StationStatisticsTest {

	@Test
	void testTotalNumberofRentOperations() {
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
		
		StationStatistics c = new StationStatistics();
		
		assertTrue(c.totalNumberofRentOperations(s) == 5);
	}

	@Test
	void testTotalNumberofReturnOperations() {
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
		
		StationStatistics c = new StationStatistics();
		
		assertTrue(c.totalNumberofReturnOperations(s) == 5);
	}

	@Test
	void testMostUsedStation() {
		Station s1 = new Station(new Location(0,0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		ParkingSlot ps1 = new ParkingSlot(s1, new Date(2020, 1, 1, 0, 0));
		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Rent
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));	// Rent
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		
		ps1.setState(ParkingSlotState.Bicycle); // Drop
		
		Station s2 = new Station(new Location(0,0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		ParkingSlot ps2 = new ParkingSlot(s2, new Date(2020, 1, 1, 0, 0));
		
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Rent
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		
		ps2.setState(ParkingSlotState.Bicycle); // Drop
		
		Station s3 = new Station(new Location(0,0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		ParkingSlot ps3 = new ParkingSlot(s3, new Date(2020, 1, 1, 0, 0));
		
		ps3.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps3, null, ps3.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps3.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps3, null, ps3.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		ps3.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps3, null, ps3.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps3.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps3, null, ps3.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Rent
		
		s1.addParkingSlot(ps1);
		s2.addParkingSlot(ps2);
		s3.addParkingSlot(ps3);
		
		MyVelib myVelib = new MyVelib();
		
		Map<UUID, Station> in = new HashMap<UUID, Station>();
		ArrayList<Station> out = new ArrayList<Station>();
		
		in.put(s1.getID(), s1);
		in.put(s2.getID(), s2);
		in.put(s3.getID(), s3);
		
		myVelib.setStations(in);
		
		out.add(s3);
		out.add(s2);
		out.add(s1);
		
		StationStatistics c = new StationStatistics();
		
		assertTrue(c.mostUsedStation(myVelib).equals(out));
	}

	@Test
	void testLeastOccupiedStation() {
		Station s1 = new Station(new Location(0,0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		ParkingSlot ps1 = new ParkingSlot(s1, new Date(2020, 1, 1, 0, 0));
		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Rent
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));	// Rent
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));		
		ps1.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps1, null, ps1.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		
		ps1.setState(ParkingSlotState.Bicycle); // Drop
		
		Station s2 = new Station(new Location(0,0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		ParkingSlot ps2 = new ParkingSlot(s2, new Date(2020, 1, 1, 0, 0));
		
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Rent
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		
		ps2.setState(ParkingSlotState.Bicycle); // Drop
		
		Station s3 = new Station(new Location(0,0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		ParkingSlot ps3 = new ParkingSlot(s3, new Date(2020, 1, 1, 0, 0));
		
		ps3.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps3, null, ps3.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps3.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps3, null, ps3.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		ps3.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps3, null, ps3.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps3.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps3, null, ps3.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Rent
		
		s1.addParkingSlot(ps1);
		s2.addParkingSlot(ps2);
		s3.addParkingSlot(ps3);
		
		MyVelib myVelib = new MyVelib();
		
		Map<UUID, Station> in = new HashMap<UUID, Station>();
		ArrayList<Station> out = new ArrayList<Station>();
		
		in.put(s1.getID(), s1);
		in.put(s2.getID(), s2);
		in.put(s3.getID(), s3);
		
		myVelib.setStations(in);
		
		out.add(s2);
		out.add(s1);
		out.add(s3);
		
		StationStatistics c = new StationStatistics();
		
		assertTrue(c.leastOccupiedStation(myVelib).equals(out));
	}

}
