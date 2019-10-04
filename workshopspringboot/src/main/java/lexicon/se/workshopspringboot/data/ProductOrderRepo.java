package lexicon.se.workshopspringboot.data;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.repository.CrudRepository;

import lexicon.se.workshopspringboot.entity.ProductOrder;

public interface ProductOrderRepo extends CrudRepository<ProductOrder, Integer>{

	List<ProductOrder> findByOrderDate(LocalDate orderDate);
	
	List<ProductOrder> findByOrderContentProductProductId(int productId);
	
	List<ProductOrder> findByOrderContentProductProductName(String productName);
	
	List<ProductOrder> findByUserUserId(int userId);
	
	
}


//i. Add functionality to find ProductOrders by DATE. Refactoring may be
//needed.
//ii. Add functionality to find ProductOrders by productid (in Product).
//iii. Add functionality to find ProductOrders by productName (in Product).
//iv. Add functionality to find ProductOrders by AppUser id.
//v. Integration test your class / interface for code YOU wrote.
//vi. Commit.