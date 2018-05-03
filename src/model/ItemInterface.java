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
	 * This is the method that will set the category of the Item. For
	 * example, pants, or shorts, or a shirt, etc.
	 * 
	 * @param catagory
	 */
	public void setPrice(String price);

	/**
	 * This is the method that will set the quantity of an item that
	 * is in the inventory.
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity);

	/**
	 * This is the method that will set the size of the item.
	 * 
	 * @param size
	 */
	public void setSize(String size);

	/**
	 * This is the method that will return the item's name.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public String getName() throws NullPointerException;

	/**
	 * This is the method that will return the item's category.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public String getPrice() throws NullPointerException;

	/**
	 * This is the method that returns the quantity of the item from
	 * the inventory.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public int getQuantity() throws NullPointerException;

	/**
	 * This is the method that returns the size of the item. Ex: S, M,
	 * L, XL, XXL.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public String getSize() throws NullPointerException;

	/**
	 * This is the method that will return the employee's ID number.
	 * It will serve as the key in a hashmap.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public long getID() throws NullPointerException;

}// End of the 'ItemInterface' class
