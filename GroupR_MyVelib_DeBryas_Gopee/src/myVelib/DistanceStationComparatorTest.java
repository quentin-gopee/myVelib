package myVelib;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Test;

class DistanceStationComparatorTest {

	@Test
	void testCompareClosest() {
		DistanceStationComparator dsc = new DistanceStationComparator(new Location(0.0, 0.0));
		Station s1 = new Station(new Location(1.0, 1.0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		Station s2 = new Station(new Location(2.0, 2.0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		assertTrue(dsc.compare(s1,s2) == -1);
	}
	
	@Test
	void testCompareEqual() {
		DistanceStationComparator dsc = new DistanceStationComparator(new Location(0.0, 0.0));
		Station s1 = new Station(new Location(1.0, 1.0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		Station s2 = new Station(new Location(1.0, 1.0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		assertTrue(dsc.compare(s1,s2) == 0);
	}
	
	@Test
	void testCompareFarthest() {
		DistanceStationComparator dsc = new DistanceStationComparator(new Location(0.0, 0.0));
		Station s1 = new Station(new Location(2.0, 2.0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		Station s2 = new Station(new Location(1.0, 1.0), StationType.Standard, true, new ArrayList<ParkingSlot>());
		assertTrue(dsc.compare(s1,s2) == 1);
	}

}
