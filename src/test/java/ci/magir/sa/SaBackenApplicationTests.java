package ci.magir.sa;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ci.magir.sa.entities.Produit;
import ci.magir.sa.repository.ProduitRepository;

@SpringBootTest
class SaBackenApplicationTests {
	
	@Autowired
	private ProduitRepository produitrepository;
	
	@Test
	public void testCreateProduit() {
		Produit produit = new Produit("SAVON 250 G",2000.00,new Date());
		produitrepository.save(produit);
	}
	
	@Test
	public void testListeProduit(){
		Produit p = produitrepository.findById(1L).get();
		System.out.println("la liste est : " + p);
		
	}
	
	
	

}
