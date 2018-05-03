package model;

public class ItemPopupNode {
	// Declaring instance variables
	private String	itemName;
	private String	size;
	private String	price;
	private String	quantity;

	// Constructor
	public ItemPopupNode() {
		itemName = "";
		size = "";
		price = "";
		quantity = "";
	}// End of Constructor

	// Overloaded Constructor
	public ItemPopupNode(String itemName, String size, String price, String quantity) {
		// Initializing instance variables with data passed through
		this.itemName = itemName;
		this.size = size;
		this.price = price;
		this.quantity = quantity;
	}// End of the Overloaded Constructor

	public String getItemName() {
		return itemName;
	}

	public String getSize() {
		return size;
	}

	public String getPrice() {
		return price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
