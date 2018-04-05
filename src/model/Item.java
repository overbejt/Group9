package model;

import java.time.Instant;

/**
 * This is the class that will hold information about each item in the
 * inventory.
 * 
 * @version 1.1
 */
public class Item implements ItemInterface {

	// To store the attributes of this item
	private Attributes	attributes;
	private Instant		id;			// To store the id of this item
	private String		name;		// To store the name of this item

	/**
	 * Constructor
	 */
	public Item() {
		// Initializing instance variables and objects
		attributes = new Attributes();
		name = "";
		id = Instant.now();
	}// End of the Constructor

	/**
	 * This is the method that will set an item's name.
	 * 
	 * @param name
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}// End of the 'setName' method

	/**
	 * This is the method that will assign the attributes to the item.
	 * 
	 * @param attributes
	 */
	@Override
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}// End of the 'setAttributes' method

	/**
	 * This is the method that will return the item's name.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	@Override
	public String getName() throws NullPointerException {
		return name;
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
		return attributes;
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
		return this.id.getEpochSecond();
	}// End of the 'getID' method

}// End of the 'Item' class
