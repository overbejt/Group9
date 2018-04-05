package AbucusExceptions;

/**
 * This is the Class that will handle invalid access level exception
 * from the Employee class.
 * 
 * @version 1.0
 */
public class InvalidAccessLevelException extends RuntimeException {

	public InvalidAccessLevelException() {
		this(null);
	}// End of Constructor

	public InvalidAccessLevelException(String msg) {
		super(msg);
	}// End of the Overloaded Constructor

}// End of the 'InvalidAccessLevelException'
