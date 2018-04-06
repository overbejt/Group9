package AbucusExceptions;

/**
 * This is the Exception class that will be thrown whenever someone
 * tries to remove the Admin from the Employee List.
 * 
 * @version 1.0
 */
public class InvalidRemovalException extends RuntimeException {

	public InvalidRemovalException() {
		this(null);
	}// End of the Constructor

	public InvalidRemovalException(String msg) {
		super(msg);
	}// End of the Overloaded Constructor

}// End of the 'InvalidRemovalException' class
