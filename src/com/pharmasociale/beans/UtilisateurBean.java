package com.pharmasociale.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pharmasociale.models.Pharmacie;
import com.pharmasociale.models.Utilisateur;
import com.pharmasociale.models.UtilisateurHome;
import com.pharmasociale.utils.HibernateUtil;

@ManagedBean
@SessionScoped
public class UtilisateurBean implements Serializable {
	
	private static final long serialVersionUID = 1094801825748586363L;
	UtilisateurHome userDao;
	
	private int id;
	private Pharmacie pharmacie;
	private String nom;
	private String prenom;
	private String userName;
	private String password;
	private Date birthday;
	private String adresse;
	private Date createdAt;
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pharmacie getPharmacie() {
		return this.pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public String addUtilisateur(){
		Utilisateur u = new Utilisateur();
		u.setAdresse(getAdresse());
		u.setNom(getNom());
		u.setPrenom(getPrenom());
		u.setUserName(getUserName());
		u.setPassword(getPassword());
		u.setAdresse(getAdresse());
		//userDao.persist(u);
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(u);
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
	
	public List all_users() {
        //boolean valid = (new UtilisateurHome()).find(user, pwd);
        Session session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String SQL_QUERY = " from Utilisateur";
        System.out.println(SQL_QUERY);
        Query query = session.createQuery(SQL_QUERY);
        Iterator<Utilisateur> it = query.iterate();
        List<Utilisateur> list = query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }else{
        	session.close();
        	FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return null;
        }
    }

}
