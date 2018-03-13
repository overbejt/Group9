package model;

/**
 * This is the class that will hold the attributes of an item.
 * 
 * @version 0.1
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
	 * This is the method that will send back an integer describing
	 * all of the attributes. 1=true, 0=false. The order will be:
	 * {shoes, pants, shirts}.
	 * 
	 * @return
	 */
	public int getAttributes() throws NullPointerException;

}// End of the 'AttributesInterface' class
