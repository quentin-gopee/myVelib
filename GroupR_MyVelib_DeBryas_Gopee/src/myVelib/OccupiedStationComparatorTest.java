package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

/**
 * Class to test OccupiedStationComparator
 * @author Quentin
 *
 */
class OccupiedStationComparatorTest {

	@Test
	void testCompareInferior() {
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
		
		s1.addParkingSlot(ps1);
		s2.addParkingSlot(ps2);
		
		OccupiedStationComparator osc = new OccupiedStationComparator();
		
		assertTrue(osc.compare(s1,s2) == -1);
	}
	
	@Test
	void testCompareEqual() {
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
		
		s1.addParkingSlot(ps1);
		s2.addParkingSlot(ps2);
		
		OccupiedStationComparator osc = new OccupiedStationComparator();
		
		assertTrue(osc.compare(s1,s2) == 0);
	}
	
	@Test
	void testCompareSuperior() {
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
		
		Station s2 = new Station(new Location(0,0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		ParkingSlot ps2 = new ParkingSlot(s2, new Date(2020, 1, 1, 0, 0));
		
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.ReservedBicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.FreeToUse, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Rent
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.OutOfOrder, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0)));
		ps2.addParkingSlotHistory(new ParkingSlotHistory(ParkingSlotState.Bicycle, ps2, null, ps2.getLastChangeDate(), new Date(2020, 1, 1, 0, 0))); // Drop
		
		s1.addParkingSlot(ps1);
		s2.addParkingSlot(ps2);
		
		OccupiedStationComparator osc = new OccupiedStationComparator();
		
		assertTrue(osc.compare(s1,s2) == 1);
	}

}
