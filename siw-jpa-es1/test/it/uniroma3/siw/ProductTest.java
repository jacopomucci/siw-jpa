package it.uniroma3.siw;

import org.junit.*;

import static org.junit.Assert.*;
import javax.persistence.*;
import java.util.List;

public class ProductTest {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	
	@BeforeClass
	public static void initEntityManager() throws Exception {
		emf = Persistence.createEntityManagerFactory("main-unit-test");
		em = emf.createEntityManager();
	}
	
	@AfterClass 
	public static void closeEntityManager() throws Exception {
		if (em != null) em.close();
		if (emf != null) emf.close();
	}
	
	@Before
	public void initTransaction() {
		tx = em.getTransaction();
	}
	
	@Test 
	public void createProduct() throws Exception {
		Product product = new Product("Prova", 10, "provaprovaprova", "a1b2c3");
		
		tx.begin();
		em.persist(product);
		tx.commit();
		
		assertNotNull("ID should not be NULL!", product.getId());
		
		List<Product> products = em.createNamedQuery("findAllProducts", Product.class).getResultList();
		assertEquals(1, products.size());
	}
}
