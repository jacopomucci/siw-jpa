package it.uniroma3.siw;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@NamedQuery(name = "findAllProducts", query = "SELECT p FROM Product p")

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String name;
	private double price;
	@Column(length = 2000)
	private String description;
	@Column(nullable = false)
	private String code;
	@ManyToMany(mappedBy = "products")
	private List<Provider> providers;
	
	
	public Product() {
		
	}
	
	public Product(String name, double price, String description, String code) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.code = code;
		this.providers = new ArrayList<Provider>();
	}
	
	public long getId() {
		return id;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	public boolean equals(Object obj) {
		Product product = (Product)obj;
		return this.getCode().equals(product.getCode());
	}
	
	public int hashCode() {
		return this.code.hashCode();
	}
	
	
}
