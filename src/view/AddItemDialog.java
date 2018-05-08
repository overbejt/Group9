package view;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.ItemPopupNode;

/**
 * This is the class that will handle the dialog pop-up when a user
 * wants to add an item.
 */
public class AddItemDialog {

	// Instance variables
	private GridPane grid;

	private TextField	itemName;
	private TextField	size;
	private TextField	price;
	private TextField	quantity;
	private ButtonType	okDoneBtnType;

	private static Dialog<ItemPopupNode> itemAdded;

	// Constructor
	private AddItemDialog() {
		initDialog();// Initializing
	}// End of Constructor

	/**
	 * This is the method that will return the wrapped TextInputDialog
	 * object
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Dialog getAddItemPopup() {
		new AddItemDialog();
		return itemAdded;
	}

	/**
	 * This is the method that will initialize the grid pane.
	 */
	private void initGridPane() {
		grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(20);
		grid.setPadding(new Insets(20, 150, 10, 10));
	}// End of the 'initGridPane' method1

	/**
	 * This is the method that will initialize the text fields.
	 */
	private void initFields() {
		// Initialize the text fields
		itemName = new TextField();
		size = new TextField();
		price = new TextField();
		quantity = new TextField();
		// Set the prompt texts
		itemName.setPromptText("Item Name");
		size.setPromptText("Size");
		price.setPromptText("Price");
		quantity.setPromptText("Quantity");
	}// End of the 'initFields' method

	/**
	 * This is the method that will initialize the button type for the
	 * Dialog
	 */
	private void initBtnType() {
		okDoneBtnType = new ButtonType("Add Item",
				ButtonData.OK_DONE);

	}// End of the 'initBtnType' method

	/**
	 * This is the method that will initialize the dialog box.
	 */
	private void initDialog() {

		itemAdded = new Dialog<>();
		itemAdded.setTitle("Add/Edit Item");
		itemAdded.setHeaderText("Enter the items properties");

		initBtnType();// Initializing the button
		initGridPane();// Initializing the gridpane
		initFields();// Initializing the Textfields
		assemble();// Putting it all together
	}// End of the 'init' method

	/**
	 * This is the method that will assemble all of the utilities and
	 * layout, and add the to the dialog box.
	 */
	private void assemble() {
		// setStyle();

		// Adding the buttons
		itemAdded.getDialogPane().getButtonTypes()
				.addAll(okDoneBtnType, ButtonType.CANCEL);
		grid.add(itemName, 1, 0);
		grid.add(size, 1, 1);
		grid.add(price, 1, 2);
		grid.add(quantity, 1, 3);
		// Adding children to parent
		itemAdded.getDialogPane().setContent(grid);

		itemAdded.setResultConverter(dialogButton -> {
			if (dialogButton == okDoneBtnType) {
				return new ItemPopupNode(itemName.getText(),
						size.getText(), price.getText(),
						quantity.getText());
			}
			return null;
		});

	}// End of the 'assemble' method

	private void setStyle() {

		// Set the style sheet
		itemAdded.getDialogPane().getStylesheets()
				.add(getClass().getResource("/view/application.css")
						.toExternalForm());

		// Set the background color?
		itemAdded.getDialogPane().getStyleClass().add("myDialog");
	}// End of the 'setStyle' method

	/**
	 * This is the method that will fill the fields with the values of
	 * the selected row from the table view.
	 * 
	 * @param name
	 * @param size
	 * @param price
	 * @param quantity
	 */
	public void setFields(String name, String size, String price,
			int quantity) {

		this.itemName.setText(name);
		this.size.setText(size);
		this.price.setText(price);
		this.quantity.setText(Integer.toString(quantity));

	}// End of the 'setFields' mehtod

}
