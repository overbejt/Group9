package view;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import model.EmployeePopupNode;

/**
 * This is the class that will handle the dialog pop-up when a user
 * wants to add an employee. s
 */
public class AddEmployeeDialog {

	// Instance variables
	private GridPane grid;

	private TextField	firstName;
	private TextField	lastName;
	private TextField	passwordA;
	private TextField	passwordB;

	private ToggleGroup	toggleGroup;
	private RadioButton	isEmployee;
	private RadioButton	isManager;
	private ButtonType	okDoneBtnType;

	// private static Dialog<Pair<String, String>> employeeAdded;
	private static Dialog<EmployeePopupNode> employeeAdded;

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
		grid.setVgap(20);
		grid.setPadding(new Insets(20, 150, 10, 10));
	}// End of the 'initGridPane' method1

	/**
	 * This is the method that will initialize the text fields.
	 */
	private void initFields() {
		// Initialize the text fields
		firstName = new TextField();
		lastName = new TextField();
		passwordA = new TextField();
		passwordB = new TextField();
		// Set the prompt texts
		firstName.setPromptText("First Name");
		lastName.setPromptText("Last Name");
		passwordA.setPromptText("Employee Password");
		passwordB.setPromptText("Confirm Employee Password");

	}// End of the 'initFields' method

	/**
	 * This is the method that will initialize the radio buttons for
	 * the user to decide between whether an employee or a manager is
	 * added.
	 */
	private void initRadioButtons() {

		// Initialize the toggle group
		toggleGroup = new ToggleGroup();

		/*
		 * Initializing isEmployee, adding it to the toggle group, and
		 * making isEmployee selected by default
		 */
		isEmployee = new RadioButton("Employee");
		isEmployee.setToggleGroup(toggleGroup);
		isEmployee.setSelected(true);

		// Initializing isManager
		isManager = new RadioButton("Manager");
		// Adding it to the toggle group
		isManager.setToggleGroup(toggleGroup);

	}// End of the 'initRadioButtons'

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
		employeeAdded.setHeaderText(
				"Enter the Employee's name and password");
		// employeeAdded.setContentText("This is the content text");

		initBtnType();// Initializing the button
		initGridPane();// Initializing the gridpane
		initFields();// Initializing the Textfields
		initRadioButtons();// Initializing the RadioButtons
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
		grid.add(firstName, 1, 0);
		grid.add(lastName, 1, 1);
		grid.add(passwordA, 1, 2);
		grid.add(passwordB, 1, 3);
		grid.add(isEmployee, 1, 4);
		grid.add(isManager, 2, 4);
		// Adding children to parent
		employeeAdded.getDialogPane().setContent(grid);

		// Convert the result to EmployeePopupNode when the
		// login button is clicked.
		employeeAdded.setResultConverter(dialogButton -> {
			if (dialogButton == okDoneBtnType) {
				return new EmployeePopupNode(firstName.getText(),
						lastName.getText(), passwordA.getText(),
						passwordB.getText(), isEmployee.isSelected(),
						isManager.isSelected());
			}
			return null;
		});

	}// End of the 'assemble' method

}// End of the 'AddEmployeeDialog' class
