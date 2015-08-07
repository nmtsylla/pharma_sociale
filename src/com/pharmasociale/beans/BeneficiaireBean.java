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
import com.pharmasociale.models.Beneficiaire;
import com.pharmasociale.models.Utilisateur;
import com.pharmasociale.utils.HibernateUtil;

@ManagedBean
@SessionScoped
public class BeneficiaireBean implements Serializable {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	private static final long serialVersionUID = 48586363L;
	
	private int idBeneficiaire;
	private Utilisateur utilisateur;
	private String nom;
	private String prenom;
	private Date brithday;
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

	public int getIdBeneficiaire() {
		return this.idBeneficiaire;
	}

	public void setIdBeneficiaire(int idBeneficiaire) {
		this.idBeneficiaire = idBeneficiaire;
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
	
	public String addBeneficiaire(){
		
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
            session.createSQLQuery("insert into Beneficiaire(idUtilisateur) value(last_insert_id())")
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
	
	public List all_Beneficiaire() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String SQL_QUERY = " from Beneficiaire";
        System.out.println(SQL_QUERY);
        Query query = session.createQuery(SQL_QUERY);
        Iterator<Beneficiaire> it = query.iterate();
        List<Beneficiaire> list = query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }else{
            return null;
        }
    }

}
