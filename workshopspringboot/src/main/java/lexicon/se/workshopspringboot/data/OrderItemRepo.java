package lexicon.se.workshopspringboot.data;

import org.springframework.data.repository.CrudRepository;

import lexicon.se.workshopspringboot.entity.OrderItem;

public interface OrderItemRepo extends CrudRepository<OrderItem, Integer>{
	
	

}
