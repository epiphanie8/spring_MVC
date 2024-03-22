package ci.magir.sa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ci.magir.sa.entities.Produit;
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
	public String saveProduit(@ModelAttribute("produit") Produit produit,  @RequestParam("date") String date, ModelMap modelMap)
	throws ParseException
	{
		//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date datecreation = dateformat.parse(String.valueOf(date));
		produit.setDatecreation(datecreation);
		
		//enregistre dans la base de donnée
		Produit saveProduit = produitservice.saveProduit(produit);
		
		//generer le message apres ajout
		String msg ="produit enregistré avec Id"+ saveProduit.getIdProduit();
		modelMap.addAttribute("msg", msg);
	
		return "createProduit";	
	}
	
	
	//Affichage de la liste de tous les produit
	
	
	@GetMapping("/ListeProduits")
	public String getAllProduit(ModelMap modelMap){
		List<Produit> prod = produitservice.getAllProduit();
		modelMap.addAttribute("produits",prod);
		return "listeProduits";
		
	}
	
	//Supprimer une produit
	@GetMapping("/supprimerProduit")
	public String deleteProduitById(@RequestParam("id") Long id, ModelMap modelMap) {
		 
		produitservice.deleteProduitById(id); 
		List<Produit> prods = produitservice.getAllProduit();
		modelMap.addAttribute("produits", prods);
		return "listeProduits";
	}
	
	//Formulaire pour Modifier un produit
	
	@GetMapping("/modifierProduit")
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap)
	{
		Produit p = produitservice.getProduit(id);
		modelMap.addAttribute("prods", p);
		
		return "editerProduit";
	}
	
	//Modifier un produit
	@PostMapping("/updateProduit")
	public String updateProduit(@ModelAttribute("produit") Produit produit, @RequestParam("date") String date, ModelMap modelMap)
	throws ParseException
	{
		//conversion de la date
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
				Date datecreation = dateformat.parse(String.valueOf(date));
				produit.setDatecreation(datecreation);
				
				//enregistre dans la base de donnée
				produitservice.updateProduit(produit);
				
				List<Produit> prods = produitservice.getAllProduit();
				modelMap.addAttribute("produits", prods);
			
				return "listeProduits";		
	}
	
	

}
