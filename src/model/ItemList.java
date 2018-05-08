package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is going to be the class that will store the inventory.
 * 
 * @version 0.1
 */
public class ItemList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1359781794835268746L;

	// Declaring an instance of an array list
	private ArrayList<Item> list;

	// Constructor
	public ItemList() {

		// Initializing the item list
		list = new ArrayList<Item>();

	}// End of the Constructor

	/**
	 * This is the method that will allow you to add a new Item to the
	 * inventory list.
	 * 
	 * @param newItem
	 *            The new item to be added to the inventory
	 */
	public void addItem(Item newItem) {

		list.add(newItem);

	}// End of the 'addItem' method

	/**
	 * This is the method that will remove an item from the inventory.
	 * 
	 * @param id
	 *            The id of the item to be removed from the inventory
	 */
	public void removeItem(long id) {

		for (Item i : list) {
			if (i.getID() == id) {
				list.remove(i);
			}
		}

	}// End of the 'removeItem' method

	/**
	 * This is the method that will retrieve the requested item from
	 * the inventory.
	 * 
	 * @param id
	 *            The ID of the item requested
	 * @return The requested item
	 */
	public Item getItem(long id) {

		Item result = new Item();

		for (Item i : list) {
			if (i.getID() == id) {
				result = i;
			}
		}

		return result;

	}// End of the 'getItem' method

	/**
	 * This is the method that will return the Item list. It will be
	 * in the form of a ArrayList.
	 * 
	 * @return The item list
	 */
	public ArrayList<Item> getItemList() {

		return this.list;

	}// End of the 'getItemList' method

	/**
	 * This is the method that allows you to set the item list. It
	 * takes in a ArrayList object. It can be used to point this
	 * ItemList to an already existing one.
	 * 
	 * @param inList
	 */
	public void setItemList(ArrayList<Item> inList) {

		this.list = inList;

	}// End of the 'setItemList' method

	/**
	 * This is the method that will clear the list of all items.
	 */
	public void clearList() {

		list.clear();

	}// End of the 'clearList' method

	/**
	 * This is the method that will concatenate all of the items in
	 * the Item List and return them as a string. This is a
	 * depreciated method. There is a method that overrides the
	 * toString() method from the Java.lang class
	 * 
	 * @return
	 */
	public String show() {

		// Declare instance of String to hold concatenation
		String result = "";

		result += "(";

		// Loop through the item list
		for (Item i : list) {

			// Concatenate
			result += i.toString();
			result += ", ";

		}

		result += ")";

		// Send the concatenated string back
		return result;

	}// End of the 'show' method

	/**
	 * This is the method that will override the toString() method
	 * from java.lang. It will also be used to generate a csv file of
	 * the inventory in a later version.
	 */
	public String toString() {

		// Declare instance of String to hold concatenation
		String result = "";

		// Loop through the item list
		for (Item i : list) {

			// Concatenate
			result += i.toString();
			result += ", ";

		}

		// Send the concatenated string back
		return result;

	}// End of the 'toString' method

}// End of the 'ItemList' class
