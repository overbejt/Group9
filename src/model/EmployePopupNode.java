package model;

import javafx.scene.control.RadioButton;

/**
 * This is the class that will hold the input from the AddEmployee Pop
 * up.
 */
public class EmployePopupNode {
	// Declaring instance variables
	private String		firstName;
	private String		lastName;
	private String		passwordA;
	private String		passwordB;
	private RadioButton	isEmployee;
	private RadioButton	isManager;

	// Constructor
	public EmployePopupNode() {
		firstName = "";
		lastName = "";
		passwordA = "";
		passwordB = "";
		isEmployee = new RadioButton();
		isManager = new RadioButton();
	}// End of Constructor

	// Overloaded Constructor
	public EmployePopupNode(String firstName, String lastName,
			String passwordA, String passwordB,
			RadioButton isEmployee, RadioButton isManager) {

		// Initializing instance variables with data passed through
		this.firstName = firstName;
		this.lastName = lastName;
		this.passwordA = passwordA;
		this.passwordB = passwordB;
		this.isEmployee = isEmployee;
		this.isManager = isManager;
	}// End of the Overloaded Constructor

}// End of the 'EmployeePopupNode' class
