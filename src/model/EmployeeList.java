package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import AbucusExceptions.EmployeeExistsException;
import AbucusExceptions.EmployeeNotFoundException;
import AbucusExceptions.InvalidRemovalException;

/**
 * This is the class that will hold all of the employees. When an
 * object of this class is initialized, it will be Serializable.
 * 
 * @version 1.0
 */
public class EmployeeList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9162446095675838851L;

	// Declaring a HashMap to store the employees
	private HashMap<String, Object> list;

	// Constructor
	public EmployeeList() {
		// Initializing the employee list
		list = new HashMap<String, Object>();
	}// End of the Constructor

	/**
	 * This is the method that will add an employee to the employee
	 * list.
	 * 
	 * @param employee
	 */
	public void addEmployee(Object employee) {

		// Check if Employee object
		if (employee instanceof Employee) {
			// Make sure that the employee doesn't already exist
			if (list.containsKey(((Employee) employee).getID())) {
				throw new EmployeeExistsException();
			} else {
				String id = ((Employee) employee).getID();
				list.put(id, employee);
			}
		} else if (employee instanceof Admin) {
			// Make sure that the admin is not already in the list
			if (!list.containsKey(((Admin) employee).getID())) {
				// Check if 'Admin' object
				list.put(((Admin) employee).getID(), employee);
			}
		} else if (employee instanceof Guest) {
			// Make sure that the guest is not already in the list
			if (!list.containsKey(((Guest) employee).getID())) {
				// Check if 'Guest' object
				list.put(((Guest) employee).getID(), employee);
			}
		}
	}// End of the 'addEmployee' method

	/**
	 * This is the method that will remove an employee from the
	 * employee list.
	 * 
	 * @param id
	 *            The id of the item to be removed
	 */
	public void removeEmployee(String id) {

		// Formating input
		id = id.toLowerCase();
		id = id.trim();
		id = id.replaceAll("\\s", "");

		// Check to make sure that it is an Employee object
		if (list.get(id) instanceof Employee) {
			list.remove(id);
		} else {
			throw new InvalidRemovalException();
		}
	}// End of the 'removeEmployee' method

	/**
	 * This is the method that will pass the reference to an Employee
	 * in the Employee List.
	 * 
	 * @param id
	 *            The id of the employee requested
	 * @return The employee requested
	 */
	public Object getEmployee(String id)
			throws EmployeeNotFoundException {
		// Formatting Input
		id = id.toLowerCase();
		id = id.trim();
		id.replaceAll("\\s", "");

		return list.get(id);
	}// End of the 'getEmployee' method

	/**
	 * This is the method that will return the Employee list in the
	 * form of a HashMap
	 * 
	 * @return The list of employees in the system
	 */
	public HashMap<String, Object> getEmployeeList() {
		return list;
	}// End of the 'getEmployeeList' method

	/**
	 * This is the method that will check if a certain employee is in
	 * the list.
	 * 
	 * @param name
	 *            The name of the employee being searched
	 * @return True if the employee is in the list. False if not.
	 */
	public boolean contains(String name) {

		// Formating the input
		name = name.toLowerCase();
		name = name.trim();
		name.replaceAll("\\s", "");

		Object object = list.get(name);
		if (object == null) {
			return false;
		} else {
			return true;
		}

	}// End of the 'contains' method

	/**
	 * This is the method that will allow you to point this object to
	 * a different employee list. It will be implemented if there is
	 * already an employee list on record.
	 * 
	 * @param inList
	 *            The employee list that is already stored
	 */
	public void setEmployeeList(EmployeeList inList) {
		this.list = inList.getEmployeeList();
	}// End of the 'setEmployeeList' method

	/**
	 * This is the method that will clear the employee list.
	 */
	public void clearList() {
		list.clear();
	}// End of the 'clearList' method

	/**
	 * Overriding the toString method. It will return a string in the
	 * form of [id: object.toString()].
	 */
	public String show() {
		// Initializing a String to hold the concatenated results
		String result = "";

		// Get the entries
		Set<Entry<String, Object>> entries = list.entrySet();

		// Loop through all the employees
		for (Entry<String, Object> k : entries) {

			// Concatenate to result
			result += "[";
			result += k.getKey();
			result += " : ";
			result += k.getValue();
			result += "]";

		} // End of loop

		// Send back the string
		return result;

	}// End of the 'toString' method

}// End of the 'EmployeeList' class
