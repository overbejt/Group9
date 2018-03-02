package model;

/**
 * This is the class that will hold all of the
 * methods and information about employees that
 * have access to the software.
 * 
 * @version 0.1
 */
public class Employee
		implements EmployeeInterface {

	/**
	 * This is the method that will set an
	 * employee's name. It will take in a string
	 * containing a concatenation of their first
	 * and last name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the method that will set an
	 * employee's password. It will take it in the
	 * form of a string. It will be case
	 * sensitive. All letters and symbols are
	 * valid input.
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the method that will set an
	 * employee's access level. It will take in an
	 * integer in the following format:
	 * <ul>
	 * <li>(Where 1 = yes and 0 = no)</li>
	 * <li>(employee, manager, admin)</li>
	 * </ul>
	 * <b>*admin access level cannot be
	 * changed</b>
	 * 
	 * @param accessLevel
	 */
	public void setAccessLevel(int accessLevel) {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the method that will set an
	 * employee's ID. It will take the epoch time
	 * and store it in an integer. This value can
	 * never be changed. It's only purpose is to
	 * serve as a key in a hashmap.
	 */
	public void setID() {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the method that will return the
	 * employee's name.
	 * 
	 * @return
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This is the method that will return the
	 * employee's password.
	 * 
	 * @return
	 */
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This is the method that will return the
	 * employee's access level in the following
	 * format:
	 * <ul>
	 * <li>(Where 1 = yes and 0 = no)</li>
	 * <li>(employee, manager, admin)</li>
	 * </ul>
	 * <b>*admin access level cannot be
	 * changed</b>
	 * 
	 * @return
	 */
	public int getAccessLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * This is the method that will return the
	 * employee's ID number. It will serve as the
	 * key in a hashmap.
	 * 
	 * @return
	 */
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}// End of the 'Employee' class
