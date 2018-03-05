package model;

/**
 * This is the class that will hold all of the attributes of an item.
 * 
 * @version 0.1
 */
public class Attributes implements AttributesInterface {

	// Instance variables
	protected boolean shoes, pants, shirts;

	public Attributes() {

	}// End of the Constructor

	/**
	 * This is the method that allows a user to assert that the item
	 * is shoes
	 */
	@Override
	public void setShoes() {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the method that allows a user to assert that the item
	 * is pants
	 */
	@Override
	public void setPants() {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the method that allows a user to assert that the item
	 * is a shirt
	 */
	@Override
	public void setShirts() {
		// TODO Auto-generated method stub

	}

	/**
	 * This is the method that will return true if the item is
	 * asserted to be shoes
	 * 
	 * @return
	 */
	@Override
	public boolean isShoes() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * This is the method that will return true if the item is
	 * asserted to be pants
	 * 
	 * @return
	 */
	@Override
	public boolean isPants() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * This is the method that will return true if the item is assert
	 * to be a shirt
	 * 
	 * @return
	 */
	@Override
	public boolean isShirts() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * This is the method that will send back an integer describing
	 * all of the attributes. 1=true, 0=false. The order will be:
	 * {shoes, pants, shirts}.
	 * 
	 * @return
	 */
	@Override
	public int getAttributes() {
		// TODO Auto-generated method stub
		return 0;
	}

}// End of the 'Attributes' class
