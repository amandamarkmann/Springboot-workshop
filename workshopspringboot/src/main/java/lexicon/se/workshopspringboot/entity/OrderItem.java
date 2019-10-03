package lexicon.se.workshopspringboot.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
	
	private int quantity;
	
	@ManyToOne(fetch = FetchType.EAGER, 
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	
	private ProductOrder productOrder;

	public OrderItem(int id, int quantity, Product product, ProductOrder productOrder) {
		this.orderItemId = id;
		this.quantity = quantity;
		this.product = product;
		this.productOrder = productOrder;
	}
	
	
	public OrderItem(int quantity, Product product, ProductOrder productOrder) {
	this(0, quantity, product, null);
	}

	public OrderItem() {
		
	}
	
	
	public double calculatePrice() {
		
		return product.getPrice() * quantity;
	}
	
	
	
	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public ProductOrder getProductOrder() {
		return productOrder;
	}


	public void setProductOrder(ProductOrder productOrder) {
		this.productOrder = productOrder;
	}


	public int getId() {
		return orderItemId;
	}


	


	@Override
	public int hashCode() {
		return Objects.hash(orderItemId, quantity);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return orderItemId == other.orderItemId && quantity == other.quantity;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderItem [id=");
		builder.append(orderItemId);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", product=");
		builder.append(product);
		builder.append("]");
		return builder.toString();
	}
	
	
}
