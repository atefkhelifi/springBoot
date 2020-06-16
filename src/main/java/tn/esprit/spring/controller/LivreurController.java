package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Livreur;
import tn.esprit.spring.services.LivreurServiceImpl;



@RestController
@RequestMapping(value="/api/livreurs")
public class LivreurController {
	@Autowired
	private LivreurServiceImpl livreurService;
	@GetMapping(value="/livreur/allLivreurs")
	public List<Livreur> afficherAllLivreurs(){
		return livreurService.afficherAllLivreurs();
				}
	@PostMapping(value="/create")
	public Livreur addLivreur(@RequestBody Livreur l) {
		return livreurService.addLivreur(l);
	}
	@PutMapping(value="/update")
	public Livreur updateLivreur(@RequestBody Livreur l) {
		return livreurService.addLivreur(l);
	}
	@DeleteMapping(value="/livreurDelete/{livreurId}")
	public void deleteLivreur(@PathVariable("livreurId")Long id){
		livreurService.deleteLivreur(id);
	}
	@GetMapping(value="/livreur/{livreurId}")
	public Optional<Livreur> afficherLivreur(@PathVariable("livreurId")Long id){
		return livreurService.afficherLivreur(id);
				}
	/*@GetMapping(value="/max/mois")
	public BigDecimal afficherMaxMois() {
		return livreurService.max();
	}*/
	
	@GetMapping(value="/livreur/mois")
	
	public Livreur afficherLivreurMois() {
		
		return livreurService.liv();
	}
	
	/*@PutMapping(value="/livreur/reinitialiser")
	public void reinitialiser(){
		livreurService.reinitialiser();
	}*/
	/*@PostMapping(value="/livreur/reinitialiser")
	public void reinitialiser() {
		 livreurService.updateMax();
	}*/
	@GetMapping(value="/livreurFind/{livreurId}")
	public Livreur findLivreur(@PathVariable("livreurId")Long id){
		return livreurService.getLivreursByLivreurId(id);
	}
	@GetMapping(value="/livreur/byName/{typePermis}")
	public List<Livreur> afficherLivreursByName(@PathVariable("typePermis")String typePermis){
		return livreurService.getLivreursByTypePermisConduire(typePermis);
				}
	
	
/*	@GetMapping(value="/salaire/{livreurId}")
	public int getAllLivraison(@PathVariable("livreurId")Long id){
		return livreurService.getSalaire(id);
	}*/
	
}
