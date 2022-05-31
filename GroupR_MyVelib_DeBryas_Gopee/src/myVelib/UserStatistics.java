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
	
	/**
	 * 
	 * @param user
	 * @return total time spent on a bike in minutes
	 */
	public int totalTimeSpentOnABike(User user) {
		
		ArrayList<Ride> rides = user.getRides();
		double totalTime=0;
		for(Ride r: rides) {
			totalTime += r.getEndingTime().getTime()-r.getStartingTime().getTime() ; 
		}
		
		return (int) (totalTime/(1000*60));
		
	}
	
	/**
	 * return total ammount of charges that a user spent for bikes
	 * @param user
	 * @return
	 */
	public double totalAmmountofCharges(User user) {
		
		ArrayList<Ride> rides = user.getRides();
		double totalCharges = 0;
		for(Ride r: rides) {
			totalCharges += r.getCost() ; 
		}
		
		return totalCharges;
	}

	/**
	 * return the total time credit earned by a user thanks to his card
	 * @param user
	 * @return
	 */
	public int timeCreditEarned(User user) {
		int timeCreditEarned =0;
		if(user.getRegistrationCard() instanceof NoCard) {
			System.out.println("this user doesn't have any registration card");
		}
		if(user.getRegistrationCard()instanceof Vlibre) {
			Vlibre card = (Vlibre) user.getRegistrationCard();
			timeCreditEarned = card.getTimeBalance();
		}
		if(user.getRegistrationCard()instanceof Vmax) {
			Vmax card = (Vmax) user.getRegistrationCard();
			timeCreditEarned = card.getTimeBalance();
		}
		return timeCreditEarned;
	}
}
