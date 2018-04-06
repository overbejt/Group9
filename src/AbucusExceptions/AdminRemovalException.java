package AbucusExceptions;

/**
 * This is the Exception class that will be thrown whenever someone
 * tries to remove the Admin from the Employee List.
 * 
 * @version 1.0
 */
public class AdminRemovalException extends RuntimeException {

	public AdminRemovalException() {
		this(null);
	}// End of the Constructor

	public AdminRemovalException(String msg) {
		super(msg);
	}// End of the Overloaded Constructor

}// End of the 'AdminRemovalException' class
