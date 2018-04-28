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
	private Instant	id;			// To store the id of this item
	private String	name;		// To store the name of this item
	private String	catagory;	// eg: Pants, shoes, shirt, etc.
	private int		quantity;	// The amount of item in the inventory
	private String	size;		// The size of the item

	/**
	 * Constructor
	 */
	public Item() {
		// Initializing instance variables and objects
		this.name = "";
		this.catagory = "";
		this.quantity = 0;
		this.size = "";
		id = Instant.now();
	}// End of the Constructor

	/**
	 * Overloaded Constructor
	 */
	public Item(String name, String catagory, int quantity,
			String size) {
		// Initializing instance variables with given data
		this.name = name;
		this.catagory = catagory;
		this.quantity = quantity;
		this.size = size;
		id = Instant.now();
	}// End of the overloaded Constructor

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
	 * This is the method that will set the category of the Item. For
	 * example, pants, or shorts, or a shirt, etc.
	 * 
	 * @param catagory
	 */
	@Override
	public void setCatagory(String catagory) {

		this.catagory = catagory;

	}// End of the 'setCatagory' method

	/**
	 * This is the method that will set the quantity of an item that
	 * is in the inventory.
	 * 
	 * @param quantity
	 */
	@Override
	public void setQuantity(int quantity) {

		this.quantity = quantity;

	}// End of the 'setQuantity' method

	/**
	 * This is the method that will set the size of the item.
	 * 
	 * @param size
	 */
	@Override
	public void setSize(String size) {

		this.size = size;

	}// End of the 'setSize' method

	/**
	 * This is the method that will return the item's name.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	@Override
	public String getName() throws NullPointerException {

		return this.name;

	}// End of the 'getName' method

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

	/**
	 * This is the method that will return the item's category.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	@Override
	public String getCatagory() throws NullPointerException {

		return this.catagory;

	}// End of the 'getCatagory' method

	/**
	 * This is the method that returns the quantity of the item from
	 * the inventory.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	@Override
	public int getQuantity() throws NullPointerException {

		return this.quantity;

	}// End of the 'getQuantity' method

	/**
	 * This is the method that returns the size of the item. Ex: S, M,
	 * L, XL, XXL.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	@Override
	public String getSize() throws NullPointerException {

		return this.size;

	}// End of the 'getSize' method

}// End of the 'Item' class
