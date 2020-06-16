package tn.esprit.spring.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;




@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Table(name = "reclamation")
public class Reclamation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long reclamationId;
	@Column(name="nom")
	private String nom ;
	@Column(name="prenom")
	private String prenom ;
	@Column(name="titre")
	private String titre ;
	@Column(name="contenu")
	private String contenu ;
	@Temporal(TemporalType.DATE)
	@Column(name="DATE")
	private Date date;
	@Enumerated(EnumType.STRING)
	@Column(name="decision")
	private Decision decision;
	//private Decision decision=Decision.EN_COURS;
	@ManyToOne
	Livreur livreur;
	@ManyToOne
	Client client;
	
	
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the reclamationId
	 */
	public Long getReclamationId() {
		return reclamationId;
	}
	/**
	 * @param reclamationId the reclamationId to set
	 */
	public void setReclamationId(Long reclamationId) {
		this.reclamationId = reclamationId;
	}
	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	/**
	 * @return the contenu
	 */
	public String getContenu() {
		return contenu;
	}
	/**
	 * @param contenu the contenu to set
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the livreurs
	 */
	public Livreur getLivreurs() {
		return livreur;
	}
	/**
	 * @param livreurs the livreurs to set
	 */
	public void setLivreurs(Livreur livreurs) {
		this.livreur = livreurs;
	}
	/**
	 * @return the clients
	 */
	public Client getClients() {
		return client;
	}
	
	/**
	 * @return the decision
	 */
	public Decision getDecision() {
		return decision;
	}
	/**
	 * @param decision the decision to set
	 */
	public void setDecision(Decision decision) {
		this.decision = decision;
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
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	/**
	 * @param clients the clients to set
	 */
	public void setClients(Client clients) {
		this.client = clients;
	}
	public Reclamation(Long reclamationId, String titre, String contenu, Date date, Livreur livreurs, Client clients) {
		super();
		this.reclamationId = reclamationId;
		this.titre = titre;
		this.contenu = contenu;
		this.date = date;
		this.livreur = livreurs;
		this.client = clients;
	}
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reclamation(String titre, String contenu, Date date, Livreur livreur, Client client) {
		super();
		this.titre = titre;
		this.contenu = contenu;
		this.date = date;
		this.livreur = livreur;
		this.client = client;
	}
	public Reclamation(Long reclamationId, Decision decision) {
		super();
		this.reclamationId = reclamationId;
		this.decision = decision;
	}
	public Reclamation(String titre, String contenu, Date date, Decision decision, Livreur livreur,
			Client client) {
		super();
		this.titre = titre;
		this.contenu = contenu;
		this.date = date;
		this.decision = decision;
		this.livreur = livreur;
		this.client = client;
	}
	public Reclamation(Long reclamationId, String titre, String contenu, Date date, Decision decision) {
		super();
		this.reclamationId = reclamationId;
		this.titre = titre;
		this.contenu = contenu;
		this.date = date;
		this.decision = decision;
	}
	public Reclamation(String nom,String prenom,String titre, String contenu, Date date, Decision decision) {
		super();
		this.nom=nom;
		this.prenom=prenom;
		this.titre = titre;
		this.contenu = contenu;
		this.date = date;
		this.decision = decision;
	}
	public Reclamation(String titre, String contenu, Date date, Decision decision, Client client) {
		super();
		this.titre = titre;
		this.contenu = contenu;
		this.date = date;
		this.decision = decision;
		this.client = client;
	}
	
	
}
