package model;

import java.io.Serializable;
import java.time.Instant;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * This is the class that will hold information about each item in the
 * inventory.
 * 
 * @version 1.1
 */
public class Item implements ItemInterface, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// To store the attributes of this item
	private transient Instant				instant;
	private transient SimpleLongProperty	id;
	// To store the name of this item
	private transient SimpleStringProperty name;
	// eg: Pants, shoes, shirt, etc.
	private transient SimpleStringProperty price;
	// The amount of item in the inventory
	private transient SimpleStringProperty quantity;
	// The size of the item
	private transient SimpleStringProperty size;

	/**
	 * Constructor
	 */
	public Item() {

		// Initializing instance variables and objects
		this.name = new SimpleStringProperty("");
		this.price = new SimpleStringProperty("");
		this.quantity = new SimpleStringProperty("");
		this.size = new SimpleStringProperty("");
		// Getting the instant
		this.instant = Instant.now();
		// Parsing instant to epoch time
		this.id = new SimpleLongProperty(instant.toEpochMilli());

	}// End of the Constructor

	/**
	 * Overloaded Constructor
	 */
	public Item(String name, String price, String quantity,
			String size) {

		// Initializing instance variables with given data
		this.name = new SimpleStringProperty(name);
		this.price = new SimpleStringProperty(price);
		String parsed = parse(quantity);
		this.quantity = new SimpleStringProperty(parsed);
		this.size = new SimpleStringProperty(size);
		// Getting the instant
		this.instant = Instant.now();
		// Parsing the instant to epoch time
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
	public void setPrice(String price) {

		this.price.set(price);

	}// End of the 'setCatagory' method

	/**
	 * This is the method that will set the quantity of an item that
	 * is in the inventory.
	 * 
	 * @param quantity
	 */
	@Override
	public void setQuantity(String quantity) {

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
	 * This is the method that will allow the id to be set. It is
	 * meant to be used when reading non serialized objects from a
	 * file.
	 * 
	 * @param id
	 */
	public void setId(long id) {

		this.id = new SimpleLongProperty(id);

	}// End of the 'setId' method

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
	public String getPrice() throws NullPointerException {

		return this.price.get();

	}// End of the 'getCatagory' method

	/**
	 * This is the method that returns the quantity of the item from
	 * the inventory.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	@Override
	public String getQuantity() throws NullPointerException {

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
		result += " , ";
		result += this.name.get();
		result += " , ";
		result += this.price.get();
		result += " , ";
		result += this.quantity.get();
		result += " , ";
		result += this.size.get();
		result += "]";

		// Sending back the concatenated string
		return result;

	}// End of the 'toString' method

	/**
	 * This is a private helper method that will parse the input into
	 * a string and then return it back
	 * 
	 * @param input
	 * @return
	 */
	private String parse(String input) {

		int value = -1;

		try {
			value = Integer.parseInt(input);
		} catch (Exception err) {

		}

		return Integer.toString(value);

	}// End of the 'parse' method

}// End of the 'Item' class
