package tn.esprit.spring.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "livreur")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Livreur extends User{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long livreurId;
	@Column(name = "nomLivreur")
	private String nomLivreur;
	@Column(name = "nbrMax")
	private Integer nbrMax=0;
	@Column(name = "dispo")
	private Boolean dispo=true;
	@Column(name = "salaire")
	private int salaire=0;

	//zone
	
	@Enumerated(EnumType.STRING)
	@Column(name="zone")
	private ZoneMap zone;
	private String zo;
	@Column(name = "typePermis")
	private String typePermisConduire;
	@Temporal(TemporalType.DATE)
	@Column(name = "datePermis")
	private Date datePermisConduire;
	
	@OneToMany(cascade = 
            CascadeType.ALL, mappedBy="livreur")
	private Set<Livraison> livraisons;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="livreur")
	private Set<Reclamation> reclamations;
	/**
	 * @return the reclamations
	 */
	public Set<Reclamation> getReclamations() {
		return reclamations;
	}
	
	/**
	 * @return the salaire
	 */
	public int getSalaire() {
		return salaire;
	}

	/**
	 * @param salaire the salaire to set
	 */
	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}

	/**
	 * @param reclamations the reclamations to set
	 */
	public void setReclamations(Set<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}
	/**
	 * @return the livreurId
	 */
	public Long getLivreurId() {
		return livreurId;
	}
	/**
	 * @param livreurId the livreurId to set
	 */
	public void setLivreurId(Long livreurId) {
		this.livreurId = livreurId;
	}
	
	
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
	 * @return the livraisons
	 */
	public Set<Livraison> getLivraisons() {
		return livraisons;
	}
	/**
	 * @param livraisons the livraisons to set
	 */
	public void setLivraisons(Set<Livraison> livraisons) {
		this.livraisons = livraisons;
	}
	
	
	
	public Livreur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Livreur(String typePermisConduire, Date datePermisConduire) {
		super();
		this.typePermisConduire = typePermisConduire;
		this.datePermisConduire = datePermisConduire;
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
	
	/**
	 * @param zone the zone to set
	 */
	public void setZone(ZoneMap zone) {
		this.zone = zone;
	}
	public Livreur(Long livreurId, String nomLivreur, Integer nbrMax, Boolean dispo, ZoneMap zone,
			String typePermisConduire, Date datePermisConduire, Set<Livraison> livraisons,
			Set<Reclamation> reclamations) {
		super();
		this.livreurId = livreurId;
		this.nomLivreur = nomLivreur;
		this.nbrMax = nbrMax;
		this.dispo = dispo;
		this.zone = zone;
		this.typePermisConduire = typePermisConduire;
		this.datePermisConduire = datePermisConduire;
		this.livraisons = livraisons;
		this.reclamations = reclamations;
	}
	public Livreur(String nomLivreur, Integer nbrMax, Boolean dispo, ZoneMap zone, String typePermisConduire,
			Date datePermisConduire, Set<Livraison> livraisons, Set<Reclamation> reclamations) {
		super();
		this.nomLivreur = nomLivreur;
		this.nbrMax = nbrMax;
		this.dispo = dispo;
		this.zone = zone;
		this.typePermisConduire = typePermisConduire;
		this.datePermisConduire = datePermisConduire;
		this.livraisons = livraisons;
		this.reclamations = reclamations;
	}
	public Livreur(String nomLivreur, ZoneMap zone, String typePermisConduire) {
		super();
		this.nomLivreur = nomLivreur;
		this.zone = zone;
		this.typePermisConduire = typePermisConduire;
	}
	public Livreur(Integer nbrMax) {
		super();
		this.nbrMax = nbrMax;
	}
	public Livreur(String nomLivreur, ZoneMap zone, String typePermisConduire,
			Date datePermisConduire) {
		super();
		this.nomLivreur = nomLivreur;
		this.zone = zone;
		this.typePermisConduire = typePermisConduire;
		this.datePermisConduire = datePermisConduire;
	}
	public Livreur(Long livreurId, String nomLivreur, ZoneMap zone, String typePermisConduire,
			Date datePermisConduire) {
		super();
		this.livreurId = livreurId;
		this.nomLivreur = nomLivreur;
		this.zone = zone;
		this.typePermisConduire = typePermisConduire;
		this.datePermisConduire = datePermisConduire;
	}
	
	public Livreur(Long livreurId, String nomLivreur, ZoneMap zone, String zo, String typePermisConduire,
			Date datePermisConduire) {
		super();
		this.livreurId = livreurId;
		this.nomLivreur = nomLivreur;
		this.zone = zone;
		this.zo =zone.name();
		this.typePermisConduire = typePermisConduire;
		this.datePermisConduire = datePermisConduire;
	}
	
	public Livreur(String nomLivreur, ZoneMap zone, String zo, String typePermisConduire,
			Date datePermisConduire) {
		super();
		this.nomLivreur = nomLivreur;
		this.zone = zone;
		this.zo =zone.name();
		this.typePermisConduire = typePermisConduire;
		this.datePermisConduire = datePermisConduire;
	}
	public Livreur(Long livreurId,String nomLivreur, ZoneMap zone, String zo, String typePermisConduire,
			Date datePermisConduire,Boolean dispo) {
		super();
		this.livreurId = livreurId;

		this.nomLivreur = nomLivreur;
		this.zone = zone;
		this.zo =zone.name();
		this.typePermisConduire = typePermisConduire;
		this.datePermisConduire = datePermisConduire;
		this.dispo = dispo;
	}
	@Override
	public String toString() {
		return "Livreur [zone=" + zone + "]";
	}
	
	
	
}
