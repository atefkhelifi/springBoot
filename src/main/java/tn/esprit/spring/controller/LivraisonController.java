package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.faces.view.ViewScoped;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Livraison;
import tn.esprit.spring.entities.Zone;
import tn.esprit.spring.entities.ZoneMap;
import tn.esprit.spring.services.LivraisonServiceImpl;

@ViewScoped

@ELBeanName(value = "livraisonController")

@Controller(value = "livraisonController")
@RequestMapping(value="/api/livraisons")
public class LivraisonController {
	
	@Autowired
	private LivraisonServiceImpl livraisonService;
	
	private Livraison livraison;
	private Float lat;
	private Float lon;
	private Zone contry;
	private String localisation; 
	
	
	
	public Zone[] getContrys() { return Zone.values(); }

	/**
	 * @return the livraison
	 */
	public Livraison getLivraison() {
		return livraison;
	}
	/**
	 * @param livraison the livraison to set
	 */
	public void setLivraison(Livraison livraison) {
		this.livraison = livraison;
	}
	/**
	 * @return the lat
	 */
	public Float getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(Float lat) {
		this.lat = lat;
	}
	/**
	 * @return the lon
	 */
	public Float getLon() {
		return lon;
	}
	/**
	 * @param lon the lon to set
	 */
	public void setLon(Float lon) {
		this.lon = lon;
	}
	
	/**
	 * @return the contry
	 */
	public Zone getContry() {
		return contry;
	}

	/**
	 * @param contry the contry to set
	 */
	public void setContry(Zone contry) {
		this.contry = contry;
	}

	/**
	 * @return the localisation
	 */
	public String getLocalisation() {
		return localisation;
	}

	/**
	 * @param localisation the localisation to set
	 */
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	@GetMapping(value="/livraison/allLivraisons")
	public List<Livraison> afficherAllLivraisons(){
		return livraisonService.afficherAllLivraisons();
				}
	@PostMapping(value="/create")
	public Livraison addLivraison(@RequestBody Livraison l) {
		return livraisonService.addLivraison(l);
	}
	@PutMapping(value="/update")
	public Livraison updateLivraison(@RequestBody Livraison l) {
		return livraisonService.addLivraison(l);
	}
	@DeleteMapping(value="/livraisonDelete/{livraisonId}")
	public void deleteLivraison(@PathVariable("livraisonId")Long id){
		livraisonService.deleteLivraison(id);
	}
	@GetMapping(value="/livraison/{livraisonId}")
	public Optional<Livraison> afficherLivraison(@PathVariable("livraisonId")Long id){
		return livraisonService.afficherLivraison(id);
				}
	@GetMapping(value="/calculeFrais/{poids}/{kilo}")
	public int calculerFrais(@PathVariable("poids")float poids,@PathVariable("kilo")int kilo){
		return livraisonService.calculeFrais( kilo);
	}
	@GetMapping(value="/affecter/{idLivraison}/{idLivreur}")
	public void affecterLivreur(@PathVariable("idLivraison")Long idLivraison,@PathVariable("idLivreur")Long idLivreur) {
		 livraisonService.affecterLivreur(idLivraison, idLivreur);
	}
	@GetMapping(value="/livree/{idLivraison}")
	public void updateMin(@PathVariable("idLivraison")Long idLivraison) {
		livraisonService.min(idLivraison);
	}
/*	@PostMapping(value="/createLU")

	public void addLivraisonUser() {
		livraisonService.addLivraison(new Livraison( localisation));
	}*/
}
