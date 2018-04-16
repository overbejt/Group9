package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Employee;
import model.EmployeeList;
import model.Persistence;


public class PersistenceTest {
	public static Persistence persistence;
	private static EmployeeList employeeList = new EmployeeList();
	
	@BeforeEach
	public void onCreate() throws Exception {
		persistence = new Persistence();
	}// End of the 'onCreate' method

	@AfterEach
	public void onDestroy() throws Exception {
		persistence = null;
	}// End of the 'onDestroy' method

	@Test
	void testItem() throws Exception {
		persistence = new Persistence();

		assert (true);
	}// End of the 'testItem' method

	@Test
	void Tests() throws IOException, ClassNotFoundException {
		persistence.writeEmployeeList(employeeList);
		persistence.readEmployeeList();
		Employee employee = new Employee();
		employeeList.addEmployee(employee);
		persistence.writeEmployeeList(employeeList);
		persistence.readEmployeeList();
	}
	
	
}
