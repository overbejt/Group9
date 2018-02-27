
/**
 * This is the main driver for the application
 * 
 * @version 0.1
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
			System.out.println("Nicole Matthews");
			// BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource(
							"/view/View.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root, 600,
					400);
			scene.getStylesheets()
					.add(getClass().getResource(
							"/view/application.css")
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

}// End of the 'Main' class
