package com.pharmasociale.models;

// Generated 5 août 2015 12:19:05 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Pharmacien generated by hbm2java
 */
public class Pharmacien implements java.io.Serializable {

	private int idPharmacien;
	private Pharmacie pharmacie;
	private Utilisateur utilisateur;
	private Set donAttribues = new HashSet(0);
	private Set dons = new HashSet(0);

	public Pharmacien() {
	}

	public Pharmacien(int idPharmacien) {
		this.idPharmacien = idPharmacien;
	}

	public Pharmacien(int idPharmacien, Pharmacie pharmacie,
			Utilisateur utilisateur, Set donAttribues, Set dons) {
		this.idPharmacien = idPharmacien;
		this.pharmacie = pharmacie;
		this.utilisateur = utilisateur;
		this.donAttribues = donAttribues;
		this.dons = dons;
	}

	public int getIdPharmacien() {
		return this.idPharmacien;
	}

	public void setIdPharmacien(int idPharmacien) {
		this.idPharmacien = idPharmacien;
	}

	public Pharmacie getPharmacie() {
		return this.pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Set getDonAttribues() {
		return this.donAttribues;
	}

	public void setDonAttribues(Set donAttribues) {
		this.donAttribues = donAttribues;
	}

	public Set getDons() {
		return this.dons;
	}

	public void setDons(Set dons) {
		this.dons = dons;
	}

}
