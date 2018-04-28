package model;

import java.time.Instant;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * This is the class that will hold information about each item in the
 * inventory.
 * 
 * @version 1.1
 */
public class Item implements ItemInterface {

	// To store the attributes of this item
	private Instant						instant;
	private final SimpleLongProperty	id;
	// To store the name of this item
	private final SimpleStringProperty name;
	// eg: Pants, shoes, shirt, etc.
	private final SimpleStringProperty catagory;
	// The amount of item in the inventory
	private final SimpleIntegerProperty quantity;
	// The size of the item
	private final SimpleStringProperty size;

	/**
	 * Constructor
	 */
	public Item() {
		// Initializing instance variables and objects
		this.name = new SimpleStringProperty("");
		this.catagory = new SimpleStringProperty("");
		this.quantity = new SimpleIntegerProperty(0);
		this.size = new SimpleStringProperty("");
		this.instant = Instant.now();
		this.id = new SimpleLongProperty(instant.toEpochMilli());
	}// End of the Constructor

	/**
	 * Overloaded Constructor
	 */
	public Item(String name, String catagory, int quantity,
			String size) {

		// Initializing instance variables with given data
		this.name = new SimpleStringProperty(name);
		this.catagory = new SimpleStringProperty(catagory);
		this.quantity = new SimpleIntegerProperty(quantity);
		this.size = new SimpleStringProperty(size);
		this.instant = Instant.now();
		this.id = new SimpleLongProperty(instant.toEpochMilli());

	}// End of the overloaded Constructor

	/**
	 * This is the method that will set an item's name.
	 * 
	 * @param name
	 */
	@Override
	public void setName(String name) {

		this.name.set(name);

	}// End of the 'setName' method

	/**
	 * This is the method that will set the category of the Item. For
	 * example, pants, or shorts, or a shirt, etc.
	 * 
	 * @param catagory
	 */
	@Override
	public void setCatagory(String catagory) {

		this.catagory.set(catagory);

	}// End of the 'setCatagory' method

	/**
	 * This is the method that will set the quantity of an item that
	 * is in the inventory.
	 * 
	 * @param quantity
	 */
	@Override
	public void setQuantity(int quantity) {

		this.quantity.set(quantity);

	}// End of the 'setQuantity' method

	/**
	 * This is the method that will set the size of the item.
	 * 
	 * @param size
	 */
	@Override
	public void setSize(String size) {

		this.size.set(size);

	}// End of the 'setSize' method

	/**
	 * This is the method that will return the item's name.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	@Override
	public String getName() throws NullPointerException {

		return this.name.get();

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

		return this.id.get();

	}// End of the 'getID' method

	/**
	 * This is the method that will return the item's category.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	@Override
	public String getCatagory() throws NullPointerException {

		return this.catagory.get();

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

		return this.quantity.get();

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

		return this.size.get();

	}// End of the 'getSize' method

	/**
	 * Overriding the default toString() method. The format will be:
	 * [ID: name: category: quantity: size]
	 */
	public String toString() {

		// Declaring a string to concatenate all of the attributes
		String result = "";

		result += "[";
		result += getID();
		result += " : ";
		result += this.name.get();
		result += " : ";
		result += this.catagory.get();
		result += " : ";
		result += this.quantity.get();
		result += " : ";
		result += this.size.get();
		result += "]";

		// Sending back the concatenated string
		return result;

	}// End of the 'toString' method

}// End of the 'Item' class
