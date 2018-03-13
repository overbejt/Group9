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

import application.EmployeeList;

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
	private File employeeList = new File("EmployeeList.txt");

	// Creating necessary objects to serialize an object
	private FileOutputStream		listOutput;
	private BufferedOutputStream	bufferOut;
	private ObjectOutputStream		outputFile;
	// Output objects
	private FileInputStream		employeeListStream;
	private BufferedInputStream	bufferIn;
	private ObjectInputStream	inputFile;

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
	void writeEmployeeList(EmployeeList list) throws IOException {

		listOutput = new FileOutputStream(employeeList);
		bufferOut = new BufferedOutputStream(listOutput);
		outputFile = new ObjectOutputStream(bufferOut);

		outputFile.writeObject(list);

		outputFile.close();

	}// End of the 'writeEmployeeList' function

	/**
	 * This is the function that will read the EmployeeList from a
	 * file.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private EmployeeList readEmployeeList()
			throws ClassNotFoundException, IOException {

		employeeListStream = new FileInputStream(employeeList);
		bufferIn = new BufferedInputStream(employeeListStream);
		inputFile = new ObjectInputStream(bufferIn);

		// Getting the EmployeeList from the file
		EmployeeList list = (EmployeeList) inputFile.readObject();
		// Closing off the inputStream
		inputFile.close();

		// Sending the EmployeeList back
		return list;

	}// End of the 'readEmployeeList' function

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

}// End of the 'Persistence' class
