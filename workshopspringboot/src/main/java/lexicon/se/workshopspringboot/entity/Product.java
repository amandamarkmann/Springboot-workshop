package lexicon.se.workshopspringboot.entity;

import java.util.Objects;

public class Product {

	private int productId;
	
	private String productName;
	
	private double price;

	
	
	public Product(int id, String name, double price) {
		this.productId = id;
		this.productName = name;
		this.price = price;
	}
	
	
	public Product(String name, int price) {
		this(0, name, price);
	}
	
	public Product() {
		
	}
	

	public String getName() {
		return productName;
	}

	public void setName(String name) {
		this.productName = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return productId;
	}


	@Override
	public int hashCode() {
		return Objects.hash(productId, productName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return productId == other.productId && Objects.equals(productName, other.productName);
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(productId);
		builder.append(", name=");
		builder.append(productName);
		builder.append(", price=");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
}
