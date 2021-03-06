package com.pharmasociale.models;

// Generated 5 août 2015 12:19:05 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DonAttribue generated by hbm2java
 */
public class DonAttribue implements java.io.Serializable {

	private int idDon;
	private Pharmacien pharmacien;
	private Beneficiaire beneficiaire;
	private Date note;
	private Date createdAt;
	private Date upadatedAt;
	private Set ligneDonAttribues = new HashSet(0);

	public DonAttribue() {
	}

	public DonAttribue(int idDon, Date note, Date createdAt, Date upadatedAt) {
		this.idDon = idDon;
		this.note = note;
		this.createdAt = createdAt;
		this.upadatedAt = upadatedAt;
	}

	public DonAttribue(int idDon, Pharmacien pharmacien,
			Beneficiaire beneficiaire, Date note, Date createdAt,
			Date upadatedAt, Set ligneDonAttribues) {
		this.idDon = idDon;
		this.pharmacien = pharmacien;
		this.beneficiaire = beneficiaire;
		this.note = note;
		this.createdAt = createdAt;
		this.upadatedAt = upadatedAt;
		this.ligneDonAttribues = ligneDonAttribues;
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

	public Beneficiaire getBeneficiaire() {
		return this.beneficiaire;
	}

	public void setBeneficiaire(Beneficiaire beneficiaire) {
		this.beneficiaire = beneficiaire;
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

	public Set getLigneDonAttribues() {
		return this.ligneDonAttribues;
	}

	public void setLigneDonAttribues(Set ligneDonAttribues) {
		this.ligneDonAttribues = ligneDonAttribues;
	}

}
