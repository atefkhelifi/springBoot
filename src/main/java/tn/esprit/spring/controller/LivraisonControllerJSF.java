package tn.esprit.spring.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.view.ViewScoped;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.entities.Livraison;
import tn.esprit.spring.entities.Livreur;
import tn.esprit.spring.entities.Status;
import tn.esprit.spring.entities.Zone;
import tn.esprit.spring.entities.ZoneMap;
import tn.esprit.spring.repository.LivraisonRepository;
import tn.esprit.spring.repository.LivreurRepository;
import tn.esprit.spring.services.LivraisonServiceImpl;

@ViewScoped
@Controller(value = "jsfLivraisonController")
@ELBeanName(value = "jsfLivraisonController")
public class LivraisonControllerJSF {
	@Autowired
	private LivraisonServiceImpl livraisonService;
	@Autowired
	private LivreurRepository livreurRep;
	@Autowired
	private LivraisonRepository livraisonRep;
	@Autowired
	private HomeController employeController;
	private List <Livraison> livraisons;
	private Float lat;
	private Float lon;
	private String localisation;
	private Date date;
	private Integer frais;
	private Status status;
	private String moyenDeTransport;
	private Integer kilometrage;
	private Livreur livreur;
	private Long LivraisonIdToBeUpdated;
	private List<Livreur> livreurs;
	private Livraison livraison;
	private Long idLivraison;
	private Long idLivreur;
	private String nomliv;
	private Long atefid;
	private Zone contry;

	
	
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
	 * @return the atefid
	 */
	public Long getAtefid() {
		return atefid;
	}
	/**
	 * @param atefid the atefid to set
	 */
	public void setAtefid(Long atefid) {
		this.atefid = atefid;
	}
	/**
	 * @return the nomliv
	 */
	public String getNomliv() {
		return nomliv;
	}
	/**
	 * @param nomliv the nomliv to set
	 */
	public void setNomliv(String nomliv) {
		this.nomliv = nomliv;
	}
	/**
	 * @return the idLivreur
	 */
	public Long getIdLivreur() {
		return idLivreur;
	}
	/**
	 * @param idLivreur the idLivreur to set
	 */
	public void setIdLivreur(Long idLivreur) {
		this.idLivreur = idLivreur;
	}
	/**
	 * @return the idLivraison
	 */
	public Long getIdLivraison() {
		return idLivraison;
	}
	/**
	 * @param idLivraison the idLivraison to set
	 */
	public void setIdLivraison(Long idLivraison) {
		this.idLivraison = idLivraison;
	}
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
	 * @return the livreurs
	 */
	public List<Livreur> getLivreurs() {
		//livreurs= (List<Livreur>) getLivreurs().stream().filter(s->s.getZone()==ZoneMap.BEJA_JANDOUBA_BIZERTE).collect(Collectors.toList());
		//livreurs =  (List<Livreur>) livreurRep.findAll();
		return livreurs;
	}
	/**
	 * @param livreurs the livreurs to set
	 */
	public void setLivreurs(List<Livreur> livreurs) {
		this.livreurs = livreurs;
	}
	/**
	 * @return the livraisonIdToBeUpdated
	 */
	public Long getLivraisonIdToBeUpdated() {
		return LivraisonIdToBeUpdated;
	}
	/**
	 * @param livraisonIdToBeUpdated the livraisonIdToBeUpdated to set
	 */
	public void setLivraisonIdToBeUpdated(Long livraisonIdToBeUpdated) {
		LivraisonIdToBeUpdated = livraisonIdToBeUpdated;
	}
	/**
	 * @return the livraisons
	 */
	public List<Livraison> getLivraisons() {
		livraisons=livraisonService.afficherAllLivraisons();
		return livraisons;
	}
	/**
	 * @param livraisons the livraisons to set
	 */
	public void setLivraisons(List<Livraison> livraisons) {
		this.livraisons = livraisons;
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
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
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
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the frais
	 */
	public Integer getFrais() {
		return frais;
	}
	/**
	 * @param frais the frais to set
	 */
	public void setFrais(Integer frais) {
		this.frais = frais;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the moyenDeTransport
	 */
	public String getMoyenDeTransport() {
		return moyenDeTransport;
	}
	/**
	 * @param moyenDeTransport the moyenDeTransport to set
	 */
	public void setMoyenDeTransport(String moyenDeTransport) {
		this.moyenDeTransport = moyenDeTransport;
	}
	/**
	 * @return the kilometrage
	 */
	public Integer getKilometrage() {
		return kilometrage;
	}
	/**
	 * @param kilometrage the kilometrage to set
	 */
	public void setKilometrage(Integer kilometrage) {
		this.kilometrage = kilometrage;
	}
	/**
	 * @return the livreur
	 */
	public Livreur getLivreur() {
		return livreur;
	}
	/**
	 * @param livreur the livreur to set
	 */
	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}
	
	public String affecterLivreur() {
		String navigateTo = "null";
		if (employeController.getAuthenticatedUser()==null || !employeController.getLoggedIn()) return "/xhtml/login.xhtml";
		//Livreur liv = new Livreur();
		//liv.setLivreurId(atefid);
		//Livraison livraison=new Livraison();
		//livraison.setLivreur(livreurRep.findByLivreurId(atefid));
		//liv.setNomLivreur(nomLivreur);
		livraisonService.addLivraison(new Livraison(LivraisonIdToBeUpdated, lat,lon,contry,localisation,livraisonService.calculeFrais((int)livraisonService.distance(lat, lon)),status,(int)livraisonService.distance(lat, lon),livreurRep.findByLivreurId(atefid)));
		Livreur livreur=livreurRep.findById(atefid).get();
		livreur.setNbrMax(livreur.getNbrMax()+1);
		livreurRep.save(livreur);
		return navigateTo;

		//livraisonRep.save(new Livraison(idLivraison,liv));
		}
	
	public List<Livreur> displayLivreur(Livraison livraison) {
		
		this.setLivraisonIdToBeUpdated(livraison.getLivraisonId());
		  this.setLivreur(livraison.getLivreur());
		//setIdLivreur(livr.getLivreur().getLivreurId());
		  this.setContry(livraison.getContry());
		  this.setLat(livraison.getLat());
		  this.setLon(livraison.getLon());
		  this.setFrais(livraison.getFrais());
		  this.setStatus(getStatus().EN_COURS);
		  this.setLocalisation(livraison.getLocalisation());

		  if (livraison.getContry()==Zone.TUNIS||livraison.getContry()==Zone.ZAGHOUAN||getContry()==Zone.NABEUL) {
					//livreurs= (List<Livreur>) getLivreurs().stream().filter(s->s.getZone()==ZoneMap.BEJA_JANDOUBA_BIZERTE).collect(Collectors.toList());
			  //System.out.println(ZoneMap.ZAGHOUAN_NABEUL_TUNIS.name());
			  //livreurs.stream().filter(e->e.getDispo().booleanValue()==true).collect(Collectors.toList());
			  livreurs =  (List<Livreur>) livreurRep.findByZoContains("ZAGHOUAN_NABEUL_TUNIS").stream().filter(e->e.getDispo()==true).collect(Collectors.toList());
			  
			  
			//  System.out.println("hbhhhhhhhhhhhhhhhhhhhhhhhhh"+livreurs.stream().filter(e->e.getDispo()==true).collect(Collectors.toList()));
			 // return livreurs.stream().filter(e->e.getDispo()==true).collect(Collectors.toList());
			  /*for(int i=0;i<livreurs.size();i++) {
					 livreur= livreurs.get(i);
					 
					 if(livreur.getDispo()==true) {
					
						 livreurs.remove(livreur);
						 
						
					 }
					 livreurs.get(i++);
					 
					// else return null;
					  //return livreurs;
				  }*/
			 // return livreurs;
			  /*for(Livreur liv:livreurs) {
				  if (liv.getDispo()==true) {
					  livreurs.remove(liv);
				  }
			  }*/
			/*
			 * int i=0; while(i<livreurs.size()&&livreurs.get(i).getDispo()==true) {
			 * livreurs.remove(i); i++; }
			 */
			 /* 
			   for(int i=0;i<livreurs.size();i++) {
				 livreur= livreurs.get(i);
				 
				 if(livreur.getDispo()==true) {
				
					 livreurs.remove(livreur);
					 return livreurs;
				 }
				// else return null;
				  //return livreurs;
			  }*/
									//return livreurs;
									}
					else if(livraison.getContry()==Zone.GAFSA||livraison.getContry()==Zone.SIDI_BOUZID||livraison.getContry()==Zone.KASSERINE) {
						livreurs =  (List<Livreur>) livreurRep.findByZoContains("GAFSA_SIDIBOUZID_KASSERINE").stream().filter(e->e.getDispo()==true).collect(Collectors.toList());//.stream().filter(e->e.getDispo().booleanValue()==false).collect(Collectors.toList());
						//livreurs.stream().filter(e->e.getDispo().booleanValue()==true).collect(Collectors.toList());
					}
					else if(livraison.getContry()==Zone.BEJA||livraison.getContry()==Zone.BIZERTE||livraison.getContry()==Zone.JANDOUBA) {
						livreurs =  (List<Livreur>) livreurRep.findByZoContains("BEJA_JANDOUBA_BIZERTE").stream().filter(e->e.getDispo()==true).collect(Collectors.toList());
					}else if(livraison.getContry()==Zone.KAIROUAN||livraison.getContry()==Zone.EL_KEF||livraison.getContry()==Zone.SILIANA) {
						livreurs =  (List<Livreur>) livreurRep.findByZoContains("KAIROUAN_SILIANA_EL_KEF").stream().filter(e->e.getDispo()==true).collect(Collectors.toList());
		  }
					else if(livraison.getContry()==Zone.GABES||livraison.getContry()==Zone.MAHDIA||livraison.getContry()==Zone.MOUNASTIR||livraison.getContry()==Zone.SFAX||livraison.getContry()==Zone.SOUSSE) {
						livreurs =  (List<Livreur>) livreurRep.findByZoContains("SFAX_GABES_MAHDIA_MOUNASTIR_SOUSSE").stream().filter(e->e.getDispo()==true).collect(Collectors.toList());
						
					}
					else if(livraison.getContry()==Zone.MEDNINE||livraison.getContry()==Zone.KEBILI||livraison.getContry()==Zone.TOZEUR||livraison.getContry()==Zone.TATAOUINE) {
						livreurs =  (List<Livreur>) livreurRep.findByZoContains("TATAOUINE_MEDNINE_KEBILI_TOZEUR").stream().filter(e->e.getDispo()==true).collect(Collectors.toList());

						
					}

				else {
					livreurs =  (List<Livreur>) livreurRep.findByTypePermisConduireContains("..");
					//System.out.println("qaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		}
		return livreurs;
		  
			

	}
	

}
