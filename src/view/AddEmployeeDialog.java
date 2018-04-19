package view;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;

/**
 * This is the class that will handle the dialog pop-up when a user
 * wants to add an employee. s
 */
public class AddEmployeeDialog {

	// Create the username and password labels and fields.
	private GridPane grid;

	private TextField	userName;
	private TextField	password;

	// Instance variables
	private TextInputDialog employeeAdded;

	// Constructor
	public AddEmployeeDialog() {
		initDialog();// Initializing
	}// End of Constructor

	/**
	 * This is the method that will initialize the grid pane.
	 */
	private void initGridPane() {
		grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));
	}// End of the 'initGridPane' method1

	/**
	 * This is the method that will initialize the text fields.
	 */
	private void initFields() {
		// Initialize the text fields
		userName = new TextField();
		password = new TextField();
		// Set the prompt texts
		userName.setPromptText("Employee Name");
		password.setPromptText("Employee Password");

	}// End of the 'initFields' method

	/**
	 * This is the method that will initialize the dialog box.
	 */
	private void initDialog() {

		employeeAdded = new TextInputDialog();
		employeeAdded.setTitle("Add Employee");
		employeeAdded.setHeaderText("This is the header");
		employeeAdded.setContentText("This is the content text");
		initGridPane();// Initializing the gridpane
		initFields();// Initializing the Textfields
		assemble();// Putting it all together
	}// End of the 'init' method

	/**
	 * This is the method that will assemble all of the utilities and
	 * layout, and add the to the dialog box.
	 */
	private void assemble() {
		grid.add(userName, 1, 0);
		grid.add(password, 1, 1);
		employeeAdded.getDialogPane().setContent(grid);// Adding
														// children to
														// parent
	}// End of the 'assemble' method

	/**
	 * This is the method that will invoke the showAndWait method from
	 * the super class.
	 */
	public void showAndWait() {
		employeeAdded.showAndWait();
	}// End of the 'showAndWait' method

}// End of the 'AddEmployeeDialog' class
