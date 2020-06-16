package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Livraison;
import tn.esprit.spring.entities.Livreur;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Zone;
import tn.esprit.spring.entities.ZoneMap;
import tn.esprit.spring.repository.LivreurRepository;
import tn.esprit.spring.services.EmployeService;
import tn.esprit.spring.services.LivraisonServiceImpl;
import tn.esprit.spring.services.LivreurServiceImpl;

@ViewScoped
@Controller(value = "employeController")
@ELBeanName(value = "employeController")
@Join(path = "/", to = "/xhtml/login.xhtml")
public class HomeController {
	@Autowired
	EmployeService employeService;
	@Autowired
	LivreurServiceImpl livreurService;
	@Autowired
	private LivraisonServiceImpl livraisonService;
	@Autowired
	private LivreurRepository livreurRepository;
	private Livraison livraison;
	private Float lat;
	private Float lon;
	private Zone contry;
	private List <Livreur> livreurs;
	private Livreur livreur;
	private Employe authenticatedUser;
	private String login; 
	private String password;
	private Boolean loggedIn;
	private Long idLivreur;
	private String nomLivreur;
	private Integer nbrMax;
	private Boolean dispo;
	private ZoneMap zone;
	private String zo; 
	private String typePermisConduire;
	private Date datePermisConduire;
	private Long livreurIdToBeUpdated;
	private String localisation;
	
	
	
	/**
	 * @return the zo
	 */
	public String getZo() {
		return zo;
	}

	/**
	 * @param zo the zo to set
	 */
	public void setZo(String zo) {
		this.zo = zo;
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
	 * @return the contry
	 */
	public Zone getContry() {
		return contry;
	}
	//public Zone[] getContrys() { return Zone.values(); }
	public Zone[] getContrys() { return Zone.values(); }
	/**
	 * @param contry the contry to set
	 */
	public void setContry(Zone contry) {
		this.contry = contry;
	}

	/**
	 * @return the livreurIdToBeUpdated
	 */
	public Long getLivreurIdToBeUpdated() {
		return livreurIdToBeUpdated;
	}
	/**
	 * @param livreurIdToBeUpdated the livreurIdToBeUpdated to set
	 */
	public void setLivreurIdToBeUpdated(Long livreurIdToBeUpdated) {
		this.livreurIdToBeUpdated = livreurIdToBeUpdated;
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
	 * @return the livreurs
	 */
	public List<Livreur> getLivreurs() {
		livreurs=livreurService.afficherAllLivreurs();
		return livreurs;
	}
	/**
	 * @param livreurs the livreurs to set
	 */
	public void setLivreurs(List<Livreur> livreurs) {
		this.livreurs = livreurs;
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
	/**
	 * @return the nomLivreur
	 */
	public String getNomLivreur() {
		return nomLivreur;
	}
	/**
	 * @param nomLivreur the nomLivreur to set
	 */
	public void setNomLivreur(String nomLivreur) {
		this.nomLivreur = nomLivreur;
	}
	/**
	 * @return the nbrMax
	 */
	public Integer getNbrMax() {
		return nbrMax;
	}
	/**
	 * @param nbrMax the nbrMax to set
	 */
	public void setNbrMax(Integer nbrMax) {
		this.nbrMax = nbrMax;
	}
	/**
	 * @return the dispo
	 */
	public Boolean getDispo() {
		return dispo;
	}
	/**
	 * @param dispo the dispo to set
	 */
	public void setDispo(Boolean dispo) {
		this.dispo = dispo;
	}
	/**
	 * @return the zone
	 */
	public ZoneMap getZone() {
		return zone;
	}
	public ZoneMap[] getZones() { return ZoneMap.values(); }
	/**
	 * @param zone the zone to set
	 */
	public void setZone(ZoneMap zone) {
		this.zone = zone;
	}
	/**
	 * @return the typePermisConduire
	 */
	public String getTypePermisConduire() {
		return typePermisConduire;
	}
	/**
	 * @param typePermisConduire the typePermisConduire to set
	 */
	public void setTypePermisConduire(String typePermisConduire) {
		this.typePermisConduire = typePermisConduire;
	}
	/**
	 * @return the datePermisConduire
	 */
	public Date getDatePermisConduire() {
		return datePermisConduire;
	}
	/**
	 * @param datePermisConduire the datePermisConduire to set
	 */
	public void setDatePermisConduire(Date datePermisConduire) {
		this.datePermisConduire = datePermisConduire;
	}
	/**
	 * @return the authenticatedUser
	 */
	public Employe getAuthenticatedUser() {
		return authenticatedUser;
	}
	/**
	 * @param authenticatedUser the authenticatedUser to set
	 */
	public void setAuthenticatedUser(Employe authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the loggedIn
	 */
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	/**
	 * @param loggedIn the loggedIn to set
	 */
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public String doLogin() {
		String navigateTo = "null";
		authenticatedUser=employeService.authenticate(login, password);
		if (authenticatedUser != null && authenticatedUser.getRole() ==Role.ADMINISTRATEUR) {
		navigateTo = "/xhtml/index.xhtml?faces-redirect=false";
		loggedIn = true; }
		else if(authenticatedUser != null && authenticatedUser.getRole() ==Role.INGENIEUR) {
			navigateTo = "/xhtml/templateAdmin.xhtml?faces-redirect=false";
			loggedIn = true;}
		else {
		FacesMessage facesMessage =
		new FacesMessage("Login Failed: please check your username/password and try again.");
		FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
		}
		public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/xhtml/login.xhtml?faces-redirect=true";
		}
		public String addEmploye() {
			String navigateTo = "null";
			if (authenticatedUser==null || !loggedIn) return "/xhtml/login.xhtml";
			livreurService.addLivreur(new Livreur(nomLivreur,  zone, zo,typePermisConduire,
					 datePermisConduire));
			return navigateTo;	
		}
		public String displayLivreur(Livreur empl)
		{
			String navigateTo = "null";
			if (getAuthenticatedUser()==null || !getLoggedIn()) return "/xhtml/login.xhtml";

		this.setNomLivreur(empl.getNomLivreur());
		this.setZone(empl.getZone());
		this.setTypePermisConduire(empl.getTypePermisConduire());
		this.setDatePermisConduire(empl.getDatePermisConduire());
		this.setLivreurIdToBeUpdated(empl.getLivreurId());
		return navigateTo;

		}
		public String removeLivreur(Long livreurId)
		{
			String navigateTo = "null";
			if (getAuthenticatedUser()==null || !getLoggedIn()) return "/xhtml/login.xhtml";

		livreurService.deleteLivreur(livreurId);
		return navigateTo;
		}
		public String updateLivreur()
		{ 
			String navigateTo = "null";
			if (getAuthenticatedUser()==null || !getLoggedIn()) return "/xhtml/login.xhtml";

			livreurService.addLivreur(new Livreur(livreurIdToBeUpdated,nomLivreur,  zone, zo,typePermisConduire,
				 datePermisConduire));
			return navigateTo;
		}
		public String addLivraisonUser() {
			String navigateTo = "null";
			if (getAuthenticatedUser()==null || !getLoggedIn()) return "/xhtml/login.xhtml";

			System.out.println(localisation);
			livraisonService.addLivraison(new Livraison( lat,lon,contry,localisation));
			return navigateTo;
		}
		public String confirm(Long livreurId) {
			String navigateTo = "null";
			if (getAuthenticatedUser()==null || !getLoggedIn()) return "/xhtml/login.xhtml";
			Livreur liv=livreurRepository.findByLivreurId(livreurId);
			liv.setNbrMax(0);
			livreurRepository.save(liv);
			return navigateTo;
			
		}
		public String calculateSalary(Long livreurId) {
			String navigateTo = "null";
			if (getAuthenticatedUser()==null || !getLoggedIn()) return "/xhtml/login.xhtml";
			livreurService.getSalaire(livreurId);
			return navigateTo;
		}
		
}
