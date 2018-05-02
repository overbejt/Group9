package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.GridPane;
import model.Employee;
import model.EmployeeList;

/**
 * This is the class that will handle the removal of Employees
 */
public class RemoveEmployeeDialog {

	// Declaring an instance variable that will be pointed to the
	// Employee List
	private EmployeeList		employeeList;
	private ArrayList<String>	list;
	private ChoiceDialog		dialog;

	// Instance variables
	private GridPane grid;

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Constructor
	public RemoveEmployeeDialog(EmployeeList employeeList) {

		// Initializing the list
		this.employeeList = employeeList;
		this.list = new ArrayList<String>();

		initDialog();// Initializing

	}// End of Constructor

	/**
	 * This is the method that will return the wrapped Dialog object
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ChoiceDialog getRemoveEmployeePopup() {

		return dialog;

	}// End of the 'getRemoveEmployeePopup' method

	private void initDialog() {

		initList();
		dialog = new ChoiceDialog<>(list.get(0), list);
		dialog.setTitle("Remove Employee");
		dialog.setHeaderText(
				"Removal of an Employee will take effect imediately");
		dialog.setContentText("Select an employee to remove");

	}// End of the 'initDialog' method

	private void initList() {

		HashMap map = employeeList.getEmployeeList();

		Set<Entry<String, Object>> entries = map.entrySet();
		// Setting the default option for the drop down
		list.add("-Select an employee-");

		// Needs a way to specify the first name listed!!!

		for (Entry<String, Object> e : entries) {

			// Test for Employee
			if (e.getValue() instanceof Employee) {

				// Only Employees can be added to the list
				Employee tmp = (Employee) e.getValue();
				String name = tmp.getName();
				list.add(name);
			}
		}
	}// End of the 'initList' method

}// End of the 'RemoveEmployeeDialog' class
