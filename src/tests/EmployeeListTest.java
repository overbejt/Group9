package tests;

import java.util.Scanner;

import application.EmployeeList;
import model.Attributes;
import model.Employee;

public class EmployeeListTest {
	static Attributes newattribute = new Attributes();
	static EmployeeList newEL = new EmployeeList();
	static boolean end = true;
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		onCreate();
		System.out.println(newEL.getEmployeeList());
//		onRemove();
		System.out.println(newEL.getEmployeeList());
		onDestroy();
		reader.close();
	}// ENd of the 'main' method
	
	/**
	 * This is the method that will create a new
	 * instance of the object that is being
	 * tested.
	 */
	public static void onCreate() {
		boolean end = true;
		Scanner reader = new Scanner(System.in);
		
		while(end) {
			newEL.addEmployee(EmployeeTest.newemplyee);
			System.out.println("Do you want to create more emplyee in the list? please input yes or no");
			String n = reader.nextLine();
			if(n.replaceAll("\\s+","").toLowerCase().equals("yes")) {
				end = false;
			}
		}
		
		reader.close();
	}// End of the 'onCreate' method
	
//	public static void onRemove() {
//		boolean end = true;
//		Scanner reader = new Scanner(System.in);
//		
//		while(end) {
//			System.out.println("please input the name of the emplyee that you want to remove");
//			String n1 = reader.nextLine();
//			if(newEL.getEmployeeList().containsValue(n1)){
//			newEL.removeEmployee(n1);
//			}
//			newEL.removeEmployee(EmployeeTest.newemplyee);
//			System.out.println("Do you want to remove more emplyee in the list? please input yes or no");
//			String n = reader.nextLine();
//			if(n.replaceAll("\\s+","").toLowerCase().equals("yes")) {
//				end = false;
//			}
//		}
//		
//		reader.close();
//	}// End of the 'onCreate' method
	
	/**
	 * This is the method that will assign the
	 * object to null. That way memory can be
	 * freed up.
	 */
	public static void onDestroy() {
		newEL.clearList();
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

}
