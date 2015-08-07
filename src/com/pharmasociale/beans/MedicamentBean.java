package com.pharmasociale.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import com.pharmasociale.models.Admin;
import com.pharmasociale.models.MedicamentHome;
import com.pharmasociale.models.Medicament;
import com.pharmasociale.models.Pharmacie;
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
	private static List<SelectItem> PHARMACIES = new ArrayList<SelectItem>();
	
	private final static SessionFactory sessionFactory = getSessionFactory();

	protected static SessionFactory getSessionFactory() {
		try {
			
			return HibernateUtil.configureSessionFactory();
//			return (SessionFactory) new InitialContext()
//					.lookup("SessionFactory");
		} catch (Exception e) {
			
		}
		return sessionFactory;
	}
	
	
	public List<SelectItem> getPharmacies() {
		
        if (PHARMACIES.isEmpty()){
        	PHARMACIES.add(new SelectItem("en", "English")); 
        }
        /*List<Pharmacie> a = (new PharmacieBean()).all_pharmacy();
        for(Pharmacie p: a){
        	PHARMACIES.add(new SelectItem(p.getIdPharmacie(), p.getEnseigne())); 
        }*/
  
        return PHARMACIES;  
    } 
	
	
	public MedicamentBean getMedicDao() {
		return medicDao;
	}

	public void setMedicDao(MedicamentBean medicDao) {
		this.medicDao = medicDao;
	}

	public int getIdMedicament() {
		return idMedicament;
	}

	public void setIdMedicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
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
		MedicamentHome mhome = new MedicamentHome();
		return mhome.addMedicament(u);
				
	}
	
	public void remove(Medicament medic) {
	    try {
	    	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    	session.beginTransaction();
	    	Query query = session.createQuery("delete Medicament where idMedicament = "+medic.getIdMedicament());
	    	int result = query.executeUpdate();
	    	session.getTransaction().commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void onCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Item Cancelled");   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        Medicament m = (Medicament) event.getObject();
        System.out.println(m.getCode()+" "+m.getNom());
        remove((Medicament) event.getObject());
    }
	
	public void onEdit(RowEditEvent event) {
		System.out.println((event.getObject()));
		FacesMessage msg = new FacesMessage(((Medicament) event.getObject()).getCode());   
        FacesContext.getCurrentInstance().addMessage(null, msg); 
		Medicament m = (Medicament) event.getObject();
    }
	
	public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
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
	
	public List getMedoc(Integer medId) {
        //boolean valid = (new UtilisateurHome()).find(user, pwd);
        Session session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String SQL_QUERY = " from Medicament where idMedicament="+medId;
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
