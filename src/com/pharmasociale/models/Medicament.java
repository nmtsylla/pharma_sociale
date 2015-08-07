package com.pharmasociale.models;

// Generated 5 août 2015 12:19:05 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Medicament generated by hbm2java
 */
public class Medicament implements java.io.Serializable {

	private int idMedicament;
	private Admin admin;
	private String nom;
	private String reference;
	private Short status;
	private String code;
	private String description;
	private Set ligneDons = new HashSet(0);
	private Set ligneDonAttribues = new HashSet(0);

	public Medicament() {
	}

	public Medicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}

	public Medicament(int idMedicament, Admin admin, String nom,
			String reference, Short status, String code, String description,
			Set ligneDons, Set ligneDonAttribues) {
		this.idMedicament = idMedicament;
		this.admin = admin;
		this.nom = nom;
		this.reference = reference;
		this.status = status;
		this.code = code;
		this.description = description;
		this.ligneDons = ligneDons;
		this.ligneDonAttribues = ligneDonAttribues;
	}

	public int getIdMedicament() {
		return this.idMedicament;
	}

	public void setIdMedicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getLigneDons() {
		return this.ligneDons;
	}

	public void setLigneDons(Set ligneDons) {
		this.ligneDons = ligneDons;
	}

	public Set getLigneDonAttribues() {
		return this.ligneDonAttribues;
	}

	public void setLigneDonAttribues(Set ligneDonAttribues) {
		this.ligneDonAttribues = ligneDonAttribues;
	}

}
