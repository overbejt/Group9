package model;

/**
 * This is the class that will hold the input from the AddEmployee Pop
 * up.
 */
public class EmployeePopupNode {
	// Declaring instance variables
	private String	firstName;
	private String	lastName;
	private String	passwordA;
	private String	passwordB;
	private boolean	isEmployee;
	private boolean	isManager;

	// Constructor
	public EmployeePopupNode() {
		firstName = "";
		lastName = "";
		passwordA = "";
		passwordB = "";
		isEmployee = false;
		isManager = false;
	}// End of Constructor

	// Overloaded Constructor
	public EmployeePopupNode(String firstName, String lastName,
			String passwordA, String passwordB, boolean isEmployee,
			boolean isManager) {

		// Initializing instance variables with data passed through
		this.firstName = firstName;
		this.lastName = lastName;
		this.passwordA = passwordA;
		this.passwordB = passwordB;
		this.isEmployee = isEmployee;
		this.isManager = isManager;
	}// End of the Overloaded Constructor

	// <<<<<<<<<<GETTERS>>>>>>>>>>>>>>>>>>
	public String getFirstName() {
		return firstName;
	}// End of the 'getFirstName' method

	public String getLastName() {
		return lastName;
	}// End of the 'getLastName' method

	public String getPasswordA() {
		return passwordA;
	}// End of the 'getPaswordA' method

	public String getPasswordB() {
		return passwordB;
	}// End of the 'getPasswordB' method

	public boolean getIsEmployee() {
		return isEmployee;
	}// End of the 'getIsEmployee' method

	public boolean getIsManager() {
		return isManager;
	}// End of the 'getIsManager' method
}// End of the 'EmployeePopupNode' class
