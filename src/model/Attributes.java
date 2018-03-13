package model;

/**
 * This is the class that will hold all of the attributes of an item.
 * 
 * @version 0.2
 */
public class Attributes implements AttributesInterface {

	// Instance variables
	private boolean	shoes, pants, shirts;
	private int		quantity, size;

	public Attributes() {
		this.shoes = false;
		this.pants = false;
		this.shirts = false;
		this.quantity = 0;
		this.size = 0;
	}// End of the Constructor

	/**
	 * This is the method that allows a user to assert that the item
	 * is shoes
	 */
	@Override
	public void setShoes(boolean state) {
		this.shoes = state;
	}// End of the 'setShoes' method

	/**
	 * This is the method that allows a user to assert that the item
	 * is pants
	 */
	@Override
	public void setPants(boolean state) {
		this.pants = state;

	}// End of the 'setPants' method

	/**
	 * This is the method that allows a user to assert that the item
	 * is a shirt
	 */
	@Override
	public void setShirts(boolean state) {
		this.shirts = state;

	}// End of the 'setShirts' method

	/**
	 * This is the method that will return true if the item is
	 * asserted to be shoes
	 * 
	 * @return
	 */
	@Override
	public boolean isShoes() {
		return this.shoes;
	}// End of the 'isShoes' method

	/**
	 * This is the method that will return true if the item is
	 * asserted to be pants
	 * 
	 * @return
	 */
	@Override
	public boolean isPants() {
		return this.pants;
	}// End of the 'isPants' method

	/**
	 * This is the method that will return true if the item is assert
	 * to be a shirt
	 * 
	 * @return
	 */
	@Override
	public boolean isShirts() {
		return this.shirts;
	}// End of the 'isShirts' method

	/**
	 * This is the method that will allow the user to set the quantity
	 * of an item in inventory.
	 * 
	 * @param amt
	 * @throws java.lang.NumberFormatException
	 */
	@Override
	public void setQuantity(int amt) throws NumberFormatException {
		this.quantity = amt;
	}

	/**
	 * This is the method that will allow the user to set the size of
	 * an item.
	 * 
	 * @param size
	 * @throws java.lang.NumberFormatException
	 */
	@Override
	public void setSize(int size) throws NumberFormatException {
		this.size = size;

	}

	/**
	 * This is the method that will return the quantity of an item in
	 * an inventory.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	@Override
	public int getQuantity() throws NullPointerException {

		return this.quantity;
	}

	/**
	 * This is the method that will return the size of an item.
	 * 
	 * @return
	 * @throws NullPointerException
	 */
	@Override
	public int getSize() throws NullPointerException {

		return this.size;
	}

}// End of the 'Attributes' class
