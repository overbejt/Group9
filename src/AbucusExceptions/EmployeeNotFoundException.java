package AbucusExceptions;

/**
 * This is the class that will handle the EmployeeNotFoundException
 * from trying to access an employee who is not entered into the
 * system.
 * 
 * @version 1.0
 */
public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException() {
		this(null);
	}// End Constructor

	public EmployeeNotFoundException(String msg) {
		super(msg);
	}// End of the Overloaded Constructor

}// End of the 'EmployeeNotFoundException' class
