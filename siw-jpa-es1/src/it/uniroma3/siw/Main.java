package it.uniroma3.siw;

import javax.persistence.*;

public class Main {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		
		
		
		Product product1 = new Product("Lampada", 10, "Una lampada molto bella", "a1b2c3");
		Product product2 = new Product("Telefono", 200, "Una telefono molto bello", "dhhio2");
		Provider provider1 = new Provider("Jacopo");
		Provider provider2 = new Provider("Sara");
		Address address1 = new Address("Via Torcervara");
		
		provider1.addProduct(product1);
		provider1.addProduct(product2);
		provider1.setAddress(address1);
		provider2.setAddress(address1);
		
		Customer customer1 = new Customer("Mario", "Rossi", address1);
		Order order1 = new Order(customer1);
		OrderLine ol1 = new OrderLine(10, 2, product1, order1);
		OrderLine ol2 = new OrderLine(100, 1, product2, order1);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(product1);
		em.persist(product2);
		em.persist(provider1);
		em.persist(provider2);
		em.persist(address1);
		em.persist(order1);
		em.persist(ol1);
		em.persist(ol2);
		em.persist(customer1);
	
		
		tx.commit();
		
		em.close();
		emf.close();
		
	}
}
