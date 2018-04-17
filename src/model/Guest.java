package model;

import java.io.Serializable;

/**
 * This is the class that will handle the Guest object. It will use
 * the Singleton design pattern. This means that the states of the
 * Guest object should not be able to be altered.
 * 
 * @version 1.0
 */
public class Guest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Instance variables
	private String	name, password;
	private int		accessLevel;
	private String	id;
	// Declaring an instance of this class to hold the object
	private static Guest guest;

	/**
	 * Constructor
	 */
	private Guest() {
		this.id = "guest";// Setting the ID
		this.name = "guest";// Setting the name
		this.password = "guest";// Setting the password
		this.accessLevel = 000;// Setting the Access Level
	}// End of the Constructor

	/**
	 * This is the method that will protect 'Guest' from ever creating
	 * more than one Instance. And it will allow other classes to
	 * access it by reference.
	 * <p>
	 * <em>Important:</em> When loading a pre-existing list of
	 * employee's, do not call this method.
	 * </p>
	 * 
	 * @return
	 */
	public static Guest getGuestInstance() {
		// Check if an instance already exists
		if (guest == null) {
			guest = new Guest();
		}
		return guest;
	}// End of the 'getAdminInstance' method

	/**
	 * This is the method that will return the employee's name.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public String getName() throws NullPointerException {
		return this.name;
	}// End of the 'getName' method

	/**
	 * This is the method that will return the employee's password.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public String getPassword() throws NullPointerException {
		return this.password;
	}// End of the 'getPassword' method

	/**
	 * This is the method that will return the employee's access level
	 * in the following format:
	 * <ul>
	 * <li>(Where 1 = yes and 0 = no)</li>
	 * <li>(employee, manager, admin)</li>
	 * </ul>
	 * <b>*admin access level cannot be changed</b>
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public int getAccessLevel() throws NullPointerException {
		return this.accessLevel;
	}// End of the 'getAccessLevel' method

	/**
	 * This is the method that will return the employee's ID. It will
	 * serve as the key in a hashmap.
	 * 
	 * @return The guest's ID
	 * @throws NullPointerException
	 */
	public String getID() throws NullPointerException {
		return this.id;
	}// End of the 'getId' method

}// End of the 'Guest' class
