package model;

/**
 * This is the Interface that will outline all of information and
 * functionality that will be required by the Employee class.
 * 
 * @version 0.3
 */
public interface EmployeeInterface {

	/**
	 * This is the method that will set an employee's name. It will
	 * take in a string containing a concatenation of their first and
	 * last name.
	 * 
	 * @param name
	 */
	public void setName(String name);

	/**
	 * This is the method that will set an employee's password. It
	 * will take it in the form of a string. It will be case
	 * sensitive. All letters and symbols are valid input.
	 * 
	 * @param password
	 */
	public void setPassword(String password);

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
	public void setAccessLevel(int accessLevel);

	/**
	 * This is the method that will set an employee's ID. It will take
	 * the epoch time and store it in a long. This value can never be
	 * changed. It's only purpose is to serve as a key in a hashmap.
	 */
	public void setID();

	/**
	 * This is the method that will return the employee's name.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public String getName() throws NullPointerException;

	/**
	 * This is the method that will return the employee's password.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public String getPassword() throws NullPointerException;

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
	public int getAccessLevel() throws NullPointerException;

	/**
	 * This is the method that will return the employee's ID number.
	 * It will serve as the key in a hashmap.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public long getID() throws NullPointerException;

}// End of the 'EmployeedInterface' class
