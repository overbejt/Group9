package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This is the class that will be responsible for handling all of the
 * persistence of the software.
 * <p>
 * This class should probably also handle saving the Item Inventory
 * </p>
 * 
 * @version 0.1
 */
public class Persistence {

	// Making a file to hold where the EmployeeList will be stored
	private File employeeList = new File("EmployeeList.josh");
	// Making a file to hold where the ItemList will be stored
	private File itemList = new File("ItemList.josh");

	// Creating necessary objects to serialize an object
	private FileOutputStream		fileOutputStream;
	private BufferedOutputStream	bufferedOutputStream;
	private ObjectOutputStream		objectOutputStream;
	// Output objects
	private FileInputStream		fileInputStream;
	private BufferedInputStream	bufferedInputStream;
	private ObjectInputStream	objectInputStream;

	// Constructor
	public Persistence() throws IOException, FileNotFoundException {

	}// End of the Constructor method

	/**
	 * This is the function that will write the EmployeeList to the
	 * file.
	 * 
	 * @param list
	 * @throws IOException
	 */
	public void writeEmployeeList(EmployeeList list)
			throws IOException {

		fileOutputStream = new FileOutputStream(employeeList);
		bufferedOutputStream = new BufferedOutputStream(
				fileOutputStream);
		objectOutputStream = new ObjectOutputStream(
				bufferedOutputStream);

		objectOutputStream.writeObject(list);

		objectOutputStream.close();

	}// End of the 'writeEmployeeList' function

	/**
	 * This is the function that will write the Item List to the file.
	 * 
	 * @param list
	 * @throws IOException
	 */
	public void writeItemList(ItemList list) throws IOException {

		/*
		 * Declaring a print writer and initializing it to write to
		 * the itemList file.
		 */
		PrintWriter writer = new PrintWriter(itemList);

		// Writing the data to the file
		writer.write(list.toString());

		// Closing the print writer to free up the resources
		writer.close();

	}// End of the 'writeItemList' method

	/**
	 * This is the method that will read the EmployeeList from a file.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public EmployeeList readEmployeeList()
			throws ClassNotFoundException, IOException {

		fileInputStream = new FileInputStream(employeeList);
		bufferedInputStream = new BufferedInputStream(
				fileInputStream);
		objectInputStream = new ObjectInputStream(
				bufferedInputStream);

		// Getting the EmployeeList from the file
		EmployeeList list = (EmployeeList) objectInputStream
				.readObject();
		// Closing off the inputStream
		objectInputStream.close();

		// Sending the EmployeeList back
		return list;

	}// End of the 'readEmployeeList' function

	/**
	 * This is the method that will read the Item List from a file.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public ItemList readItemList()
			throws ClassNotFoundException, IOException {

		// Creating an instance of ItemList object
		ItemList list = new ItemList();
		/*
		 * Creating an instance of a scanner and initializing it to
		 * read from the ItemList file
		 */
		Scanner sc = new Scanner(itemList);

		// Getting the data from the file
		String data = sc.nextLine();

		// Closing the scanner to free up resources
		sc.close();

		// Splitting the data up into individual items as an array
		String[] items = data.split("\\]");

		// Loop through all the items in the list
		for (String s : items) {

			// Removing the delimiters
			s = s.replaceAll("\\[", "");
			s = s.replaceAll("\\]", "");
			// Removing any excess white space
			s = s.trim();

			// Handling a special case from testing
			if (s.startsWith(",")) {
				s = s.substring(1);
			}

			/*
			 * Splitting each item into an array as attributes. Index
			 * 0 = id, Index 1 = name, Index 2 = price, Index 3 =
			 * quantity, Index 4 = size
			 */
			String[] attributes = s.split("\\,");

			// Handling the last null item
			try {
				attributes[0] = attributes[0].trim();
				// Parse the id
				long id = Long.parseLong(attributes[0]);
				attributes[1] = attributes[1].trim();
				// Parse the name
				String name = attributes[1];
				attributes[2] = attributes[2].trim();
				// Parse the price
				String price = attributes[2];
				attributes[3] = attributes[3].trim();
				// Parse the quantity
				String quantity = attributes[3];
				attributes[4] = attributes[4].trim();
				// Parse the size
				String size = attributes[4];

				// Declaring a temp Item for adding to the list
				Item item = new Item();
				// Setting the attributes
				item.setId(id);
				item.setName(name);
				item.setPrice(price);
				item.setQuantity(quantity);
				item.setSize(size);

				// Adding the item to the list
				list.addItem(item);

			} catch (Exception err) {
				// The last 'item' in the list will throw an exception
				// because it is empty
			}

		} // end of loop

		// Sending the EmployeeList back
		return list;

	}// End of the 'readItemList' method

	/**
	 * This is the function that will return true if a file containing
	 * the Employee List exists, and false if no file exists. It works
	 * just as if you were to invoke the '.exists()' function on a
	 * File object.
	 * 
	 * @return
	 */
	public boolean employeeListExists() {

		// Send back the result
		return employeeList.exists();

	}// End of the 'employeeListExists' function

	/**
	 * This is the function that will return true if a file containing
	 * the Item List exists, and false if no file exists. It works
	 * just as if you were to invoke the '.exists()' function on a
	 * File object.
	 * 
	 * @return
	 */
	public boolean itemListExists() {

		return itemList.exists();

	}// End of the 'itemListExists' method

}// End of the 'Persistence' class
