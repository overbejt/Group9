package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Item;

/**
 * This is the test case for the Item class. It is using the JUnit 5
 * library and it is the Jupiter version.
 * 
 * @version 1.0
 */
class ItemTest {

	public static Item item;

	@BeforeEach
	public void onCreate() throws Exception {
		item = new Item();
	}// End of the 'onCreate' method

	@AfterEach
	public void onDestroy() throws Exception {
		item = null;
	}// End of the 'onDestroy' method

	@Test
	void testItem() throws Exception {
		item = new Item();

		assert (true);
	}// End of the 'testItem' method

	@Test
	void testSetName() {

		System.out.println("hi");

		// Create a name
		String name = "jeans";
		// Set the name
		item.setName(name);
		// Get the name
		String result = item.getName();
		// Compare the names
		assertEquals(name, result);

	}// End of the 'testSetName' method

	@Test
	void testSetAttributes() {

		/*
		 * I think there is a class in the JUnit5 with the name
		 * 'Attributes'. Because, it will not let me use the
		 * Attributes class in this test.
		 */

		assertNotNull(item.getAttributes());

	}// End of the 'testSetAttributes' method

	@Test
	void testSetID() {

		assertNotNull(item.getID());

	}// End of the 'testSetID' method

	@Test
	void testGetName() {

		// Create a name
		String name = "jeans";
		// Set the name
		item.setName(name);
		// Get the name
		String result = item.getName();
		// Compare the names
		assertEquals(name, result);

	}// End of the 'testGetName' method

	@Test
	void testGetAttributes() {
		fail("Junit will not let me create an Attributes object");
	}// End of the 'testGetAttributes' method

	@Test
	void testGetID() {
		assertNotNull(item.getID());
	}// End of the 'testGetID' method

}// End of the 'ItemTest' class
