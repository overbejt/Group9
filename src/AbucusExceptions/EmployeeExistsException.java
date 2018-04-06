package AbucusExceptions;

/**
 * This is the Exception class that will be thrown when attempting to
 * add an employee to the list that already exists.
 * 
 * @version 1.0
 */
public class EmployeeExistsException extends RuntimeException {

	public EmployeeExistsException() {
		this(null);
	}// End of the Constructor

	public EmployeeExistsException(String msg) {
		super(msg);
	}// End of the Overloaded Constructor

}// End of the 'EmployeeExistsException' class
