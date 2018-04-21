package view;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

/**
 * This is the class that will handle the dialog pop-up when a user
 * wants to add an employee. s
 */
public class AddEmployeeDialog {

	// Create the username and password labels and fields.
	private GridPane grid;

	private TextField	userName;
	private TextField	password;

	private ButtonType okDoneBtnType;

	// Instance variables
	private static Dialog<Pair<String, String>> employeeAdded;

	// Constructor
	private AddEmployeeDialog() {
		initDialog();// Initializing
	}// End of Constructor

	/**
	 * This is the method that will return the wrapped TextInputDialog
	 * object
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Dialog getAddEmployeePopup() {
		new AddEmployeeDialog();
		return employeeAdded;
	}// End of the 'getAddEmployeePopup' method

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
	 * This is the method that will initialize the button type for the
	 * Dialog
	 */
	private void initBtnType() {
		okDoneBtnType = new ButtonType("Add Employee",
				ButtonData.OK_DONE);

	}// End of the 'initBtnType' method

	/**
	 * This is the method that will initialize the dialog box.
	 */
	private void initDialog() {

		employeeAdded = new Dialog<>();
		employeeAdded.setTitle("Add Employee");
		employeeAdded.setHeaderText("This is the header");
		employeeAdded.setContentText("This is the content text");

		initBtnType();// Initializing the button
		initGridPane();// Initializing the gridpane
		initFields();// Initializing the Textfields
		assemble();// Putting it all together
	}// End of the 'init' method

	/**
	 * This is the method that will assemble all of the utilities and
	 * layout, and add the to the dialog box.
	 */
	private void assemble() {
		// Adding the buttons
		employeeAdded.getDialogPane().getButtonTypes()
				.addAll(okDoneBtnType, ButtonType.CANCEL);
		grid.add(userName, 1, 0);
		grid.add(password, 1, 1);
		employeeAdded.getDialogPane().setContent(grid);// Adding
														// children to
														// parent

		// Convert the result to a username-password-pair when the
		// login button is clicked.
		employeeAdded.setResultConverter(dialogButton -> {
			if (dialogButton == okDoneBtnType) {
				return new Pair<>(userName.getText(),
						password.getText());
			}
			return null;
		});

	}// End of the 'assemble' method

	/**
	 * // * This is the method that will invoke the showAndWait method
	 * from // * the super class. //
	 */
	// public void showAndWait() {
	// employeeAdded.showAndWait();
	// }// End of the 'showAndWait' method

}// End of the 'AddEmployeeDialog' class
