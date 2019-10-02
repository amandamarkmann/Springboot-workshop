package lexicon.se.workshopspringboot.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;


public class ProductOrder {
	
	private int productOrderId;
	private LocalDate orderDate;
	private LocalTime orderHour;
	private List <OrderItem> orderContent;
	private AppUser user;
	
	
	public ProductOrder(int productOrderId, LocalDateTime orderTime, List<OrderItem> orderContent, AppUser user) {
		this.productOrderId = productOrderId;
		this.orderDate = orderTime.toLocalDate();
		this.orderHour = orderTime.toLocalTime();
		this.orderContent = orderContent;
		this.user = user;
	}


	public ProductOrder(LocalDate orderDate, LocalTime orderHour, List<OrderItem> orderContent, AppUser user) {
		this.orderDate = orderDate;
		this.orderHour = orderHour;
		this.orderContent = orderContent;
		this.user = user;
	}


	public int getProductOrderId() {
		return productOrderId;
	}


	public void setProductOrderId(int productOrderId) {
		this.productOrderId = productOrderId;
	}


	public List<OrderItem> getOrderContent() {
		return orderContent;
	}


	public void setOrderContent(List<OrderItem> orderContent) {
		this.orderContent = orderContent;
	}


	public LocalDate getOrderDate() {
		return orderDate;
	}


	public LocalTime getOrderHour() {
		return orderHour;
	}


	public AppUser getUser() {
		return user;
	}


	
	public void addItem(OrderItem item) {
		if(!orderContent.contains(item)) {
			orderContent.add(item);
			item.setProductOrder(this);
		} else {
			throw new IllegalArgumentException("Could not add: " + item);
		}
	}
	
	public void removeItem(OrderItem item) {
		if(orderContent.contains(item)) {
			orderContent.remove(item);
			item.setProductOrder(null);
		}else {
			throw new IllegalArgumentException("Could not remove: " + item);
		}
	}
	
	
	public double totalPrice() {
//		double total = 0;
//		for(OrderItem item : orderContent) {
//			total = total + item.calculatePrice();
//		}
//		return total;
		
		return orderContent.stream()
				.mapToDouble(OrderItem::calculatePrice)
				.sum();
				
	}


	@Override
	public int hashCode() {
		return Objects.hash(orderDate, orderHour, productOrderId, user);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductOrder other = (ProductOrder) obj;
		return Objects.equals(orderDate, other.orderDate) && Objects.equals(orderHour, other.orderHour)
				&& productOrderId == other.productOrderId && Objects.equals(user, other.user);
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductOrder [productOrderId=");
		builder.append(productOrderId);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", orderHour=");
		builder.append(orderHour);
		builder.append(", orderContent=");
		builder.append(orderContent);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}
	
	
}
