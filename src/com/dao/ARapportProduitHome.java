package com.dao;
// Generated 7 f�vr. 2017 11:34:39 by Hibernate Tools 5.2.0.Beta1

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.models.ARapportProduit;
import com.models.ARapportProduitId;

/**
 * Home object for domain model class ARapportProduit.
 * @see com.models.ARapportProduit
 * @author Hibernate Tools
 */
public class ARapportProduitHome {

	private static final Log log = LogFactory.getLog(ARapportProduitHome.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{ 
		this.sessionFactory = sessionFactory;
	}

	public void persist(ARapportProduit transientInstance) {
		log.debug("persisting ARapportProduit instance");
		try {
			sessionFactory.openSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ARapportProduit instance) {
		log.debug("attaching dirty ARapportProduit instance");
		try {
			sessionFactory.openSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@SuppressWarnings("deprecation")
	public void attachClean(ARapportProduit instance) {
		log.debug("attaching clean ARapportProduit instance");
		try {
			sessionFactory.openSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ARapportProduit persistentInstance) {
		log.debug("deleting ARapportProduit instance");
		try {
			sessionFactory.openSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ARapportProduit merge(ARapportProduit detachedInstance) {
		log.debug("merging ARapportProduit instance");
		try {
			ARapportProduit result = (ARapportProduit) sessionFactory.openSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ARapportProduit findById(ARapportProduitId id) {
		log.debug("getting ARapportProduit instance with id: " + id);
		try {
			ARapportProduit instance = (ARapportProduit) sessionFactory.openSession()
					.get("com.models.ARapportProduit", id);
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

	public List<ARapportProduit> findByExample(ARapportProduit instance) {
		log.debug("finding ARapportProduit instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<ARapportProduit> results = (List<ARapportProduit>)sessionFactory.openSession().createCriteria("com.models.ARapportProduit")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
