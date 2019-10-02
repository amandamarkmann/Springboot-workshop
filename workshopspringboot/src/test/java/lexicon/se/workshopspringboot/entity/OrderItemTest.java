package lexicon.se.workshopspringboot.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

public class OrderItemTest {
	
	
	private OrderItem testOrderItem;
	
	private Product p;
	
	private ProductOrder po;
	
	@Before
	public void setup() {
		
		p = new Product(1, "Coat", 400.0);
		
		po = new ProductOrder(0, LocalDateTime.now(), null, null);
		
		testOrderItem = new OrderItem(1, 4, p, po);
		
	}
	
	
	@Test
	public void testOrderItem_successfully_created() {
		assertEquals(1, testOrderItem.getId());
		assertEquals(4, testOrderItem.getQuantity());
		assertNotNull(testOrderItem.getProduct());
		assertNotNull(testOrderItem.getProductOrder());
	
	}
	
	@Test
	public void test_equals_and_hashcode_true() {
		
		OrderItem copy = new OrderItem(1,4, p, po);
		
		assertTrue(copy.equals(testOrderItem));
		assertEquals(copy.hashCode(), testOrderItem.hashCode());
	}
	
	
	
	@Test
	public void test_calculatePrice_expected_1600() {
		
		double expectedPrice = 1600;
		double actualPrice = testOrderItem.calculatePrice();
		
		assertTrue(expectedPrice == actualPrice);
		assertEquals(expectedPrice, actualPrice, 0);
	}
}