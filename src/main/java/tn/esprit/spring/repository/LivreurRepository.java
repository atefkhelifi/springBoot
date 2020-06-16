package tn.esprit.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entities.Livraison;
import tn.esprit.spring.entities.Livreur;
import tn.esprit.spring.entities.ZoneMap;



public interface LivreurRepository extends JpaRepository<Livreur,Long>{
	//@Scheduled(cron = "0 0 0 1 * *")
	/*@Query(value = "SELECT max(chargeDeTravail) FROM Livreur")
	public BigDecimal max();*/
	//@Scheduled(cron = "*/10 * * * * *")
	@Modifying
	@Query( "update Livreur u set u.dispo = false where u.nbrMax>5 ")
    @Transactional
	public void updateMax();
	//@Scheduled(cron = "*/10 * * * * *")
	@Modifying
	@Query( "update Livreur u set u.dispo = true where u.nbrMax=0 ")
    @Transactional
	public void updateMin();
	@Modifying
	@Query( "update Livreur u set u.salaire = 0 where u.salaire>0 ")
    @Transactional
	public void updateSalaire();
	
	@Query(value = "select l FROM Livreur l order by size (l.livraisons) desc")
    List<Livreur> liv();
	
	/*@Query(value = "select l FROM Livreur l where l.ZoneMap=ZoneMap.ZAGHOUAN_NABEUL_TUNIS")
    List<Livreur> livreurs();*/
	
/*	@Query("update Livreur u set u.livraisons =0")
	public void reinitialiser();*/
	public Livreur findByLivreurId(Long id);
	public List<Livreur> findByTypePermisConduireContains(String typePermis);
	public List<Livreur> findByZoneContains(ZoneMap zone);
	public List<Livreur> findByZoContains(String zone);
	@Query("select count(e.livraisons) from Livreur e where e.id = :id")
	int countByLivraison(Long id);
	@Query("select e.livraisons from Livreur e where e.id = :id")
	List<Livraison> getAllLivraison(Long id);
	
}
