package model;

import java.time.Instant;

/**
 * This is the class that will handle the Employee object 'Admin'. It
 * will implement the Singleton design pattern. None of the states
 * from 'Admin' can be changed. They can only be read by referenced.
 * 
 * @version 1.0
 */
public class Admin {

	// Instance variables
	private String	name, password;
	private int		accessLevel;
	private Instant	id;
	// Declaring an instance of this class to hold the object
	private static Admin	admin;
	private static Employee	adminB;

	/**
	 * Constructor
	 */
	private Admin() {
		adminB = new Employee();
		adminB.setAccessLevel(001);
		adminB.setName("admin");
		adminB.setPassword("admin");

		// this.id = Instant.now();// Setting the ID
		// this.name = "admin";// Setting the name
		// this.password = "admin";// Setting the password
		// this.accessLevel = 001;// Setting the Access Level
	}// End of the Constructor

	/**
	 * This is the method that will protect 'Admin' from ever creating
	 * more than one Instance. And it will allow other classes to
	 * access it by reference.
	 * <p>
	 * <em>Important:</em> When loading a pre-existing list of
	 * employee's, do not call this method.
	 * </p>
	 * 
	 * @return
	 */
	public static Employee getAdminInstance() {
		// Check if an instance already exists
		if (admin == null) {
			admin = new Admin();
		}
		return adminB;
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
	 * This is the method that will return the employee's ID number.
	 * It will serve as the key in a hashmap.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public long getID() throws NullPointerException {
		return this.id.getEpochSecond();
	}// End of the 'getId' method

}// End of the 'Admin' class
