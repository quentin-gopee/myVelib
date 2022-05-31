package myVelib;

import java.util.ArrayList;

/**
 * All statistics about the users
 * @author jehandebryas
 *
 */

public class UserStatistics extends Statistics{

	public UserStatistics(MyVelib myVelib) {
		super(myVelib);
	}
	
	
	/**
	 * Methods
	 */
	
	/**
	 * @param user
	 * @return number of rides made by a user 
	 */
	public int numberOfRides(User user) {
		if(user.getRides().isEmpty()) {return 0;}
		else return user.getRides().size();
	}
	
	public double totalTimeSpentOnABike(User user) {
		
		ArrayList<Ride> rides = user.getRides();
		double totalTime=0;
		for(Ride r: rides) {
			totalTime += r.getEndingTime().getTime()-r.getStartingTime().getTime() ; //rajouter difference de temps
		}
		
		return totalTime;
		
	}
	
	public double totalAmmountofCharges(User user) {
		
		ArrayList<Ride> rides = user.getRides();
		double totalCharges = 0;
		for(Ride r: rides) {
			totalCharges += r.getCost() ; 
		}
		
		return totalCharges;
	}

	public int timeCreditEarned(User user) {
		int timeCreditEarned = 0;
		//code here
		return timeCreditEarned;
	}
}
