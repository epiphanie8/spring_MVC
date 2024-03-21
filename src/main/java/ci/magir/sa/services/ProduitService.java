package ci.magir.sa.services;

import java.util.ArrayList;

import ci.magir.sa.entities.Produit;

public interface ProduitService {
	
	Produit saveProduit(Produit p);
	Produit updateProduit(Produit p);
	void deleteProduit(Produit p);
	void deleteByProduit(Long id);
	ArrayList<Produit> getProduit();
	Produit getAllProduit(Long id);
	
}
