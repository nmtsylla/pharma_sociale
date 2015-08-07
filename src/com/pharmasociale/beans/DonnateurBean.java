package com.pharmasociale.beans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.pharmasociale.models.Admin;
import com.pharmasociale.models.Donnateur;
import com.pharmasociale.models.Pharmacie;
import com.pharmasociale.models.Utilisateur;
import com.pharmasociale.models.UtilisateurHome;
import com.pharmasociale.utils.HibernateUtil;

@ManagedBean
@SessionScoped
public class DonnateurBean implements Serializable {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	private static final long serialVersionUID = 109L;
	
	private int idDonnateur;
	private Utilisateur utilisateur;
	private String nom;
	private String prenom;
	private String adresse;
	
	
	
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public int getIdDonnateur() {
		return this.idDonnateur;
	}

	public void setIdAdmin(int idDonnateur) {
		this.idDonnateur = idDonnateur;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}
	
	

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public String addDonnateur(){
		
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.createSQLQuery("insert into Utilisateur(nom, prenom, adresse) "+
            		"values(:nom, :prenom, :adresse)")
            		.setParameter("nom", getNom())
            	      .setParameter("prenom", getPrenom())
            	      .setParameter("adresse", getAdresse())
            	      .executeUpdate();
            session.createSQLQuery("insert into Donnateur(idUtilisateur) value(last_insert_id())")
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
	
	public List all_donnateur() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String SQL_QUERY = " from Donnateur";
        System.out.println(SQL_QUERY);
        Query query = session.createQuery(SQL_QUERY);
        Iterator<Donnateur> it = query.iterate();
        List<Donnateur> list = query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }else{
            return null;
        }
    }

}
