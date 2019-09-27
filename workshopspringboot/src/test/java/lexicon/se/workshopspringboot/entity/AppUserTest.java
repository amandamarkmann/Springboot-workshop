package lexicon.se.workshopspringboot.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppUserTest {
	
	
	private AppUser testObject;
	
	@Before
	public void setup() {
		testObject = new AppUser(1, "Test", "Testsson", "test@test.se");
		
		
	}
	
	@Test
	public void testObject_successfully_created() {
		assertEquals(1, testObject.getId());
		assertEquals("Test", testObject.getFirstName());
		assertEquals("Testsson", testObject.getLastName());
		assertEquals("test@test.se", testObject.getEmail());
	}
	
	
	@Test
	public void test_equals_and_hashcode_true() {
		AppUser copy = new AppUser(1, "Test", "Testsson", "test@test.se");
		
		assertTrue(copy.equals(testObject));
		assertEquals(copy.hashCode(), testObject.hashCode());
		
	}
	
	@Test
	public void test_toString_contains_correct_information() {
		String toString = testObject.toString();
		
		assertTrue(
				toString.contains("1") &&
				toString.contains("Test") &&
				toString.contains("Testsson") &&
				toString.contains("test@test.se")
		);
		
	}

}
