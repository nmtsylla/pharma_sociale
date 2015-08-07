package com.pharmasociale.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pharmasociale.models.Pharmacie;
import com.pharmasociale.models.Utilisateur;
import com.pharmasociale.utils.HibernateUtil;


public class PharmacieBean implements Serializable {
	
	private static final long serialVersionUID = 10363L;
	PharmacieBean medicDao;
	private int idPharmacie;
	private String enseigne;
	private String reference;
	private String adresse;
	private String ville;
	private Set utilisateurs = new HashSet(0);
	

	public int getIdPharmacie() {
		return idPharmacie;
	}

	public void setIdPharmacie(int idPharmacie) {
		this.idPharmacie = idPharmacie;
	}

	public String getEnseigne() {
		return enseigne;
	}

	public void setEnseigne(String enseigne) {
		this.enseigne = enseigne;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Set getUtilisateurs() {
		return utilisateurs;
	}

	public String addPharmacy(){
		Pharmacie u = new Pharmacie();
		u.setAdresse(getAdresse());
		u.setEnseigne(getEnseigne());
		u.setReference(getReference());
		u.setVille(getVille());
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
	
	public List all_pharmacy() {
        //boolean valid = (new UtilisateurHome()).find(user, pwd);
        Session session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String SQL_QUERY = " from Pharmacie";
        System.out.println(SQL_QUERY);
        Query query = session.createQuery(SQL_QUERY);
        Iterator<Pharmacie> it = query.iterate();
        List<Pharmacie> list = query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }else{
            return null;
        }
    }
}
