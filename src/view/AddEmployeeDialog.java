package view;

import javafx.scene.control.TextInputDialog;

/**
 * This is the class that will handle the dialog pop-up when a user
 * wants to add an employee. s
 */
public class AddEmployeeDialog {

	// Instance variables
	private TextInputDialog employeeAdded;

	// Constructor
	public AddEmployeeDialog() {
		init();// Initializing
	}// End of Constructor

	/**
	 * This is the method that will initialize the dialog box.
	 */
	public void init() {
		employeeAdded = new TextInputDialog();
		employeeAdded.setTitle("Add Employee");
		employeeAdded.setHeaderText("This is the header");
		employeeAdded.setContentText("This is the content text");
	}// End of the 'init' method

	/**
	 * This is the method that will invoke the showAndWait method from
	 * the super class.
	 */
	public void showAndWait() {
		employeeAdded.showAndWait();
	}// End of the 'showAndWait' method

}// End of the 'AddEmployeeDialog' class
