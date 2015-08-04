package com.pharmasociale.models;

// Generated 26 juin 2015 11:47:43 by Hibernate Tools 4.0.0

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Pharmacien.
 * @see com.pharmasociale.models.Pharmacien
 * @author Hibernate Tools
 */
public class PharmacienHome {

	private static final Log log = LogFactory.getLog(PharmacienHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Pharmacien transientInstance) {
		log.debug("persisting Pharmacien instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Pharmacien instance) {
		log.debug("attaching dirty Pharmacien instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pharmacien instance) {
		log.debug("attaching clean Pharmacien instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Pharmacien persistentInstance) {
		log.debug("deleting Pharmacien instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pharmacien merge(Pharmacien detachedInstance) {
		log.debug("merging Pharmacien instance");
		try {
			Pharmacien result = (Pharmacien) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Pharmacien findById(int id) {
		log.debug("getting Pharmacien instance with id: " + id);
		try {
			Pharmacien instance = (Pharmacien) sessionFactory
					.getCurrentSession().get(
							"com.pharmasociale.models.Pharmacien", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Pharmacien instance) {
		log.debug("finding Pharmacien instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.pharmasociale.models.Pharmacien")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
