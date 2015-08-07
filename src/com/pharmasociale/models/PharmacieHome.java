package com.pharmasociale.models;

// Generated 5 août 2015 12:19:05 by Hibernate Tools 4.0.0

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Pharmacie.
 * @see com.pharmasociale.models.Pharmacie
 * @author Hibernate Tools
 */
public class PharmacieHome {

	private static final Log log = LogFactory.getLog(PharmacieHome.class);

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

	public void persist(Pharmacie transientInstance) {
		log.debug("persisting Pharmacie instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Pharmacie instance) {
		log.debug("attaching dirty Pharmacie instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Pharmacie instance) {
		log.debug("attaching clean Pharmacie instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Pharmacie persistentInstance) {
		log.debug("deleting Pharmacie instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pharmacie merge(Pharmacie detachedInstance) {
		log.debug("merging Pharmacie instance");
		try {
			Pharmacie result = (Pharmacie) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Pharmacie findById(int id) {
		log.debug("getting Pharmacie instance with id: " + id);
		try {
			Pharmacie instance = (Pharmacie) sessionFactory.getCurrentSession()
					.get("com.pharmasociale.models.Pharmacie", id);
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

	public List findByExample(Pharmacie instance) {
		log.debug("finding Pharmacie instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.pharmasociale.models.Pharmacie")
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
