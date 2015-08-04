package com.pharmasociale.beans;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pharmasociale.models.Admin;
import com.pharmasociale.models.MedicamentHome;
import com.pharmasociale.models.Medicament;
import com.pharmasociale.utils.HibernateUtil;


public class MedicamentBean implements Serializable {
	
	private static final long serialVersionUID = 1094801825748586363L;
	MedicamentBean medicDao;

	private int idMedicament;
	private Admin admin;
	private String nom;
	private String reference;
	private Short status;
	private String code;
	private String description;
	
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
	
	public String addMedicament(){
		Medicament u = new Medicament();
		u.setCode(getCode());
		u.setDescription(getDescription());
		u.setNom(getNom());
		u.setReference(getReference());
		u.setStatus(getStatus());
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
	
	public List all_medocs() {
        //boolean valid = (new UtilisateurHome()).find(user, pwd);
        Session session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String SQL_QUERY = " from Medicament";
        System.out.println(SQL_QUERY);
        Query query = session.createQuery(SQL_QUERY);
        Iterator<Medicament> it = query.iterate();
        List<Medicament> list = query.list();
        if (list.size() > 0) {
            session.close();
            return list;
        }else{
            return null;
        }
    }
}
