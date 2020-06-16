package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Livraison;
import tn.esprit.spring.entities.Livreur;
import tn.esprit.spring.entities.Status;
import tn.esprit.spring.entities.Zone;
import tn.esprit.spring.entities.ZoneMap;
import tn.esprit.spring.repository.LivraisonRepository;
import tn.esprit.spring.repository.LivreurRepository;



@Service
public class LivraisonServiceImpl implements ILivraisonService{
	@Autowired
	LivraisonRepository livraisonRepository;
	@Autowired
	LivreurRepository livreurRepository;
	
	@Override
	public List<Livraison> afficherAllLivraisons() {
		List<Livraison> livraisons=(List<Livraison>)livraisonRepository.findAll();
		return livraisons;
	}

	@Override
	public Livraison addLivraison(Livraison l) {
		// TODO Auto-generated method stub
		return livraisonRepository.save(l);
	}

	@Override
	public void deleteLivraison(Long id) {
		// TODO Auto-generated method stub
		livraisonRepository.deleteById(id);
	}

	@Override
	public Livraison updateLivraison(Livraison l) {
		// TODO Auto-generated method stub
		return livraisonRepository.save(l);
	}

	@Override
	public Optional<Livraison> afficherLivraison(Long id) {
		// TODO Auto-generated method stub
		return livraisonRepository.findById(id);
	}

	@Override
	public int calculeFrais(int kilometrage) {
		// TODO Auto-generated method stub
			if (kilometrage<=50) {
			return 5;	
			}else return 10;	
	
	}
	/*@Override
	public void affecterLivreur(Long idLivraison, Long idLivreur) {
		// TODO Auto-generated method stub
		Livraison livraison=livraisonRepository.findById(idLivraison).get();
		Livreur livreur=livreurRepository.findById(idLivreur).get();
		
		
		//if(livreur.getDispo()==true&&livreur.getZone()==ZoneMap.ZAGHOUAN_NABEUL_TUNIS&&(livraison.getLocalisation()==Zone.TUNIS||livraison.getLocalisation()==Zone.ZAGHOUAN||livraison.getLocalisation()==Zone.NABEUL)) {
			livreur.setNbrMax(livreur.getNbrMax()+1);
			livreurRepository.save(livreur);
			livraison.setLivreur(livreur);
			livraisonRepository.save(livraison);

			
		}
		//else if(livreur.getDispo()==true&&livreur.getZone()==ZoneMap.BEJA_JANDOUBA_BIZERTE&&(livraison.getLocalisation()==Zone.BEJA||livraison.getLocalisation()==Zone.JANDOUBA||livraison.getLocalisation()==Zone.BIZERTE)) {
			livreur.setNbrMax(livreur.getNbrMax()+1);
			livreurRepository.save(livreur);
			livraison.setLivreur(livreur);
			livraisonRepository.save(livraison);
			

		}
		//else if(livreur.getDispo()==true&&livreur.getZone()==ZoneMap.GAFSA_SIDIBOUZID_KASSERINE&&(livraison.getLocalisation()==Zone.GAFSA||livraison.getLocalisation()==Zone.KASSERINE||livraison.getLocalisation()==Zone.SIDI_BOUZID)) {
			livreur.setNbrMax(livreur.getNbrMax()+1);
			livreurRepository.save(livreur);
			livraison.setLivreur(livreur);
			livraisonRepository.save(livraison);
			
		}
		//else if(livreur.getDispo()==true&&livreur.getZone()==ZoneMap.KAIROUAN_SILIANA_EL_KEF&&(livraison.getLocalisation()==Zone.KAIROUAN||livraison.getLocalisation()==Zone.SILIANA||livraison.getLocalisation()==Zone.EL_KEF)) {
			livreur.setNbrMax(livreur.getNbrMax()+1);
			livreurRepository.save(livreur);
			livraison.setLivreur(livreur);
			livraisonRepository.save(livraison);
			
				
		}
		//else if(livreur.getDispo()==true&&livreur.getZone()==ZoneMap.SFAX_GABES_MAHDIA_MOUNASTIR_SOUSSE&&(livraison.getLocalisation()==Zone.SFAX||livraison.getLocalisation()==Zone.GABES||livraison.getLocalisation()==Zone.MAHDIA||livraison.getLocalisation()==Zone.SOUSSE||livraison.getLocalisation()==Zone.MOUNASTIR)) {
			livreur.setNbrMax(livreur.getNbrMax()+1);
			livreurRepository.save(livreur);
			livraison.setLivreur(livreur);
			livraisonRepository.save(livraison);
			
					
		}
		//else if(livreur.getDispo()==true&&livreur.getZone()==ZoneMap.TATAOUINE_MEDNINE_KEBILI_TOZEUR&&(livraison.getLocalisation()==Zone.KEBILI||livraison.getLocalisation()==Zone.MEDNINE||livraison.getLocalisation()==Zone.KEBILI||livraison.getLocalisation()==Zone.TOZEUR)) {
			livreur.setNbrMax(livreur.getNbrMax()+1);
			livreurRepository.save(livreur);
			livraison.setLivreur(livreur);
			livraisonRepository.save(livraison);
			
					
		}else
		System.out.println("error d affectation");
			
	}*/
	/*public void dispo() {
		Livreur liv ;
		if(liv.getDispo()==false) {
		
			Set<Livraison> livraisonss= liv.getLivraisons();
			for (int i = 0; i < livraisonss.size(); i++) {
				if(livraisonss.stream().) {
					
				}
			}
		}
	} */
	public void min(Long idLivraison) {
		//Livraison l;
		Livraison l=livraisonRepository.findById(idLivraison).get();

		Livreur liv=l.getLivreur();
		l.setStatus(Status.LIVREE);
			int n=liv.getNbrMax();
			liv.setNbrMax(n-1);
		livraisonRepository.save(l);
		
	}
	public void updateMin() {
		livraisonRepository.updateMin();
	}

	@Override
	public void affecterLivreur(Long idLivraison, Long idLivreur) {
		// TODO Auto-generated method stub
		
	}
	public double distance(double lat1, double lon1) {
		if ((lat1 == 36.79692) && (lon1 == 10.157208)) {
			return 0;
		}
		else {
			double theta = lon1 - 10.157208;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(36.79692)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(36.79692)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515* 1.609344;
			return Math.round(dist*100)/100;
		}
	}

}
