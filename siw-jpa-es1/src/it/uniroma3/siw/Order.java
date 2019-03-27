package it.uniroma3.siw;

import javax.persistence.*;
import java.time.*;

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
