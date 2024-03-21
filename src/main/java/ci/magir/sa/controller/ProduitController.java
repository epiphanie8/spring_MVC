package ci.magir.sa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import ci.magir.sa.services.ProduitService;

@Controller
public class ProduitController {
	
	@Autowired
	ProduitService produitservice;
	
	//demander le formulaire de creation de produit
	@GetMapping("/showCreate")
	public String showCreate() {
		
		return "createProduit";		
	}
	
	//enregistrer un produit
	
	@PostMapping("/saveProduit")
	public String saveProduit() {
		return null;
		
	}
	
	
	

}
