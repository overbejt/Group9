package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * This is the controller class. For now, it will be the go-between
 * for the model class and the view classes.
 * 
 * @version 0.3
 */
public class Controller {

	@FXML
	private TextField fieldBtm;

	// called by the FXML loader after the labels
	// declared above are injected:
	public void initialize() {

		// do initialization and configuration
		// work...

	}

	public void btnWasClicked(ActionEvent evt) {
		fieldBtm.setText("An Item was added");
		fieldBtm.setVisible(true);
		System.out.println("It was clicked");
	}// End of the 'btnWasClicked' method

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

	/**
	 * This is the method that will handle the event that the user
	 * clicks the menu item 'save'. It will invoke the methods for
	 * saving the inventory and the user list.
	 * 
	 * @param e
	 */
	public void menuItemSaveClicked(ActionEvent e) {
		// For Testing and debugging
		fieldBtm.setText("The save button was clicked");
		fieldBtm.setVisible(true);

		System.out.println("The save button was clicked");
		// Invoke the save method
		save();

	}// End of the 'menuItemSaveClicked' method

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

	// <<<<<<<<<<<<<<<<<,>>>>>>>>>>>>>>>>

	/**
	 * This is the method that will save the inventory and the
	 * employee list.
	 */
	public void save() {
		System.out.println(
				"The save method from the controller was called");
	}// End of the 'save' method

}// End of the 'Controller' class
