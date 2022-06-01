package myVelib;
import java.*;
import java.util.*;


/**
 * class representing a location in X Y coordinates
 * @author jehandebryas
 *
 */

public class Location {

	private double X;
	private double Y;
	
	/**
	 * initializer
	 * @param x
	 * @param y
	 */
	public Location(double x, double y) {
		super();
		setX(x);
		setY(y);
	}
	
	
	
	@Override
	public String toString() {
		return "Location [X=" + X + ", Y=" + Y + "]";
	}



	/**
	 * create a random location bewteen 0 and max
	 * @param max
	 */
	public Location(double max) {
		super();
		this.X = new Random().nextDouble()*max;
		this.Y = new Random().nextDouble()*max;
	}

	/**
	 * getters & setters
	 * @return
	 */
	public double getX() {
		return X;
	}

	public void setX(double x) {
		X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}
	
	public double distance(Location location) {
		double distance = Math.pow(this.X-location.getX(),2) + Math.pow(this.Y-location.getY(),2);
		return Math.pow(distance, ((double)1)/((double)2));

	}
		
}
