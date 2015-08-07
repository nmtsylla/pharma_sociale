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
import com.pharmasociale.models.Pharmacie;
import com.pharmasociale.models.Utilisateur;
import com.pharmasociale.models.UtilisateurHome;
import com.pharmasociale.utils.HibernateUtil;

@ManagedBean
@SessionScoped
public class AdminBean implements Serializable {
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	private static final long serialVersionUID = 1094801825748586363L;
	
	private int idAdmin;
	private Utilisateur utilisateur;
	private String nom;
	private String prenom;
	private String userName;
	private String password;
	private String adresse;
	
	
	
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
	public String getAdresse() {
		return adresse;
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
	
	

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public String addAdmin(){
		Utilisateur u = new Utilisateur();
		u.setAdresse(getAdresse());
		u.setNom(getNom());
		u.setPrenom(getPrenom());
		u.setUserName(getUserName());
		u.setPassword(getPassword());
		Admin admin = new Admin();
		
		//userDao.persist(u);
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.createSQLQuery("insert into Utilisateur(nom, prenom, userName, password, adresse) "+
            		"values(:nom, :prenom, :userName, :password, :adresse)")
            		.setParameter("nom", getNom())
            	      .setParameter("prenom", getPrenom())
            	      .setParameter("userName", getUserName())
            	      .setParameter("password", getPassword())
            	      .setParameter("adresse", getAdresse())
            	      .executeUpdate();
            session.createSQLQuery("insert into Admin(idUtilisateur) value(last_insert_id())")
            	      .executeUpdate();
            
            String req = "insert into Utilisateur(nom, prenom, userName, password, adresse) "+
            		"value(:nom, :prenom, :userName, :password, :adresse)";
            String req2 = "insert into Admin(idUtilisateur) value(last_insert_id())";
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
	
	public List all_admin() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String SQL_QUERY = " from Admin";
        System.out.println(SQL_QUERY);
        Query query = session.createQuery(SQL_QUERY);
        Iterator<Admin> it = query.iterate();
        List<Admin> list = query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }else{
            return null;
        }
    }

}
