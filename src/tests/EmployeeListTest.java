package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Attributes;
import model.Employee;
import model.EmployeeList;
import model.Item;
import model.ItemList;

public class EmployeeListTest {
	
	private static EmployeeList newEL = new EmployeeList();
	
	@BeforeEach
	void setUp() throws Exception {
		newEL = new EmployeeList();
	}// End of the 'setUp' method

	@AfterEach
	void tearDown() throws Exception {
		newEL = null;
	}// End of the 'tearDown' method

	@Test
	void testItem() throws Exception {
		newEL = new EmployeeList();

		assert (true);
	}// End of the 'testItem' method
	
	@Test
	void testEmployeeList() {
		assertNotNull(newEL);
	}// End of the 'testItemList' method
	
	@Test
	void testAddEmployee() {
		Employee original = new Employee();
		newEL.addEmployee(original);
		assertEquals(original, newEL.getEmployee(original.getID()));
	}

	@Test
	void testRemoveEmployee() {
		Employee employee = new Employee();
		newEL.addEmployee(employee);
		newEL.removeEmployee(employee.getID());
		boolean isEmpty = newEL.getEmployeeList().isEmpty();
		assertEquals(true, isEmpty);
	}
	
	@Test
	void testGetEmployeeList() {
		Employee employee = new Employee();
		employee.setName("Sanity Check");
		newEL.addEmployee(employee);
		HashMap<Long, Object> sample = newEL.getEmployeeList();
		assertEquals(newEL.getEmployeeList(), sample);
	}
	
	@Test
	void testSetItemList() {
		EmployeeList employeeList = new EmployeeList();
		Employee employee = new Employee();
		employee.setName("Sanity Check");
		employeeList.addEmployee(employee);
		newEL.setEmployeeList(employeeList);
		assertEquals(newEL.getEmployeeList(), employeeList.getEmployeeList());
	}

	@Test
	void testClearList() {
		newEL.clearList();
		boolean expected = true;
		boolean result = newEL.getEmployeeList().isEmpty();
		assertEquals(expected, result);
	}

}
