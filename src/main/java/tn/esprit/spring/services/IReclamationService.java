package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Reclamation;




public interface IReclamationService {
	List<Reclamation> afficherAllReclamations();
	Reclamation addReclamation(Reclamation r);
	void deleteReclamation(Long id);
	Reclamation updateReclamation(Reclamation r);
	 Optional<Reclamation> afficherReclamation(Long id);
	 Reclamation traiterDecision(Long id,Reclamation r);
}
