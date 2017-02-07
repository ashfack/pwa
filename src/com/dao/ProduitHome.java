package com.dao;
// Generated 7 f�vr. 2017 11:34:39 by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.models.Produit;

/**
 * Home object for domain model class Produit.
 * @see com.models.Produit
 * @author Hibernate Tools
 */
public class ProduitHome {

	private static final Log log = LogFactory.getLog(ProduitHome.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{ 
		this.sessionFactory = sessionFactory;
	}

	public void persist(Produit transientInstance) {
		log.debug("persisting Produit instance");
		try {
			sessionFactory.openSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Produit instance) {
		log.debug("attaching dirty Produit instance");
		try {
			sessionFactory.openSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(Produit instance) {
		log.debug("attaching clean Produit instance");
		try {
			sessionFactory.openSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Produit persistentInstance) {
		log.debug("deleting Produit instance");
		try {
			sessionFactory.openSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Produit merge(Produit detachedInstance) {
		log.debug("merging Produit instance");
		try {
			Produit result = (Produit) sessionFactory.openSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Produit findById(java.lang.String id) {
		log.debug("getting Produit instance with id: " + id);
		try {
			Produit instance = (Produit) sessionFactory.openSession().get("com.models.Produit", id);
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

	public List<Produit> findByExample(Produit instance) {
		log.debug("finding Produit instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Produit> results = (List<Produit>)sessionFactory.openSession().createCriteria("com.models.Produit")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
