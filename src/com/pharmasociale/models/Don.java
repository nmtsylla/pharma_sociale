package com.pharmasociale.models;

// Generated 5 août 2015 12:19:05 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Don generated by hbm2java
 */
public class Don implements java.io.Serializable {

	private int idDon;
	private Donnateur donnateur;
	private Pharmacien pharmacien;
	private String reference;
	private Date note;
	private Date createdAt;
	private Date upadatedAt;
	private Set ligneDons = new HashSet(0);

	public Don() {
	}

	public Don(int idDon, Date note, Date createdAt, Date upadatedAt) {
		this.idDon = idDon;
		this.note = note;
		this.createdAt = createdAt;
		this.upadatedAt = upadatedAt;
	}

	public Don(int idDon, Donnateur donnateur, Pharmacien pharmacien,
			String reference, Date note, Date createdAt, Date upadatedAt,
			Set ligneDons) {
		this.idDon = idDon;
		this.donnateur = donnateur;
		this.pharmacien = pharmacien;
		this.reference = reference;
		this.note = note;
		this.createdAt = createdAt;
		this.upadatedAt = upadatedAt;
		this.ligneDons = ligneDons;
	}

	public int getIdDon() {
		return this.idDon;
	}

	public void setIdDon(int idDon) {
		this.idDon = idDon;
	}

	public Donnateur getDonnateur() {
		return this.donnateur;
	}

	public void setDonnateur(Donnateur donnateur) {
		this.donnateur = donnateur;
	}

	public Pharmacien getPharmacien() {
		return this.pharmacien;
	}

	public void setPharmacien(Pharmacien pharmacien) {
		this.pharmacien = pharmacien;
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

	public Set getLigneDons() {
		return this.ligneDons;
	}

	public void setLigneDons(Set ligneDons) {
		this.ligneDons = ligneDons;
	}

}
