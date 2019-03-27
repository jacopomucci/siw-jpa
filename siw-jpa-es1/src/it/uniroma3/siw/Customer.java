package it.uniroma3.siw;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.time.*;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private LocalDate dateOfBirth;
	private LocalDate registrationDate;
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;
	@OneToOne
	private Address address;
	
	public Customer() {
		
	}
	
	public Customer(String firstName, String lastName, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.orders = new ArrayList<Order>();
	}
	
	
	public List<Order> getOrders() {
		return this.orders;
	}

	
	
}
