package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Livreur;



public interface ILivreurService {
	List<Livreur> afficherAllLivreurs();
	Livreur addLivreur(Livreur l);
	void deleteLivreur(Long id);
	Livreur updateLivreur(Livreur l);
	 Optional<Livreur> afficherLivreur(Long id);
	/* public BigDecimal max();*/
	 public Livreur liv();
	 /*void reinitialiser();*/
		public Livreur getLivreursByLivreurId(Long id);
		public List<Livreur> getLivreursByTypePermisConduire(String typePermis);
		void getSalaire(Long id);
		}
