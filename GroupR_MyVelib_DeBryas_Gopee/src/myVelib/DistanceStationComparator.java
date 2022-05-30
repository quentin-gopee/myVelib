package myVelib;
import java.util.*;

public class DistanceStationComparator implements Comparator<Station> {
	
	private Location location;
	
	/**
	 * Creates a new DistanceStationComparator
	 * @param location the location to compute distance
	 */
	public DistanceStationComparator(Location location) {
		this.location = location;
	}
	
	@Override
	/**
	 * Compares two station to sort stations from the closest to the farthest to location
	 * @param s1 station 1
	 * @param s2 station 2
	 * @return 1 if s1 is the closest, 0 if s1 and s2 are at equal distance, 1 if s2 is the closest
	 */
	public int compare(Station s1, Station s2) {
		double d1 = location.distance(s1.getLocation());
		double d2 = location.distance(s2.getLocation());
		if (d1 < d2) {
			return 1;
		} else if (d1 == d2) {
			return 0;
		} else {
			return -1;
		}
	}
	
	/**
	 * getter for location
	 * @return location
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * setter for location
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
}
