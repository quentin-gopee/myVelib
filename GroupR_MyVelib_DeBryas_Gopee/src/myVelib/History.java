package myVelib;

import java.util.Date;

/**
 * class used to register in the system each evants that happens in the myvelib system.
 * This data will be used after to make statistics.
 * @author jehandebryas
 *
 */

public class History {

	private Date startingTime;
	private Date endingTime;
	
	/**
	 * @param startingTime
	 * @param endingTime
	 */
	public History(Date startingTime, Date endingTime) {
		super();
		this.startingTime = startingTime;
		this.endingTime = endingTime;
	}
	
	public History() {
		super();
	}

	
	/**
	 * getters & setters
	 * @return
	 */
	public Date getStartingTime() {
		return startingTime;
	}
	

	public void setStartingTime(Date startingTime) {
		this.startingTime = startingTime;
	}
	

	public Date getEndingTime() {
		return endingTime;
	}
	

	public void setEndingTime(Date endingTime) {
		this.endingTime = endingTime;
	}
	
	
}
