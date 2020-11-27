package it.uniroma3.siw;

import javax.persistence.*;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("main-unit");
		EntityManager em = emf.createEntityManager();
		
		Address address1 = new Address("Via Torcervara");
		Address address2 = new Address("Via Fasulla");
		Provider provider1 = new Provider("Jacopo", address1);
		Provider provider2 = new Provider("Sara", address1);
		Product product1 = new Product("Lampada", 10, "Una lampada molto bella", "a1b2c3");
		Product product2 = new Product("Telefono", 200, "Una telefono molto bello", "dhhio2");
		provider1.addProduct(product1);
		provider1.addProduct(product2);
		provider2.addProduct(product1);
		
		Customer customer1 = new Customer("Mario", "Rossi", address2);
		Customer customer2 = new Customer("Paolo", "Bianchi", address1);
		Order order1 = new Order(customer1);
		Order order2 = new Order(customer1);
		Order order3 = new Order(customer2);
		OrderLine ol1 = new OrderLine(10, 2, product1, order1);
		OrderLine ol2 = new OrderLine(100, 1, product2, order2);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(product1);
		em.persist(product2);
		em.persist(provider1);
		em.persist(provider2);
		em.persist(order1);
		em.persist(order2);
		em.persist(order3);
		em.persist(ol1);
		em.persist(ol2);
		
		tx.commit();
		
		em.close();
		emf.close();
		
	}
}
