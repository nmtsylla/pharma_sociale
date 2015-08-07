package com.pharmasociale.models;

// Generated 5 août 2015 12:19:05 by Hibernate Tools 4.0.0

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.pharmasociale.utils.HibernateUtil;

/**
 * Home object for domain model class LigneDonAttribue.
 * @see com.pharmasociale.models.LigneDonAttribue
 * @author Hibernate Tools
 */
public class LigneDonAttribueHome {

	private static final Log log = LogFactory
			.getLog(LigneDonAttribueHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return HibernateUtil.configureSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	
	

	public void persist(LigneDonAttribue transientInstance) {
		log.debug("persisting LigneDonAttribue instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(LigneDonAttribue instance) {
		log.debug("attaching dirty LigneDonAttribue instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LigneDonAttribue instance) {
		log.debug("attaching clean LigneDonAttribue instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(LigneDonAttribue persistentInstance) {
		log.debug("deleting LigneDonAttribue instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LigneDonAttribue merge(LigneDonAttribue detachedInstance) {
		log.debug("merging LigneDonAttribue instance");
		try {
			LigneDonAttribue result = (LigneDonAttribue) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LigneDonAttribue findById(
			com.pharmasociale.models.LigneDonAttribueId id) {
		log.debug("getting LigneDonAttribue instance with id: " + id);
		try {
			LigneDonAttribue instance = (LigneDonAttribue) sessionFactory
					.getCurrentSession().get(
							"com.pharmasociale.models.LigneDonAttribue", id);
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

	public List findByExample(LigneDonAttribue instance) {
		log.debug("finding LigneDonAttribue instance by example");
		try {
			List results = sessionFactory
					.getCurrentSession()
					.createCriteria("com.pharmasociale.models.LigneDonAttribue")
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
