package it.uniroma3.siw;

import javax.persistence.*;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String street;
	@Column(nullable = true)
	private String state;
	private String zipcode;
	private String country;
	
	public Address() {
	
	}
	
	public Address(String street) {
		this.street = street;
	}
	
	
}
