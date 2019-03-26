package products;

import javax.persistence.*;

@Entity
@Table(name = "products_table")
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
	
	public Product() {
		
	}
	
	public Product(String name, double price, String description, String code) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.code = code;
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
