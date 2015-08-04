package com.pharmasociale.models;

// Generated 26 juin 2015 11:47:43 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DonRecu generated by hbm2java
 */
public class DonRecu implements java.io.Serializable {

	private int idDon;
	private Pharmacien pharmacien;
	private Donnateur donnateur;
	private String reference;
	private Date note;
	private Date createdAt;
	private Date upadatedAt;
	private Set medRecus = new HashSet(0);

	public DonRecu() {
	}

	public DonRecu(int idDon) {
		this.idDon = idDon;
	}

	public DonRecu(int idDon, Pharmacien pharmacien, Donnateur donnateur,
			String reference, Date note, Date createdAt, Date upadatedAt,
			Set medRecus) {
		this.idDon = idDon;
		this.pharmacien = pharmacien;
		this.donnateur = donnateur;
		this.reference = reference;
		this.note = note;
		this.createdAt = createdAt;
		this.upadatedAt = upadatedAt;
		this.medRecus = medRecus;
	}

	public int getIdDon() {
		return this.idDon;
	}

	public void setIdDon(int idDon) {
		this.idDon = idDon;
	}

	public Pharmacien getPharmacien() {
		return this.pharmacien;
	}

	public void setPharmacien(Pharmacien pharmacien) {
		this.pharmacien = pharmacien;
	}

	public Donnateur getDonnateur() {
		return this.donnateur;
	}

	public void setDonnateur(Donnateur donnateur) {
		this.donnateur = donnateur;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getNote() {
		return this.note;
	}

	public void setNote(Date note) {
		this.note = note;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpadatedAt() {
		return this.upadatedAt;
	}

	public void setUpadatedAt(Date upadatedAt) {
		this.upadatedAt = upadatedAt;
	}

	public Set getMedRecus() {
		return this.medRecus;
	}

	public void setMedRecus(Set medRecus) {
		this.medRecus = medRecus;
	}

}
