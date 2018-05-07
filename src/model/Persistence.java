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
		//
		// fileOutputStream = new FileOutputStream(itemList);
		//
		// bufferedOutputStream = new BufferedOutputStream(
		// fileOutputStream);
		//
		// objectOutputStream = new ObjectOutputStream(
		// bufferedOutputStream);
		//
		// objectOutputStream.writeObject(list);
		//
		// // Get Entry set
		// Set<Entry<Long, Item>> entries = list.getItemList()
		// .entrySet();
		//
		// // Loop through the list
		// for (Entry<Long, Item> e : entries) {
		// // Write the id
		// objectOutputStream.writeLong(e.getValue().getID());
		// }
		//
		// objectOutputStream.close();

		PrintWriter writer = new PrintWriter(itemList);

		writer.write(list.toString());
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

		// fileInputStream = new FileInputStream(itemList);
		// bufferedInputStream = new BufferedInputStream(
		// fileInputStream);
		// objectInputStream = new ObjectInputStream(
		// bufferedInputStream);
		//
		// // Getting the EmployeeList from the file
		// ItemList list = (ItemList) objectInputStream.readObject();
		// // Closing off the inputStream
		// objectInputStream.close();

		ItemList list = new ItemList();

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
