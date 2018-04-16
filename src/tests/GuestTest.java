package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Guest;


public class GuestTest {
	public static Guest guest;
	
	@BeforeEach
	public void onCreate() throws Exception {
		guest = guest.getGuestInstance();
	}// End of the 'onCreate' method

	@AfterEach
	public void onDestroy() throws Exception {
		guest = null;
	}// End of the 'onDestroy' method

	@Test
	void testItem() throws Exception {
		guest = guest.getGuestInstance();

		assert (true);
	}// End of the 'testItem' method

	@Test
	void Tests() {
		
		assertEquals(guest.getName(), "guest");
		assertEquals(guest.getPassword(), "guest");
		assertEquals(guest.getAccessLevel(), 000);
		assertNotNull(guest.getID());
	}
	
	
}
