package myVelib;

import java.util.ArrayList;

/**
 * a Class containing all methods used to compute and display statistics about MyVelib system
 * @author jehandebryas
 *
 */

public class Statistics {

	private UserStatistics uStats;
	private StationStatistics sStats;

	/**
	 * constructor
	 */
	public Statistics() {
		uStats = new UserStatistics();;
		sStats = new StationStatistics();
	}

	/*
	 * getters & setters
	 */
	public UserStatistics getuStats() {
		return uStats;
	}

	public void setuStats(UserStatistics uStats) {
		this.uStats = uStats;
	}

	public StationStatistics getsStats() {
		return sStats;
	}

	public void setsStats(StationStatistics sStats) {
		this.sStats = sStats;
	}	
}
