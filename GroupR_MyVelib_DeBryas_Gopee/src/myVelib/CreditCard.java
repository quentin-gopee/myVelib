package myVelib;

/**
 * Class for the credit card
 * @author Quentin
 *
 */
public class CreditCard {
	
	/**
	 * balance of the card
	 */
	private double balance;
	
	/**
	 * Creates a credit card with a balance of 0
	 */
	public CreditCard() {
		balance = 0;
	}
	
	/**
	 * Creates a credit card with an initial balance
	 * @param balance the initial balance
	 */
	public CreditCard(double balance) {
		this.balance = balance;
	}
	
	/**
	 * getter for balance
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * setter for balance
	 * @param balance the new balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
