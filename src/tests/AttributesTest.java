package tests;

import java.util.Scanner;

import model.Attributes;

public class AttributesTest {
	
	static Attributes newattribute = new Attributes();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		onCreate();
		System.out.println("Quantity: " + newattribute.getQuantity());
		System.out.println("Size: " + newattribute.getSize());
		System.out.println("is Shoes? " + newattribute.isShoes() );
		System.out.println("is Shirts? " + newattribute.isShirts() );
		System.out.println("is Pants? " + newattribute.isPants() );
		onDestroy();
	}// ENd of the 'main' method
	
	/**
	 * This is the method that will create a new
	 * instance of the object that is being
	 * tested.
	 */
	public static void onCreate() {
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Is the product shoes, pants or shirts? ");
		String n = reader.nextLine();
		if(n.replaceAll("\\s+","").toLowerCase().equals("shoes")) {
			newattribute.setShoes(true);
		}
		if(n.replaceAll("\\s+","").toLowerCase().equals("pants")) {
			newattribute.setPants(true);
		}
		if(n.replaceAll("\\s+","").toLowerCase().equals("shirts")) {
			newattribute.setShirts(true);
		}
		
		System.out.println("Set the quantity");
		int a = reader.nextInt();
		newattribute.setQuantity(a);
		
		System.out.println("Set the size");
		int a1 = reader.nextInt();
		newattribute.setSize(a1);
		
		reader.close();
	}// End of the 'onCreate' method
	
	/**
	 * This is the method that will assign the
	 * object to null. That way memory can be
	 * freed up.
	 */
	public static void onDestroy() {
		newattribute = null;
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
