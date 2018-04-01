package model;

/**
 * This is the interface that will be implemented by the Item class.
 * 
 * @version 0.1
 */
public interface ItemInterface {

	/**
	 * This is the method that will set an item's name.
	 * 
	 * @param name
	 */
	public void setName(String name);

	/**
	 * This is the method that will assign the attributes to the item.
	 * 
	 * @param attributes
	 */
	public void setAttributes(Attributes attributes);

	/**
	 * This is the method that will set an item's ID. It will take the
	 * epoch time and store it in a long. This value can never be
	 * changed. It's only purpose is to serve as a key in a hashmap.
	 */
	public void setID();

	/**
	 * This is the method that will return the item's name.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public String getName() throws NullPointerException;

	/**
	 * This is the method that will return the Attributes object
	 * associated with this item.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public Attributes getAttributes() throws NullPointerException;

	/**
	 * This is the method that will return the employee's ID number.
	 * It will serve as the key in a hashmap.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public long getID() throws NullPointerException;

}// End of the 'ItemInterface' class
