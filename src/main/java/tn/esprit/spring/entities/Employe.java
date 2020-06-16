package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Employe implements Serializable {
	
	private static final long serialVersionUID = -1396669830860400871L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String password;
	
	private String prenom;
	
	private String nom;
	
	//@Column(unique=true)
	private String email;

	private boolean actif;
	
	@Enumerated(EnumType.STRING)
	//@NotNull
	private Role role;
	
	

	
	
	public Employe() {
		super();
	}
	
	public Employe(String nom, String prenom, String email, boolean actif, Role role) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.actif = actif;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	/**
	 * @return the actif
	 */
	public boolean isActif() {
		return actif;
	}

	/**
	 * @param actif the actif to set
	 */
	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public Employe(String password, String prenom, String nom, String email, boolean actif, Role role) {
		super();
		this.password = password;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.actif = actif;
		this.role = role;
	}

	public Employe(int id, String password, String prenom, String nom, String email, boolean actif, Role role) {
		super();
		this.id = id;
		this.password = password;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.actif = actif;
		this.role = role;
	}
	
	
	
	
}
