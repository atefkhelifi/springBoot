package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.repository.ReclamationRepository;


@Service
public class ReclamationServiceImpl implements IReclamationService{
	@Autowired
	ReclamationRepository reclamationRepository;
	@Override
	public List<Reclamation> afficherAllReclamations() {
		List<Reclamation> Reclamations=(List<Reclamation>)reclamationRepository.findAll();
		return Reclamations;
	}

	@Override
	public Reclamation addReclamation(Reclamation r) {
		// TODO Auto-generated method stub
		return reclamationRepository.save(r);
	}

	@Override
	public void deleteReclamation(Long id) {
		// TODO Auto-generated method stub
		reclamationRepository.deleteById(id);
	}

	@Override
	public Reclamation updateReclamation(Reclamation r) {
		// TODO Auto-generated method stub
		return reclamationRepository.save(r);
	}

	@Override
	public Optional<Reclamation> afficherReclamation(Long id) {
		// TODO Auto-generated method stub
		return reclamationRepository.findById(id);
	}

	@Override
	public Reclamation traiterDecision(Long id, Reclamation r) {
		if (reclamationRepository.findById(id).isPresent()){
			Reclamation tt = reclamationRepository.findById(id).get();

	        tt.setDecision(r.getDecision());
	        
	        
	        
	        Reclamation traitedReclamation = reclamationRepository.save(tt);
	        
	        return traitedReclamation;
	    }else{
	        return null;
	    }
		
	}
	
}
