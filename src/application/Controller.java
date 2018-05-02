package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;

import AbucusExceptions.InvalidRemovalException;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Admin;
import model.Employee;
import model.EmployeeList;
import model.EmployeePopupNode;
import model.Guest;
import model.Item;
import model.ItemList;
import model.Persistence;
import view.AddEmployeeDialog;
import view.RemoveEmployeeDialog;

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
	private TableView<Item>				tableView;
	@FXML
	private HBox						tableBox;
	@FXML
	private TableColumn<String, Item>	nameColumn;
	@FXML
	private TableColumn<String, Item>	catagoryColumn;
	@FXML
	private TableColumn<String, Item>	sizeColumn;
	@FXML
	private TableColumn<String, Item>	quantityColumn;
	@FXML
	private MenuItem					menuExitItem;
	@FXML
	private Menu						menuEdit;
	@FXML
	private MenuItem					menuAddEmployee;
	@FXML
	private MenuItem					menuRemoveEmployee;
	@FXML
	private MenuItem					menuAddItem;
	@FXML
	private MenuItem					menuRemoveItem;
	@FXML
	private JFXRadioButton				sizeRdBtn;
	@FXML
	private JFXRadioButton				priceRdBtn;
	@FXML
	private JFXRadioButton				quantityRdBtn;
	@FXML
	private JFXRadioButton				nameRdBtn;

	// >>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<
	// Instance objects
	private Scene			scene;
	private Stage			primaryStage;
	private FXMLLoader		fxmlLoader;
	private Parent			parent;
	private Persistence		persistence;
	private EmployeeList	employeeList;
	private Employee		currentEmployee;
	private ItemList		itemList;

	private boolean	isEmployee	= false;
	private boolean	isManager	= false;
	private boolean	isAdmin		= false;
	private boolean	isGuest		= false;

	// >>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<
	private final PseudoClass errorClass = PseudoClass
			.getPseudoClass("error");// For input validation
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

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
			System.out
					.println("Employee List: " + employeeList.show());
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

		}

		// Check if ItemList file exists
		if (persistence.itemListExists()) {

			itemList = persistence.readItemList();

			System.out.println("Item List: " + itemList.show());

		} else {

			// When a file does not exist, create a new Item List
			itemList = new ItemList();

		}

		// Invoke the method that will initialize the table
		initTable();

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

			// Switch to Inventory scene
			loadInventoryScene();

		} else {
			// Test if a user name was entered
			if (userNameField.getText().trim().length() == 0) {
				userNameField.pseudoClassStateChanged(errorClass,
						true);
			} else {
				// Test if user name entered exists
				String inputName = userNameField.getText();
				// Format input
				inputName = inputName.replaceAll("\\s", "");

				// Test if in the employee list
				if (inputName.equals("admin")) {
					isAdmin = true;// Might not be the best place

				} else if (employeeList.contains(inputName)) {

					currentEmployee = (Employee) employeeList
							.getEmployee(inputName);
				} else {
					// Alert the user to not a valid user name
					System.out.println("Invalid User Name");
				}
			} // End of user name verification
				// Test if a password was entered
			if (passwordField.getText().trim().length() == 0) {
				passwordField.pseudoClassStateChanged(errorClass,
						true);
			} else {
				String inPassword = passwordField.getText();
				inPassword = inPassword.trim();//
				if (isAdmin) {
					if (inPassword.equals("admin")) {
						isAdmin = true;// Setting the user sate
						// Invoke the 'loadInventoryScene' method
						loadInventoryScene();
					}
				} else if (inPassword
						.equals(currentEmployee.getPassword())) {

					// Test if good password

					// Test if manager
					if (currentEmployee.getAccessLevel() == 10) {
						isManager = true;
					}
					// Test if Employee
					if (currentEmployee.getAccessLevel() == 100) {
						isEmployee = true; // Setting the user state
					}

					// Invoke the 'loadInventoryScene' method
					loadInventoryScene();

				} else {
					// Alert the user to bad input
					System.out.println("Invalid Input");
				}

			} // End of password verification
		} // End of guest test

		System.out.println("?");

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

		// Getting the wrapped dialog for the add employee popup
		@SuppressWarnings("rawtypes")
		Dialog addEmployeePopup = AddEmployeeDialog
				.getAddEmployeePopup();

		// Creating an optional node to hold the input
		Optional<EmployeePopupNode> result = addEmployeePopup
				.showAndWait();

		// System.out.println(result.toString());

		validateNewEmployee(result);// Validate input

		// TEMP
		System.out.println("Employee List: " + employeeList.show());

	}// End of the 'menuAddEmployeeClicked' method

	/**
	 * This is the method that will be called when the user clicks on
	 * the Remove Employee menu item.
	 */
	@FXML
	public void menuRemoveEmployeeClicked() {

		// TMP
		System.out.println("The Remove Employee button was clicked");

		// Creating a remove employee pop up object
		RemoveEmployeeDialog removeEmployee = new RemoveEmployeeDialog(
				employeeList);

		ChoiceDialog dialog = removeEmployee.getRemoveEmployeePopup();

		Optional<String> result = dialog.showAndWait();

		// Make sure there is input to validate
		if (result.isPresent()) {
			System.out
					.println("Selected for removal: " + result.get());

			// Test for if the user selected the default value
			if (!result.get().equals("-Select an employee-")) {

				// Handle errors
				try {
					employeeList.removeEmployee(result.get());

					System.out.println(employeeList.show());// For
															// testing

					// Update the employee list file
					persistence.writeEmployeeList(employeeList);

					System.out.println(
							"Employee list was updated and saved");

				} catch (Exception er) {

					// Declaring a string to hold the message to tell
					// the employee
					String msg = "";

					// Test if there is an Invalid Removal Exception
					if (er instanceof InvalidRemovalException) {
						// Alert the user to employee not removed
						msg = "Employee not removed.";

					} else {
						// Alert the user that there was a problem
						// saving the employee list
						msg = "There was a problem saving the employee list";
					}

					System.out.println(msg);
					Alert err = new Alert(AlertType.CONFIRMATION,
							msg);
					err.show();
				} // End of exception handling

			} // End of if result present test

			// For testing
			System.out
					.println("Employee List: " + employeeList.show());

		} // End of the test for default value

	}// End of the 'menuRemoveEmployeeClicked' method

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
			// Saving the Employee List
			persistence.writeEmployeeList(employeeList);
		} catch (IOException err) {
			// TODO Auto-generated catch block
			err.printStackTrace();
		}
	}// End of the 'save' method

	/**
	 * This is the method that will initialize the table
	 */
	@FXML
	private void initTable() {

	}// End of the 'initTable' method

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

			scene = new Scene(parent, 600, 400);
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

	/**
	 * This is the method that will validate the input from the add
	 * employee pop-up. It will take in an optional node that should
	 * contain the new employee's name and their password.
	 * 
	 * @return
	 */
	private void
			validateNewEmployee(Optional<EmployeePopupNode> input) {
		// Test for empty input
		if (input.isPresent()) {
			// Getting the node for processing
			EmployeePopupNode node = input.get();

			// Get the employee's name
			String firstName = node.getFirstName();
			String lastName = node.getLastName();
			// Get the employee's password
			String passwordA = node.getPasswordA();
			String passwordB = node.getPasswordB();
			// Get the employee's access rights
			boolean newIsEmployee = node.getIsEmployee();
			boolean newIsManager = node.getIsManager();

			// Format the key

			String key = firstName + lastName;

			// Test if employee already exists
			if (!employeeList.contains(key)) {
				// Test if the user entered the employee first name
				if (firstName.trim().length() != 0) {
					// Test if the user entered the employee's last
					// name
					if (lastName.trim().length() != 0) {
						// Test if the user entered passwordA
						if (passwordA.trim().length() != 0) {
							// Test if the user entered passwordB
							if (passwordB.trim().length() != 0) {

								// Test if passworA matches passwordB
								if (passwordA.equals(passwordB)) {

									// Create new Employee
									Employee newEmployee = new Employee();
									newEmployee.setName(firstName,
											lastName);

									// Set the new employee's
									// password
									newEmployee
											.setPassword(passwordA);

									// Set the employee's access Level
									// Test is new Employee is just an
									// employee
									if (newIsEmployee) {
										newEmployee
												.setAccessLevel(100);
									}
									// Test if new Employee is a
									// manager
									if (newIsManager) {
										newEmployee
												.setAccessLevel(010);
									}

									// Add the new employee to the
									// list
									employeeList
											.addEmployee(newEmployee);

									// Save the employeeList
									try {
										persistence.writeEmployeeList(
												employeeList);
									} catch (IOException e) {
										// TODO Auto-generated catch
										// block
										e.printStackTrace();
									}

								} else {
									// Alert the user to the bad first
									// name
									String msg = "New employee not added. Passwords do not match";
									System.out.println(msg);
									Alert err = new Alert(
											AlertType.CONFIRMATION,
											msg);
									err.show();
								}

							} else {
								// Alert the user to missing passwordB
								String msg = "New employee not added.  New employee's confirmed password is missing";
								System.out.println(msg);
								Alert err = new Alert(
										AlertType.CONFIRMATION, msg);
								err.show();
							}
						} else {
							// Alert the user to missing passwordA
							String msg = "New employee not added.  New employee's password not entered";
							System.out.println(msg);
							Alert err = new Alert(
									AlertType.CONFIRMATION, msg);
							err.show();
						}
					} else {
						// Alert the user to bad last name
						String msg = "New employee not added.  New employee's last name not entered";
						System.out.println(msg);
						Alert err = new Alert(AlertType.CONFIRMATION,
								msg);
						err.show();
					}

				} else {
					// Alert the user to the bad first name
					String msg = "New employee not added.  New employee's first name not entered";
					System.out.println(msg);
					Alert err = new Alert(AlertType.CONFIRMATION,
							msg);
					err.show();
				}

			} else {

				// Alert the user that the employee already exists
				String msg = "New employee not added.  Employee already exists";
				System.out.println(msg);
				Alert err = new Alert(AlertType.CONFIRMATION, msg);
				err.show();

			}

		} // End of test for cancel button

	}// End of the 'validateNewEmployee' method

}// End of the 'Controller' class
