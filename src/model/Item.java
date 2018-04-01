package model;

import java.time.Instant;

/**
 * This is the class that will hold information about each item in the
 * inventory.
 * 
 * @version 0.1
 */
public class Item implements ItemInterface {

	// To store the attributes of this item
	private Attributes	attributes;
	private Instant		id;			// To store the id of this item
	private String		name;		// To store the name of this item

	/**
	 * Constructor
	 */
	public void Item() {
		// Initializing instance variables and objects
		attributes = new Attributes();
		name = "";
		setID();
	}// End of the Constructor

	/**
	 * This is the method that will set an item's name.
	 * 
	 * @param name
	 */
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}// End of the 'setName' method

	/**
	 * This is the method that will assign the attributes to the item.
	 * 
	 * @param attributes
	 */
	@Override
	public void setAttributes(Attributes attributes) {
		// TODO Auto-generated method stub

	}// End of the 'setAttributes' method

	/**
	 * This is the method that will set an item's ID. It will take the
	 * epoch time and store it in a long. This value can never be
	 * changed. It's only purpose is to serve as a key in a hashmap.
	 */
	@Override
	public void setID() {
		// TODO Auto-generated method stub

	}// End of the 'setID' method

	/**
	 * This is the method that will return the item's name.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	@Override
	public String getName() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}// End of the 'getName' method

	/**
	 * This is the method that will return the Attributes object
	 * associated with this item.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	@Override
	public Attributes getAttributes() throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}// End of the 'getAttributes' method

	/**
	 * This is the method that will return the employee's ID number.
	 * It will serve as the key in a hashmap.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	@Override
	public long getID() throws NullPointerException {
		// TODO Auto-generated method stub
		return 0;
	}// End of the 'getID' method

}// End of the 'Item' class
