package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Employee;

/**
 * I made this class file while in another branch.
 * Then I merged the branch back to the master
 * branch. And now this file is serving as an
 * example of what can be done to make a test
 * class. The results cat either be written in a
 * table, OR, you could program it to write the
 * results to a csv file for excel.
 * 
 * @author Josh Overbeck
 *
 */
public class EmployeeTest {
	public static Employee employee;
	
	@BeforeEach
	public void onCreate() throws Exception {
		employee = new Employee();
	}// End of the 'onCreate' method

	@AfterEach
	public void onDestroy() throws Exception {
		employee = null;
	}// End of the 'onDestroy' method

	@Test
	void testItem() throws Exception {
		employee = new Employee();

		assert (true);
	}// End of the 'testItem' method

	@Test
	void testNameandPassword() {
		System.out.println("Testing if name and password is empty");
		employee.setName("");
		employee.setPassword("");
		assertEquals(employee.getName(), "");
		assertEquals(employee.getPassword(), "");
		System.out.println("Testing if name and password is spacebars");
		employee.setName("          ");
		employee.setPassword("          ");
		assertEquals(employee.getName(), "          ");
		assertEquals(employee.getPassword(), "          ");
		System.out.println("Testing if name and password is !@#%@$%#$789/*-");
		employee.setName("!@#%@$%#$789/*-");
		employee.setPassword("!@#%@$%#$789/*-");
		assertEquals(employee.getName(), "!@#%@$%#$789/*-");
		assertEquals(employee.getPassword(), "!@#%@$%#$789/*-");
		System.out.println("Testing if name and password is null");
		employee.setName(null);
		employee.setPassword(null);
		assertEquals(employee.getName(), null);
		assertEquals(employee.getPassword(), null);
		Assert.fail("Name and password shouldn't been able to set to null");
	}// End of the 'testNameandPassword' method
	
	@Test
	void testAccessLevelandID() {
		System.out.println("Testing if AccessLevel is 0");
		employee.setAccessLevel(0);
		assertEquals(employee.getAccessLevel(), 0);
		System.out.println("Testing if AccessLevel is 1000");
		employee.setAccessLevel(1000);
		assertEquals(employee.getAccessLevel(), 1000);
		System.out.println("Testing if AccessLevel is -50");
		employee.setAccessLevel(-50);
		assertEquals(employee.getAccessLevel(), -50);
		System.out.println("Testing if able to get ID");
		assertNotNull(employee.getID());
	}

}// End of the 'EmployeeTest' class
