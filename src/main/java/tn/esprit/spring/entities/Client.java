package tn.esprit.spring.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long clientId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="client")
	private Set<Reclamation> reclamations;
	/**
	 * @return the clientId
	 */
	public Long getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the reclamations
	 */
	public Set<Reclamation> getReclamations() {
		return reclamations;
	}
	/**
	 * @param reclamations the reclamations to set
	 */
	public void setReclamations(Set<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}
	public Client(Long clientId, Set<Reclamation> reclamations) {
		super();
		this.clientId = clientId;
		this.reclamations = reclamations;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
