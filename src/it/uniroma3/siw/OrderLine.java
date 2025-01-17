package it.uniroma3.siw;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "order_line")
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private double price;
	private int quantity;
	@ManyToOne
	private Order order;
	@ManyToOne
	private Product product;
	
	
	public OrderLine() {
		
	}
	
	public OrderLine(double price, int quantity, Product product, Order order) {
		this.price = price;
		this.quantity = quantity;
		this.product = product;
		this.order = order;
	}
}
