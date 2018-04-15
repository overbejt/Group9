package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Attributes;
import model.Item;

/**
 * This is the test case for the Item class. It is using the JUnit 5
 * library and it is the Jupiter version.
 * 
 * @version 1.0
 */
public class AttributesTest {

	public static Attributes newattribute;
	
	@BeforeEach
	public void onCreate() throws Exception {
		newattribute = new Attributes();
	}// End of the 'onCreate' method

	@AfterEach
	public void onDestroy() throws Exception {
		newattribute = null;
	}// End of the 'onDestroy' method

	@Test
	void testItem() throws Exception {
		newattribute = new Attributes();

		assert (true);
	}// End of the 'testItem' method

	@Test
	void testvariables() {
		System.out.println("Testing seters and geters");
		newattribute.setShoes(true);
		newattribute.setPants(true);
		newattribute.setShirts(true);
		boolean resultShoes = newattribute.isShoes();
		boolean resultPants = newattribute.isPants();
		boolean resultShirts = newattribute.isShirts();
		assertEquals(resultShoes, true);
		assertEquals(resultPants, true);
		assertEquals(resultShirts, true);
		newattribute.setShoes(false);
		newattribute.setPants(false);
		newattribute.setShirts(false);
		resultShoes = newattribute.isShoes();
		resultPants = newattribute.isPants();
		resultShirts = newattribute.isShirts();
		assertEquals(resultShoes, false);
		assertEquals(resultPants, false);
		assertEquals(resultShirts, false);
		System.out.println("Testing set Quantity and Size to 10");
		newattribute.setQuantity(10);
		newattribute.setSize(10);
		assertEquals(newattribute.getQuantity(), 10);
		assertEquals(newattribute.getSize(), 10);
		System.out.println("Testing set Quantity and Size to 0");
		newattribute.setQuantity(0);
		newattribute.setSize(0);
		assertEquals(newattribute.getQuantity(), 0);
		assertEquals(newattribute.getSize(), 0);
		System.out.println("Testing set Quantity and Size to -10");
		newattribute.setQuantity(-10);
		newattribute.setSize(-10);
		assertEquals(newattribute.getQuantity(), -10);
		assertEquals(newattribute.getSize(), -10);
	}// End of the 'testvariables' method


}
