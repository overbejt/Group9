package tests;

import java.util.Scanner;

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
	static Employee newemplyee = new Employee();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		onCreate();
		System.out.println("Name: " + newemplyee.getName());
		System.out.println("Password: " + newemplyee.getPassword());
		System.out.println("AccessLevel: " + newemplyee.getAccessLevel());
		onDestroy();
	}// ENd of the 'main' method

	/**
	 * This is the method that will create a new
	 * instance of the object that is being
	 * tested.
	 */
	public static void onCreate() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the name of Employee");
		String n = reader.next();
		newemplyee.setName(n);
		System.out.println("Set the password for Emplyee");
		String p = reader.next();
		newemplyee.setPassword(p);
		System.out.println("Set the AccessLevel for Emplyee");
		int a = reader.nextInt();
		newemplyee.setAccessLevel(a);
		reader.close();
	}// End of the 'onCreate' method
	
	/**
	 * This is the method that will assign the
	 * object to null. That way memory can be
	 * freed up.
	 */
	public static void onDestroy() {
		newemplyee = null;
	}// End of the 'onDestroy' method

	/**
	 * This is the method that will handle
	 * printing to the console. It's not
	 * necessary, But I find Java's implementation
	 * to be tedious.
	 * 
	 * @param msg
	 */
	public void print(String msg) {
		System.out.println(msg);
	}// End of the 'print' method

}// End of the 'EmployeeTest' class
