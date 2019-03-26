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
	@ManyToOne
	private Customer customer;
	
	
	public Order(Customer customer) {
		this.customer = customer;
	}
	
}
