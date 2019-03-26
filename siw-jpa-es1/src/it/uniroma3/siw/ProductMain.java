package it.uniroma3.siw;

import javax.persistence.*;

public class ProductMain {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		
		Product product1 = new Product("Lampada", 10, "Una lampada molto bella", "a1b2c3");
		Product product2 = new Product("Telefono", 200, "Una telefono molto bello", "dhhio2");
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(product1);
		em.persist(product2);
		tx.commit();
		
		em.close();
		emf.close();
		
	}
}
