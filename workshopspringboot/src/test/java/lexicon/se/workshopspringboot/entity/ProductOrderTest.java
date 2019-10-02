package lexicon.se.workshopspringboot.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ProductOrderTest {
	
	
	private ProductOrder testProductOrder;
	private AppUser testUser;
	private OrderItem testItem;
	private Product p;
	
	@Before
	public void setup() {
			
		 p = new Product(1, "Coat", 400.0);
		
		 testUser = new AppUser(1, "Test", "Testsson", "test@test.se");
		
		 testItem = new OrderItem(1, 2, p, testProductOrder);
		 
		 testProductOrder = new ProductOrder(1, LocalDateTime.parse("2019-10-01T11:22:30"), new ArrayList<>(), testUser);
	}
	
	@Test
	public void test_productOrder_successfully_created() {
		assertEquals(1, testProductOrder.getProductOrderId());
		assertEquals(LocalDate.parse("2019-10-01"), testProductOrder.getOrderDate());
		assertEquals(LocalTime.parse("11:22:30"), testProductOrder.getOrderHour());
		assertEquals(new ArrayList<>(), testProductOrder.getOrderContent());
		assertEquals(testUser, testProductOrder.getUser());
		
	}
	
	@Test
	public void test_equals_and_hashcode_true() {
		
		ProductOrder copy = new ProductOrder(1, LocalDateTime.parse("2019-10-01T11:22:30"), new ArrayList<>(), testUser);
		
		assertTrue(copy.equals(testProductOrder));
		assertEquals(copy.hashCode(), testProductOrder.hashCode());
		
	}
	
	
	@Test
	public void test_add_and_remove_item_true() {
		
		testProductOrder.addItem(testItem);
		
		int expectedSize = 1;
		int actualSize = testProductOrder.getOrderContent().size();
		
		assertTrue(expectedSize == actualSize);
		assertEquals(expectedSize, actualSize);
		
		
		testProductOrder.removeItem(testItem);
		
		int expectedFinalSize = 0;
		int actualFinalSize = testProductOrder.getOrderContent().size();
		
		assertTrue(expectedFinalSize == actualFinalSize);
		assertEquals(expectedFinalSize, actualFinalSize);
		
	}
	
	
	@Test
	public void test_totalPrice_sum_expected() {
		
		testProductOrder.addItem(testItem);
		
		double expectedTotalPrice = 800.0;
		double actualTotalPrice = testProductOrder.totalPrice();
		
		assertTrue(expectedTotalPrice == actualTotalPrice);
		assertEquals(expectedTotalPrice, actualTotalPrice, 0);
		
	}
}
