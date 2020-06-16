package tn.esprit.spring.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Table(name = "livraison")
public class Livraison {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long livraisonId;
	@Column(name="lat")
	private Float lat;
	@Column(name="lon")
	private Float lon;
	
	@Enumerated(EnumType.STRING)
	@Column(name="contrey")
	//enum Zone
	private Zone contry ;
	@Column(name="localisation")
	//enum Zone
	private String localisation ;
	@Temporal(TemporalType.DATE)
	@Column(name="date")
	private Date date;
	@Column(name="frais")
	private Integer frais;
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;
	@Column(name="moyenDeTransport")
	private String moyenDeTransport;
	@Column(name="kilometrage")
	private Integer kilometrage;
	@ManyToOne(cascade = 
            CascadeType.ALL)
	Livreur livreur;
	@OneToOne
	private Facture facture;
	public Livraison() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	

	public Livraison(Livreur livreur) {
		super();
		this.livreur = livreur;
	}

	/**
	 * @return the livraisonId
	 */
	public Long getLivraisonId() {
		return livraisonId;
	}
	/**
	 * @param livraisonId the livraisonId to set
	 */
	public void setLivraisonId(Long livraisonId) {
		this.livraisonId = livraisonId;
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
	/**
	 * @return the facture
	 */
	public Facture getFacture() {
		return facture;
	}
	/**
	 * @param facture the facture to set
	 */
	public void setFacture(Facture facture) {
		this.facture = facture;
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

	

	public Livraison(Long livraisonId, Livreur livreur) {
		super();
		this.livraisonId = livraisonId;
		this.livreur = livreur;
	}

	public Livraison(Long livraisonId, Float lat) {
		super();
		this.livraisonId = livraisonId;
		this.lat = lat;
	}






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






	public Livraison(Long livraisonId, Float lat, Float lon, Zone contry, String localisation, Integer frais,
			Status status, Integer kilometrage, Livreur livreur) {
		super();
		this.livraisonId = livraisonId;
		this.lat = lat;
		this.lon = lon;
		this.contry = contry;
		this.localisation = localisation;
		this.frais = frais;
		this.status = status;
		this.kilometrage = kilometrage;
		this.livreur = livreur;
	}






	public Livraison(Float lat, Float lon, Zone contry, String localisation, Date date, Integer frais, Status status,
			String moyenDeTransport, Integer kilometrage, Livreur livreur, Facture facture) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.contry = contry;
		this.localisation = localisation;
		this.date = date;
		this.frais = frais;
		this.status = status;
		this.moyenDeTransport = moyenDeTransport;
		this.kilometrage = kilometrage;
		this.livreur = livreur;
		this.facture = facture;
	}






	public Livraison(Float lat, Float lon, Zone contry, String localisation) {
		super();
		this.lat = lat;
		this.lon = lon;
		this.contry = contry;
		this.localisation = localisation;
	}






	public Livraison(Long livraisonId, Float lat, Float lon, Zone contry, String localisation, Livreur livreur) {
		super();
		this.livraisonId = livraisonId;
		this.lat = lat;
		this.lon = lon;
		this.contry = contry;
		this.localisation = localisation;
		this.livreur = livreur;
	}



	
}
