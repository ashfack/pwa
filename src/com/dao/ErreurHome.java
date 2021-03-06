package com.dao;
// Generated 7 f�vr. 2017 11:34:39 by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.models.Erreur;
import com.models.ErreurId;

/**
 * Home object for domain model class Erreur.
 * @see com.models.Erreur
 * @author Hibernate Tools
 */
public class ErreurHome {

	private static final Log log = LogFactory.getLog(ErreurHome.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{ 
		this.sessionFactory = sessionFactory;
	}

	public void persist(Erreur transientInstance) {
		log.debug("persisting Erreur instance");
		try {
			sessionFactory.openSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Erreur instance) {
		log.debug("attaching dirty Erreur instance");
		try {
			sessionFactory.openSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Erreur instance) {
		log.debug("attaching clean Erreur instance");
		try {
			sessionFactory.openSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Erreur persistentInstance) {
		log.debug("deleting Erreur instance");
		try {
			sessionFactory.openSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Erreur merge(Erreur detachedInstance) {
		log.debug("merging Erreur instance");
		try {
			Erreur result = (Erreur) sessionFactory.openSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Erreur findById(ErreurId id) {
		log.debug("getting Erreur instance with id: " + id);
		try {
			Erreur instance = (Erreur) sessionFactory.openSession().get("com.models.Erreur", id);
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

	public List<Erreur> findByExample(Erreur instance) {
		log.debug("finding Erreur instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Erreur> results = (List<Erreur>)sessionFactory.openSession().createCriteria("com.models.Erreur")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
