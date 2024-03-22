package ci.magir.sa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.magir.sa.entities.Produit;
import ci.magir.sa.repository.ProduitRepository;

@Service
public class ProduitServiceImp implements ProduitService{

	@Autowired
	ProduitRepository produitrepository;
	
	@Override
	public Produit saveProduit(Produit p) {
		produitrepository.save(p);
		return p;
	}

	@Override
	public Produit updateProduit(Produit p) {
		produitrepository.save(p);
		return p;
	}

	@Override
	public void deleteProduit(Produit p) {
		produitrepository.delete(p);
		
	}

	@Override
	public void deleteProduitById(Long id) {
		produitrepository.deleteById(id);
		
	}

	@Override
	public List<Produit> getAllProduit() {
		return produitrepository.findAll();
	}

	@Override
	public Produit getProduit(Long id) {
		return produitrepository.findById(id).get();
	}

}
