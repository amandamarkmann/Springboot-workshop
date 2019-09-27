package lexicon.se.workshopspringboot.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

	
	private Product testProduct;
	
	
	@Before
	public void setup() {
		
		testProduct = new Product(1, "Coat", 400.00);
		
	}
	
	@Test
	public void testProduct_successfully_created() {
		assertEquals(1, testProduct.getId());
		assertEquals("Coat", testProduct.getName());
		assertEquals(400.00, testProduct.getPrice(), 0);
	}
	
	
	@Test
	public void test_equals_and_hashcode_true() {
		Product copy = new Product(1,"Coat", 400.00);

		assertTrue(copy.equals(testProduct));
		assertEquals(copy.hashCode(), testProduct.hashCode());
		
	}
	
	@Test
	public void test_toString_contains_correct_information() {
		String toString = testProduct.toString();
		
		assertTrue(
				toString.contains("1") &&
				toString.contains("Coat") &&
				toString.contains("400.0")
			);
		
	}
	
	
}
