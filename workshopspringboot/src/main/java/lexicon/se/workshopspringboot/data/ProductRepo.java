package lexicon.se.workshopspringboot.data;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import lexicon.se.workshopspringboot.entity.Product;


public interface ProductRepo extends CrudRepository<Product, Integer>{

	List<Product> findByProductName(String productName);
	
	
}
