
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
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Enter a print statement that says
			// your name below here
			// System.out.println("Added and formatted by Josh");
			// System.out.println("Nicole Matthews");
			// System.out.println("Feiyu Wang");
			// System.out.println("Jacob Sandy");
			//
			// System.out.println("I Added another print statement");
			// System.out.println("Git push test");

			// FXMLLoader loader = new FXMLLoader(getClass()
			// .getResource("/view/InventoryScene.fxml"));
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("/view/LoginScene.fxml"));

			Parent root = loader.load();

			// Getting the controller
			Controller controller = loader.getController();

			Scene scene = new Scene(root, 600, 400);
			scene.getStylesheets()
					.add(getClass()
							.getResource("/view/application.css")
							.toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Abacus");
			primaryStage.setMaximized(true);
			primaryStage.show();

			// Handle close action**************
			primaryStage.setOnCloseRequest(event -> {
				event.consume();// Stop from closing

				System.out.println("Ready to go");

				controller.end();

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}// End of the 'Main' class
