package myVelib;

import java.util.ArrayList;

/**
 * a Class containing all methods used to compute and display statistics about MyVelib system
 * @author jehandebryas
 *
 */

public class Statistics {

	private MyVelib myVelib;

	/**
	 * constructor
	 * @param myVelib
	 */
	public Statistics(MyVelib myVelib) {
		super();
		this.myVelib = myVelib;
	}

	/*
	 * getters & setters
	 */
	public MyVelib getMyVelib() {
		return myVelib;
	}

	public void setMyVelib(MyVelib myVelib) {
		this.myVelib = myVelib;
	}
	
}
