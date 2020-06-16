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

import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.services.ReclamationServiceImpl;


@RestController
@RequestMapping(value="/api/reclamations")
public class ReclamationController {
	@Autowired
	private ReclamationServiceImpl reclamationService;
	@GetMapping(value="/reclamation/allReclamations")
	public List<Reclamation> afficherAllReclamations(){
		return reclamationService.afficherAllReclamations();
				}
	@PostMapping(value="/create")
	public Reclamation addReclamation(@RequestBody Reclamation r) {
		return reclamationService.addReclamation(r);
	}
	@PutMapping(value="/update")
	public Reclamation updateReclamation(@RequestBody Reclamation r) {
		return reclamationService.addReclamation(r);
	}
	@DeleteMapping(value="/reclamationDelete/{reclamationId}")
	public void deleteReclamation(@PathVariable("reclamationId")Long id){
		reclamationService.deleteReclamation(id);
	}
	@GetMapping(value="/Reclamation/{reclamationId}")
	public Optional<Reclamation> afficherReclamation(@PathVariable("reclamationId")Long id){
		return reclamationService.afficherReclamation(id);
				}
	@PostMapping(value="/reclamationDecision/{reclamationId}")
	public Reclamation traiterDecision(@PathVariable("reclamationId")Long id,@RequestBody Reclamation r){
		return reclamationService.traiterDecision(id, r);
	}
}
