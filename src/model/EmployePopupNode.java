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

}// End of the 'EmployeePopupNode' class
