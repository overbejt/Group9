
/**
 * This is the main driver for the application
 * 
 * @version 0.3
 */
package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		// Handling any exceptions
		try {

			// Initializing the FXML loader
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/view/LoginBeta.fxml"));

			// Creating an instance of the controller class
			Controller controller = new Controller();

			// Setting the controller for the login scene
			loader.setController(controller);

			// Loading the fxml document
			Parent root = loader.load();

			// Giving the controller this instance of the primary
			// stage
			controller.setPrimaryStage(primaryStage);

			// Initializing the scene
			Scene scene = new Scene(root, 600, 400);

			// Adding the style sheet
			scene.getStylesheets()
					.add(getClass()
							.getResource("/view/application.css")
							.toExternalForm());

			// Setting the stage
			primaryStage.setScene(scene);

			// Setting the title of the application
			primaryStage.setTitle("Abacus");

			// Making it full screen
			primaryStage.setMaximized(true);

			// Showing the scene
			primaryStage.show();

			// Handle close action**************
			primaryStage.setOnCloseRequest(event -> {
				event.consume();// Stop from closing

				// Invoking the method in the controller class that
				// will handle user request to exit the system
				controller.end();

			});

		} catch (Exception e) {
			// Alert the user to missing passwordA
			String msg = "OOPS!  Well this is embarrasing.  Apparently there was a fatal error.  Please try again";
			System.out.println(msg);
			Alert err = new Alert(AlertType.CONFIRMATION, msg);
			err.show();
		}

	}// End of the 'start' method

	// The main method
	public static void main(String[] args) {
		launch(args);
	}

}// End of the 'Main' class
