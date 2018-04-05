package AbucusExceptions;

/**
 * This is the class that will handle the ItemNotFoundException.
 * 
 * @version 1.0
 */
public class ItemNotFoundException extends RuntimeException {

	public ItemNotFoundException() {
		this(null);
	}// End of the Constructor

	public ItemNotFoundException(String msg) {
		super(msg);
	}// End of the Overloaded Constructor

}// End of the 'ItemNotFoundException' class
