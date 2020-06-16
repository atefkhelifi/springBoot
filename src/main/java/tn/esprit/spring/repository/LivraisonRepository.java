package tn.esprit.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Livraison;


public interface LivraisonRepository extends JpaRepository<Livraison,Long>{
	@Query("update Livraison l set l.livreur.nbrMax=l.livreur.nbrMax-1 where l.status=LIVREE")
	public void updateMin();
}
