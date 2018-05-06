package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

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

	// The inventory will be stored in a hashmap
	private static HashMap<Long, Item>	list;
	private ObservableMap<Long, Item>	map;

	// Constructor
	public ItemList() {

		// Initializing the item list
		list = new HashMap<Long, Item>();
		map = FXCollections.observableMap(list);

	}// End of the Constructor

	/**
	 * This is the method that will allow you to add a new Item to the
	 * inventory list.
	 * 
	 * @param newItem
	 *            The new item to be added to the inventory
	 */
	public void addItem(Item newItem) {

		map.put(newItem.getID(), newItem);

	}// End of the 'addItem' method

	/**
	 * This is the method that will remove an item from the inventory.
	 * 
	 * @param id
	 *            The id of the item to be removed from the inventory
	 */
	public void removeItem(Long id) {

		map.remove(id);

	}// End of the 'removeItem' method

	/**
	 * This is the method that will retrieve the requested item from
	 * the inventory.
	 * 
	 * @param id
	 *            The ID of the item requested
	 * @return The requested item
	 */
	public Item getItem(Long id) {

		return map.get(id);

	}// End of the 'getItem' method

	/**
	 * This is the method that will return the Item list. It will be
	 * in the form of a HashMap. It can be used for sorting methods.
	 * 
	 * @return The item list
	 */
	public ObservableMap<Long, Item> getItemList() {

		return this.map;

	}// End of the 'getItemList' method

	/**
	 * This is the method that allows you to set the item list. It
	 * takes in a HashMap object. It can be used to point this
	 * ItemList to an already existing one.
	 * 
	 * @param inList
	 */
	public void setItemList(ObservableMap<Long, Item> inList) {

		this.map = inList;

	}// End of the 'setItemList' method

	/**
	 * This is the method that will clear the list of all items.
	 */
	public void clearList() {

		map.clear();

	}// End of the 'clearList' method

	/**
	 * This is the method that will concatenate all of the items in
	 * the Item List and return them as a string.
	 * 
	 * @return
	 */
	public String show() {

		// Declare instance of String to hold concatenation
		String result = "";

		// Get Entry set
		Set<Entry<Long, Item>> entries = map.entrySet();

		result += "(";

		// Loop through all entries in the inventory
		for (Entry<Long, Item> e : entries) {

			// Concatenate
			result += e.getValue().toString();
			result += ", ";

		}

		result += ")";

		// Send the concatenated string back
		return result;

	}// End of the 'show' method

	/**
	 * This is the method that will override the toString() method
	 * from java.lang. It will also be used to generate a csv file of
	 * the inventory.
	 */
	public String toString() {

		// Declare instance of String to hold concatenation
		String result = "";

		// Get Entry set
		Set<Entry<Long, Item>> entries = map.entrySet();

		// result += "(";

		// Loop through all entries in the inventory
		for (Entry<Long, Item> e : entries) {

			// Concatenate
			result += e.getValue().toString();
			result += "\n";

		}

		// result += ")";

		// Send the concatenated string back
		return result;

	}// End of the 'toString' method

}// End of the 'ItemList' class
