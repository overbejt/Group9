package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Item;
import model.ItemList;

/**
 * This is the Test case for the ItemList class.
 * 
 * @version 1.0
 */

class ItemListTest {

	// Instance of ItemList object with greatest scope
	private static ItemList list;

	@BeforeEach
	void setUp() throws Exception {
		list = new ItemList();
	}// End of the 'setUp' method

	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}// End of the 'tearDown' method

	@Test
	void testItemList() {
		assertNotNull(list);
	}// End of the 'testItemList' method

	@Test
	void testAddItem() {
		Item original = new Item();
		list.addItem(original);
		assertEquals(original, list.getItem(original.getID()));
	}// End of the 'testAddItem' method

	@Test
	void testRemoveItem() {
		Item item = new Item();
		list.addItem(item);
		list.removeItem(item.getID());
		boolean isEmpty = list.getItemList().isEmpty();
		assertEquals(true, isEmpty);
	}// End of the 'testRemoveItem' method

	@Test
	void testGetItem() {
		Item original = new Item();
		list.addItem(original);
		Item sample = list.getItem(original.getID());
		assertEquals(original, sample);
	}// End of the 'testGetItem' method

	@Test
	void testGetItemList() {
		// To prevent null list
		Item item = new Item();
		item.setName("Sanity Check");

		list.addItem(item);
		HashMap<Long, Item> sample = list.getItemList();
		assertEquals(list.getItemList(), sample);
	}// End of the 'testGetItemList' method

	@Test
	void testSetItemList() {
		HashMap<Long, Item> sample = new HashMap();
		list.setItemList(sample);
		assertEquals(sample, list.getItemList());
	}// End of the 'testSetItemList' method

	@Test
	void testClearList() {
		list.clearList();
		boolean expected = true;
		boolean result = list.getItemList().isEmpty();
		assertEquals(expected, result);
	}// End of the 'testClearList' method

}// End of the 'ItemListTest' class
