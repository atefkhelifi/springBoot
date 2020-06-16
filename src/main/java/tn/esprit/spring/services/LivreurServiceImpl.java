package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Livreur;
import tn.esprit.spring.entities.ZoneMap;
import tn.esprit.spring.repository.LivreurRepository;



@Service
public class LivreurServiceImpl implements ILivreurService{
	@Autowired
	LivreurRepository livreurRepository;
	@Override
	public List<Livreur> afficherAllLivreurs() {
		List<Livreur> livreurs=(List<Livreur>)livreurRepository.findAll();
		return livreurs;
	}

	@Override
	public Livreur addLivreur(Livreur l) {
		// TODO Auto-generated method stub
		return livreurRepository.save(l);
	}

	@Override
	public void deleteLivreur(Long id) {
		// TODO Auto-generated method stub
		livreurRepository.deleteById(id);
	}

	@Override
	public Livreur updateLivreur(Livreur l) {
		// TODO Auto-generated method stub
		return livreurRepository.save(l);
}

	@Override
	public Optional<Livreur> afficherLivreur(Long id) {
		// TODO Auto-generated method stub
		return livreurRepository.findById(id);
	}

/*	@Override
	public BigDecimal max() {
		// TODO Auto-generated method stub
		return livreurRepository.max();
	}*/
	@Scheduled(cron = "*/60 * * * * *")
	public void nonDispo() {
		 livreurRepository.updateMax();
	}
	@Scheduled(cron = "*/60 * * * * *")
	public void dispo() {
		livreurRepository.updateMin();
	}
	@Scheduled(cron = "0 0 12 * * ?")
	//@Scheduled(cron = "*/60 * * * * *")
	public void updateSalaire() {
		livreurRepository.updateSalaire();
	}
	@Override
	public Livreur liv() {
		// TODO Auto-generated method stub
		return livreurRepository.liv().get(0);
	}
 /*   public List<Livreur> livreurs()
    
    {
		return livreurRepository.livreurs();
		}*/

	/*	@Override
	public void reinitialiser() {
		// TODO Auto-generated method stub
		livreurRepository.reinitialiser();
	}*/

	@Override
	public Livreur getLivreursByLivreurId(Long id) {
		// TODO Auto-generated method stub
		return livreurRepository.findByLivreurId(id);
	}

	@Override
	public List<Livreur> getLivreursByTypePermisConduire(String typePermis) {
		// TODO Auto-generated method stub
		return livreurRepository.findByTypePermisConduireContains(typePermis);
	}
	
	public List<Livreur> getLivreursByZone(ZoneMap zone) {
		// TODO Auto-generated method stub
		return livreurRepository.findByZoneContains(zone);
	}
	public List<Livreur> getLivreursByZo(String zone) {
		// TODO Auto-generated method stub
		return livreurRepository.findByZoContains(zone);
	}
	
	
	
	public void getSalaire(Long id){
		Livreur livreur=livreurRepository.findByLivreurId(id);
		if(livreurRepository.getAllLivraison(id).size()>100) {	
		//return 5*livreurRepository.getAllLivraison(id).size()+100;
		 livreur.setSalaire(5*livreurRepository.getAllLivraison(id).size()+100);
		livreurRepository.save(livreur);
		}
	else if(livreurRepository.getAllLivraison(id).size()<=100 && 50<livreurRepository.getAllLivraison(id).size()) {
		//return 5*livreurRepository.getAllLivraison(id).size()+50;
		livreur.setSalaire(5*livreurRepository.getAllLivraison(id).size()+50);
		livreurRepository.save(livreur);
	}
	else {
		livreur.setSalaire(5*livreurRepository.getAllLivraison(id).size());
		livreurRepository.save(livreur);
	}
			
	}

	/*@Override
	public Livreur liv() {
		// TODO Auto-generated method stub
		return livreurRepository.liv();
	}

	@Override
	public void reinitialiser() {
		// TODO Auto-generated method stub
		livreurRepository.reinitialiser();
	}*/
	

}
