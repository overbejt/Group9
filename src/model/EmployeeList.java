package model;

import java.io.Serializable;
import java.util.HashMap;

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

	// Declaring instance variables
	private Employee employee;

	private HashMap<Long, Employee> list;

	// Constructor
	public EmployeeList() {
		// Initializing the employee list
		list = new HashMap<Long, Employee>();
	}// End of the Constructor

	/**
	 * This is the method that will add an employee to the employee
	 * list.
	 * 
	 * @param employee
	 */
	public void addEmployee(Employee employee) {
		list.put(employee.getID(), employee);
	}// End of the 'addEmployee' method

	/**
	 * This is the method that will remove an employee from the
	 * employee list.
	 * 
	 * @param id
	 *            The id of the item to be removed
	 */
	public void removeEmployee(long id) {
		list.remove(id);
	}// End of the 'removeEmployee' method

	/**
	 * This is the method that will pass the reference to an Employee
	 * in the Employee List.
	 * 
	 * @param id
	 *            The id of the employee requested
	 * @return The employee requested
	 */
	public Employee getEmployee(long id) {
		return list.get(id);
	}// End of the 'getEmployee' method

	/**
	 * This is the method that will return the Employee list in the
	 * form of a HashMap
	 * 
	 * @return The list of employees in the system
	 */
	public HashMap getEmployeeList() {
		return list;
	}// End of the 'getEmployeeList' method

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

}// End of the 'EmployeeList' class
