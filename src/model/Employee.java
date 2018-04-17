package model;

import java.io.Serializable;

/**
 * This is the class that will hold all of the methods and information
 * about employees that have access to the software.
 * 
 * @version 0.1
 */
public class Employee implements EmployeeInterface, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Instance variables
	private String	firstName, lastName, password;
	private int		accessLevel;
	private String	id;

	/**
	 * This is the Constructor method.
	 */
	public Employee() {
		this.firstName = null;
		this.lastName = null;
		this.password = null;
		this.accessLevel = -1;
		this.id = null;
	}// End of the Constructor

	/**
	 * This is the method that will set an employee's name. It will
	 * take in a string containing a concatenation of their first and
	 * last name.
	 * 
	 * @param name
	 */
	@Override
	public void setName(String fname, String lname) {
		this.firstName = fname;
		this.lastName = lname;

		// Now the id can be set
		setId();

	}// End of the 'setName' method

	/**
	 * This is the method that will set an employee's password. It
	 * will take it in the form of a string. It will be case
	 * sensitive. All letters and symbols are valid input.
	 * 
	 * @param password
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;

	}// End of the 'setPassword' method

	/**
	 * This is the method that will set an employee's access level. It
	 * will take in an integer in the following format:
	 * <ul>
	 * <li>(Where 1 = yes and 0 = no)</li>
	 * <li>(employee, manager, admin)</li>
	 * </ul>
	 * <b>*admin access level cannot be changed</b>
	 * 
	 * @param accessLevel
	 */
	@Override
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;

	}// End of the 'setAccessLevel' method

	/**
	 * This is the method that will generate the id. It is a private
	 * helper method. It will take the first name, and the last name
	 * and convert both to all lower case. Then it will remove all
	 * whitespace. Finally it will concatenate both the first and last
	 * names.
	 */
	private void setId() {
		firstName.toLowerCase();
		firstName.trim();
		lastName.toLowerCase();
		lastName.trim();
		id = firstName + lastName;
	}// End of the 'setId' method

	/**
	 * This is the method that will return the employee's name.
	 * 
	 * @return
	 */
	@Override
	public String getName() {
		return this.firstName + " " + this.lastName;
	}// End of the 'getName' method

	/**
	 * This is the method that will return the employee's password.
	 * 
	 * @return
	 */
	@Override
	public String getPassword() {
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
	 */
	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}// End of the 'getAccessLevel' method

	/**
	 * This is the method that will return the employee's ID. It will
	 * serve as the key in a hashmap.
	 * 
	 * @return
	 */
	@Override
	public String getID() {
		return id;
	}// End of the 'getId' method

}// End of the 'Employee' class
