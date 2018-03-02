package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class Controller {

	@FXML
	private TextField	fieldBtm;
	@FXML
	private Button		btn;

	@FXML
	private MenuItem close;

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
	 * This is the method that will perform
	 * actions when the user clicks the close menu
	 * item. It will display an alert box asking
	 * if they want to save. Then, based on their
	 * decision, it will either exit, or save and
	 * then exit.
	 * 
	 * @param e
	 */
	@FXML
	public void
			menuItemCloseClicked(ActionEvent e) {

		// The alert box
		String msg = "Would you like to save the inventory?";
		Alert alert = new Alert(
				AlertType.CONFIRMATION, msg);

		alert.showAndWait().filter(
				response -> response == ButtonType.OK)
				.ifPresent(response -> end());
		System.exit(0);// Exiting the program
		// (redundant?)

	}// End of the 'menuItemCloseClicked'method

	/**
	 * This is the method that will handle the
	 * event that the user clicks the menu item
	 * 'save'. It will invoke the methods for
	 * saving the inventory and the user list.
	 * 
	 * @param e
	 */
	public void
			menuItemSaveClicked(ActionEvent e) {

		System.out.println(
				"The save button was clicked");

	}// End of the 'menuItemSaveClicked' method

	/**
	 * This is the method that will invoke the
	 * persistence methods when a user chooses to
	 * exit the program.
	 */
	public void end() {
		System.out
				.println("Controller/end method");
		// save some files
		System.exit(0);// End the program
	}// End of the 'end' method

}// End of the 'Controller' class
