package model;

import java.time.Instant;

/**
 * This is the class that will hold all of the methods and information
 * about employees that have access to the software.
 * 
 * @version 0.1
 */
public class Employee implements EmployeeInterface {

	// Instance variables
	private String	name, password;
	private int		accessLevel;
	private Instant	id;

	/**
	 * This is the Constructor method.
	 */
	public Employee() {
		this.name = null;
		this.password = null;
		this.accessLevel = -1;
		this.id = Instant.now();
	}// End of the Constructor

	/**
	 * This is the method that will set an employee's name. It will
	 * take in a string containing a concatenation of their first and
	 * last name.
	 * 
	 * @param name
	 */
	@Override
	public void setName(String name) {
		this.name = name;

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
	 * This is the method that will return the employee's name.
	 * 
	 * @return
	 */
	@Override
	public String getName() {
		return this.name;
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
	 * This is the method that will return the employee's ID number.
	 * It will serve as the key in a hashmap.
	 * 
	 * @return
	 */
	@Override
	public long getID() {
		return this.id.getEpochSecond();
	}// End of the 'getId' method

}// End of the 'Employee' class
