package application;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import model.Admin;
import model.Employee;
import model.EmployeeList;
import model.Guest;
import model.Persistence;
import view.AddEmployeeDialog;

/**
 * This is the controller class. For now, it will be the go-between
 * for the model class and the view classes.
 * 
 * @version 0.3
 */
public class Controller {

	// >>>>>>>>>>>>Login Scene Instance variables<<<<<<<<<<<<<<<<<<<<<
	@FXML
	private JFXToggleButton		guestToggle;
	@FXML
	private JFXPasswordField	passwordField;
	@FXML
	private JFXTextField		userNameField;
	@FXML
	private JFXButton			loginBtn;

	// >>>>>>>>>>>>Inventory Scene Instance variables<<<<<<<<<<<<<<<<<
	@FXML
	private MenuItem		menuExitItem;
	@FXML
	private Menu			menuEdit;
	@FXML
	private MenuItem		menuAddEmployee;
	@FXML
	private MenuItem		menuRemoveEmployee;
	@FXML
	private MenuItem		menuAddItem;
	@FXML
	private MenuItem		menuRemoveItem;
	@FXML
	private JFXRadioButton	sizeRdBtn;
	@FXML
	private JFXRadioButton	priceRdBtn;
	@FXML
	private JFXRadioButton	quantityRdBtn;
	@FXML
	private JFXRadioButton	nameRdBtn;

	// >>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<
	// Instance objects
	private Stage			primaryStage;
	private FXMLLoader		fxmlLoader;
	private Parent			parent;
	private Persistence		persistence;
	private EmployeeList	employeeList;
	private Employee		currentEmployee;

	private boolean	isEmployee	= false;
	private boolean	isAdmin		= false;
	private boolean	isGuest		= false;

	// >>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<
	private final PseudoClass errorClass = PseudoClass
			.getPseudoClass("error");// For input validation

	/**
	 * This is the method that will only run once on initialization.
	 * It will initialize instance objects and variables. It will also
	 * handle loading from local memory, if any exists.
	 * 
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void initialize() throws ClassNotFoundException,
			FileNotFoundException, IOException {

		// Initializing the Persistence object
		persistence = new Persistence();

		// Check if EmployeeList file exists
		if (persistence.employeeListExists()) {
			employeeList = persistence.readEmployeeList();
		} // End of EmployeeList check
		else {
			employeeList = new EmployeeList();
			// Creating an 'Admin' object
			Admin admin = Admin.getAdminInstance();
			// Adding 'Admin' to the EmployeeList
			employeeList.addEmployee(admin);

			// Creating a 'Guest' object
			Guest guest = Guest.getGuestInstance();
			// Adding 'Guest' to the EmployeeList
			employeeList.addEmployee(guest);

			// !!Needs Tested for weakness
		}

	}// End of the 'initialize' method

	// <<<<<<<<<<<<<<Login Screen>>>>>>>>>>>>>>>>>>>>>>

	/**
	 * This is the method that will handle the user trying to log in.
	 * It will verify if they are a valid user and if their password
	 * is correct. It will also allow them to login as a guest.
	 * 
	 * @param e
	 */
	@FXML
	public void loginBtnClicked() {

		System.out.println("The login button was clicked");

		boolean correctPassword = false;

		// Test if logging in as a guest
		if (guestToggle.isSelected()) {

			isGuest = true;// Setting the user state
			System.out.println("Guest Logged In: " + isGuest);
			// Switch to Inventory scene
			loadInventoryScene();
			System.out.println("Guest Logged In: " + isGuest);

		} else {
			// Test if a user name was entered
			if (userNameField.getText().trim().length() == 0) {
				userNameField.pseudoClassStateChanged(errorClass,
						true);
			} else {
				// Test if user name entered exists
				String inputName = userNameField.getText();
				// Test if in the employee list
				if (inputName.equals("admin")) {
					isAdmin = true;// Might not be the best place
				} else if (employeeList.contains(inputName)) {
					currentEmployee = (Employee) employeeList
							.getEmployee(inputName);
				} else {
					// Alert the user to not a valid user name
				}
			} // End of user name verification
				// Test if a password was entered
			if (passwordField.getText().trim().length() == 0) {
				passwordField.pseudoClassStateChanged(errorClass,
						true);
			} else {
				String inPassword = passwordField.getText();
				if (isAdmin) {
					if (inPassword.equals("admin")) {
						isAdmin = true;// Setting the user sate
						// Invoke the 'loadInventoryScene' method
						loadInventoryScene();
					}
				}
				// Test if good password
				else if (inPassword
						.equals(currentEmployee.getPassword())) {
					isEmployee = true; // Setting the user state
					// Invoke the 'loadInventoryScene' method
					loadInventoryScene();

				} else {
					// Alert the user to bad input
				}

			} // End of password verification
		} // End of guest test

		System.out.println("?");
		// try {
		// // Removing the ability to add/remove Employees
		// disableEmployeeListEdit();
		// } catch (Exception err) {
		// System.out.println(err);
		// }

	}// End of the 'loginBtnClicked' method

	// <<<<<<<<<<<<<<Inventory Screen>>>>>>>>>>>>>>>>>>>>>>

	/**
	 * This is the method that will perform actions when the user
	 * clicks the close menu item. It will display an alert box asking
	 * if they want to save. Then, based on their decision, it will
	 * either exit, or save and then exit.
	 * 
	 * @param e
	 */
	@FXML
	public void menuItemCloseClicked(ActionEvent e) {
		end();

	}// End of the 'menuItemCloseClicked'method

	public void btnWasClicked(ActionEvent evt) {

		System.out.println("It was clicked");
	}// End of the 'btnWasClicked' method

	/**
	 * This is the method that will handle the event that the user
	 * clicks the menu item 'save'. It will invoke the methods for
	 * saving the inventory and the user list.
	 * 
	 * @param e
	 */
	@FXML
	public void menuItemSaveClicked(ActionEvent e) {
		// For Testing and debugging
		// fieldBtm.setText("The save button was clicked");
		// fieldBtm.setVisible(true);

		System.out.println("The save button was clicked");
		// Invoke the save method
		save();

	}// End of the 'menuItemSaveClicked' method

	/**
	 * This is the method that will sort all the items in the
	 * inventory based on their size.
	 */
	@FXML
	public void sizeRadioClicked() {
		if (priceRdBtn.isSelected()) {
			priceRdBtn.setSelected(false);
		}
		if (quantityRdBtn.isSelected()) {
			quantityRdBtn.setSelected(false);
		}
		if (nameRdBtn.isSelected()) {
			nameRdBtn.setSelected(false);
		}
		if (sizeRdBtn.isSelected()) {
			System.out.println("The Size Radio Button was clicked");
		}
	}// End of the 'sizeRadioClicked' method

	/**
	 * This is the method that will sort all the items in the
	 * inventory based on their price.
	 */
	@FXML
	public void priceRadioClicked() {
		if (sizeRdBtn.isSelected()) {
			sizeRdBtn.setSelected(false);
		}
		if (quantityRdBtn.isSelected()) {
			quantityRdBtn.setSelected(false);
		}
		if (nameRdBtn.isSelected()) {
			nameRdBtn.setSelected(false);
		}
		if (priceRdBtn.isSelected()) {
			System.out.println("The Price Radio Button was clicked");
		}
	}// End of the 'priceRadioClicked' method

	/**
	 * This is the method that will sort all the items in the
	 * inventory based on their quantity.
	 */
	@FXML
	public void quantityRadioClicked() {
		if (sizeRdBtn.isSelected()) {
			sizeRdBtn.setSelected(false);
		}
		if (priceRdBtn.isSelected()) {
			priceRdBtn.setSelected(false);
		}
		if (nameRdBtn.isSelected()) {
			nameRdBtn.setSelected(false);
		}
		if (quantityRdBtn.isSelected()) {
			System.out
					.println("The Quantity Radio Button was clicked");
		}
	}// End of the 'quantityRadioClicked' method

	/**
	 * This is the method that will sort all the items in the
	 * inventory based on their name.
	 */
	@FXML
	public void nameRadioClicked() {
		if (priceRdBtn.isSelected()) {
			priceRdBtn.setSelected(false);
		}
		if (quantityRdBtn.isSelected()) {
			quantityRdBtn.setSelected(false);
		}
		if (sizeRdBtn.isSelected()) {
			sizeRdBtn.setSelected(false);
		}
		if (nameRdBtn.isSelected()) {
			System.out.println("The name Radio Button was clicked");
		}
	}// End of the 'nameRadioClicked' method

	/**
	 * This is the method that will filter Edit options based on which
	 * user is logged in.
	 * 
	 * @param e
	 */
	@FXML
	public void menuEditClicked() {
		System.out.println("The Menu item 'Edit' was clicked");
		System.out.println("Guest: " + isGuest);

		// Only admin and managers are allowed to add/remove employees
		if (isEmployee || isGuest) {
			disableEmployeeListEdit();
		}
		// Guests are not allowed to edit anything
		if (isGuest) {
			disableItemListEdit();
		}

	}// End of the 'menuEditClicked' method

	/**
	 * This is the method that will handle an event where a user
	 * clicked the add Employee button.
	 */
	@FXML
	public void menuAddEmployeeClicked() {
		System.out.println("The ADD Employee button was clicked");

		// Need to create an input box
		AddEmployeeDialog employeeAdded = new AddEmployeeDialog();
		employeeAdded.showAndWait();
	}// End of the 'menuAddEmployeeClicked' method

	// <<<<<<<<<<<<<<<<<Helper Methods>>>>>>>>>>>>>>>>

	/**
	 * This is the method that will allow this Controller class to
	 * load new FXML files. Essentially switching the scenes when
	 * needed.
	 * 
	 * @param loader
	 */
	public void setPrimaryStage(Stage inStage) {
		primaryStage = inStage;
	}// End of the 'setFxmlLoader' method

	/**
	 * This is the method that will invoke the persistence methods
	 * when a user chooses to exit the program.
	 */
	public void end() {
		System.out.println("Controller/end method");

		// The alert box
		String msg = "Would you like to save the inventory?";
		Alert alert = new Alert(AlertType.CONFIRMATION, msg);

		// If click yes, then save. Else exit
		alert.showAndWait()
				.filter(response -> response == ButtonType.OK)
				.ifPresent(response -> save());
		System.exit(0);// Exiting the program

	}// End of the 'end' method

	/**
	 * This is the method that will save the inventory and the
	 * employee list.
	 */
	private void save() {
		System.out.println(
				"The save method from the controller was called");
		try {
			persistence.writeEmployeeList(employeeList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// End of the 'save' method

	/**
	 * This is a private helper method that will load the inventory
	 * scene.
	 */
	private void loadInventoryScene() {
		try {
			// Switching to the inventory scene
			fxmlLoader = new FXMLLoader(getClass()
					.getResource("/view/InventoryScene.fxml"));

			// To keep the states of everything in this controller
			fxmlLoader.setController(this);

			parent = fxmlLoader.load();// Loading the new FXML file

			Scene scene = new Scene(parent, 600, 400);
			scene.getStylesheets()
					.add(getClass()
							.getResource("/view/application.css")
							.toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Abacus");
			primaryStage.setMaximized(true);// Maximizing
			primaryStage.setFullScreen(true);// Setting to full screen
			primaryStage.show();
		} catch (Exception err) {
			// It should catch this
		}
	}// End of the 'loadInventoryScene' method

	/**
	 * This is a private helper class that will prevent anyone but
	 * 'admin' and a manager from being able to edit the employee
	 * list.
	 */
	@FXML
	private void disableEmployeeListEdit() {

		System.out.println("disabled");
		menuAddEmployee.setDisable(true);
		menuRemoveEmployee.setDisable(true);

	}// End of the 'disableEmployeeListEdit' method

	/**
	 * This is a private helper method that will prevent Guests from
	 * being able to edit the Item List.
	 */
	@FXML
	private void disableItemListEdit() {
		menuAddItem.setDisable(true);
		menuRemoveItem.setDisable(true);
	}// End of the 'disableItemListEdit' method

	/**
	 * This is the method that will reset all of the user states.
	 */
	private void resetUserState() {
		isGuest = false;
		isAdmin = false;
		isEmployee = false;
	}// End of the 'resetUserState' method

}// End of the 'Controller' class
