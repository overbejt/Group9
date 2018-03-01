package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
	
	@FXML
    private TextField fieldBtm ;
	@FXML
    private Button btn ;

    // called by the FXML loader after the labels declared above are injected:
    public void initialize() {

        // do initialization and configuration work...

       
    }
	
    
    public void btnWasClicked(ActionEvent evt) {
    	fieldBtm.setText("An Item was added");
    	fieldBtm.setVisible(true);  
    	System.out.println("It was clicked");
    }//End of the 'btnWasClicked' method
    
    
    /**
     * This is the method that will invoke the persistence methods when a user chooses to exit the program.
     */
    public void end() {
    	System.out.println("saving files");
    	//save some files
    	System.exit(0);
    }//End of the 'end' method
    
}//End of the 'Controller' class
