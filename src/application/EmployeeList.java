package application;

import java.io.Serializable;
import java.util.HashMap;

import model.Employee;

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
	private Employee	employee;
	private HashMap		list;

	// Constructor
	public EmployeeList() {
		// Initializing the employee list
		list = new HashMap();
	}// End of the Constructor

}// End of the 'EmployeeList' class
