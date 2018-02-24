
/**
 * This is the main driver for the application
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
			System.out.println(
					"Added and formatted by Josh");
			// BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource(
							"View.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root, 600,
					400);
			scene.getStylesheets()
					.add(getClass().getResource(
							"application.css")
							.toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Abacus");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
