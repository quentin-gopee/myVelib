package myVelib;

import java.util.Comparator;

/**
 * Comparator for station to sort them according to their occupation
 * @author Quentin
 *
 */
public class OccupiedStationComparator implements Comparator<Station> {
	
	private Counter counter;
	
	public OccupiedStationComparator() {
		counter = new Counter();
	}

	@Override
	/**
	 * Compares two stations according to there occupation
	 * @param s1 station 1
	 * @param s2 station 2
	 * @return a positive integer if s1 is the least occupied, 0 if s1 and 2 have the same occupation and -1 if s2 is the least occupied
	 */
	public int compare(Station s1, Station s2) {
		int diff1 = counter.countRentingStation(s1) - counter.countDroppingStation(s1);
		int diff2 = counter.countRentingStation(s2) - counter.countDroppingStation(s2);
		return diff1-diff2;
	}	
}
