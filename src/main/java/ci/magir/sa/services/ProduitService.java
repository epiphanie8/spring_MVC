package ci.magir.sa.services;

import java.util.ArrayList;
import java.util.List;

import ci.magir.sa.entities.Produit;

public interface ProduitService {
	
	Produit saveProduit(Produit p);
	Produit updateProduit(Produit p);
	void deleteProduit(Produit p);
	void deleteProduitById(Long id);
	List<Produit> getAllProduit();
	Produit getProduit(Long id);
	
}
