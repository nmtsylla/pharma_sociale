package com.pharmasociale.beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.pharmasociale.models.Admin;
import com.pharmasociale.models.Don;
import com.pharmasociale.models.Donnateur;
import com.pharmasociale.models.Medicament;
import com.pharmasociale.models.Pharmacie;
import com.pharmasociale.models.Pharmacien;
import com.pharmasociale.models.Utilisateur;
import com.pharmasociale.models.UtilisateurHome;
import com.pharmasociale.utils.HibernateUtil;

@ManagedBean
@SessionScoped
public class DonBean implements Serializable {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	private static final long serialVersionUID = 109483L;
	private int idDon;
	private static List<SelectItem> MEDICAMENTS = new ArrayList<SelectItem>();
	private Donnateur donnateur;
	private Pharmacien pharmacien;
	private String reference;
	private Set ligneDons = new HashSet(0);
	
	
	public int getIdDon() {
		return idDon;
	}

	public void setIdDon(int idDon) {
		this.idDon = idDon;
	}

	public Donnateur getDonnateur() {
		return donnateur;
	}

	public void setDonnateur(Donnateur donnateur) {
		this.donnateur = donnateur;
	}

	public Pharmacien getPharmacien() {
		return pharmacien;
	}

	public void setPharmacien(Pharmacien pharmacien) {
		this.pharmacien = pharmacien;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Set getLigneDons() {
		return ligneDons;
	}

	public void setLigneDons(Set ligneDons) {
		this.ligneDons = ligneDons;
	}

	public String addDon(){
		
		//userDao.persist(u);
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.createSQLQuery("insert into Utilisateur(nom, prenom, userName, password, adresse) "+
            		"values(:nom, :prenom, :userName, :password, :adresse)")
            		
            	      .executeUpdate();
            session.createSQLQuery("insert into Admin(idUtilisateur) value(last_insert_id())")
            	      .executeUpdate();
            
            session.getTransaction().commit();
            return "true";
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
            return "false";
        } finally {
            session.flush();
            session.close();
        }
	}
	
	public List all_don() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String SQL_QUERY = " from Don";
        System.out.println(SQL_QUERY);
        Query query = session.createQuery(SQL_QUERY);
        Iterator<Don> it = query.iterate();
        List<Don> list = query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }else{
            return null;
        }
    }
	
	public List<SelectItem> getMedicaments() {			
        if (MEDICAMENTS.isEmpty()){
        	List<Medicament>  ph = (new MedicamentBean()).all_medocs();
        	System.out.println(ph.size());
        	for(Medicament p: ph){
        		MEDICAMENTS.add(new SelectItem(p.getIdMedicament(), p.getNom())); 
        	}	        	
        }
        return MEDICAMENTS;  
    }

}
