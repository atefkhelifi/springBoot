package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Livraison;


public interface ILivraisonService {
	List<Livraison> afficherAllLivraisons();
	Livraison addLivraison(Livraison l);
	void deleteLivraison(Long id);
	Livraison updateLivraison(Livraison l);
	 Optional<Livraison> afficherLivraison(Long id);
	 int calculeFrais(int kilometrage);
	 void affecterLivreur(Long idLivraison, Long idLivreur);
	 
}
