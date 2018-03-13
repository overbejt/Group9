package model;

/**
 * This is the class that will hold the attributes of an item.
 * 
 * @version 0.2
 */
public interface AttributesInterface {

	/**
	 * This is the method that allows a user to assert that the item
	 * is shoes
	 */
	public void setShoes(boolean state) throws NullPointerException;

	/**
	 * This is the method that allows a user to assert that the item
	 * is pants
	 */
	public void setPants(boolean state) throws NullPointerException;

	/**
	 * This is the method that allows a user to assert that the item
	 * is a shirt
	 */
	public void setShirts(boolean state) throws NullPointerException;

	/**
	 * This is the method that will allow the user to set the quantity
	 * of an item in inventory.
	 * 
	 * @param amt
	 * @throws java.lang.NumberFormatException
	 */
	public void setQuantity(int amt)
			throws java.lang.NumberFormatException;

	/**
	 * This is the method that will allow the user to set the size of
	 * an item.
	 * 
	 * @param size
	 * @throws java.lang.NumberFormatException
	 */
	public void setSize(int size)
			throws java.lang.NumberFormatException;

	/**
	 * This is the method that will return true if the item is
	 * asserted to be shoes
	 * 
	 * @return
	 */
	public boolean isShoes() throws NullPointerException;

	/**
	 * This is the method that will return true if the item is
	 * asserted to be pants
	 * 
	 * @return
	 */
	public boolean isPants() throws NullPointerException;

	/**
	 * This is the method that will return true if the item is assert
	 * to be a shirt
	 * 
	 * @return
	 */
	public boolean isShirts() throws NullPointerException;

	/**
	 * This is the method that will return the quantity of an item in
	 * an inventory.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public int getQuantity() throws NullPointerException;

	/**
	 * This is the method that will return the size of an item.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	public int getSize() throws NullPointerException;

}// End of the 'AttributesInterface' class
