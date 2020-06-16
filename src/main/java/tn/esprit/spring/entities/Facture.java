package tn.esprit.spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "facture")
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long factureId;
	@Column(name="prix")
	private Float prix;
	@Column(name="poids")
	private Float poids;
	@OneToOne(mappedBy="facture")
	private Livraison livraison;
	/**
	 * @return the factureId
	 */
	public Long getFactureId() {
		return factureId;
	}
	/**
	 * @param factureId the factureId to set
	 */
	public void setFactureId(Long factureId) {
		this.factureId = factureId;
	}
	/**
	 * @return the prix
	 */
	public Float getPrix() {
		return prix;
	}
	/**
	 * @param prix the prix to set
	 */
	public void setPrix(Float prix) {
		this.prix = prix;
	}
	/**
	 * @return the poids
	 */
	public Float getPoids() {
		return poids;
	}
	/**
	 * @param poids the poids to set
	 */
	public void setPoids(Float poids) {
		this.poids = poids;
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
	
}
