package ci.magir.sa.services;

import java.util.ArrayList;

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
	public void deleteByProduit(Long id) {
		produitrepository.deleteById(id);
		
	}

	@Override
	public ArrayList<Produit> getProduit() {
		return (ArrayList<Produit>) produitrepository.findAll();
	
	}

	@Override
	public Produit getAllProduit(Long id) {
		return produitrepository.findById(id).get();
	}

}
