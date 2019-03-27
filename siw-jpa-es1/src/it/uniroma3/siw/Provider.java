package it.uniroma3.siw;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = true) 
	private String phoneNumber;
	private String email;
	private String vatin;
	@Column(nullable = false)
	@ManyToMany
	private List<Product> products;
	@ManyToOne
	private Address address;
	
	
	public Provider() {
		
	}
	
	public Provider(String name, Address address) {
		this.name = name;
		this.address = address;
		this.products = new ArrayList<Product>();
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
