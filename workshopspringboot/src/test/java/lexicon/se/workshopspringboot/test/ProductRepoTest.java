package lexicon.se.workshopspringboot.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;

import java.util.List;

import lexicon.se.workshopspringboot.data.ProductRepo;
import lexicon.se.workshopspringboot.entity.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ProductRepoTest {

	
	@Autowired
	private ProductRepo testObject;
	private Product testProduct;
	
	
	@Before
	public void setup() {
		Product product = new Product("Coat", 200.00);
		testProduct = testObject.save(product);
	}
	
	@Test
	public void test_product_save_succesfull() {
		
		assertNotNull(testProduct);
		assertTrue(testProduct.getId() !=0);
		assertEquals("Coat", testProduct.getName());
		assertEquals(200.00, testProduct.getPrice(),0);
		
	}
	
	
	@Test
	public void product_name_should_return_list() {
		String productName = "Coat";
		List<Product> result = testObject.findByProductName(productName);
		
		assertEquals(1, result.size());
	}
	
}
