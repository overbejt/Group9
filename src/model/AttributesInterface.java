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
	public void setShoes();

	/**
	 * This is the method that allows a user to assert that the item
	 * is pants
	 */
	public void setPants();

	/**
	 * This is the method that allows a user to assert that the item
	 * is a shirt
	 */
	public void setShirts();

	/**
	 * This is the method that will return true if the item is
	 * asserted to be shoes
	 * 
	 * @return
	 */
	public boolean isShoes();

	/**
	 * This is the method that will return true if the item is
	 * asserted to be pants
	 * 
	 * @return
	 */
	public boolean isPants();

	/**
	 * This is the method that will return true if the item is assert
	 * to be a shirt
	 * 
	 * @return
	 */
	public boolean isShirts();

	/**
	 * This is the method that will send back an integer describing
	 * all of the attributes. 1=true, 0=false. The order will be:
	 * {shoes, pants, shirts}.
	 * 
	 * @return
	 */
	public int getAttributes();

}// End of the 'AttributesInterface' class
