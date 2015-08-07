package com.pharmasociale.models;

// Generated 5 août 2015 12:19:05 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Admin generated by hbm2java
 */
public class Admin implements java.io.Serializable {

	private int idAdmin;
	private Utilisateur utilisateur;
	private Set medicaments = new HashSet(0);

	public Admin() {
	}

	public Admin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public Admin(int idAdmin, Utilisateur utilisateur, Set medicaments) {
		this.idAdmin = idAdmin;
		this.utilisateur = utilisateur;
		this.medicaments = medicaments;
	}

	public int getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Set getMedicaments() {
		return this.medicaments;
	}

	public void setMedicaments(Set medicaments) {
		this.medicaments = medicaments;
	}

}
