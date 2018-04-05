package AbucusExceptions;

/**
 * This is the class that will handle the InvalidPasswordException
 * from a user login attempt.
 * 
 * @version 1.0
 */
public class InvalidPasswordException extends RuntimeException {

	public InvalidPasswordException() {
		this(null);
	}// End of the Constructor

	public InvalidPasswordException(String msg) {
		super(msg);
	}// End of the Overloaded Constructor

}// End of the 'InvalidPasswordException' class
