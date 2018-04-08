package application;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import model.Admin;
import model.EmployeeList;
import model.Guest;
import model.Persistence;

/**
 * This is the controller class. For now, it will be the go-between
 * for the model class and the view classes.
 * 
 * @version 0.3
 */
public class Controller {

	@FXML
	private JFXPasswordField	passwordField;
	@FXML
	private JFXTextField		usrNameField;
	@FXML
	private JFXButton			loginBtn;

	// >>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<
	// Instance objects
	private Stage			primaryStage;
	private FXMLLoader		fxmlLoader;
	private Parent			parent;
	private Persistence		persistence;
	private EmployeeList	employeeList;

	// >>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<

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

		// Check if ItemList file exists

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
	public void loginBtnClicked(ActionEvent e) {

		// Test the user name and their password.
		// If valid, then switch to the inventory scene

		// Or allow to log in as a guest
		// Then switch to the inventory scene

		// Or ask the manager to log them in and change their
		// password

		System.out.println("The login button was clicked");
		// Invoke the 'loadInventoryScene' method
		loadInventoryScene();

	}// End of the 'menuItemSaveClicked' method

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

		}
	}// End of the 'loadInventoryScene' method

}// End of the 'Controller' class
