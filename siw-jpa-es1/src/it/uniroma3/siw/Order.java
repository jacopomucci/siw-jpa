package it.uniroma3.siw;

import javax.persistence.*;
import java.time.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private LocalDateTime creationTime;
	@ManyToOne(cascade= {CascadeType.PERSIST})
	private Customer customer;
	@OneToMany(mappedBy = "order")
	private List<OrderLine> orderlines;
	
	public Order() {
		
	}
	
	public Order(Customer customer) {
		this.customer = customer;
		this.creationTime = LocalDateTime.now();
		this.orderlines = new ArrayList<OrderLine>();
	}
	
	public void addOrderLine(OrderLine ol) {
		orderlines.add(ol);
	}
	
	
}
